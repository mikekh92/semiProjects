<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.serviceCenter.model.vo.FAQ, java.util.ArrayList,com.kh.common.PageInfo" %>
<%
	ArrayList<FAQ> FAQList = (ArrayList<FAQ>)request.getAttribute("FAQList");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DS SPORTS</title>

    <!--Latest compiled and minified CSS-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

	<link rel="stylesheet" href="/Semi/views/admin-css/manage_Sc_kyu.css">
</head>
<body>
	<%@include file="/views/common/adminMenubar.jsp" %> 
	<div id="content_2">
		<!--왼쪽 여백--><div id="content_2_empty"></div>
		<div id="content_2_1">
			<h2>FAQ관리</h2>
		</div>
		<!--input 바 시작-->
		<div id="content_2_2">
			<form action="searchFAQ.sc" method="post">
				<div id="content_2_2_1">
					<div class="selecdiv col-sm-2">
					<select id="select" class="form-control" name="select_faq_cate">
						<option value="title">제목</option>
						<option value="faq-select">구분</option>
					</select>
					</div>
					<div class="col-sm-5">
						<input type="text" name="search_user" id="search_user" class="form-control"> 
					</div>   
					<div class="col-sm-3">
						<button type="submit" id="search_btn"><img src="/Semi/views/image/search.png" id="search_img">검색</button>
					</div>    
				</div>      
			</form>
		</div>
		<!--input 바 끝-->

		<!--회원 명 수 및 버튼 시작-->
		<div id="content_2_3">

			검색 게시글 수 <span style="color:red"><%=pi.getListCount() %></span>개
		</div>
		<div id="content_2_4">
			<button type="button" class="btn btn-warning" onclick="location.href='/Semi/views/admin/serviceCenter/FAQEnroll.jsp'">FAQ 등록</button>
			<button type="button" class="btn btn-warning" id="openBtn" disabled>선택 공개</button>			
			<button type="button" class="btn btn-warning" id="deleteBtn" disabled>선택 비공개</button>

		</div>
		<!--회원 명 수 및 버튼 끝-->

		<!--게시글 테이블 작업 시작-->
		<div id="content_2_5">
			<table class="table table-sm">
				<thead class="thead-light">
				<tr>
					<th width="5%"><input type="checkbox" name="cmCheck" id="mCheck"></th>
					<th width="10%">번호</th>
					<th width="20%">구분</th>
					<th width="45%">제목</th>
					<th width="20%">상태</th>
				</tr>
				</thead>
				<tbody id="main-tbody">
				<%for(FAQ f : FAQList) {%>
				<tr class="onModal">
					<td ondblclick="event.cancelBubble=true"><input type="checkbox" name="cmCheck"></td>
					<td><%=f.getFaqNo() %></td>
					<td><%=f.getFaqCate() %></td>
					<td><%=f.getFaqTitle() %></td>
					<td><%=(f.getFaqStatus().equals("Y") ) ? "공개 상태" : "비공개 상태"%></td>
				</tr>
				<%}%>
				</tbody>
			</table>
		</div>
		<!--게시글 테이블 작업 끝-->
		
		<!--글 목록 시작-->
		<div id="content_2_6">
			<ul class="pagination">
				<%if(pi.getStartPage()!=1) {%>
				<li class="page-item"><a class="page-link" href="<%=contextPath%>/ScList.sc?cpage=<%=pi.getStartPage()-pi.getPageLimit()%>">Previous</a></li>
				<%}%>
				<%for(int i=pi.getStartPage();i<=pi.getEndPage();i++) {%>
				<li class="page-item index-page"><a class="page-link" href="<%=contextPath%>/ScList.sc?cpage=<%=i%>"><%=i%></a></li>
				<%}%>
				<%if(pi.getEndPage()!=pi.getMaxPage()) {%>
				<li class="page-item"><a class="page-link" href="<%=contextPath%>/ScList.sc?cpage=<%=pi.getEndPage()+1%>">Next</a></li>
				<%} %>
			  </ul>
		</div>
		<!--글 목록 끝-->
		<div class="modal1" id="myModal1">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">FAQ 상세</h4>
        <button type="button" class="close myModal1Close" >&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       	<table class="table modal-table table-sm" id="modal-bodyy">
	       

				
		</table>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer" Id="modalFooter">
        <button type="button" class="btn btn-dark" onclick="enroll();">수정</button>
        <button type="button" class="btn btn-danger myModal1Close">닫기</button>
      </div>

    </div>
  </div>
</div>
	</div>
	<form action="faqEnroll.sc" method="post" id="enroll-form">
	
	</form>
<script>
window.onload=function(){
	var liArr = $(".index-page");
	for(var i=0;i<liArr.length;i++){
		liArr.eq(i).removeClass("active");
		if(liArr.eq(i).text()==<%=pi.getCurrentPage()%>){
			liArr.eq(i).addClass("active");
		}
	}
}
	var myModal = document.getElementsByClassName("myModal1Close");
	for(var i=0;i<myModal.length;i++){
		myModal[i].onclick=function(){
			document.getElementById("myModal1").style.display="none";
		}
	}
	$("#mCheck").change(function(){
		if($(this).prop('checked')==true) $("input[name=cmCheck]").prop('checked',true);
		else $("input[name=cmCheck]").prop('checked',false);
	})
	
	$(".onModal").dblclick(function(){
		document.getElementById("myModal1").style.display="block";
		var td = (Math.abs(this.childNodes[3].innerHTML-<%=pi.getListCount()%>) % <%=pi.getBoardLimit()%>) ;
		var str = "";
		var str2= "";
		$.ajax({
			url : "ScList.sc",
			data :{cpage : <%=pi.getCurrentPage()%>,
				ajaxSwitch : 1},
			success : function(result){	
				str +=	"<tr>"+
				"<th width='40%;'>번호</th>" +
				"<td width='60%;'>"+result[td].faqNo+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<th>구분</th>" +
			"<td>"+result[td].faqCate+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<th>제목</th>" +
			"<td>"+result[td].faqTitle+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<td colspan='2' height='200px'>"+result[td].faqContent+"</td>" +
			"</tr>";
			str2+="<input type='hidden' name='faqNo' value="+result[td].faqNo+">"+
			"<input type='hidden' name='faqCate' value="+result[td].faqCate+">"+
			"<input type='hidden' name='faqTitle' value='"+result[td].faqTitle+"'>"+
			"<input type='hidden' name='faqContent' value='"+result[td].faqContent+"'>";
			$("#modal-bodyy").html(str);
			$("#enroll-form").html(str2);
			},
			error : function(){
				console.log("실패");
			}
		})
	})
	
	
		$("input[name=cmCheck]").change(function(){
		var count=0;
		var cmCheck=$("input[name=cmCheck]");
		for(var i=0;i<cmCheck.length;i++){
			if(cmCheck[i].checked == true) count++;
			if(count>=2) break;
		}
		if(count>0) {
			document.getElementById("deleteBtn").removeAttribute('disabled');
			document.getElementById("openBtn").removeAttribute('disabled');
		}
		else {
			document.getElementById("deleteBtn").disabled=true;
			document.getElementById("openBtn").disabled=true;
		}

	})
		document.addEventListener('keydown',function(e){
		if(e.keyCode==27 && document.getElementById("myModal1").style.display == "block")
			document.getElementById("myModal1").style.display="none";
	})
	var sw=0;
	$("#deleteBtn").click(function(){
		if(window.confirm("비공개 처리 하시겠습니까?")){
			sw=0;
			changeStatus();
		}
		
	})
	$("#openBtn").click(function(){
		if(window.confirm("공개 처리 하시겠습니까?")){
			sw=1;
			changeStatus();
		}
		
	})	
	
	
	function changeStatus(){
			var check1 = [];
			var tds=[];
			var data1=[];
			var cmCheck=$("input[name=cmCheck]");
			var trs = document.getElementById("main-tbody").getElementsByTagName("tr");
			var count=0;
			for(var i=1;i<cmCheck.length;i++){
				if(cmCheck[i].checked == true) {
					check1[count]= i-1;
					count++;
				}
			}
			for(var i=0;i<check1.length;i++){
				tds[i] = trs[check1[i]].getElementsByTagName("td");
				data1[i]=tds[i][1].innerHTML;
			}
			console.log(data1);
			$.ajax({
				url : "ajaxHide.sc",
				traditional : true,
				data :{fnoArr : data1,
					sw: sw},
				success : function(){
					window.alert("정상 처리 되었습니다.");
					window.location.reload(true);
				},
				error : function(){
					console.log("실패");
				}
			})
	}
	
	
	function enroll(){
		var form = document.getElementById("enroll-form");

		form.submit();
	}
</script>
</body>
</html>
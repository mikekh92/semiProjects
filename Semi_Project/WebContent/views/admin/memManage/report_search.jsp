<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.report.model.vo.Report, java.util.ArrayList, com.kh.common.PageInfo" %>
<%
	ArrayList<Report> rList = (ArrayList<Report>)request.getAttribute("rList");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	String reportCate = (String)request.getAttribute("reportCate");
	String searchUser = (String)request.getAttribute("searchUser");
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
			<h2>신고내역</h2>
		</div>
		<!--input 바 시작-->
		<div id="content_2_2">
			<form action="searchReport.re" method="post">
				<div id="content_2_2_1">
					<div class="selecdiv col-sm-2">
					<select id="select" class="form-control" name="select_report_cate">
						<option value="userId">회원ID</option>
						<option value="repoterId">신고자</option>
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

			검색 게시글 수 <span style="color:red"><%=pi.getListCount() %></span>명
		</div>
		<div id="content_2_4">
			<button type="button" class="btn btn-warning" id="detailBtn" disabled>상세내용</button>
			<button type="button" class="btn btn-warning" id="deleteBtn" disabled>선택삭제</button>
		</div>
		<!--회원 명 수 및 버튼 끝-->

		<!--게시글 테이블 작업 시작-->
		<div id="content_2_5">
			<table class="table table-sm">
				<thead class="thead-light">
				<tr>
					<th><input type="checkbox" name="cmCheck" id="mCheck"></th>
					<th>번호</th>
					<th>아이디</th>
					<th>신고날짜</th>
					<th>신고제목</th>
					<th>신고자</th>
					<th>처리상태</th>
				</tr>
				</thead>
				<tbody id="main-tbody">
				<%for(Report r : rList) {%>
				<tr class = "onModal">
					<td ondblclick="event.cancelBubble=true"><input type="checkbox" name="cmCheck"></td>
					<td><%=r.getrepNo() %></td>
					<td><%=r.getrepUserId() %></td>
					<td><%=r.getrepEnterdate() %></td>
					<td><%=r.getrepTitle() %></td>
					<td><%=r.getrepRepoter() %></td>
					<td><%=(r.getrepStatus().equals("Y") ) ? "처리 완료" : "미처리 상태"%></td>
				</tr>
				<%} %>
				</tbody>
			</table>
		</div>
		<!--게시글 테이블 작업 끝-->
		
		<!--글 목록 시작-->
		<div id="content_2_6">
			<ul class="pagination">
				<%if(pi.getStartPage()!=1) {%>
				<li class="page-item"><a class="page-link" href="<%=contextPath%>/searchReport.re?cpage=<%=pi.getStartPage()-pi.getPageLimit()%>&select_report_cate=<%=reportCate%>&search_user=<%=searchUser%>">Previous</a></li>
				<%}%>
				<%for(int i=pi.getStartPage();i<=pi.getEndPage();i++) {%>
				<li class="page-item index-page"><a class="page-link" href="<%=contextPath%>/searchReport.re?cpage=<%=i%>&select_report_cate=<%=reportCate%>&search_user=<%=searchUser%>"><%=i%></a></li>
				<%}%>
				<%if(pi.getEndPage()!=pi.getMaxPage()) {%>
				<li class="page-item"><a class="page-link" href="<%=contextPath%>/searchReport.re?cpage=<%=pi.getEndPage()+1%>&select_report_cate=<%=reportCate%>&search_user=<%=searchUser%>">Next</a></li>
				<%} %>
			  </ul>
		</div>
		<!--글 목록 끝-->
		<div class="modal1" id="myModal1">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">신고 상세 내역</h4>
        <button type="button" class="close" onclick="myModal1Close();" >&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       	<table class="table modal-table table-sm" id="modal-bodyy">       
				
		</table>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      	<button type="button" id="confirm" class="btn btn-dark" onclick ="reportUser();">확인</button>
        <button type="button" id="delete" class="btn btn-danger" onclick="deleteUser();">삭제</button>
        <button type="button" class="btn btn-danger" onclick="myModal1Close();">닫기</button>
      </div>

    </div>
  </div>
</div>
	</div>
	
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
	
	
$(".onModal").dblclick(function(){
	document.getElementById("myModal1").style.display="block";
	var str = ""
	$.ajax({
		url : "ajaxModal.re",
		data :{rno : this.childNodes[3].innerHTML},
		success : function(result){
			str +=	"<tr>"+
			"<th width='40%;'>신고 번호</th>" +
			"<td width='60%;'>"+result.repNo+"</td>" +
		"</tr>" +
		"<tr>"+
		"<th>아이디</th>" +
		"<td>"+result.repUserId+"</td>" +
		"</tr>" + 
		"<tr>"+
		"<th>신고자</th>" +
		"<td>"+result.repRepoter+"</td>" +
		"</tr>" + 
		"<tr>"+
		"<th>신고날짜</th>" +
		"<td>"+result.repEnterdate+"</td>" +
		"</tr>" + 
		"<tr>"+
		"<th>신고제목</th>" +
		"<td>"+result.repTitle+"</td>" +
		"</tr>" + 
		"<tr>"+
		"<td colspan='2' height='200px'>"+result.repContent+"</td>" +
		"</tr>" + 
		"<tr>";
		$("#modal-bodyy").html(str);
		if(result.repStatus=='Y'){
			document.getElementById("confirm").style.display="none";
			document.getElementById("delete").style.display="none";
		}
		},
		error : function(){
			console.log("실패");
		}
	})
})

$("#detailBtn").click(function(){
	document.getElementById("myModal1").style.display="block";
	var num, tds;
	var cmCheck=$("input[name=cmCheck]");
	var trs = document.getElementById("main-tbody").getElementsByTagName("tr");
	for(var i=0;i<cmCheck.length;i++){
		if(cmCheck[i].checked == true){
			num = i;
			break;
		}
	}
	tds = trs[num-1].getElementsByTagName("td");
	var str = ""
		$.ajax({
			url : "ajaxModal.re",
			data :{rno : tds[1].innerHTML},
			success : function(result){
				str +=	"<tr>"+
				"<th width='40%;'>신고 번호</th>" +
				"<td width='60%;'>"+result.repNo+"</td>" +
			"</tr>" +
			"<tr>"+
			"<th>아이디</th>" +
			"<td>"+result.repUserId+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<th>신고자</th>" +
			"<td>"+result.repRepoter+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<th>신고날짜</th>" +
			"<td>"+result.repEnterdate+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<th>신고제목</th>" +
			"<td>"+result.repTitle+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<td colspan='2' height='200px'>"+result.repContent+"</td>" +
			"</tr>" + 
			"<tr>";
			$("#modal-bodyy").html(str);
			if(result.repStatus=='Y'){
				document.getElementById("confirm").style.display="none";
				document.getElementById("delete").style.display="none";
			}
			},
			error : function(){
				console.log("실패");
			}
		})
})







	function myModal1Close(){
		document.getElementById("myModal1").style.display="none";
	}
	
	function reportUser(){
		var name = document.getElementById("modal-bodyy").childNodes[1].childNodes[1].innerHTML;
		var rno = document.getElementById("modal-bodyy").childNodes[0].childNodes[1].innerHTML;
		$.ajax({
			url : "ajaxRPC.re",
			data : {
					userId : name,
					rno : rno
					},
			success : function(result){
				alert("처리가 완료되었습니다.");
				myModal1Close();
				window.location.reload(true);
			},
			error : function(){
				console.log("실패");
			}
		})
	}
	
	function deleteUser(){
		var rno = document.getElementById("modal-bodyy").childNodes[0].childNodes[1].innerHTML;
		$.ajax({
			url : "ajaxRPC.re",
			data : {
					rno : rno
					},
			success : function(result){
				alert("처리가 완료되었습니다.");
				myModal1Close();
				window.location.reload(true);
			},
			error : function(){
				console.log("실패");
			}
		})
	}
	$("#mCheck").change(function(){
		if($(this).prop('checked')==true) $("input[name=cmCheck]").prop('checked',true);
		else $("input[name=cmCheck]").prop('checked',false);
	})

	$("input[name=cmCheck]").change(function(){
		var count=0;
		var cmCheck=$("input[name=cmCheck]");
		for(var i=0;i<cmCheck.length;i++){
			if(cmCheck[i].checked == true) count++;
			if(count>=2) break;
		}
		if(count>0) document.getElementById("deleteBtn").removeAttribute('disabled');
		else document.getElementById("deleteBtn").disabled=true;
		if(count==1) document.getElementById("detailBtn").removeAttribute('disabled');
		else document.getElementById("detailBtn").disabled=true;

	})
		document.addEventListener('keydown',function(e){
		if(e.keyCode==27 && document.getElementById("myModal1").style.display == "block")
			document.getElementById("myModal1").style.display="none";
	})
	
	$("#deleteBtn").click(function(){
		if(window.confirm("탈퇴 처리 하시겠습니까?")){
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
		$.ajax({
			url : "ajaxDelete.re",
			traditional : true,
			data :{rnoArr : data1},
			success : function(){
				window.alert("정상 처리 되었습니다.");
				window.location.reload(true);
			},
			error : function(){
				console.log("실패");
			}
		})
		}
		
	})
</script>
</body>
</html>
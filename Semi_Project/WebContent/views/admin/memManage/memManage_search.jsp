<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList, com.kh.memManage.model.vo.Member, com.kh.common.PageInfo" %>
<%
	ArrayList<Member> mList = (ArrayList<Member>)request.getAttribute("mList");
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

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
			<h2>회원관리</h2>
		</div>
		<!--input 바 시작-->
		<div id="content_2_2">
			<form action="searchUser.mm" method="post">
				<input type="hidden" name="cpage" value="1">
				<div id="content_2_2_1">
					<div class="selecdiv col-sm-2">
					<select id="select" name="select_user_cate" class="form-control">
						<option value="userId">회원ID</option>
						<option value="userName">회원명</option>
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

			검색 회원 수 <span style="color:red"><%=pi.getListCount() %></span>명
		</div>
		<div id="content_2_4">
			<button type="button" class="btn btn-warning" id="detailBtn" disabled>회원보기</button>
			<button type="button" class="btn btn-warning" >회원수정</button>
			<button type="button" class="btn btn-warning" id="deleteBtn" disabled>회원삭제</button>
			<button type="button" class="btn btn-warning">쿠폰확인</button>
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
					<th>이름</th>
					<th>전화번호</th>
					<th>구매금액</th>
					<th>쿠폰</th>
					<th>회원상태</th>
				</tr>
				</thead>
				<tbody id="main-tbody">
					<%for(Member m : mList) { %>
					<%String status = ""; %>
					<tr class="onModal">
						<td ondblclick="event.cancelBubble='true'"><input type="checkbox" name="cmCheck" ></td>
						<td><%=m.getUserNo() %></td>
						<td><%=m.getUserId()%></td>
						<td><%=m.getUserName() %></td>
						<td><%=m.getPhone() %></td>
						<td>100,000</td>
						<td>5장</td>
						<%switch(m.getuStatus()) {
						case "Y" : status = "회원 상태"; break;
						case "N" : status = "탈퇴 상태"; break; 
						case "H" : status = "휴먼 상태"; break;
						case "S" : status = "정지 상태"; break;
						case "U" : status = "영구 정지 상태"; break;
						}%>
						<td><%=status %></td>
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
				<li class="page-item"><a class="page-link" href="<%=contextPath%>/searchUser.mm?cpage=<%=pi.getStartPage()-pi.getPageLimit()%>">Previous</a></li>
				<%}%>
				<%for(int i=pi.getStartPage();i<=pi.getEndPage();i++) {%>
				<li class="page-item index-page"><a class="page-link" href="<%=contextPath%>/searchUser.mm?cpage=<%=i%>"><%=i%></a></li>
				<%}%>
				<%if(pi.getEndPage()!=pi.getMaxPage()) {%>
				<li class="page-item"><a class="page-link" href="<%=contextPath%>/searchUser.mm?cpage=<%=pi.getEndPage()+1%>">Next</a></li>
				<%} %>
			  </ul>
		</div>
		<!--글 목록 끝-->
		<div class="modal1" id="myModal1">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">회원상세정보</h4>
        <button type="button" class="close myModal1Close" >&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       	<table class="table modal-table table-sm" id="modal-bodyy">	       

				
		</table>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger myModal1Close">닫기</button>
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
			url : "ajaxModal.mm",
			data :{mno : this.childNodes[3].innerHTML},
			success : function(result){
				str +=	"<tr>"+
				"<th width='40%;'>회원번호</th>" +
				"<td width='60%;'>"+result.userNo+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<th>아이디</th>" +
			"<td>"+result.userId+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<th>이름</th>" +
			"<td>"+result.userName+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<th>이메일</th>" +
			"<td>"+result.email+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<th>전화번호</th>" +
			"<td>"+result.phone+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<th>아이디 생성 날짜</th>" +
			"<td>"+result.enterDate+"</td>" +
			"</tr>";
			$("#modal-bodyy").html(str);
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
		url : "ajaxModal.mm",
		data :{mno : tds[1].innerHTML},
		success : function(result){
			str +=	"<tr>"+
			"<th width='40%;'>회원번호</th>" +
			"<td width='60%;'>"+result.userNo+"</td>" +
		"</tr>" + 
		"<tr>"+
		"<th>아이디</th>" +
		"<td>"+result.userId+"</td>" +
		"</tr>" + 
		"<tr>"+
		"<th>이름</th>" +
		"<td>"+result.userName+"</td>" +
		"</tr>" + 
		"<tr>"+
		"<th>이메일</th>" +
		"<td>"+result.email+"</td>" +
		"</tr>" + 
		"<tr>"+
		"<th>전화번호</th>" +
		"<td>"+result.phone+"</td>" +
		"</tr>" + 
		"<tr>"+
		"<th>아이디 생성 날짜</th>" +
		"<td>"+result.userBirth+"</td>" +
		"</tr>";
		$("#modal-bodyy").html(str);
		},
		error : function(){
			console.log("실패");
		}
	})
	})
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
		console.log(data1);
		$.ajax({
			url : "ajaxDelete.mm",
			traditional : true,
			data :{mnoArr : data1},
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
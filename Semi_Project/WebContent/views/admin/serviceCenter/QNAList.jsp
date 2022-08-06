<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.serviceCenter.model.vo.QNA, java.util.ArrayList,com.kh.common.PageInfo" %>
<%
	ArrayList<QNA> QNAList = (ArrayList<QNA>)request.getAttribute("QNAList");
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
			<h2>1:1 문의 관리</h2>
		</div>
		<!--input 바 시작-->
		<div id="content_2_2">
			<form action="searchQNA.sc" method="post">
				<div id="content_2_2_1">
					<div class="selecdiv col-sm-2">
					<select id="select" class="form-control" name="select_qna_cate">
						<option value="title">제목</option>
						<option value="qna-select">구분</option>
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

			검색 문의 수 <span style="color:red"><%=pi.getListCount() %></span>개
		</div>
		<div id="content_2_4">
 	
		</div>
		<!--회원 명 수 및 버튼 끝-->

		<!--게시글 테이블 작업 시작-->
		<div id="content_2_5">
			<table class="table table-sm">
				<thead class="thead-light">

				<tr>
					<th width="5%"><input type="checkbox" name="cmCheck" id="mCheck"></th>
					<th width="5%">번호</th>
					<th width="10%">아이디</th>
					<th width="20%">작성시간</th>
					<th width="10%">구분</th>
					<th>제목</th>
					<th>처리상태</th>
				</tr>
				</thead>
				<tbody>
				<%for(QNA q : QNAList) {%>
				<tr class="onModal">
					<td ondblclick="event.cancelBubble=true"><input type="checkbox" name="cmCheck"></td>
					<td><%=q.getQnaNo() %></td>
					<td><%=q.getQnaId() %></td>
					<td><%=q.getQnaEnterdate() %></td>
					<td><%=q.getQnaCate() %></td>
					<td><%=q.getQnaTitle() %></td>
					<td><%=(q.getQnaStatus().equals("Y")) ? "미처리 상태" : "처리상태" %></td>
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
				<li class="page-item"><a class="page-link" href="<%=contextPath%>/QNAList.sc?cpage=<%=pi.getStartPage()-pi.getPageLimit()%>">Previous</a></li>
				<%}%>
				<%for(int i=pi.getStartPage();i<=pi.getEndPage();i++) {%>
				<li class="page-item index-page"><a class="page-link" href="<%=contextPath%>/QNAList.sc?cpage=<%=i%>"><%=i%></a></li>
				<%}%>
				<%if(pi.getEndPage()!=pi.getMaxPage()) {%>
				<li class="page-item"><a class="page-link" href="<%=contextPath%>/QNAList.sc?cpage=<%=pi.getEndPage()+1%>">Next</a></li>
				<%} %>
			  </ul>
		</div>
		<!--글 목록 끝-->
		<div class="modal1" id="myModal1">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">1:1 문의 상세</h4>
        <button type="button" class="close myModal1Close" >&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       	<table class="table modal-table" id="modal-bodyy">			       

				
		</table>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      	<button type="button" class="btn btn-warning" id="enrollAnswer" onclick="enrollAnswer();">답변 등록</button>
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
		url : "ajaxQNAModal.sc",
		data :{qno : this.childNodes[3].innerHTML},
		success : function(result){
			var answerdate = (result.qnaAnswerdate != null) ? result.qnaAnswerdate : "" ;
			var answer = (result.qnaAnswer != null) ? result.qnaAnswer : "";
			
			str += "<tr>" +
			"<th width='50%' id='qnaNoo'>문의 번호 :" + result.qnaNo+"</th>"+
			"<th rowspan='3' style='vertical-align:middle'>답변작성일 :" + answerdate +"</th>" +
					"</tr>" +
					"<tr>" +
						"<th>ID :" + result.qnaId + "</th>" +
					"</tr>" +
					"<tr>" +
					"<th> 문의 제목 :" + result.qnaTitle + "</th>" +
					"</tr>" +
					"<tr>" +
					"<td rowspan='2' id='textareaTd' height='300px'>" +
					"<textarea style='resize:none' readonly >"+result.qnaContent+"</textarea>"+
					"</td>" +
						"<td rowspan='2' id='textareaTd' height='300px'>" +
							"<textarea style='resize:none' id='qnaContentt'>"+answer+"</textarea>"+
						"</td>" +
					"</tr>";				       
		$("#modal-bodyy").html(str);
		if(result.qnaStatus=='N')
		document.getElementById("enrollAnswer").style.display="none";
		else
		document.getElementById("enrollAnswer").style.display="block";
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

	window.onkeydown = function(){
		if(event.keyCode==27){
			document.getElementById("myModal1").style.display="none";
		}
	}
	function enrollAnswer(){
		if(window.confirm("등록 하시겠습니까?")){
			$.ajax({
				url: "ajaxEnrollAnswer.sc",
				data:{qnaNo : $("#qnaNoo").text().substr(7),
					qnaAnswer : $("#qnaContentt").val()},
				type:"post",
				success : function(){
					window.alert("성공적으로 등록되었습니다.");
					window.location.reload(true);
				},
				error : function(){

				}
			})
		}
	}
	
</script>
</body>
</html>
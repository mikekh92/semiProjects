<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, com.kh.serviceCenter.model.vo.QNA" %>
<% 
	ArrayList<QNA> qList = (ArrayList<QNA>)request.getAttribute("qList");
	int count = qList.size();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DS SPORTS</title>
<style>
.hide{

  width: 100%;
  height: 0vh;
  transition: all 0.5s;	
  visibility: collapse;

}
.act {

  height: 30vh;
  transition: all 0.5s;	
  visibility: visible;
  
}
.hide-main{

	height: 0vh;
	transition: all 0.5s; 	
	visibility: collapse;
}
.act-main{

	height:5vh;
	transition: all 0.5s;	
	visibility: visible;
	
}
</style>
</head>
<body>
	<%@include file="/views/common/menubar.jsp"%>
<div height="200px"></div>
    <div id="ccccc" style="height:100px;margin-top:30px;">
    <button style="font-size:20px;width:200px;height:50px;" onclick="location.href='FaqForm.fq?cpage=1'" class="btn btn-dark">FAQ</button> 
    <button style="font-size:20px;width:200px;height:50px;" onclick="location.href='listt.no?cpage=1'" class="btn btn-dark">공지사항</button> 
    <button style="font-size:20px;width:200px;height:50px;" onclick="location.href='userQNAList.sc'" class="btn btn-dark">1:1문의</button> 
    </div>
<div align="center" style="margin-bottom:50px;"><h2>1:1 문의</h2></div>
<div style="height:1000px;">
		<div align="right" style="margin-bottom:30px;"><button class="btn btn-dark" onclick="location.href='/Semi/views/service/insertUserQNA.jsp'">글쓰기</button></div>
		<table class="table" style="text-align:center;">
			<thead>
				<tr>
					<th>게시번호</th>
					<th>질문 제목</th>
					<th>질문 등록 시간</th>
					<th>답변 등록 시간</th>
					<th>답변 등록 여부</th>
				</tr>
			</thead>
			<tbody>
				<%if(count==0) {%>
					<tr>
						<td colspan="5">작성된 문의가 존재하지 않습니다.</td>
					</tr>
				<%}else{%>
					<%for(int i=count-1;i>=0;i--) {%>
						<tr class="onDetail">
							<td><%=i+1%></td>
							<td><%=qList.get(i).getQnaTitle() %>
							<td><%=qList.get(i).getQnaEnterdate() %>
							<td><%=(qList.get(i).getQnaAnswerdate()!=null) ? qList.get(i).getQnaAnswerdate() : "" %>
							<td><%=(qList.get(i).getQnaStatus().equals("Y") ) ? "답변 미등록" : "답변 등록"%></td>
						</tr>
						<tr class="hide-main main<%=i+1 %> table-active" >
						<th colspan="2">질문내용</th>
						<th colspan="3">답변내용</th>
						</tr>
						<tr class="hide <%=i+1%>">
						<td colspan="2" style="border-right:2px solid black;"><%=qList.get(i).getQnaContent() %></td>
						<td colspan="3"><%=(qList.get(i).getQnaAnswer()!=null) ? qList.get(i).getQnaAnswer() : "답변이 아직 존재하지 않습니다." %></td>
						</tr>
					<%}%>
					<tr>
						<th colspan="5"></th>
					</tr>
				<%}%>
			</tbody>
		</table>
	</div>
	<script>
	$(".onDetail").dblclick(function(){
		var num = $(this).children(0).eq(0).text();
		$("."+num).toggleClass('act');
		$(".main"+num).toggleClass('act-main');
	})
	
	</script>
	
</body>
</html>
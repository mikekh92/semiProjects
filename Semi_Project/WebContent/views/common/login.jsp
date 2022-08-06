<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DS SPORTS</title>
<link rel="stylesheet" href="/Semi/resources/css/login.css">
</head>
<body>
	<%@include file="/views/common/menubar.jsp"%>

	<div id="login_content_empty">
		
	</div>
	<div id="login_content1">
		<div id="login_content1_1">
			<h1>로그인</h1>
		</div>
		<form action="/Semi/loginUser.lo" method="post">
		<div id="login_content1_2">
			<table id="login_table">
				<tr>
					<th width="100px">아이디 :</th>
					<td width="200px" height="30px" class="inputTd"><input type="text" class="form-control" name="userId"></td>
				</tr>
				<tr>
					<td colspan="2" height="30px"></td>
				</tr>
				<tr>
					<th>비밀번호 : </th>
					<td class="inputTd"><input type="password" class="form-control" name="userPw"></td>
				</tr>
			</table>
			<br><br>
			<button type="submit" class="btn btn-success">로그인</button>
			<button type="button" class="btn btn-danger" onclick="location.href='/Semi/views/semi/newMember.jsp'">회원가입</button>

		</div>
		</form>
		<div id="login_content1_3">
			<br><br>
			<a href="#">아이디 찾기</a> |
			<a href="#">비밀번호 찾기</a>
		</div>
	</div>
</body>
</html>
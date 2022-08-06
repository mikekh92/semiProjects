<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DS SPORTS</title>
</head>
<body>
	<%@include file="/views/common/menubar.jsp"%>
	
	<div style="height:100px;"></div>
	<div align="center" style="margin-bottom:100px;"><h2>1:1 문의 작성</h2></div>
	<form action = "/Semi/insertUserQNA.sc" method="post">
	<input type="hidden" name="userId" value='<%=loginUser.getUserId() %>'>
		<div class="col-sm-3">
			<table>
				<tr>
					<td width="70px">구분 : </td>
					<td width="200px">	
						<select id="search_user" class="form-control" name="qnaCate">
							<option value="110">배송관련</option>
							<option value="120">주문관련</option>
							<option value="130">상품관련</option>
						</select>
					</td>
				</tr>
			</table>
		</div>
		<div style="height:30px"></div>
		<div class="col-sm-5">
			<table>
				<tr>
					<th width="70px">제목 : </th>
					<td width="300px"><input type="text" name="qnaTitle" class="form-control"></td>
			</table>
		</div>
		<div style="height:70px"></div>
		<div class="col-sm">
			<table>
				<tr>
					<th width="70px">내용 : </th>
					<td><textarea rows="20" cols="200" class="form-control" style="resize:none;" name="qnaContent"></textarea></td>
				</tr>
			</table>		
		</div>
		<div style="height: 100px"></div>
		<div align="center">
			<button type="submit" class="btn btn-success">문의하기</button>
		</div>
		</form>
</body>
</html>
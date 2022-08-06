<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, com.kh.basket1.model.vo.Basket, com.kh.member_2.model.vo.MemberUser" %>
<%
	ArrayList<Basket> baList= (ArrayList<Basket>)request.getAttribute("baList");
	int totalprice=0;

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DS SPORTS</title>
</head>
<body>
	<%@include file="/views/common/menubar.jsp"%>
	<div style="height:200px">
	</div>
	<%for(Basket b : baList) {%>
	<div style="height:100px">
		<span>주문 상품 : <%=b.getProName() %></span>
		<span>주문 수량 : <%=b.getPayOrderNo() %>개</span><br>
		<span>총 가격 : <%=b.getPayOrderNo() * b.getProPrice() %> 원</span>
		<%totalprice = totalprice + (b.getPayOrderNo() * b.getProPrice()); %>
	</div>
	<%}%>
	
	<form action="/Semi/views/payment/kakao.jsp">
	<input type="hidden" name="name"  value='<%=loginUser.getUserName() %>'>
	<input type="hidden" name="email"  value='<%=loginUser.getEmail() %>'>
	<input type="hidden" name="phone"  value='<%=loginUser.getPhone() %>'>
	<input type="hidden" name="address"  value="인천광역시 부평동 충선로">
	<input type="hidden" name="totalPrice" value='<%=totalprice %>'>
	<button type="submit" class="btn-success">결제하기</button>
	</form>
	
	
</body>
</html>
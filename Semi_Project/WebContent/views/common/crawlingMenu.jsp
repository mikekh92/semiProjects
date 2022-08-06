<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="java.util.ArrayList, com.kh.product.model.vo.Product" %>
    
<%
	ArrayList<Product> pList = (ArrayList<Product>)request.getAttribute("pList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%for(Product p : pList) {%>
	<div>
	<img src='<%=p.getProImage()%>' width="150" height="150"><br>
	<h4><%=p.getProName() %></h4>
	<h4><%=p.getProPrice() %></h4>
	</div>
	
	<%}%>
	
</body>
</html>
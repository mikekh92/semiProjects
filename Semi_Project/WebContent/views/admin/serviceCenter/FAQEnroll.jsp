<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.kh.serviceCenter.model.vo.FAQ"  %>


<%
	FAQ faq = new FAQ();
	if(request.getAttribute("faq")!=null){
		faq = (FAQ)request.getAttribute("faq");
	}

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

	<link rel="stylesheet" href="/Semi/views/admin-css/admin_a_2.css">
</head>
<body>
	<%@include file="/views/common/adminMenubar.jsp" %> 
	<div id="content_2">
		<!--왼쪽 여백--><div id="content_2_empty"></div>
		<div id="content_2_1">
			<h2>FAQ작성</h2>
		</div>
		<form action="/Semi/faqInsert.sc" method="post" id="enroll-form"> 
		<div id="content_2_2">
				<%if(faq!=null) {%>
					<input type="hidden" name="faqNo" value='<%=faq.getFaqNo() %>'>
				<%}%>
				<div id="content_2_2_1">
					<div class="selecdiv col-sm-2">
					구분
					</div>
					<div class="col-sm-5">
					<select id="search_user" class="form-control" name="faqCate">
					<%if(faq.getFaqCate()!=null) {%>
							<option value="110" <%=(faq.getFaqCate().equals("배송관련")) ? "selected" : ""%>>배송관련</option>
							<option value="120" <%=(faq.getFaqCate().equals("주문관련")) ? "selected" : ""%>>주문관련</option>
							<option value="130" <%=(faq.getFaqCate().equals("상품관련")) ? "selected" : ""%>>상품관련</option>
					<%} else {%>
							<option value="110">배송관련</option>
							<option value="120">주문관련</option>
							<option value="130">상품관련</option>
							
					<%}%>
					
					</select>
					</div>   
					<br><br><br><br>
					<div class="selecdiv col-sm-2">
					제목
					</div>
					<div class="col-sm-5">
					<%if(faq.getFaqTitle()!=null) {%>
						<input type="text" name="faqTitle" id="search_user" class="form-control" value="<%=faq.getFaqTitle()%>">
					<%} else {%>
						<input type="text" name="faqTitle" id="search_user" class="form-control">	
					<%}%>
					
					</div>    
				</div>      
		</div>

		<div id="content_2_3">
			<div id="content_2_3_1">내용</div>
			<textarea name="faqContent"><%=(faq.getFaqContent()!=null) ? faq.getFaqContent() : "" %> </textarea>
			
		</div>
		<div id="content_2_4">
			<button type="submit" class="btn btn-warning">FAQ 등록</button>
			<button type="button" class="btn btn-warning" onclick="history.back()">돌아가기</button>
		</div>
		</form>
		
	</div>
	
</body>
</html>
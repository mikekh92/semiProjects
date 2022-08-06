<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.ArrayList, com.kh.order.model.vo.Order, com.kh.common.PageInfo" %>
    
<%
ArrayList<Order> oList = (ArrayList<Order>)request.getAttribute("list");
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

	<link rel="stylesheet" href="/Semi/views/admin-css/order_gwan.css">
<style>
    #content_2_5{
    height:50%;
    width:95%;
    background-color: rgb(216, 226, 229);
    margin: auto;
    margin-top: 50px;
    color: rgb(19, 18, 18);
    text-align: center;
}
.table{
    text-align: center;
    border: 1px solid black;
}
</style>	
</head>
<body>
		<%@include file="/views/common/adminMenubar.jsp" %>
        <div id="content_2">
            <!--왼쪽 여백--><div id="content_2_empty"></div>
            <div id="content_2_1">
                <h2>주문내역관리</h2>
            </div>
            <!--input 바 시작-->
            <div id="content_2_2">
                <form action="search_user.do" method="post">
                    <div id="content_2_2_1">
                        <div class="selecdiv col-sm-2">
                        <select id="select" class="form-control">
                            <option value="userId">주문자</option>
                            <option value="noticeTitle">주문번호</option>
                        </select>
                        </div>
                        <div class="col-sm-5">
                            <input type="text" name="search_user" id="search_user" class="form-control" placeholder="주문자명 또는 주문번호"> 
                        </div>   
                        <div class="col-sm-3">
                            <button type="submit" id="search_btn"><img src="/Semi/views/image/search.png" id="search_img">검색</button>
                        </div>    
                    </div>      
                </form>
            </div>
            <h2 align="center">배송현황 관리</h2>
            <!--input 바 끝-->
    
            <!--회원 명 수 및 버튼 시작-->
            <div id="content_2_3">
    
			검색 주문번호 수 <span style="color:red"><%=pi.getListCount() %></span>개
            </div>
            <div id="content_2_4">
                <button type="button" class="btn btn-warning">배송관리</button>
                <button type="button" class="btn btn-warning"><a href="/Semi/views/admin/order/orderListView1_2.jsp">반품관리</a></button>
                <button type="button" class="btn btn-warning"><a href="/Semi/views/admin/order/orderListView1_3.jsp">취소관리</a></button>
            </div>
            <!--회원 명 수 및 버튼 끝-->
    
            <!--게시글 테이블 작업 시작-->
            <div id="content_2_5">
                <br>
                
                <table align="center" class="table-hover" >
                    <thead>
                        <th width="15%">주문일자</th>
                        <th width="15%">주문번호</th>
                        <th width="10%">주문자</th>
                        <th width="10%">상품명</th>
                    </thead>
                    <tbody>
                    <%for(Order o : oList)  {%>
                        <tr>
                            <td><%=o.getOrderDate() %></td>
                            <td><%=o.getOrderOno() %></td>
                            <td><%=o.getOrderer() %></td>
                            <td><%=o.getProductName() %></td>
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
				<li class="page-item"><a class="page-link" href="<%=contextPath%>/list.oo?cpage=<%=pi.getStartPage()-pi.getPageLimit()%>">Previous</a></li>
				<%}%>
				<%for(int i=pi.getStartPage();i<=pi.getEndPage();i++) {%>
				<li class="page-item index-page"><a class="page-link" href="<%=contextPath%>/list.oo?cpage=<%=i%>"><%=i%></a></li>
				<%}%>
				<%if(pi.getEndPage()!=pi.getMaxPage()) {%>
				<li class="page-item"><a class="page-link" href="<%=contextPath%>/list.oo?cpage=<%=pi.getEndPage()+1%>">Next</a></li>
				<%} %>
			  </ul>
		</div>
            <!--글 목록 끝-->
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
</script>
</body>
</html>
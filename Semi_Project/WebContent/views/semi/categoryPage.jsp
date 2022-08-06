<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.common.PageInfo,java.util.ArrayList" %>
    <%
    	PageInfo pi =(PageInfo)request.getAttribute("pi");
    
   		int currentPage = pi.getCurrentPage();
		int startPage = pi.getStartPage();
		int endPage = pi.getEndPage();
		int maxPage = pi.getMaxPage();
    	String category = (String)request.getAttribute("category");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="/Semi/resources/css/categoryPage.css">


<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>
  .list a{
    text-decoration: none;
  }
  #catebox{
    width: 1000px;
    height: 500px;
    position: relative;
    margin-left:700px ;
    margin-top: 100px;
    
  }
  #catebox #catebox-pr{
    
    width: 19%;
    height: 50%;
    display: inline-block;
  }
  #catebox #catebox-pr>img{
    width: 100%;
    height: 50%;
  }
  #catebox #catebox-pr>h4{
    width: 100%;
    height: 14%;
    border: 1px #000000 solid;
    text-align: center;
    padding: 0;
    margin: 0;
    
   
  }
  #catebox-pr img{
  width:200px;
  height:200px;
  
  
  }
</style>
<body>
	 <%@ include file="/views/common/menubar.jsp"%>

   <%for(Product n : pr) {%>
   <div class="list">
    <div class="list1">
		<a href=""><h3 class="cate-top"></h3></a>
    </div>
    <div class="list2">
		<a href=""><h3 class="cate-middle"></h3></a>
    </div>
    <div class="list3">
		<a href=""><h3 class="cate-bottom"></h3></a>
    </div>
   </div>
	<%} %>


	


		
	
   <div id="catebox">
          <%for(Product n : pr) {%>
        <div id="catebox-pr">
          <a href="<%=contextPath%>/detail.pr?dt=<%=n.getProNo()%>"><img src='<%=n.getProImage()%>'></a><br>
          <h4><%=n.getProName()%></h4>
          <h4><%=n.getProPrice()%></h4><br>
        </div>
          <%} %>


          <br><br><br>


          
        <div class="paging-area" align="center">
          <%if(currentPage!=1){ %>
          <button onclick="location.href='<%=contextPath%>/<%=category %>.pg?cpage=<%=currentPage-1%>'">&lt;</button>
          <%} %>
          
          <%for(int i =startPage; i<=endPage; i++){ %>
      <%if(i!=currentPage){ %>
              <button onclick="location.href='<%=contextPath%>/<%=category %>.pg?cpage=<%=i%>'"><%=i %></button>
                  <%}else{ %>
          <button disabled><%=i %></button>         
            <%} %>
          <%} %>
          
          <%if(currentPage!=maxPage){ %>
          <button onclick="location.href='<%=contextPath%>/<%=category %>.pg?cpage=<%=currentPage+1%>'">&gt;</button>
        <%} %>
      </div>
      
      

      
      
      
      
       <script>
        $(document).ready(function() {
 			if('<%=category %>'=="soccer"){
                $(".cate-top").text("축구공");
                $(".cate-middle").text("축구화");
                $(".cate-bottom").text("보호장비");
                $(".list1>a").attr("href","<%=contextPath%>/soccertp.pg?cpage=1");
                $(".list2>a").attr("href","<%=contextPath%>/soccermd.pg?cpage=1");
                $(".list3>a").attr("href","<%=contextPath%>/soccerbt.pg?cpage=1");
 			}
        	if('<%=category %>'=="boling"){
                $(".cate-top").text("볼링공");
                $(".cate-middle").text("볼링화");
                $(".cate-bottom").text("보호장비");
                $(".list1>a").attr("href","<%=contextPath %>/boling.pg?cpage=1&tp=21");
                $(".list2>a").attr("href","<%=contextPath %>/boling.pg?cpage=1&tp=22");
                $(".list3>a").attr("href","<%=contextPath %>/boling.pg?cpage=1&tp=23");
 			}
        
            	if('<%=category %>'=="health"){
                $(".cate-top").text("스트랩");
                $(".cate-middle").text("리프팅벨트");
                $(".cate-bottom").text("보호대");
                $(".list1>a").attr("href","<%=contextPath %>/health.pg?cpage=1&tp=31");
                $(".list2>a").attr("href","<%=contextPath %>/health.pg?cpage=1&tp=32");
                $(".list3>a").attr("href","<%=contextPath %>/health.pg?cpage=1&tp=33");
              }
        	if('<%=category %>'=="cycle"){
                $(".cate-top").text("자전거");
                $(".cate-middle").text("LED전등");
                $(".cate-bottom").text("보호장비");
                $(".list1>a").attr("href","<%=contextPath %>/cycle.pg?cpage=1&tp=41");
                $(".list2>a").attr("href","<%=contextPath %>/cycle.pg?cpage=1&tp=42");
                $(".list3>a").attr("href","<%=contextPath %>/cycle.pg?cpage=1&tp=43");
 			}

            });
      </script>
	
	


</body>
</html>
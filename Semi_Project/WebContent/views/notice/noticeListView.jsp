<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.common.PageInfo,java.util.ArrayList,com.kh.notice.model.vo.Notice"%>
<%

	PageInfo pi =(PageInfo)request.getAttribute("pi");
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="/Semi/resources/css/notice.css">
<style>
    .outer{
        background-color: aliceblue;
            color: darkgoldenrod;
            width: 1000px;
            margin: auto;
            margin-top: 50px;
            border : 1px solid black;
    }
   	table{
   	 	text-align:center;
    }

    .notice1{
      width: 100px;
      height: 60px;
      font-size: 13px;
      border: 1px black solid;
      border-radius: 5%;
      background-color: beige;
    }
    .notice11{
      width: 700px;
      height: 60px;
      font-size: 13px;
      border: 1px black solid;
      border-radius: 5%;
    }
    .notice1:hover{
      cursor: pointer;
    }
    .big-noticer{
      position: relative;
      left: 140px;
      
    }
    .container>h2{
      margin: 100px 0px;
    }
   

</style>


</head>
<body>
    <%@include file="/views/common/menubar.jsp"%>
    <div id="ccccc" style="height:100px;margin-top:30px;">
    <button style="font-size:20px;width:200px;height:50px;" onclick="location.href='FaqForm.fq?cpage=1'" class="btn btn-dark">FAQ</button> 
    <button style="font-size:20px;width:200px;height:50px;" onclick="location.href='listt.no?cpage=1'" class="btn btn-dark">????????????</button> 
    <button style="font-size:20px;width:200px;height:50px;" onclick="location.href='userQNAList.sc'" class="btn btn-dark">1:1??????</button> 
    </div>
    <div class="container">
  <h2 style="text-align: center"><b>????????????</b></h2>         
  <table class="big-noticer">
  	<thead>
          <%if(list.isEmpty()){%>
	      		<tr>
	      			<td colspan="5">???????????? ??????????????? ????????????.</td>
	      		</tr>
	          <%}else{%>
          
          <%for(Notice n : list) {%>
      <tr>
      	<th class="notice1"><%=n.getNoticeNo()%></th>
        <th class="notice11"><%=n.getNoticeTitle() %></th>
      </tr>
      
      <%} %>
      <%} %>
    </thead>
  </table>
  
</div>

   <script>
        $(function(){

            $(".notice1").click(function(){
              // console.log("??????");
              //??????????????? ???????????? ?????? ????????? ???????????? ?????? ?????? ????????? ????????????(?????????)
              //?????? tr??? ?????? td??? ?????? text??? ????????????
              var nno = $(this).text(); //??????????????? ??????
              console.log(nno);

              location.href='<%=contextPath%>/detaill.no?nno='+nno;
          });
            });
    </script>
  
     <br><br><br>
     
     
          <div class="paging-area" align="center">
       		<%if(currentPage!=1){ %>
            <button onclick="location.href='<%=contextPath%>/listt.no?cpage=<%=currentPage-1%>'">&lt;</button>
            <%} %>
            
            <%for(int i =startPage; i<=endPage; i++){ %>
	 			<%if(i!=currentPage){ %>
	            	<button onclick="location.href='<%=contextPath%>/listt.no?cpage=<%=i%>'"><%=i %></button>
                    <%}else{ %>
				  	<button disabled><%=i %></button>         
	            <%} %>
            <%} %>
            
            <%if(currentPage!=maxPage){ %>
            <button onclick="location.href='<%=contextPath%>/listt.no?cpage=<%=currentPage+1%>'">&gt;</button>
       		<%} %>
       
        </div>



  
        
        <br>
 

</body>
</html>
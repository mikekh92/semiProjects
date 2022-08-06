<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.kh.common.PageInfo,com.kh.product.model.vo.*,java.util.ArrayList"%>
    
    <%
    PageInfo pi =(PageInfo)request.getAttribute("pi");
    ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
    String msg = (String)session.getAttribute("alertMsg");
    int currentPage = pi.getCurrentPage();
    int startPage = pi.getStartPage();
    int endPage = pi.getEndPage();
    int maxPage = pi.getMaxPage();
    int paging;
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    

    
    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
            <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" href="/Semi/views/admin-css/admin_a_2.css">
    <title>product-body</title>
</head>
<style>
    #body{
        width: 100%;
        height: 100%;
        padding: 30px;
        font-size: 14px;
    }
    .btn-dark{
        float: right;
        margin-left: 20px;
    }
    table{
        padding: 0px;
        text-align: center;
        height: 20px;
    }
    table input[type="checkbox"]{
        height: 15px;
    }
    form{
        font-family: 'Sunflower', sans-serif;
    }
    .paging-area{
        width:1020px;
        height: 100px;
    }
    #search *{
        height: 100%;
    }
    #search{
        height: 40px;
    }
</style>
<body>
	<%@ include file="/views/common/adminMenubar.jsp" %>
    <div id="content_2">
        <div id="body">
            <!-- ----------------------------검색-------------------------------- -->
            <div id="search">
            <form action="searchProduct.pd" id="searchFrom">
                <label for="searchPd">상품명 검색</label>
                <input type="text" name="searchPd" id="search-pd" style="width: 300px;" >
                <button type="submit" class="btn btn-success" id="search">검색</button>
            </form>
        	</div>
			<!-- ----------------------------검색-------------------------------- -->
            
            
            <form action="delete.pd" method="get" id="form">
                <button type="button" class="btn btn-dark" id="sell">판매게시</button>
                <button type="button" class="btn btn-dark" id="delete">판매 중지</button>
                <button type="button" class="btn btn-dark" onclick="location.href='<%=contextPath%>/categoryList.pd'">상품등록</button>
                <br clear="both">
                <br><br>
                <table class="table table-bordered table-sm table-hover" style="width: 100%; height: 10px;">
                    <thead>
                        <th style="width: 5%;"><input type="checkbox" name="" id="allCheck"></th>
                        <th style="width: 10%;">번호</th>
                        <th style="width: 20%;">상품명</th>
                        <th style="width: 10%;">상품코드</th>
                        <th style="width: 15%;">제작업체</th>
                        <th style="width: 10%;">가격</th>
                        <th style="width: 10%;">수량</th>
                        <th style="width: 10%;">노출상태</th>
                        <th style="width: 10%;">삭제</th>
                    </thead>
                    <tbody id="listbody">
                    <%for(Product p : list){ %>
                        <tr>
                            <td class="1"><input type="checkbox" name="ckList" id="" value="<%=p.getProNo() %>"></td>
                            <td><%=p.getProNo() %></td>
                            <td><%=p.getProName() %></td>
                            <td><%=p.getProCode() %></td>
                            <td><%=p.getProMaker() %></td>
                            <td><%=p.getProPrice() %></td>
	                        <td><%=p.getProAmount() %></td>
	                        <td><%=p.getSellstat() %></td>
	                        <td><%=p.getStatus() %></td>
	                    </tr>
	                    <%} %>
	                </tbody>
	            </table>
	        </form>
	    </div>
    
        <br clear="both">
        <br><br><br>
	    <div class="paging-area" align="center">
            <%if(currentPage!=1){ %>
                <button onclick="location.href='<%=contextPath%>/list.pd?cpage=<%=currentPage-1%>'" class="btn btn-primary">&lt;</button>
                <%}else{ %>
                    <button onclick="location.href='<%=contextPath%>/list.pd?cpage=<%=currentPage-1%>'" disabled class="btn btn-primary">&lt;</button>
                    <%} %>
                    
            <%for(paging=startPage; paging<=endPage; paging++){%>
            	<%if(paging!=currentPage){ %>
                    <button onclick="location.href='<%=contextPath%>/list.pd?cpage=<%=paging%>'" class="btn btn-primary"><%=paging%></button>
                    <%}else{ %>
                        <button disabled class="btn btn-primary"><%=paging %></button>         
                        <%} %>
                        <%} %>
                        
                        <%if(currentPage!=maxPage){ %>
                            <button onclick="location.href='<%=contextPath%>/list.pd?cpage=<%=currentPage+1%>'">&gt;</button>
                            <%}else{%>
                                <button onclick="location.href='<%=contextPath%>/list.pd?cpage=<%=currentPage+1%>'" disabled>&gt;</button>
                                <%} %>
        </div>
    </div>                        
        <script>            
            $("#allCheck").click(function(){
                if($("#allCheck").is(":checked")){
                    $("input[name=ckList]:checkbox").prop("checked",true);
                }else{
                    $("input[name=ckList]:checkbox").prop("checked",false);
                }
                    
            });         

            $("#delete").click(function(){
                var qt=[];
                var count=0;
                var tq = $(":input[name=ckList]");
                for(var i = 0;i<tq.length;i++){

                    if(tq[i].checked==true){
                        qt[count]=tq[i].value;
                        count++;
                    }
                }
                $.ajax({
                    url : "delete.pd",
                    data : {
                        qt : qt
                    },
                    traditional:true,
                    success : function(){
                        window.location.reload(true);
                    }
                })
            });
            $("#sell").click(function(){
                var qt=[];
                var count=0;
                var tq = $(":input[name=ckList]");
                for(var i = 0;i<tq.length;i++){

                    if(tq[i].checked==true){
                        qt[count]=tq[i].value;
                        count++;
                    }
                }
                $.ajax({
                    url : "sell.pd",
                    data : {
                        qt : qt
                    },
                    traditional:true,
                    success : function(){
                        window.location.reload(true);
                    }
                })
            })

            $("#listbody td").not($(".1")).click(function(){
            	
                // var add ="<input type='hidden' name='imglength' value='"+count+"'>";
            	location.href = "<%=contextPath%>/detail.pd?proNo="+$(this).parent().children().eq(1).text();
				
            })
            $("#search").click(function(){
            	
            })

            
            </script>
</body>
</html>
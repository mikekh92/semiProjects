<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.common.PageInfo,com.kh.serviceCenter.model.vo.*,java.util.ArrayList" %>
    
    <%
    PageInfo pi =(PageInfo)request.getAttribute("pi");
    ArrayList<FAQ> list = (ArrayList<FAQ>)request.getAttribute("list");
    int search = (int)request.getAttribute("search");
    String scContent = (String)request.getAttribute("scContent");
    int currentPage = pi.getCurrentPage();
    int startPage = pi.getStartPage();
    int endPage = pi.getEndPage();
    int maxPage = pi.getMaxPage();
    int paging;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
        <!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>FAQ</title>
<style>
    #tables{
        width: 80%;
        margin-left: auto;
        margin-right: auto;
    }
</style>
</head>
<body>
    <%@ include file = "/views/common/menubar.jsp" %>
    
    <div id="content2">
        <div style="height: 200px;"></div>
        <div style="height: 100px; margin-left: 20%; font-size: large;">
            <form action="search.fq">
            <select name="search" id="search" class='smallcg form-control form-control-lg' required style='font-size: 20px; width: 15%; display: inline;'>
                <option value="1" name="title">제목</option>
                <option value="2" name="content">내용</option>
            </select>
            <input type="text" name="scContent" class="form-control" style='font-size: 20px; width: 50%; display: inline;'>
            <button type="submit" class="btn btn-info" style='font-size: 20px; width: 10%; display: inline;'>검색</button>
            </form>
        </div>

        <div id="tables">
            <table class="table table-bordered table-sm table-hover" style="width: 100%; height: 10px;">
                <thead>
                <tr>
                    <th width="10%">번호</td>
                    <th width="10%">카테고리</td>
                    <th width="30%">제목</td>
                    <th width="40%">내용</td>
                </tr>
                </thead>
                <tbody>
	                <%for(FAQ f : list){ %>
	                <tr>
	                    <td><%=f.getFaqNo() %></td>
	                    <td><%=f.getFaqCate() %></td>
	                    <td><%=f.getFaqTitle() %></td>
	                    <td><%=f.getFaqContent() %></td>
	                </tr>
                </tbody>
                <%} %>
            </table>
        </div>
    </div>
<div class="paging-area" align="center">
            <%if(currentPage!=1){ %>
                <button onclick="location.href='<%=contextPath%>/search.fq?cpage=<%=currentPage-1%>&search=<%=search%>&scContent=<%=scContent %>'" class="btn btn-primary">&lt;</button>
                <%}else{ %>
                    <button onclick="location.href='<%=contextPath%>/search.fq?cpage=<%=currentPage-1%>&search=<%=search%>&scContent=<%=scContent %>'" disabled class="btn btn-primary">&lt;</button>
                    <%} %>
                    
            <%for(paging=startPage; paging<=endPage; paging++){%>
            	<%if(paging!=currentPage){ %>
                    <button onclick="location.href='<%=contextPath%>/search.fq?cpage=<%=paging%>&search=<%=search%>&scContent=<%=scContent %>'" class="btn btn-primary"><%=paging%></button>
                    <%}else{ %>
                        <button disabled class="btn btn-primary"><%=paging %></button>         
                        <%} %>
                        <%} %>
                        
                        <%if(currentPage!=maxPage){ %>
                            <button onclick="location.href='<%=contextPath%>/search.fq?cpage=<%=currentPage+1%>&search=<%=search%>&scContent=<%=scContent %>'" class="btn btn-primary">&gt;</button>
                            <%}else{%>
                                <button onclick="location.href='<%=contextPath%>/search.fq?cpage=<%=currentPage+1%>&search=<%=search%>&scContent=<%=scContent %>'"  class="btn btn-primary" disabled>&gt;</button>
                                <%} %>
        </div>
        <script>
            $("tbody tr").click(function(){
                location.href="<%=contextPath%>/detail.fq?faqNo="+$(this).children().eq(0).text();
            });
        </script>


</body>
</html>
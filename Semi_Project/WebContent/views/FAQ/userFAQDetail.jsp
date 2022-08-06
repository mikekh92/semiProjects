<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.serviceCenter.model.vo.FAQ"%>
    
    <%
    FAQ f = (FAQ)request.getAttribute("f");
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
    textarea{
        height: 100%;
        width: 100%;
    }
</style>
</head>
<body>
    <%@ include file = "/views/common/menubar.jsp" %>

    <div style="height: 200px;"></div>
    <div id="tables">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th width="15%">번호 : <%=f.getFaqNo() %></th>
                    <th width="25%">카테고리 : <%=f.getFaqCate() %></th>
                    <th>제목 : <%=f.getFaqTitle() %></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>내용</td>
                    <td colspan="2"><textarea name="" id="" cols="30" rows="10" style="resize: none;" readonly><%=f.getFaqContent()%></textarea></td>
                </tr>
            </tbody>
        </table>
        <div align="center">
            <button type="button" class="btn btn-info" onclick="history.back();">뒤로가기</button>
        </div>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.notice.model.vo.Notice"%>
<%
	Notice notice = (Notice)request.getAttribute("notice");

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <!--Latest compiled and minified CSS-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

	<link rel="stylesheet" href="/Semi/views/admin-css/admin_b_2_1.css">
<style>
    #content_2_2{
        background-color: rgb(224, 243, 246);
            color: rgb(63, 59, 59);
            width: 95%;
            height: 60%;
            margin: auto;
            margin-top: 50px;
    }
    table{
        width: 70%;
        text-align: center;
    }
</style>   
</head>
<body>
	<%@include file="/views/common/adminMenubar.jsp" %>
    <div id="content_2">
        <!--왼쪽 여백--><div id="content_2_empty"></div>
        <div id="content_2_1">
            <h2 align="center">공지사항 상세보기</h2>
        </div>
        <!--게시글 테이블 작업 시작-->
        <div id="content_2_2">
            <br>
            <table align="center" border="1">
                <tr>
                    <th width="70px">제목</th>
                    <td width="350px" colspan="3"><%=notice.getNoticeTitle()%></td>                    
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><%=notice.getNoticeWriter() %></td>
                    <th>작성일</th>
                    <td><%=notice.getNoticeDate() %></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3">
                        <p style="height: 200px;"><%=notice.getNoticeContent() %></p>
                    </td>
                </tr>
            </table>
            <br><br>
        </div>
        <div id="content_2_3" align="center">
            <a href="<%=contextPath%>/list.no?cpage=1" class="btn btn-success">목록으로 가기</a>
<%--             <%if(loginUser!=null && loginUser.getUserId().equals(notice.getNoticeWriter())) %> --%>
            <a href="<%=contextPath%>/updateForm.no?nno=<%=notice.getNoticeNo()%>" class="btn btn-warning">수정하기</a>
            <a href="<%=contextPath%>/delete.no?nno=<%=notice.getNoticeNo()%>" class="btn btn-danger">삭제하기</a>
<%--             <%} %> --%>
        </div>
    </div>
</body>
</html>
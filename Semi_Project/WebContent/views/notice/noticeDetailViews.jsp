<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,com.kh.member_2.model.vo.MemberUser, com.kh.notice.model.vo.Notice"%>
    <%
    ArrayList<Notice> notice = (ArrayList<Notice>)request.getAttribute("notice");


    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@include file="/views/common/menubar.jsp"%>

	<div class="outer">
        <br><h2 align="center">공지사항 상세보기</h2><br>
	
        <table id="detail-area" align="center" border="1">
            <tr>
                <th width="70px">제목</th>
				<td width="350px" colspan="3"><%=notice.get(0).getNoticeTitle()%></td>
            </tr>
            <tr>
                <th>작성자</th>

				<td><%=notice.get(0).getNoticeWriter()%></td>
                <th>작성일</th>

				<td><%=notice.get(0).getNoticeDate()%></td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3">

						<p style="height: 150px;"><%=notice.get(0).getNoticeContent()%></p>	
                </td>
            </tr>
        </table>
        
        <br>
		
        <div align="center">
            <a href="<%=contextPath%>/listt.no?cpage=1" class="btn btn-success">목록으로 가기</a> <br>
			<br>
        </div>
        


    </div>
</body>
</html>
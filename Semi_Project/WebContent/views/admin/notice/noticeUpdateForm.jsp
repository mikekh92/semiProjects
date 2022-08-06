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
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

	<link rel="stylesheet" href="/Semi/views/admin-css/admin_b_2_3.css">
    <style>
        #content_2_1{
                background-color: rgb(239, 244, 245);
                    color: rgb(45, 44, 44);
                    width: 95%;
                    height: 70%;
                    margin: auto;
                    margin-top: 50px;
        }
        #updateForm input,#updateForm textarea{
            width: 100%;
            box-sizing: border-box;
        }
        #updateForm table{
            border: 1px soild white;
        }
    </style>          
</head>
<body>
	<%@include file="/views/common/adminMenubar.jsp" %>
    <div id="content_2">
        <!--왼쪽 여백--><div id="content_2_empty"></div>
        <!--게시글 테이블 작업 시작-->
        <div id="content_2_1">
            <br> <h2 align="center">공지사항 수정하기</h2>
                <form id="updateForm" action="<%=contextPath%>/update.no" method="post">
                	<input type="hidden" name="nno" value="<%=notice.getNoticeNo()%>">
                    <table align="center">
                        <tr>
                            <th width="50px">제목</th>
                            <td width="400px"><input type="text" name="title" value="<%=notice.getNoticeTitle() %>" required></td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <textarea name="content" id="" cols="30" rows="10" style="resize: none;" required ><%=notice.getNoticeContent() %></textarea>
                            </td>
                        </tr>
                    </table>
        
                    <div align="center">
                    <button type="submit" class="btn btn-warning" id="update">수정하기</button>
                    <button type="button" class="btn btn-info" onclick="history.back();">뒤로가기</button>
                    </div>
                </form>        
        </div>
        <!--게시글 테이블 작업 끝-->
    </div>
</body>
<script>
	$(function(){
		
		$("#update").click(function(){
		
		var msg2 ="수정하시겠습니까?";
		
		if(msg2){
			alert("수정확인")
		}else{
			alert("수정취소");
		}
		
// 		if(msg2!="null") {
// 			if(confirm(msg2)){
// 				confirm(msg2);
<%-- 				<%session.removeAttribute("confirmMsg");%> --%>
// 			}
// 			}
		});
	});
</script>
</html>
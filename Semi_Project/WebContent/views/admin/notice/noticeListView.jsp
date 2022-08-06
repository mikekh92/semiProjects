<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.common.PageInfo,java.util.ArrayList,com.kh.notice.model.vo.Notice"%>
<%
	ArrayList <Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int startPage= pi.getStartPage();
	int endPage= pi.getEndPage();
	int maxPage= pi.getMaxPage();
	int listCount=pi.getListCount();
	

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

	<link rel="stylesheet" href="/Semi/views/admin-css/admin_b_2.css">
<style>
    #content_2_5{
    height:70%;
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
                <h2>공지사항관리</h2>
            </div>
            <!--input 바 시작-->
            <div id="content_2_2">
                <form action="search.no?cpage=1" method="post">
                    <div id="content_2_2_1">
                        <div class="selecdiv col-sm-2">
                        <select id="select" class="form-control" name="firstSelect">
                            <option value="NOTICE_TITLE">글제목</option>
                        </select>
                        </div>
                        <div class="col-sm-5">
                            <input type="text" name="secondSelect" id="search_user" class="form-control" placeholder="내용을 입력해주세요"> 
                        </div>   
                        <div class="col-sm-3">
                            <button type="submit" id="search_btn"><img src="/Semi/views/image/search.png" id="search_img">검색</button>
                        </div>    
                    </div>      
                </form>
            </div>
            <!--input 바 끝-->
    
            <!--회원 명 수 및 버튼 시작-->
            <div id="content_2_3">
    
                검색 회원 수 <span style="color:red"><%=listCount %></span>명
            </div>
            <div id="content_2_4">
            
<%--             <%if(loginUser!= null && loginUser.getUserId().equals("admin")){ %> --%> 
            		
                <button type="button" class="btn btn-warning" onclick="location.href='<%=contextPath %>/enrollForm.no'";>작성하기</button>
                <button type="button" class="btn btn-warning" id="deleting">삭제</button>
                
            </div>
            
<%--             <%} %> --%>
            
            <!--회원 명 수 및 버튼 끝-->
    
            <!--게시글 테이블 작업 시작-->
            <div id="content_2_5">
                <br>    
<%--                         <form action="<%=contextPath%>/list.no" method="post"> --%>
<!--                         <input type="text" name="selectNumber" id="selectNumber">  		 -->
<!--                         <select id="selectNumberbox" class="form-control" name="selectNumberbox" onchange="selectNumber()"> -->
<!--                             <option value="5">5개</option> -->
<!--                             <option value="10" selected="selected">10개</option> -->
<!--                             <option value="20">20개</option> -->
<!--                         </select> -->
<!--                         	<button type="submit">선택</button> -->
<!--                         </form>          -->
                
                	<table align="center" class="table-hover" >
                    <thead>
                        <th width="4%">
                            <input type="checkbox" name="" id="">
                        </th>
                        <th width="6%">글번호</th>
                        <th width="50%">글제목</th>
                        <th width="15%">작성자</th>
                        <th width="10%">조회수</th>
                        <th width="15%">작성일</th>
                    </thead>
                    <tbody>
                    <%if(list.isEmpty()){ %>
                    		<tr>
                    			<td colspan="6">존재하는 공지 없음</td>
                    		</tr>
                    <%}else{ %>
                    <%for(Notice n : list) {%>
                        <tr>
                            <td ondblclick="event.cancelBubble='true'">
                            	<input type="checkbox" name="deletes" value="<%=n.getNoticeNo()%>">
                            </td>
                            <td><%=n.getNoticeNo() %></td>
                            <td><%=n.getNoticeTitle() %></td>
                            <td><%=n.getNoticeWriter() %></td>
                            <td><%=n.getNoticeViewNo() %></td>
                            <td><%=n.getNoticeDate() %></td>
                        </tr>
                   	 <%} %>
                    <%} %> 
                   </tbody>
                </table>    
                
            </div>
            <!--게시글 테이블 작업 끝-->
            
            <!--글 목록 시작-->
        
            <div id="content_2_6">
                <ul class="pagination">
                	<%if(currentPage!=1){ %>
                    <li class="page-item"><a class="page-link" href="<%=contextPath%>/list.no?cpage=<%=currentPage-1%>">&lt;</a></li>
                    <%} %>
                    <%for(int i=startPage; i<=endPage; i++){ %>
                    	<%if(i!=currentPage){%>
                    		<li class="page-item"><a class="page-link" href="<%=contextPath%>/list.no?cpage=<%=i%>"><%=i %></a></li>
                    	<%}else{ %>	
                    		<li class="page-item active"><a class="page-link" href=""><%=i %></a></li>
                    	<%} %>
                    <%} %>
                    <%if(currentPage!=maxPage){ %>
                    <li class="page-item"><a class="page-link" href="<%=contextPath%>/list.no?cpage=<%=currentPage+1%>">&gt;</a></li>
                    <%} %>
                </ul>
            </div>
            <!--글 목록 끝-->
        </div>
</body>
<script>
    $(function(){
        $(".table-hover>tbody>tr").dblclick(function(){ 
            location.href="<%=contextPath%>/detail.no?nno="+$(this).children().eq(1).text();
        });
        
    	$("#deleting").click(function(){
    		
    		var temp = $("input[name=deletes]:checked");
    		
    		var values = [];
    		for(var i=0;i<temp.length;i++){
//     			values.push(parseInt(temp[i].value));
    			values.push(temp[i].value);
    		}
    		
    		var nowPageNo = "<%=currentPage%>";
    		
    		$.ajax({
    			type: "POST",
    			url : "deleting.no",
    			traditional : true,
    			data: {values:values,}, 
    			success: function(result){
    					window.location.href="<%=contextPath%>/list.no?cpage="+nowPageNo;

<%--     				location.href="<%=contextPath%>/deliting.no?nno="+$(".table-hover>tbody>tr").children().eq(1).text(); --%>
    			},
    			error:function(){  
    	            //에러가 났을 경우 실행시킬 코드
    			}
    		})

     	});
    	
    });
</script>
</html>
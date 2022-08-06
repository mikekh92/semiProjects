<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        
    
    <meta charset="UTF-8">
    <title>Insert title here</title>
      <link rel="stylesheet" href="/WebContent/resources/css/categoryPage.css">
  <link rel="stylesheet" href="/WebContent/resources/css/main.css">
  <link rel="stylesheet" href="/WebContent/resources/css/detailPage.css">
  <link rel="stylesheet" href="/WebContent/resources/css/notice.css">
    <style>
    
    .outer{
        color: crimson;
        width: 1000px;
        /* margin: auto;
        margin-top: 50px; */
    }
    #mypage-form>tr>td{
        /* margin: auto; */
        margin-top: 200px;
    }
    #mypage-form input {margin:5px}

    #side_ng{
        border: 1px solid black;
        list-style-type: none;
        position:absolute;

        background-color: beige;
        text-align: left;
        height: 100%;
        width: 130px; 
        /* height: 500px; */
        padding: 150px 20px 50px 0px;
        margin: 0px 0px 0px 0px;
    }
    
    #side_ng>li{
        /* border: 1px solid black; */
        width: 100px;
        margin-left: 20px;
    }
    
    #side_ng>li:hover{
        transform: scale(1.2);
    }
    
    #side_ng>li>a{
        padding: 7px;
        font-size: 16px;
        font-weight: bold;
        text-decoration: none;
        color: rgb(108, 117, 117);
    }
    </style>
</head>
<body>
	<%@include file="/views/common/menubar.jsp"%>
    
    <%
    String userId = loginUser.getUserId();
    String userName = loginUser.getUserName();
    String userPw = loginUser.getUserPw();
    //삼항연산자 = 조건 ? 참일때 실행할 구문 : 거짓일때 실행할 구문;
    String phone = (loginUser.getPhone() == null) ? "":loginUser.getPhone();//삼항 연산자
    String email = (loginUser.getEmail() == null) ? "":loginUser.getEmail();  
    %>  
        
    
    <div class="outer">
        
        <form id="mypage-form" action="<%=contextPath%>/update.me" method="post">
            
            <div id="side_ng">
                <li>    <a href="/Semi/myPage.me">기본정보</a>    </li><br>                
                <li>    <a href="<%=contextPath %>/views/member/myPage_Modify.jsp">정보수정</a>    </li><br>
                <li>    <a href="<%=contextPath %>/views/member/myPage_OrderCheck.jsp">주문조회</a>    </li><br>
                <li>    <a href="<%=contextPath %>/views/member/myPage_Withdrawal.jsp" style=" color: rgb(80, 241, 31)">회원탈퇴</a>    </li><br>
            </div>
	
		
				<div style="height:100px"></div>
                <div id="title-box" style="text-align: center;">
                    <h2>회원탈퇴</h2>
                 </div>
            <table style="text-align: bottom; border: 1px solid black; margin: 0 auto; height: 300px;">
                
                

                    <tr>
                        <td>* 아이디</td>
                        <td><input  type="text" name="userId" maxlength="12" required value="<%=userId%>" readonly></td>
                        <!-- <td><button type="button" onclick="">중복확인</button></td> -->
                    </tr>
                    <tr>
                        <td>* 이름</td>
                        <td><input type="text" name="userName" maxlength="6" required value="<%=userName%>"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td><input type="text" name="phone" placeholder="-포함해서 입력" value="<%=phone%>"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td><input type="email" name="email" value="<%=email%>"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>주소</td>
                        <td><input type="text" name="address" value=""></td>
                        <td></td>
                    </tr>
                    
            </table>
        </form>
    </div>


       
        

        <div align="left" style=" width: 100px; margin-left: 545px;">
            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteForm">회원 탈퇴</button>
        </div>
        
        
        
        <div class="modal" id="deleteForm">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">회원 탈퇴</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <!-- Modal body -->
                    <div class="modal-body" align="center">
                        <b>회원 탈퇴 후 해당 정보는 복구가 불가능 합니다. <br> 정말로 탈퇴 하시겠습니까? </b> <br><br>
                        <form action="<%=contextPath%>/delete.me" method="post">
                            <%-- <input type="hidden" name="userId" value="<%=userId%>"> --%>
                            <table>
                                <tr>
                                    <td>비밀번호 입력 : </td>	
                                    <td><input type="password" name="userPw" required></td>			
                                </tr>
                            </table>
                            <br>
                            <button type="submit" class="btn btn-danger">탈퇴하기</button>		
                        </form>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>


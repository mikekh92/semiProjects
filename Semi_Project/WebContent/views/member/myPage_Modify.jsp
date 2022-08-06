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
        color: green;
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
                <li>    <a href="<%=contextPath %>/views/member/myPage_Modify.jsp" style=" color: rgb(80, 241, 31)">정보수정</a>    </li><br>
                <li>    <a href="<%=contextPath %>/views/board/boardListView.jsp">주문조회</a>    </li><br>
                <li>    <a href="<%=contextPath %>/views/member/myPage_Withdrawal.jsp">회원탈퇴</a>    </li><br>
            </div>
            
            
            <div style="height:100px"></div>
            
                 <div id="title-box" style="text-align: center;">
                    <h2>정보수정</h2>
                 </div>

            <table style="text-align: bottom; border: 1px solid black; margin: 0 auto; height: 300px;">
                

                
                
                    <tr>
                        <td>* 아이디</td>
                        <td><input  type="text" name="userId" maxlength="12" required value="<%=userId%>" readonly></td>
                    </tr>
                    <tr>
                        <td>* 이름</td>
                        <td><input type="text" name="userName" maxlength="6" required value="<%=userName%>" readonly></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td><input type="text" name="phone" placeholder="-포함해서 입력" value="<%=phone%>" readonly></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td><input type="text" name="email" value="<%=email%>" readonly></td>
                        <td></td>
                    </tr>
            </table>
        </form>
    </div>
        
        <div align="center">
            <button type="submit" class="btn btn-success" data-toggle="modal" data-target="#updateForm">정보 변경</button>
            <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#updatePwForm">비밀번호 변경</button>
        </div>
    </form>
</div>






<!-- The Modal -->
<div class="modal" id="updatePwForm">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">비밀번호 변경</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        	<form action="<%=contextPath%>/updatePw.me" method="post">

					<input type="hidden" name="userId" value="<%=userId%>">
                <table>
                    <tr>
                        <td>현재 비밀번호</td>
                        <td><input type="password" name="userPw" id="enterPw" required></td>
                    </tr>
                    <tr>
                        <td>변경할 비밀번호</td>
                        <td><input type="password" name="updatePw" id="Pw1" required></td>
                    </tr>
                    <tr>
                        <td>변경할 비밀번호 확인</td>
                        <td><input type="password" name="checkPw" id="Pw2" required></td>
                    </tr>
                </table>
                <br>
                <button type="submit" class="btn btn-dark" onclick="return validatePw();">비밀번호 변경</button>
            </form>

            <script>

                function validatePw(){
                        if($("input[name=updatePw]").val() != $("input[name=checkPw]").val()){
                            alert("변경할 비밀번호와 비밀번호 확인이 맞지 않습니다.");
                            return false;
                        }
                   }
                
            </script>
      </div>
    </div>
  </div>
</div>


<!-- The Modal -->
<div class="modal" id="updateForm">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">정보 변경</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        	<form action="<%=contextPath%>/update.me" method="post">
					<input type="hidden" name="userId" value="<%=userId%>">
                <table>
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

                </table>
                <br>
                <button type="submit" class="btn btn-dark" onclick="return validate();">정보 변경</button>
                
            </form>

</body>
</html>
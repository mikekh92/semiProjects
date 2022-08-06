<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Address"%>
    
    <%
		Address ad = (Address)request.getAttribute("AddressPw");
    	
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="../WebContent/resources/css/categoryPage.css">
  <link rel="stylesheet" href="/WebContent/resources/css/main.css">
  <link rel="stylesheet" href="../WebContent/resources/css/detailPage.css">
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
	    
	    String phone = (loginUser.getPhone() == null) ? "":loginUser.getPhone();
	    String email = (loginUser.getEmail() == null) ? "":loginUser.getEmail();
    %>
     
     
     
     
     
    <div class="outer">
        
        <form id="mypage-form" action="<%=contextPath%>/update.me" method="post">
        
            <div id="side_ng">
                <li>    <a href="<%=contextPath %>/myPage.me" style=" color: rgb(80, 241, 31)">기본정보</a>    </li><br>                
                <li>    <a href="<%=contextPath %>/views/member/myPage_Modify.jsp">정보수정</a>    </li><br>
                <li>    <a href="<%=contextPath %>/views/member/myPage_OrderCheck.jsp">주문조회</a>    </li><br>
                <li>    <a href="<%=contextPath %>/views/member/myPage_Withdrawal.jsp">회원탈퇴</a>    </li><br>
            </div>
            <div style="height:150px"></div>
                <div id="title-box" style="text-align: center;">
                    <h2>기본정보</h2>
                 </div>
           		 <table style="text-align: bottom; border: 1px solid black; margin: 0 auto; height: 500px; margin-left: 200px;">
                    <tr>
                        <td style="width:100px;">* 아이디</td>
                        <td><input  type="text" name="userId" maxlength="12" required value="<%=userId%>" readonly></td>
                        <!-- <td><button type="button" onclick="">중복확인</button></td> -->
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
                        <td><input type="email" name="email" value="<%=email%>" readonly></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>주소</td>
                        <td><input type="text" name="address" value="<%=ad.getPost_Code()%>" readonly></td><br>
                        <td><input type="text" name="address" value="<%=ad.getRoad_Address()%>" readonly></td><br>

                        <td></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="address" value="<%=ad.getJibun_Address()%>" readonly></td><br>
                        <td><input type="text" name="address" value="<%=ad.getDetail_Address()%>" readonly></td><br>
                        <td><input type="text" name="address" value="<%=ad.getExtra_Address()%>" readonly></td>
                    </tr>



                </table>
            </form>
        </div>

       
</body>
</html>


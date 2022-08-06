<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList, com.kh.basket1.model.vo.Basket,com.kh.member_2.model.vo.MemberUser, com.kh.basket1.model.service.basket1Service, java.net.URLEncoder" %>
<%
 //   String name = (String)request.getAttribute("name");
 //   String email = (String)request.getAttribute("email");
 //  String phone = (String)request.getAttribute("phone");
 //  String address = (String)request.getAttribute("address");
  //  int totalPrice = (int)request.getAttribute("totalPrice");
  	 MemberUser loginUser = (MemberUser)request.getSession().getAttribute("loginUser");
     String name = (String)request.getParameter("name");
     String email = (String)request.getParameter("email");
     String phone = (String)request.getParameter("phone");
     String address = (String)request.getParameter("address");
     String stotalPrice = (String)request.getParameter("totalPrice");
     if(request.getAttribute("sw")!=null){
         name = String.valueOf(request.getAttribute("name"));
         email = String.valueOf(request.getAttribute("email"));
         phone = String.valueOf(request.getAttribute("phone"));
         address = String.valueOf(request.getAttribute("address"));
         stotalPrice = String.valueOf(request.getAttribute("totalPrice"));
     }
     
     int totalPrice = Integer.parseInt(stotalPrice);
     System.out.println("name: "+name);
    System.out.println("email: "+email);
     System.out.println("phone: "+phone);
     System.out.println("address: "+address);
     System.out.println("stotalPrice: "+stotalPrice);
     System.out.println("totalPrice: "+totalPrice);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DS SPORTS</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
    <script>
    $(function(){


        var IMP = window.IMP; // 생략가능
        IMP.init('imp76914986'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        IMP.request_pay({
            pg : 'html5_inicis',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '당산 스포츠 결제건',
            amount : <%=totalPrice%>,
            buyer_email : '<%=email%>',
            buyer_name : '<%=name%>',
            buyer_tel : '<%=phone%>',
            buyer_addr : '<%=address%>',
            buyer_postcode : '123-456',
            //m_redirect_url : 'http://www.naver.com'
        }, function(rsp) {
            if ( rsp.success ) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                jQuery.ajax({
                    url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid
                        //기타 필요한 데이터가 있으면 추가 전달
                    }
                }).done(function(data) {
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                    if ( everythings_fine ) {
                        msg = '결제가 완료되었습니다.';
                        msg += '\n고유ID : ' + rsp.imp_uid;
                        msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                        msg += '\결제 금액 : ' + rsp.paid_amount;
                        msg += '카드 승인번호 : ' + rsp.apply_num;
                        
                        alert(msg);

                    } else {
                        //[3] 아직 제대로 결제가 되지 않았습니다.
                        //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                    }
                });
          
                //성공시 이동할 페이지
                
                window.location.href="/Semi/orderCon.or?order=<%=loginUser.getUserNo()%>";
                    <%--  location.href='<%=request.getContextPath()%>/order/paySuccess?msg='+msg; --%>
                } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="<%=request.getContextPath()%>/orderCan.or?order=<%=loginUser.getUserNo()%>";
                alert(msg);
            }
        });
        
    });
    </script> 
 
</body>
</html>
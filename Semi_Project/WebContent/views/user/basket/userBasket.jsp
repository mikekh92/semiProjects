<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.memManage.model.vo.*,com.kh.serviceCenter.user.model.vo.Basket,java.util.ArrayList,com.kh.member_2.model.vo.MemberUser"%>
    
    <%
    ArrayList<Basket> list = (ArrayList<Basket>)request.getAttribute("list");
    int totalPrice=0;
    int count = 1;
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
<title>Insert title here</title>
  <style>
    table{
          font-size: 18px;
          text-align: center;
          vertical-align: middle;
          display: table;
    }
    tfoot{
        font-size: 23px;
    }
    table th{
        text-align: center;
    }
    img{
        width: 150px;
        height: 150px;
    }
  </style>
</head>
<body>
    <%@ include file = "/views/common/menubar.jsp" %>
  <div class="container" style="border: 1px solid black;">
    <div  style="display: inline;">
        <h2  style="display: inline-block;">ORDER / PAYMENT</h2>
    </div>
    <div style="float: right; margin-top: 25px;">
        장바구니 ▶ 주문서 ▶ 주문완료
    </div>
     <hr style="height: 2px; background-color: lightgray;">         
    <table class="table">
        <thead>
            <tr>
                <th><input type="checkbox" id="allcheck"></th>
                <th>전체</th>
                <th>사진</th>
                <th>상품명</th>
                <th>판매가</th>
                <th>수량</th>
                <th>주문금액</th>
            </tr>
      </thead>
        <tbody>
        <%for(Basket b : list){ %>
            <tr class="basketList">
                <td style="vertical-align: middle;"><input type="checkbox" name="checkbox"></td>
                <td style="vertical-align: middle;"><%=count%><%count++; %></td>
                <td style="vertical-align: middle;">
                    <div class="image">
                    <img src="<%=b.getProImage() %>" alt="" width="150px" height="150px">
                    </div>
                </td>
                <td style="vertical-align: middle;"><%=b.getProName() %></td>
                <td style="vertical-align: middle;"><%=b.getProPrice() %></td>
                <td style="vertical-align: middle;"><input type="number" value='<%=b.getPayOrderNo() %>' maxlength="2" oninput = "maxLengthCheck(this)"style="width:50px;" class="payOrderNo" min="1"></td>
                <td style="vertical-align: middle;"><%=b.getProPrice() * b.getPayOrderNo()%></td>
            </tr>
            <%totalPrice+= b.getProPrice() * b.getPayOrderNo();%>
            <%} %>
        </tbody>
        <tfoot>
            <tr align="right">
                <td colspan="9">총 주문금액 = <span id="span"><%=totalPrice%></span></td>
            </tr>
            <tr>
                <form action="/Semi/views/payment/kakao.jsp" id="kakaoForm">
                    <input type="hidden" name="name"  value='<%=loginUser.getUserName() %>'>
                    <input type="hidden" name="email"  value='<%=loginUser.getEmail() %>'>
                    <input type="hidden" name="phone"  value='<%=loginUser.getPhone() %>'>
                    <input type="hidden" name="address"  value="인천광역시 부평동 충선로">
                    <input type="hidden" name="totalPrice" id="totalprice" value="<%=totalPrice%>">
                <td colspan="9"><button class="btn btn-dark" type="button" style="float: right;" id="payMentBtn">결제하기</button></td>
            </form>
            </tr>
        </tfoot>
    </table>

  </div>
  <script>
  
      $(function(){
        var totalPrice = $("#span").text();
        totalPrice = parseInt(totalPrice);
        var totalPriceVal = totalPrice
        
        $("input:checkbox").attr("checked",true);
        

		var check = [];
		var basket = [];
		var count=0;
		<%for(Basket b : list){%>
			check[count] = <%=b.getBasketNo()%>
			basket[count] = <%=b.getBasketNo()%>
			count++;
		<%}%>
        $("#allcheck").click(function(){

            if($(this).is(":checked")){
                $("input[name=checkbox]").prop("checked",true);
                totalPrice=totalPriceVal;
                check = basket;
                console.log(check);
            }else{
                $("input[name=checkbox]").prop("checked",false);
                totalPrice=0;
                check = check.map(e => 0);
                console.log(check);
            }
            $("#totalprice").val(totalPrice);
            $("#span").html(totalPrice);

        });
        $("input[name=checkbox]").change(function(){
            var total = $(this).parent().parent().children().eq(6).text();
            total = parseInt(total);
            if($(this).is(":checked")){
                totalPrice+=total;
                check[$("input[name=checkbox]").index(this)] = basket[$("input[name=checkbox]").index(this)];
                console.log(check);

            }else{
                totalPrice-=total;
                check[$("input[name=checkbox]").index(this)] = 0;
                console.log(check);
            }
            $("#totalprice").val(totalPrice);
            $("#span").html(totalPrice);
        });
       
        
        $(".payOrderNo").focusin(function(){
        	console.log($(this).val());
        	$(this).data('val',$(this).val());
        	
        })
        
        $(".payOrderNo").change(function(){
          var checked = $(this).parent().parent().children().eq(0).children();
      	  var price = $(this).parent().parent().children().eq(4).text();
      	  var total = $(this).parent().parent().children().eq(6);
      	  
      	  var differNo = $(this).val() -  $(this).data('val');
      	  var plus = price * $(this).val();
      	  var totalPlus = price * differNo;      	  


      	  console.log(totalPlus);
      	  
      	  total.text(plus);

		  if(checked.prop('checked')==true){
			  totalPrice = parseInt(totalPrice);
			  totalPrice = totalPrice + totalPlus;
			  $("#span").html(totalPrice);
		  }
		  totalPriceVal = totalPriceVal + totalPlus;
		  $(this).data('val',$(this).val());
        })
        
        
        
        
        $("#payMentBtn").click(function(){
        	var orderNo = [];
        	var count=0;
        	<%for(Basket b : list){%>
        		orderNo[count] = $(".basketList").eq(count).children().eq(5).children().eq(0).val();
        		count++;
        	<%}%>
            $("#totalprice").val(totalPrice);
        	var form = document.getElementById("kakaoForm");
        	$.ajax({
        		url:"/Semi/confirmBasket.ba",
        		data:{bano : check,
        			orderNo : orderNo},
    			traditional : true,
    			success: function(result){
    				form.submit();
    			},
    			error: function(){
    				
    			}
        	});
        	
        })
        
        window.onpageshow = function(event) {
            if ( event.persisted || (window.performance && window.performance.navigation.type == 2)) {
                $.ajax({
              	  url:"/Semi/orderCan.or",
                  	  data:{order : <%=loginUser.getUserNo()%>}
                });
            }
        }	
      })
	

	function maxLengthCheck(object){
    if (object.value.length > object.maxLength){
      //object.maxLength : 매게변수 오브젝트의 maxlength 속성 값입니다.
      object.value = object.value.slice(10, object.maxLength);
    }    
  }
      

  </script>
  
  
  
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,com.kh.product.model.vo.Product"%>
    <% 
    ArrayList<Product> pr = (ArrayList<Product>)request.getAttribute("list");
       int proNo = (int)pr.get(0).getProNo(); 
       int price = pr.get(0).getProPrice();

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="/Semi/resources/css/detailPage.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
table{
	text-align : center;
}	
</style>
</head>
<body>
<%@include file="/views/common/menubar2.jsp"%>
	
	
     <!-- 상품 디테일 헤더부분 -->
      <div class="detail-top">
        <!-- 디테일 헤더 왼쪽 -->
        <div id="detail-top-left" style="margin-left:300px;">
			<img src='<%=pr.get(0).getProImage() %>' width="500px" height="500px">
        </div>
        <!-- 디테일 헤더 오른쪽 위-->
        <div id="detail-top-right">
          <pre id="pr-top">
            <h2 style="text-align: center;">Product Info제품정보<br></h2>
            시즌 도움말 보기 / 성별 2022 S/S / 여 <br>
            조회수(1개월) 400회 이상 <br>
            좋아요  12 <br>
          </pre>
          <pre id="pr-top">
            <h2 style="text-align: center;">Delivery Info배송정보</h2><br>
            배송 방법 국내 배송 / 입점사 배송 / 로젠택배<br>
            Price Info가격정보 <br>
            당산스포츠 판매가 228,000원<br>
          </pre>
          <!-- 디테일 헤더 오른쪽 아래-->
          <div id="detail-top-right-bottom">
            <div id="buy-order">
            <button id="buy">구매하기</button>
            <div class="order1"><button id="order11">찜하기</button></div>
            <div class="order2"><button id="order22">장바구니</button></div>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              
              <h3 style="display: inline-block;" id="total">상품 총금액 : 20,000원</h3>
            </div>
          </div>
        </div>
      </div>

      <div class="detail-middle">
        <div id="detail-button">
          <button id="content">상세</button>
          <button id="reviews">리뷰</button>
        </div>
        <div id="pr-description" style="background-color:white;border:0px;">
        	<img src='<%=pr.get(0).getProDes() %>'>
        </div>
        
        <div id="pr-content" style="display:none">
<!--         <form action="reviewlist.ro" method="post"> -->
          <table align="center">
            <tr>
              <th>리뷰제목</th>
              <td>
<!--                 <input type="text" name="insertReviewTitle" id="insertReviewTitle" required> -->
				<textarea name="insertReviewTitle" id="insertReviewTitle" cols="10" rows="1" required></textarea>
              </td>
            </tr>
            <tr>
              <th>리뷰작성</th>
              <td>
                <textarea name="insertReviewContent" id="insertReviewContent" cols="100" rows="15" required></textarea>
              </td>
            </tr>  
            <tr>
            	<td></td>   
              	<td align="center">
              		<button onclick="insertReview();">리뷰달기</button>
              	</td>
            </tr>
          </table>  
<!--         </form> -->
        </div>
        
        <div id="pr-answer" align="center" style='border: 0px solid black;display:none'>

        </div>
        
        


<!-- modalEnd -->

<!--         <div id="pr-reviews"> -->
<!--           <div class="review-score"> -->
<!--             <h3 style="display: inline-block;">사용자 리뷰 총 평점수&nbsp;&nbsp; ★★★★☆ &nbsp;&nbsp;4.7</h3> -->
<!--           </div> -->
<!--           <div id="stars-view"> -->
          
<!--             <h4>별점 개수별로 조회</h2> -->
<!--             <select name="star" id="star"> -->
<!--               <option value="5">★★★★★</option> -->
<!--               <option value="4">★★★★☆</option> -->
<!--               <option value="3">★★★☆☆</option> -->
<!--               <option value="2">★★☆☆☆</option> -->
<!--               <option value="1">★☆☆☆☆</option> -->
<!--             </select> -->
<!--           </div> -->
<!--         </div> -->
<!--         <div id="pr-question"></div> -->
<!--       </div> -->

      <script>
        $('#content').click(function(){
        	$("#pr-description").css("display","block");
        	$("#pr-content").css("display","none");
        	$("#pr-answer").css("display","none");
        });
        
        
        $(function(){
        	selectReview();
        	
        })
        $("#reviews").click(function(){
        	$("#pr-description").css("display","none");
        	$("#pr-content").css("display","block");
        	$("#pr-answer").css("display","block");
        	
        })
        function insertReview(){
			$.ajax({
				url : "insertReview.ro",
				data : {
					insertReviewTitle : $("#insertReviewTitle").val(),
					insertReviewContent : $("#insertReviewContent").val(),
					productNo :	<%=proNo%>,
					
				},
				type : "post",
				success : function(result){
					if(result>0){
						console.log(1);
						selectReview();
						$("#insertReviewTitle").val("");
						$("#insertReviewContent").val("");
					}
				},
				error : function(){
					console.log("ajax 통신 실패");	
				}
			})	
		}
        
        // 리뷰 하기
		
        //리뷰 조회
        function selectReview(){
        	$.ajax({
        		url : "reviewlist.ro",
         		data : { productNo : <%=proNo%>},
        			success : function(list){
        				var row = "";
        				for (var i in list) {
        					row += "<br><br><table border='1' width='1000px' style='background-color: antiquewhite;'>"
        						 + "<tr>"
        						 + "<th>리뷰번호</th>"	
	        					 + "<td>"+list[i].reviewNo+"</td>"
	        					 + "<th>상품명</th>"
	        					 + "<td>"+list[i].reviewProduct+"</td>"
	        					 + "<th>작성자</th>"
	        					 + "<td>"+list[i].reviewWriter+"</td>"
	        					 + "</tr>"
	        					 + "<tr>"
	        					 + "<th>리뷰 제목</th>"
	        					 + "<td colspan='6'>"+list[i].reviewTitle+"<td>"
	        					 + "</tr>"
	        					 + "<tr>"
	        					 + "<th>리뷰 내용</th>"
	        					 + "<td colspan='6'><p style='height: 50px;'>"+list[i].reviewContent+"</p><td>"
	        					 + "</tr>"
	        					 + "<tr>"
	        					 + "<th>리뷰 날짜</th>"
	        					 + "<td>"+list[i].reviewDate+"</td>"
	        					 + "<th>리뷰 조회수</th>"
	        					 + "<td>"+list[i].reviewViewNo+"</td>"
	        					 + "</tr>"
	        					 +"<tr>"
	        					 +"<td colspan='6'>"+"<button type='button' class='reporttBtn'>신고하기</button>"+"</td>"
	        					 +"</tr>"
	        					 + "</table><br><br>";

        			}
        			$("#pr-answer").html(row);
        		},
        		error : function(){
                     console.log("ajax 통신 실패");	
        		}	
       		})
        }


        //여기부터 노민규
        //ajax 등 동적 생성 태그 이벤트 시 아래와 같이 사용
       $(document).on("click",".reporttBtn",function(event){
    	   var userId = $(this).parent().parent().parent().children().eq(0).children().eq(5).text();
    	   var repoter = "";
    	   <%if(loginUser!=null){%>
    	   		repoter = '<%=loginUser.getUserId()%>'
    	   <%}%>
    	   if(window.confirm("해당 리뷰를 신고처리 하시겠습니까?")){
    		   $.ajax({
    			   url:"/Semi/reportUuser.re",
    			   data : {userId : userId,
    				   repoter : repoter},
    			   type :"post",
    			   success : function(result){
    				 if(result==1) alert("성공적으로 신고처리 되었습니다.");  
    				 if(result==0) alert("로그인 후 이용해주세요");
    					
    			   },
    			   error : function(){
    				   
    			   }
    		   })
    	   }
    
       })
       
       var userNoo = 0;
       <%if(loginUser!=null){%>
       		userNoo = '<%=loginUser.getUserNo()%>'
       		userNoo = parseInt(userNoo);
       <%}%>
       
       	$("#buy").click(function(){
          location.href ='<%=contextPath%>/purchase.pr?pc=<%=pr.get(0).getProNo()%>&lo='+userNoo+'&po=1&price=<%=price%>'
        });
        $("#order22").click(function(){
          location.href = '<%=contextPath%>/userBaskett.bk?pc=<%=pr.get(0).getProNo()%>&lo='+userNoo+'&po=1'
        });
        
      </script>
</body>
</html>
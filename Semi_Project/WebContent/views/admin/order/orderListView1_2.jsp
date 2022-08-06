<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DS SPORTS</title>

    <!--Latest compiled and minified CSS-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

	<link rel="stylesheet" href="/Semi/views/admin-css/order_gwan.css">
<style>
    #content_2_5{
    height:50%;
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
                <h2>주문내역관리</h2>
            </div>
            <!--input 바 시작-->
            <div id="content_2_2">
                <form action="search_user.do" method="post">
                    <div id="content_2_2_1">
                        <div class="selecdiv col-sm-2">
                        <select id="select" class="form-control">
                            <option value="userId">주문자</option>
                            <option value="noticeTitle">주문번호</option>
                        </select>
                        </div>
                        <div class="col-sm-5">
                            <input type="text" name="search_user" id="search_user" class="form-control" placeholder="주문자명 또는"> 
                        </div>   
                        <div class="col-sm-3">
                            <button type="submit" id="search_btn"><img src="/Semi/views/image/search.png" id="search_img">검색</button>
                        </div>    
                    </div>      
                </form>
            </div>
            <h2 align="center">반품현황 관리</h2>
            <!--input 바 끝-->
    
            <!--회원 명 수 및 버튼 시작-->
            <div id="content_2_3">
    
                검색 회원 수 <span style="color:red">30</span>명
            </div>
            <div id="content_2_4">
                <button type="button" class="btn btn-warning"><a href="/Semi/views/admin/order/orderListView1_1.jsp">배송관리</a></button>
                <button type="button" class="btn btn-warning">반품관리</button>
                <button type="button" class="btn btn-warning"><a href="/Semi/views/admin/order/orderListView1_3.jsp">취소관리</a></button>
            </div>
            <!--회원 명 수 및 버튼 끝-->
    
            <!--게시글 테이블 작업 시작-->
            <div id="content_2_5">
                <br>
                
                <table align="center" class="table-hover" >
                    <thead>
                        <th width="15%">주문일자</th>
                        <th width="15%">주문번호</th>
                        <th width="10%">주문자</th>
                        <th width="10%">상품명</th>
                        <th width="10%">결제금액</th>
                        <th width="10%">상품금액</th>
                        <th width="10%">배송비</th>
                        <th width="10%">결제유형</th>
                        <th width="10%">반품상태</th>
                    </thead>
                    <tbody>
                        <tr>
                            <td>2022-05-14</td>
                            <td>1</td>
                            <td>바보</td>
                            <td>자전거</td>
                            <td>5만원</td>
                            <td>5만원</td>
                            <td>0원</td>
                            <td>카드</td>
                            <td>반품중</td>
                        </tr>
                        <tr>
                            <td>2022-05-14</td>
                            <td>1</td>
                            <td>바보</td>
                            <td>자전거</td>
                            <td>5만원</td>
                            <td>5만원</td>
                            <td>0원</td>
                            <td>카드</td>
                            <td>반품중</td>
                        </tr>
                        <tr>
                            <td>2022-05-14</td>
                            <td>1</td>
                            <td>바보</td>
                            <td>자전거</td>
                            <td>5만원</td>
                            <td>5만원</td>
                            <td>0원</td>
                            <td>카드</td>
                            <td>반품중</td>
                        </tr>
                        <tr>
                            <td>2022-05-14</td>
                            <td>1</td>
                            <td>바보</td>
                            <td>자전거</td>
                            <td>5만원</td>
                            <td>5만원</td>
                            <td>0원</td>
                            <td>카드</td>
                            <td>반품중</td>
                        </tr>
                    </tbody>
                </table>    
            </div>
            <!--게시글 테이블 작업 끝-->
            
            <!--글 목록 시작-->
            <div id="content_2_6">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                  </ul>
            </div>
            <!--글 목록 끝-->
        </div>
</body>
</html>
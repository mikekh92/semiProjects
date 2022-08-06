<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String contextPath = request.getContextPath();
	int adCate = -1;
	if(request.getAttribute("adCate")!=null){
	adCate = (int)request.getAttribute("adCate");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DS SPORTS</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/Semi/views/admin-css/admin_style_header.css">
<link rel="stylesheet" href="/Semi/views/admin-css/admin_style_content.css">

</head>
<body>
    <!--header 시작-->
        <div id="header">
            <img src="/Semi/views/image/DsSports.png">
        </div>
    <!--header 끝-->

    <!--왼쪽 메뉴 바 시작(content_1)-->
            <div id="content_1">
                <div id="content_1_empty"></div>
                <table>
                    <tr class="PM">
                        <td class="left-menu"><a href="<%=contextPath%>/list.pd?cpage=1">상품관리</a></td>
                        <td><img src="/Semi/views/image/down_triangle.png" class="triangle"></td>
                    </tr>
                    <tr class="PM">
                        <td colspan="2" class="sub-menu"><a href="<%=contextPath%>/list.pd?cpage=1">조회</a></td>
                    </tr>
                    <tr class="PM">
                        <td colspan="2" class="sub-menu"><a href="<%=contextPath%>/categoryList.pd">등록</a></td>
                    </tr>
                    <!-- <tr class="PM">
                        <td colspan="2" class="sub-menu"><a href="/Semi/views/admin/a_2.jsp">수정</a></td>
                    </tr>-->
                    <tr class="PM">
                        <td colspan="2" class="sub-menu"><a href="/Semi/views/admin/product/categoryUpdate.jsp">카테고리수정</a></td>
                    </tr>

                    <tr class="SM"> 
                        <td class="left-menu"><a href="/Semi/list.oo?cpage=1">쇼핑몰 관리</a></td>
                        <td><img src="/Semi/views/image/down_triangle.png" class="triangle"></td>
                    </tr>
                    <tr class="SM">
                        <td colspan="2" class="sub-menu"><a href="/Semi/list.oo?cpage=1">주문내역 관리</a></td>
                    </tr>
                    <tr class="SM">
                        <td colspan="2" class="sub-menu"><a href="<%=contextPath%>/list.no?cpage=1">공지사항 관리</a></td>
                    </tr>
                    <tr class="SM">
                        <td colspan="2" class="sub-menu"><a href="<%=contextPath%>/list.ro?cpage=1">리뷰 관리</a></td>
                    </tr>

                    <tr class="CM">
                        <td class="left-menu"><a href="/Semi/manage.mm?cpage=1">회원관리</a></td>
                        <td><img src="/Semi/views/image/down_triangle.png" class="triangle"></td>
                    </tr>
                    <tr class="CM">
                        <td colspan="2" class="sub-menu"><a href="/Semi/manage.mm?cpage=1">회원 관리</a></td>
                    </tr>
                    <tr class="CM">
                        <td colspan="2" class="sub-menu"><a href="/Semi/reportList.re?cpage=1">신고 내역</a></td>
                    </tr>

                    <tr class="Service">
                        <td class="left-menu"><a href="/Semi/ScList.sc?cpage=1">고객센터</a></td>
                        <td><img src="/Semi/views/image/down_triangle.png" class="triangle"></td>
                    </tr>
                    <tr class="Service">
                        <td colspan="2" class="sub-menu"><a href="/Semi/ScList.sc?cpage=1">FAQ 관리</a></td>
                    </tr>
                    <tr class="Service">
                        <td colspan="2" class="sub-menu"><a href="/Semi/QNAList.sc?cpage=1">1:1문의</a></td>
                    </tr>
                </table>
            </div>
        <!--왼쪽 메뉴 바(content_1) 끝-->
    <script>
        //menubar 변경으로 인한 왼쪽 메뉴바 변경
        // window.onload=function(){
        //     if(window.location.href.search("a_1.jsp")!=-1){
        //         var setClass = document.getElementsByClassName('PM');
        //         for(var i=1;i<setClass.length;i++){
        //                 setClass[i].childNodes[1].childNodes[0].style.display='block';
        //             }
        //         setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
        //         setClass[0].childNodes[1].childNodes[0].style.color="yellow";
        //         setClass[1].childNodes[1].childNodes[0].style.color="yellow";
        //     }
        //     if(window.location.href.search("a_2.jsp")!=-1){
        //         var setClass = document.getElementsByClassName('PM');
        //         for(var i=1;i<setClass.length;i++){
        //                 setClass[i].childNodes[1].childNodes[0].style.display='block';
        //             }
        //         setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
        //         setClass[0].childNodes[1].childNodes[0].style.color="yellow";
        //         setClass[2].childNodes[1].childNodes[0].style.color="yellow";
        //     }
        //     if(window.location.href.search("a_3.jsp")!=-1){
        //         var setClass = document.getElementsByClassName('PM');
        //         for(var i=1;i<setClass.length;i++){
        //                 setClass[i].childNodes[1].childNodes[0].style.display='block';
        //             }
        //         setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
        //         setClass[0].childNodes[1].childNodes[0].style.color="yellow";
        //         setClass[3].childNodes[1].childNodes[0].style.color="yellow";
        //     }
        //     if(window.location.href.search("b_1.jsp")!=-1){
        //         var setClass = document.getElementsByClassName('SM');
        //         for(var i=1;i<setClass.length;i++){
        //                 setClass[i].childNodes[1].childNodes[0].style.display='block';
        //             }
        //         setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
        //         setClass[0].childNodes[1].childNodes[0].style.color="yellow";
        //         setClass[1].childNodes[1].childNodes[0].style.color="yellow";
        //     }
        //     if(window.location.href.search("b_2.jsp")!=-1){
        //         var setClass = document.getElementsByClassName('SM');
        //         for(var i=1;i<setClass.length;i++){
        //                 setClass[i].childNodes[1].childNodes[0].style.display='block';
        //             }
        //         setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
        //         setClass[0].childNodes[1].childNodes[0].style.color="yellow";
        //         setClass[2].childNodes[1].childNodes[0].style.color="yellow";
        //     }
        //     if(window.location.href.search("b_3.jsp")!=-1){
        //         var setClass = document.getElementsByClassName('SM');
        //         for(var i=1;i<setClass.length;i++){
        //                 setClass[i].childNodes[1].childNodes[0].style.display='block';
        //             }
        //         setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
        //         setClass[0].childNodes[1].childNodes[0].style.color="yellow";
        //         setClass[3].childNodes[1].childNodes[0].style.color="yellow";
        //     }
            
        //     if(<%=adCate%>==3){
        //         var setClass = document.getElementsByClassName('CM');
        //         for(var i=1;i<setClass.length;i++){
        //                 setClass[i].childNodes[1].childNodes[0].style.display='block';
        //             }
        //         setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
        //         setClass[0].childNodes[1].childNodes[0].style.color="yellow";
        //         setClass[1].childNodes[1].childNodes[0].style.color="yellow";
        //     }
        //     if(window.location.href.search("re")!=-1){
        //         var setClass = document.getElementsByClassName('CM');
        //         for(var i=1;i<setClass.length;i++){
        //                 setClass[i].childNodes[1].childNodes[0].style.display='block';
        //             }
        //         setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
        //         setClass[0].childNodes[1].childNodes[0].style.color="yellow";
        //         setClass[2].childNodes[1].childNodes[0].style.color="yellow";
        //     }
        //     if(window.location.href.search("d_1.jsp")!=-1){
        //         var setClass = document.getElementsByClassName('Service');
        //         for(var i=1;i<setClass.length;i++){
        //                 setClass[i].childNodes[1].childNodes[0].style.display='block';
        //             }
        //         setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
        //         setClass[0].childNodes[1].childNodes[0].style.color="yellow";
        //         setClass[1].childNodes[1].childNodes[0].style.color="yellow";
        //     }
        //     if(window.location.href.search("d_2.jsp")!=-1){
        //         var setClass = document.getElementsByClassName('Service');
        //         for(var i=1;i<setClass.length;i++){
        //                 setClass[i].childNodes[1].childNodes[0].style.display='block';
        //             }
        //         setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
        //         setClass[0].childNodes[1].childNodes[0].style.color="yellow";
        //         setClass[2].childNodes[1].childNodes[0].style.color="yellow";
        //     }
        // }//변경 종료
		$(document).ready(function(){
			if(<%=adCate%>==1){
		        var setClass = document.getElementsByClassName('PM');
		        for(var i=1;i<setClass.length;i++){
		        	setClass[i].childNodes[1].childNodes[0].style.display='block';
		        }
		        setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
		        setClass[0].childNodes[1].childNodes[0].style.color="yellow";
		        setClass[1].childNodes[1].childNodes[0].style.color="yellow";
		   	}
			
	        if(<%=adCate%>==2){
	       		var setClass = document.getElementsByClassName('PM');
	        	for(var i=1;i<setClass.length;i++){
	        		setClass[i].childNodes[1].childNodes[0].style.display='block';
	      		}
	        	setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
	        	setClass[0].childNodes[1].childNodes[0].style.color="yellow";
	        	setClass[2].childNodes[1].childNodes[0].style.color="yellow";
	        }
	        if(<%=adCate%>==4){
	            var setClass = document.getElementsByClassName('SM');
	            for(var i=1;i<setClass.length;i++){
	                    setClass[i].childNodes[1].childNodes[0].style.display='block';
	                }
	            setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
	            setClass[0].childNodes[1].childNodes[0].style.color="yellow";
	            setClass[1].childNodes[1].childNodes[0].style.color="yellow";
	        }
	        if(<%=adCate%>==5){
	                 var setClass = document.getElementsByClassName('SM');
	                 for(var i=1;i<setClass.length;i++){
	                         setClass[i].childNodes[1].childNodes[0].style.display='block';
	                     }
	                 setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
	                 setClass[0].childNodes[1].childNodes[0].style.color="yellow";
	                 setClass[2].childNodes[1].childNodes[0].style.color="yellow";
	             }
	        if(<%=adCate%>==6){
	                 var setClass = document.getElementsByClassName('SM');
	                 for(var i=1;i<setClass.length;i++){
	                        setClass[i].childNodes[1].childNodes[0].style.display='block';
	                     }
	                 setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
	                 setClass[0].childNodes[1].childNodes[0].style.color="yellow";
	                 setClass[3].childNodes[1].childNodes[0].style.color="yellow";
	             }
			if(<%=adCate%>==7){
                var setClass = document.getElementsByClassName('CM');
                for(var i=1;i<setClass.length;i++){
                        setClass[i].childNodes[1].childNodes[0].style.display='block';
                    }
                setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
                setClass[0].childNodes[1].childNodes[0].style.color="yellow";
                setClass[1].childNodes[1].childNodes[0].style.color="yellow";
            }
	        if(<%=adCate%>==8){
	            var setClass = document.getElementsByClassName('CM');
	            for(var i=1;i<setClass.length;i++){
	                    setClass[i].childNodes[1].childNodes[0].style.display='block';
	                }
	            setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
	            setClass[0].childNodes[1].childNodes[0].style.color="yellow";
	            setClass[2].childNodes[1].childNodes[0].style.color="yellow";
	        }
	        if(<%=adCate%>==9){
	            var setClass = document.getElementsByClassName('Service');
	            for(var i=1;i<setClass.length;i++){
	                setClass[i].childNodes[1].childNodes[0].style.display='block';
	            }
	            setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
	            setClass[0].childNodes[1].childNodes[0].style.color="yellow";
	            setClass[1].childNodes[1].childNodes[0].style.color="yellow";
	        }
	        if(<%=adCate%>==10){
	            var setClass = document.getElementsByClassName('Service');
	            for(var i=1;i<setClass.length;i++){
	            setClass[i].childNodes[1].childNodes[0].style.display='block';
	            }
	            setClass[0].childNodes[3].childNodes[0].setAttribute("src","/Semi/views/image/triangle.png");
	            setClass[0].childNodes[1].childNodes[0].style.color="yellow";
	            setClass[2].childNodes[1].childNodes[0].style.color="yellow";
	            }
		});
        
        
        //삼각형 변경 스크립트
        var triangles=document.getElementsByClassName("triangle");
        function tri_click(idx){
            triangles[idx].onclick =function() {

                if(this.getAttribute("src").search("down")!=-1){
                    var className =triangles[idx].parentNode.parentNode.getAttribute('class');
                    var setClass = document.getElementsByClassName(className);
                    for(var x=1;x<setClass.length;x++){
                        setClass[x].childNodes[1].childNodes[0].style.display='block';
                    }
                    this.setAttribute("src","/Semi/views/image/triangle.png");
                }else{
                    var className =triangles[idx].parentNode.parentNode.getAttribute('class');
                    var setClass = document.getElementsByClassName(className);
                    for(var x=1;x<setClass.length;x++){
                        setClass[x].childNodes[1].childNodes[0].style.display='none';
                    }
                    this.setAttribute("src","/Semi/views/image/down_triangle.png");
                }
            };
        }
        for(var i=0;i<triangles.length;i++){
            tri_click(i);
        }
		//JS에서는 기존 반복문 방식으로는 해당 방번호를 반환 받을 수 없음
        //클로저 기법 [idx]을 이용하여 해당 배열 값을 정상적으로 반환

    </script>
</body>
</html>
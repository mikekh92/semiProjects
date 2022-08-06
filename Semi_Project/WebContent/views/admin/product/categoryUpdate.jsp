<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    
        <!-- jQuery library -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    
        <!-- Popper JS -->
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    
        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="/Semi/views/admin-css/admin_a_2.css">
        <title>category-update</title>
    </head>
    <style>
        div{
            font-family: 'Sunflower', sans-serif;
        }
        .smallcg{
            display: none;
        }
         select option[value=""][disabled] {
            display: none;
        }
        select{
            width: 100%;
            margin: 50px;        
        }
        button{
            margin-left:50px;
        }
        #category-sm button{
            display: none;
        }
        .category{
            width: 100%;
        }
    </style>
    <body>
        <%@ include file="/views/common/adminMenubar.jsp" %>
        <div id="content_2">
            <div id="category-bg" class="category">
                <select name="bigCg" id="bigCg" required multiple class="form-control form-control-lg" style="font-size: 25px; width: 80%">
                    <option value="" selected disabled>1차 카테고리 설정</option>
                    <option value="soccer" class="bigcg">축구</option>
                    <option value="bowling" class="bigcg">볼링</option>
                    <option value="weight" class="bigcg">웨이트</option>
                    <option value="cycle" class="bigcg">사이클</option>
                </select>
                <button class="btn btn-info">추가</button>
                <button class="btn btn-info">수정</button>
                <button class="btn btn-info">삭제</button>
            </div>
            <br><br>
            <div id="category-sm" class="category">
                <select name="" id="smallcg-sc" class="smallcg form-control form-control-lg" required multiple style="font-size: 25px; width: 80%">
                    <option value="" selected disabled>2차 카테고리 설정</option>
                    <option value="ball-sc">축구공</option>
                    <option value="shoes-sc">축구화</option>
                    <option value="protect-sc">보호장비</option>
                </select>
                <select name="" id="smallcg-bw" class="smallcg form-control form-control-lg" required multiple style="font-size: 25px; width: 80%">
                    <option value="" selected disabled>2차 카테고리 설정</option>
                    <option value="ballbw">볼링공</option>
                    <option value="shoes-bw">볼링화</option>
                    <option value="protect-bw">보호장비</option>
                </select>
                <select name="" id="smallcg-wi" class="smallcg form-control form-control-lg" required multiple style="font-size: 25px; width: 80%">
                    <option value="" selected disabled>2차 카테고리 설정</option>
                    <option value="strap">스트랩</option>
                <option value="belt">리프팅벨트</option>
                <option value="protect-wi">보호대</option>
                </select>
                <select name="" id="smallcg-cy" class="smallcg form-control form-control-lg" required multiple style="font-size: 25px; width: 80%">
                    <option value="" selected disabled>2차 카테고리 설정</option>
                    <option value="body-cy">자전거</option>
                    <option value="helmet">헬멧</option>
                    <option value="light">LED전등</option>
                </select>
                <button class="btn btn-info">추가</button>
                <button class="btn btn-info">수정</button>
                <button class="btn btn-info">삭제</button>
            </div>
        </div>
        <script>
            $(function(){
                $("#bigCg").change(function(){
                    $("#category-sm button").show();
                    $("#no").hide();
                    var bigCg = $(this).val();
                    if(bigCg=="soccer"){
                        $("#smallcg-sc").show();
                    }else{
                        $("#smallcg-sc").hide();
                    };
                    
                    
                    if(bigCg=="bowling"){
                        $("#smallcg-bw").show();
                    }else{
                        $("#smallcg-bw").hide();
                    };
                    
                    
                    if(bigCg=="weight"){
                        $("#smallcg-wi").show();
                        }else{
                            $("#smallcg-wi").hide();
                        };
                        
                        
                        if(bigCg=="cycle"){
                            $("#smallcg-cy").show();
                        }else{
                            $("#smallcg-cy").hide();
                        };
                        
                    });
                    $(".smallcg").change(function(){
                        var smallCg = $(this).val();
                    });
                    
                });
            </script>
    </body>
    </html>
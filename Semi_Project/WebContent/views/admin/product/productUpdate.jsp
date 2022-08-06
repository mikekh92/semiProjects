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
    <title>product-update</title>
    <style>
        div{
         font-family: 'Sunflower', sans-serif;
        }
        .smallcg{
            display: none;
        }
        #select,#body{
                width: 50%;
        }
        select option[value=""][disabled] {
        display: none;
        }
        select{
            margin: 50px;
        }
        table tr{
            height: 50px;
            font-size: large;
        }
        table input{
            width: 100%;
        }
        #radio1>input{
            width:10%;
        }
    </style>
</head>
<body>
    <%@ include file="/views/common/adminMenubar.jsp" %>
    <div id="content_2">
        <div id="select">
            <select name="bigCg" id="bigCg" required class="form-control form-control-lg" style="font-size: 25px; width: 50%">
                <option value="" selected disabled>1차 카테고리 설정</option>
                <option value="soccer" class="bigcg">축구</option>
                <option value="bowling" class="bigcg">볼링</option>
                <option value="weight" class="bigcg">웨이트</option>
                <option value="cycle" class="bigcg">사이클</option>
            </select>
            
            <select name="" id="smallcg-sc" class="smallcg form-control form-control-lg" required style="font-size: 25px; width: 50%">
                <option value="" selected disabled>2차 카테고리 설정</option>
                <option value="ball-sc">축구공</option>
                <option value="shoes-sc">축구화</option>
                <option value="protect-sc">보호장비</option>
            </select>
            <select name="" id="smallcg-bw" class="smallcg form-control form-control-lg" required style="font-size: 25px; width: 50%">
                <option value="" selected disabled>2차 카테고리 설정</option>
                <option value="ballbw">볼링공</option>
                <option value="shoes-bw">볼링화</option>
                <option value="protect-bw">보호장비</option>
            </select>
            <select name="" id="smallcg-wi" class="smallcg form-control form-control-lg" required style="font-size: 25px; width: 50%">
                <option value="" selected disabled>2차 카테고리 설정</option>
                <option value="strap">스트랩</option>
                <option value="belt">리프팅벨트</option>
                <option value="protect-wi">보호대</option>
            </select>
            <select name="" id="smallcg-cy" class="smallcg form-control form-control-lg" required style="font-size: 25px; width: 50%">
                <option value="" selected disabled>2차 카테고리 설정</option>
                <option value="body-cy">자전거</option>
                <option value="helmet">헬멧</option>
                <option value="light">LED전등</option>
            </select>
        </div>
        <br><br><br>
        <div id="body">
            <form action="#" method="post" id="frame">
                <table>
                    <thead>
                        <tr>
                            <td width="150px">상품명</td>
                            
                            <td><input type="text" name="" id=""></td>
                        </tr>
                        <tr>
                            <td>상품가격</td>
                            <td><input type="text" name="" id=""></td>
                        </tr>
                        <tr>
                            <td>제품코드</td>
                            <td><input type="text" name="" id=""></td>
                        </tr>
                        <tr>
                            <td>상태</td>
                            <td id="radio1">
                                <input type="radio" name="condition" id="soldout" value=""> 
                                <label for="soldout">품절</label>
                                <input type="radio" name="condition" id="sale" value=""> 
                                <label for="sale">판매 중</label>
                            </td>
                        </tr>
                    </thead>
                    <tbody id="imgbody">
                        <tr class="imgtr1">
                            <td>이미지</td>
                            <td><input type="file" name="" id=""></td>
                        </tr>
                    </tbody>
                    <tr>
                        <td colspan="2">
                            <button type="button" class="btn btn-info" id="add">이미지 추가</button>
                            <button type="button" class="btn btn-dark" id="minus">이미지 삭제</button>
                            </td>
                    </tr>
                    <tr>
                        <td>상세설명</td>
                        <td><textarea name="" id="" cols="30" rows="10" style="resize: none; width: 100%; height: 100%;"></textarea></td>
                    </tr>
                    <tr>
                        <td>상품수량</td>
                        <td><input type="number" name="" id="" min="0"></td>
                    </tr>
                    <tr style="margin:auto;">
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="2"><button type="submit" class="btn btn-info">상품등록</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
        






        <script>
            $(function(){
                $("#bigCg").change(function(){
                    var bigCg = $(this).val();
                    // console.log(bigCg);
                    if(bigCg=="soccer"){
                        // $("#smallcg-sc").css("display","inline-block");
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

    <script>
        $(function(){
            var count=1;
            $("#add").click(function(){
                count++;
                var add = "<tr class=imgtr"+count+">"
                        +"<td>이미지</td>"
                        +"<td>"+"<input type='file'+id=''></td>"
                        +"</tr>";
                $("#imgbody").append(add);
                console.log(count)
            });
            $("#minus").click(function(){
                $("#imgbody tr").remove(".imgtr"+count);
                count--;
                console.log(count);
            });
        });
    </script>




</body>
</html>
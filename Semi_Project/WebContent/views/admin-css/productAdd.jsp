<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.product.model.vo.Category,com.kh.product.model.vo.sCategory,java.util.ArrayList"%>
    
    <%
    	ArrayList<Category> bList = (ArrayList<Category>)request.getAttribute("bList");
    	ArrayList<sCategory> scList = (ArrayList<sCategory>)request.getAttribute("sList");
    	String alertMsg = (String)session.getAttribute("alertMsg");
    %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    

    
        <!-- Popper JS -->
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    
        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="/Semi/views/admin-css/admin_a_2.css">
                <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <title>DS SPORTS</title>
        <style>
            div{
             font-family: 'Sunflower', sans-serif;
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
            table input{
                width: 100%;
            }
        </style>
    </head>
    <body>
        <%@ include file="/views/common/adminMenubar.jsp" %>
        <form action="productInsert.pd" method="post" id="form" enctype="multipart/form-data">
        <div id="content_2">
            <div id="select">
                <select name="bigCg" id="bigCg" required class="form-control form-control-lg" style="font-size: 25px; width: 50%">
                    <%for(Category c : bList){ %>
                        <option value="<%=c.getCateNo() %>"><%=c.getCateName() %></option>
                        <%} %>
                        <!-- <option value="soccer" class="bigcg">축구</option>
                            <option value="bowling" class="bigcg">볼링</option>
                            <option value="weight" class="bigcg">웨이트</option>
                            <option value="cycle" class="bigcg">사이클</option> -->
                    </select>
				<select name="smallCg" id="smallCg" class='smallcg form-control form-control-lg' required style='font-size: 25px; width: 50%''>
				
				</select>
                        
            </div>
            </select>
        <script>
            $("#bigCg").change(function(){
                var result1 = $(this).val();
                 	$.ajax({
                		url : "scategorylist.pd",
                		data : {bcg : result1},
                		success : function(result){
		                			var sel="";
		                            for(var i in result){
		                                sel +="<option value="+result[i].cateNo+">"+result[i].cateName+"</option>";
		                            }
		                            $("#smallCg").html(sel);
		                        },
		                        error : function(){
		                        	console.log("실패");
		                        }
                	})
            });
            
            
            
            </script>
            


            <br><br><br>
            <div id="body">
                
                    <table>
                        <thead>
                            <tr>
                                <td width="150px">상품명</td>
                                
                                <td><input type="text" name="name" id=""></td>
                            </tr>
                            
                            <tr>
                                <td>상품가격</td>
                                <td><input type="text" name="price" id=""></td>
                            </tr>
                            <tr>
                                <td>제품코드</td>
                                <td><input type="text" name="code" id=""></td>
                            </tr>
                        </thead>
                        <tbody id="imgbody">
                            <tr class="imgtr">
                                <td>이미지</td>
                                <td><input type="file" name="img1" id="img1"></td>
                            </tr>
                        </tbody>
                        <tr>
                                <td colspan="2">
                                <button type="button" class="btn btn-info" id="add">이미지 추가</button>
                                <button type="button" class="btn btn-dark" id="minus">이미지 삭제</button>
                                </td>
                        </tr>
                        <tr>
                            <td>제작회사</td>
                            <td><input type="text" name="maker" id=""></td>
                        </tr>
                        <tr>
                            <td>상세설명</td>
                            <td><textarea name="des" id="" cols="30" rows="10" style="resize: none; width: 100%; height: 100%;"></textarea></td>
                        </tr>
                        <tr>
                            <td>사이즈</td>
                            <td><input type="text" name="size" id=""></td>
                        </tr>
                        <tr>
                            <td>상품수량</td>
                            <td><input type="number" name="amount" id="" min="0"></td>
                        </tr>
                        <tr>
                            <td>상품레벨</td>
                            <td><input type="number" name="level" id="" min="0"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><button type="button" class="btn btn-info" onclick="go();">상품등록</button></td>
                        </tr>
                    </table>
                    <div id="imgmg">
        
                    </div>
                </form>
            </div>
        </div>
        
            
    
        <script>
            $(function(){
                var count=1;
                $("#add").click(function(){
                    count++;
                    var add = "<tr class=imgtr"+count+">"
                             +"<td>이미지</td>"
                             +"<td>"+"<input type='file' id='img'"+count+" name='img"+count+"'></td>"
                             +"</tr>";
                    $("#imgbody").append(add);
                    
                });
                $("#minus").click(function(){
                    $("#imgbody tr").remove(".imgtr"+count);
                    count--;
                });
            });


            function go(){
                var count = $("#imgbody input").length;
                var add ="<input type='hidden' name='imglength' value='"+count+"'>";
                
                $("#imgmg").append(add);
				// $("#imgbody input : file").length;
				 $("#form").submit();
            };
            
           
        </script>
    
        
    
    </body>
    </html>
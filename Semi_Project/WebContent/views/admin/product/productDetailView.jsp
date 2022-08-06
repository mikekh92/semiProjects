<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.product.model.vo.*,java.util.ArrayList"%>
    
    <%
    	Product p = (Product)request.getAttribute("p");
    	ArrayList<Category> bList = (ArrayList<Category>)request.getAttribute("bList");
    	ArrayList<Attachment> list = (ArrayList<Attachment>)request.getAttribute("list");
    	Category b = (Category)request.getAttribute("b");
    	Category s = (Category)request.getAttribute("s");
    	int proNo = (int)request.getAttribute("proNo");
    	String msg = (String)session.getAttribute("alertMsg");
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
        <title>product-add</title>
        <style>
            div{
             font-family: 'Sunflower', sans-serif;
            }
            #select,#body{
                width: 50%;
            }
            /* select option[value=""][disabled] {
            display: none;
            } */
            #bigCg, #smallCg{
                margin: 50px;
                /* visibility:hidden; */
                display: none;
            }
            table input{
                width: 100%;
            }
            .cate{
                margin: 50px;
                font-size: 25px;
                display: inline;
            }
            #levnum,#add,#minus,.imgtr,#com{
            	display : none;
            	
            }
        </style>
    </head>
    <body>
        <%@ include file="/views/common/adminMenubar.jsp" %>
        <form action="productUpdate.pd" method="get" id="form">
    <input type="hidden" name="proNo" value="<%=proNo%>">
        <div id="content_2">
            <div id="select">
                <select name="bigCg" id="bigCg" class="form-control form-control-lg" style="font-size: 25px; width: 50%" required>
                    <%for(Category c : bList){ %>
                        <option value="<%=c.getCateNo() %>"><%=c.getCateName() %></option>
                        <%} %>
                    </select>
				<select name="smallCg" id="smallCg" class='smallcg form-control form-control-lg' style='font-size: 25px; width: 50%' required>
				</select>

                <select name="" id="cate1" disabled class='cate form-control form-control-lg' style='font-size: 25px; width: 50%'>
                    <option value=""><%=b.getCateName()%></option>
                </select>
                <select name="" id="cate2" disabled class="cate form-control form-control-lg" style="font-size: 25px; width: 50%">
                    <option value=""><%=s.getCateName()%></option>
                </select>
                <div align="center" style="padding: 150px;">
                
                 <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#drop" style="width: 200px; height: 200px;">
				    삭제
				  </button>
				
				  <!-- The Modal -->
				  <div class="modal" id="drop">
				    <div class="modal-dialog">
				      <div class="modal-content">
				      
				        <!-- Modal Header -->
				        <div class="modal-header">
				            <h4 class="modal-title"></h4>
				            <button type="button" class="close" data-dismiss="modal">&times;</button>
				        </div>
				        
				        <!-- Modal body -->
				        <div class="modal-body">
				            삭제하시겠습니까?
				        </div>
				        
				        <!-- Modal footer -->
				        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="drop();">예</button>
				            <button type="button" class="btn btn-danger" data-dismiss="modal">아니오</button>
				        </div>
				        
				      </div>
				    </div>
				  </div>
                
                
                
                
                
                
                
                
                    <!-- <button type="button" id="del" onclick="drop();" class="btn btn-dark" style="width: 200px; height: 200px;">상품 삭제</button> -->
                </div>
                
            </div>
        <script>
            $(function(){
                $("#bigCg option").each(function(){
                    if($(this).val()== <%=p.getCateBno()%>) {
                    	$(this).attr("selected",true);
                    }
                })

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
                
                        });
            </script>
            


            <br><br><br>
            <div id="body">
                
                    <table id="listbody">
                        <thead>
                            <tr>
                                <td width="150px">상품명</td>
                                <td><input type="text" name="name" id="" value="<%=p.getProName()%>" readonly required></td>
                            </tr>
                            
                            <tr>
                                <td>상품가격</td>
                                <td><input type="text" name="price" id="" value="<%=p.getProPrice() %>" readonly required></td>
                            </tr>
                            <tr>
                                <td>제품코드</td>
                                <td><input type="text" name="code" id="" value="<%=p.getProCode() %>" readonly required></td>
                            </tr>
                        </thead>
                        <tbody id="imgbody">
                            </tr>
                        </tbody>
                        <%for (Attachment a : list) {%>
                            <tr class="fuck">
                            	<td></td>
                                <td><%=a.getOriginName() %></td>
                            </tr>
                        <%} %>
                        <tr>
                            <td>제작회사</td>
                            <td><input type="text" name="maker" id="" value="<%=p.getProMaker()%>" readonly required></td>
                        </tr>
                        <tr>
                            <td>상세설명</td>
                            <td><textarea name="des" id="" cols="30" rows="10" style="resize: none; width: 100%; height: 100%;" readonly><%=p.getProDes() %></textarea></td>
                        </tr>
                        <tr>
                            <td>사이즈</td>
                            <td><input type="text" name="size" id="" value="<%=p.getProSize()%>" readonly required></td>
                        </tr>
                        <tr>
                            <td>상품수량</td>
                            <td><input type="number" name="amount" id="" min="0" value="<%=p.getProAmount()%>" readonly required></td>
                        </tr>
                        <tr>
                            <td>상품레벨</td>
                            <td>
                            	<input type="text" name="level" id="lev" value="<%=p.getProLevel()%>" readonly required>
                            	<input type="number" name="levelnum" id="levnum" min="0">
                            </td>
                        </tr>
                        <tr><td></td></tr>
                        <tr>
                            <td colspan="2">
                                <button type="button" class="btn btn-info" onclick="update();">상품수정</button>
			                    <button type="button" class="btn btn-info" onclick="history.back();">뒤로가기</button>
			                    <button type="submit" class="btn btn-info" id="com">완료</button>
                            </td>
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

	             
	             $("#imgmg").append(add);
					// $("#imgbody input : file").length;
				 $("#form").submit();
            };

            function update(){
                $("#listbody td input,textarea").removeAttr("readonly");
                $("#select select").css("display","inline");
                $(".cate").hide();
                $("#lev").css("display","none");
                $("#levnum").css("display","inline");
                $("#com").css("display","inline");
            }


            function drop(){
	           	var count = $(".fuck").length;
	            console.log(count);
	            var add ="<p><input type='hidden' name='imglength' value='"+count+"'></p>";
                location.href="<%=contextPath%>/dropProduct.pd?proNo="+<%=proNo%>+"&count="+count
            }
        </script>

        
    
    </body>
    </html>
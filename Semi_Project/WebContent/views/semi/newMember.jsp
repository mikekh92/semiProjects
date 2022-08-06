 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DS SPORTS</title>
<link rel="stylesheet" href="/Semi/resources/css/login.css">
</head>
<body>
	<%@include file="/views/common/menubar.jsp" %>
	
	<div id="login_content_empty">
		
	</div>
	<div id="login_content1">
		<div id="login_content1_1">
			<h1>회원가입</h1>
		</div>
		<form action="/Semi/newMemberUser.lo" method="post" id="newMemberUser">
		<div id="login_content1_2">
			<table id="login_table">
				<tr>
					<th width="100px">* 아이디 :</th>
					<td width="50px"></td>
					<td width="200px" height="30px" class="inputTd"><input type="text" class="form-control" name="userId" required id=""userId"></td>
				</tr>
				<tr>
					<td colspan="2" height="30px"></td>
				</tr>
				<tr>
					<th>* 비밀번호 : </th>
					<td width="50px"></td>
					<td class="inputTd"><input type="password" class="form-control" name="userPw" required id="userPw"></td>
				</tr>
				<tr>
					<td colspan="2" height="30px"></td>
				</tr>
				<tr>
					<th>* 비밀번호 확인 : </th>
					<td width="50px"></td>
					<td class="inputTd"><input type="password" class="form-control" name="userPwC" id="userPwC" required></td>
				</tr>
				<tr>
					<td colspan="3" height="30px" id="userPwcTd" ></td>
				</tr>
				<tr>
					<th>* 이름 : </th>
					<td width="50px"></td>
					<td class="inputTd"><input type="text" class="form-control" name="userName" id="userName" required></td>
				</tr>
				<tr>
					<td colspan="2" height="30px"></td>
				</tr>
				<tr>
					<th>* 이메일 : </th>
					<td width="50px"></td>
					<td class="inputTd"><input type="text" class="form-control" name="email" id="email" required></td>
					<td width="30px"></td>
					<td><button type="button" class="btn-dark" id="emailCon1" onclick="emailCon();">인증번호 받기</button></td>
				</tr>
				<tr>
					<td colspan="2" height="30px"></td>
				</tr>
				<tr id="emailConfirmTr" style="display:none">
					<th>인증번호 :  </th>
					<td width="50px"></td>
					<td class="inputTd"><input type="text" class="form-control" name="emailConfirm" id="emailConfirm" required></td>
					<td width="30px"></td>
					<td><button type="button" class="btn-dark" id="emailConfirm1" onclick="emailConfi();">인증번호 확인</button></td>
				</tr>
				<tr id="emailConfirmTr2" style="display:none">
					<th colspan="5">이메일을 확인해주세요 인증메일이 보이지 않을 경우 스팸함을 확인해주세요</th>
				</tr>
				<tr>
					<td colspan="2" height="30px"></td>
				</tr>
				<tr>
					<th>* 전화번호 : </th>
					<td width="50px"></td>
					<td class="inputTd"><input type="text"  oninput="this.value = this.value.replace(/[^0-9-.]/g, '').replace(/(\..*)\./g, '$1');" class="form-control" name="phone" id="phone" maxlength="13" required ></td>
				</tr>
				<tr>
					<td colspan="2" height="30px"></td>
				</tr>
				<tr align="center">
				<th colspan="3">*주소</th>
				</tr>
				<tr>
					<td colspan="2" height="30px"></td>
				</tr>
				<tr>
					<td colspan="2" width="200px" >
					<input type="text" id="postcode" placeholder="우편번호" class="form-control" onclick="execDaumPostcode()" name="postcode" readonly required>
					</td>
					<td><input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class="btn-secondary"></td>
				</tr>
				<tr>
					<td colspan="2" height="15px"></td>
				</tr>
				<tr align="center">
				<th colspan="3"><input type="text" id="roadAddress" placeholder="도로명주소" class="form-control" name="roadAddress"></th>
				</tr>
				<tr>
					<td colspan="2" height="15px"></td>
				</tr>
				<tr align="center">
				<th colspan="3"><input type="text" id="jibunAddress" placeholder="지번주소" class="form-control" name="jibunAddress"></th>
				</tr>
				<tr>
					<td colspan="2" height="15px"></td>
				</tr>
				<tr align="center">
				<th colspan="3"><input type="text" id="detailAddress" placeholder="상세주소" class="form-control" name="detailAddress" required></th>
				</tr>
				<tr>
					<td colspan="2" height="15px"></td>
				</tr>
				<tr align="center">
				<th colspan="3"><input type="text" id="extraAddress" placeholder="참고항목" class="form-control" name="extraAddress"></td></th>
				</tr>
				<tr>
					<td colspan="2" height="15px"><span id="guide" style="color:#999;display:none" class="form-control"></span></td>
				</tr>
				<tr>
					<td colspan="2" height="30px"></td>
				</tr>
				<tr>
					<th>* 생년월일 : </th>
					<td width="50px"></td>
					<td class="inputTd"><input type="date" class="form-control" name="userBirth" required></td>
				</tr>
				<tr>
					<td colspan="2" height="30px"></td>
				</tr>
				<tr>
					<th>* 성별  : </th>
					<td width="50px"></td>
					<td class="inputTd"><select name="gender" class="form-control">
					<option value="M">남자</option>
					<option value="F">여자</option>
					</select></td>
				</tr>
				
				
			</table>
			<br><br>
			<button type="submit" style="display:none" id="submitBtn"></button>
			<button type="button" class="btn btn-danger" onclick="newMember();">회원가입</button>
		</div>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("roadAddress").value = roadAddr;
                document.getElementById("jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
    
    function newMember(){
    	var newMemberUser = document.getElementById("submitBtn");

    	if($("#userPw").val()!=$("#userPwC").val()){
    		$("#userPwcTd").text("비밀번호 확인이 일치하지 않습니다.");
    		document.getElementById("userPw").scrollIntoView(true);
    	}else{
    		$.ajax({
    			url:"/Semi/ajaxConfirmSign.lo",
    			data:{userId : $("#userId").val(),
    				email : $("#email").val(),
    				phone : $("#phone").val()},
    			type : "post",
    			success : function(result){
    				console.log(result);
    				if(result==0){
    					if(document.getElementById("emailConfirm1").disabled==true){
	    	    			newMemberUser.click();
    					}else{
    						window.alert("이메일 인증을 완료해주세요");
    					}
    				}else{
    					window.alert("ID, 이메일, 전화번호 중 이미 가입된 정보가 있습니다. 다시 확인해주세요");
    				}
    			},
    			error : function(){
    				
    			}
    			
    		})
    	}
    }
    $(function(){
        $("#phone").on("propertychange change keyup paste input",function(){
			if($(this).val().length==3 && between($(this).val().substring(0,3),000,999)){
				var str = $(this).val().substring(0,3);
				str += "-";
				$(this).val(str);
			}
			if($(this).val().length==8 && between($(this).val().substring(4,8),0000,9999)){
				var str = $(this).val().substring(0,8);
				str += "-";
				$(this).val(str);
			}
				
        })
    })
    
    function between(x, min, max){
    	return x>=min && x<=max;
    }
    var ConEmail = "";
    var auKey="";
	function emailCon(){
		if($("#email").val()=="" || $("#email").val().indexOf('@')==-1 ){
			window.alert("올바른 메일 주소를 입력해주세요");
		}else{
		$("#emailConfirmTr").css('display','');
		$("#emailConfirmTr2").css('display','');
		$.ajax({
			url : "/Semi/SendMaill.lo",
			data :{email : $("#email").val()},
			type:"post",
			success : function(result){
				ConEmail = result.ConEmail;
				auKey = result.auKey;
			},
			error : function(){
				
			}
			
		});
		}
	}
	
	function emailConfi(){
		if($("#email").val()==ConEmail && $("#emailConfirm").val()==auKey){
			window.alert("인증이 완료되었습니다.")
			$("#email").prop('readonly',true);
			$("#emailConfirm").prop('readonly',true);
			$("#emailConfirm1").attr('disabled',true);
			$("#emailCon1").attr('disabled',true);		
			}else{
				window.alert("이메일 혹은 인증번호가 일치하지 않습니다. 다시 인증해주세요");
				console.log(ConEmail);
				console.log(auKey);
			
			}
	}
</script>
</body>
</html>
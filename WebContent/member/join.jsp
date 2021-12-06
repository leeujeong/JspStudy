<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewprot" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		
		$('#id').on('keyup', function(){
			$.ajax({
				url:'idCheck.member', 
				type:'post',
				data:'id=' + $('#id').val(),
				dataType:'json',
				success:function(resData){
					if(resData.result == true){
							$('#id_check').text('사용 가능한 아이디');
						}else{
							$('#id_check').text('이미 사용중인 아이디');
							}
						},
				error:function(xhr){
					alert(xhr.responseText);
					}
				});
			});
		$('#f').on('submit', function(evnet){
			if($('#pw').val() != $('#pwcheck').val()){
				alert('비밀번호를 확인하세요');
				event.preventDefault();
				$('#pw').val('');
				$('#pw').focus();
				$('#pwcheck').val('');
				return false
			}
			return true;
		});
	});
	
</script>
</head>
<body>

	<div>
		<h1>회원 가입</h1>
		<form id="f" action="join.member" method="post">
			<input type="text" name="id" id="id" placeholder="아이디"><br>
			<span id="id_check"></span><br>
			<input type="password" name="pw" id="pw" placeholder="비밀번호"><br>
			<input type="password" name="pwcheck" id="pwcheck" placeholder="비밀번호확인"><br>
			<input type="text" name="name" id="name" placeholder="이름"><br>
			<input type="text" name="email" id="email" placeholder="이메일"><br>
			<button>가입하기</button>
			<input type="reset" value="입력취소">
			<input type="button" value="가입취소" onclick="location.href='index.jsp'">
		</form>
	</div>
</body>
</html>
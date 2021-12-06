<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;'
	}
	a{
		color: black;
	}
	.wrap{
		width: 500px;
		margin: 100px auto;
		text-align: center;
	}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		$('#f').on('submit', function(event){
			if($('#id').val() == '' || $('#name').val() == ''){
				alert('아이디와 이름은 필수 입니다.');
				event.preventDefault();
				return false;
			}
			return true;
		});
	});
</script>
</head>
<body>
	<div class="wrap">
		<h3>회원 관리 시스템</h3>
		<a href="views/login.jsp">로그아웃</a>
		<hr>
		<form action="/ServerProgram/update.do" method="post" id="f">
			<input type="text" name="id" id="id" placeholder="아이디"><br>
			<input type="text" name="name" id="name" placeholder="이름"><br><br>
			<button>로그인</button>&nbsp;&nbsp;
			<a href="/ServerProgram/joinPage.do">회원가입</a>
		</form>
	</div>

</body>
</html>
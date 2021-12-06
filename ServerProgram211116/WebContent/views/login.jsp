<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<style>
	.wrap{
		margin:100px;
	}
	.btn_area{
		margin: 20px
	}
</style>
</head>
<body>
<%
	session.invalidate();
%>
<div class="wrap">
	<form id="f" action="views/manager.jsp" method="post">
		
			<h3>회원관리 프로그램</h3>
			<div>
				<input type="text" name="id" id="id" placeholder="아이디">
			</div>
			<div>
				<input type="text" name="name" id="name" placeholder="이름">
			</div>
			<div class="btn_area">
				<button>로그인</button>
				<a href="views/join.jsp">회원가입</a>
			</div>
	</form>
</div>
</body>
</html>
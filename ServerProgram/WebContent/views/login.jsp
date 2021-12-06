<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	
</script>
<style>
	table{
		border-collapse: collapse;
		border-top: 2px solid gray;
		border-bottom:2px solid gray;
	}
</style>
</head>
<body>
	<header>
		<h3>회원관리 프로그램</h3>
			<div>
				<a href="/ServerProgram/logout.do">로그아웃</a>
			</div>
	</header>
	<hr>
	<section>
		<form id="f" action="/ServerProgram/update.do" method="post">
			<table>
				<thead>
					<tr>
						<td>아이디</td>
						<td>이름</td>
						<td>등금</td>
						<td>포인트</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${loginUser.id}</td>
						<td><input type="text" id="name" name="name" value="${loginUser.name}"></td>
						<td>${loginUser.grade}</td>
						<td><<input type="text" id="point" name="point" value="${loginUser.point}"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4">
							<button>수정하기</button>
							<input type="button" value="탈퇴하기" id="delete_btn">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</section>
</body>
</html>
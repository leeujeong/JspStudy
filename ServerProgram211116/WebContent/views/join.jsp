<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.wrap{
		margin:100px;
	}
	tfoot{
		text-align: center;
	}
</style>
<body>

<div class="wrap">

	<form action="views/loginpage.jsp" method="post">
		<table>
			<thead>
				<tr>
					<td corspan="2"><h3>회원 가입 폼</h3></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<label for="id">아이디</label>
					</td>
					<td>
						<input type="text" name="id" id="id">
					<td>
				</tr>
				<tr>
					<td>
						<label for="name">이름</label>
					</td>
					<td>
						<input type="text" name="name" id="name">
						<input type="hidden" id="no" value="no">
						<input type="hidden" id="point" value="1000">
						<input type="hidden" id="grade" value="bronze">
					<td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<button> 회원가입 </button>
						<input type="button" value="돌아가기" onclick="location.href='views/login.jsp'">
					</td>
		</table>

	</form>
</div>
</body>
</html>
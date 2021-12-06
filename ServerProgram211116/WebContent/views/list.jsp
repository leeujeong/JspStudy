<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">

</script>

</head>
<body>

	<a href="/ServerProgram/joinFrom.do">로그인 하러가기</a>
	<hr>
	<h1>회원 목록</h1>
	<table border="1">
		<thead>
			<tr>
				<td>회원번호</td>
				<td>아이디</td>
				<td>이름</td>
				<td>등급</td>
				<td>포인트</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${totalCount eq 0}">
				<tr>
					<td colspan="8">등록된 멤버가 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${totalCount gt 0}">
				<c:forEach items="${list}" var="member">
					<tr>
						<td>${member.no}</td>
						<td>${member.id}</td>
						<td>${member.name}</td>
						<td>${member.grade}</td>
						<td>${member.point}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
</body>
</html>
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
	a{
		color: black;
		text-decoration:none;
	}
	
	.title{
		font-weight:bold;
		font-size:24px;
	}
	tfoot td{
		text-align : center;
	}
</style>
</head>
<body>
<div>
	<div  class="title">
		<c:if test="${loginUser != null}">
			<a href="insertForm.board">새 이미지게시글 작성하기</a>
		</c:if>
	</div>

	
	<table border="1">
		<thead>
			<tr>
				<td>순번</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="4">없음</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach varStatus="vs" items="${list}" var="board">
					<tr>
						<td>${startNum - vs.index}</td>
						<td><a href="view.board?bNo=${board.bNo}">${board.title}</a></td>
						<td>${board.writer}</td>
						<td>${board.created}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">${pageEntity }</td>
			</tr>
		</tfoot>
	</table>

</div>
	
	
</body>
</html>
<%@page import="dto.Notice"%>
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
<style type="text/css">
	td{
		padding:5px;
	}
	tfoot{
		text-align:center;
	}

</style>
</head>
<body>
	<!-- 검색란 -->
	<form action="find.notice">
		<select name="column">
			<option value="WRITER">작성자</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="ALL">작성자 + 제목 + 내용 </option>
		</select>
		<input type="text" name="query">
		<button>검색</button>
		<input type="button" value="전체보기" onclick="location.href='list.notice'">
		
	</form>
	
	
	<div>
		<c:if test="${loginUser.id =='admin'}">
			<a href="insertForm.notice">공지사항 작성하기</a>
		</c:if>
	</div>
	
	<table border="1">
		<caption>공지수 : ${totalRecord} </caption>
		<thead>
			<tr>
				<td>순번</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="5">없음</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach varStatus="s" items="${list}" var="notice">
					<tr>
						<td>${startNum - s.index}</td> <!-- 순서대로 표시되는 순번(게시글 번호와 상관없음) -->
						<td><a href="view.notice?nNo=${notice.nNo}">${notice.title}</a></td>
						<td>${notice.writer}</td>
						<td>${notice.hit}</td>
						<td>${notice.nDate}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">${pageEntity}</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>
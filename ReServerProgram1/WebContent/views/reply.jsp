<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#delete_btn').on('click', function(event){
			if(confirm('삭제할까요?')){
				location.href="delete.do?no="+${board.no};
				event.preventDefault();
			}else{
				alert('삭제 실패했습니다.');
				history.back();
			}
		});
	});
	
	</script>
</head>
<body>
	<form>
		<div>
			<h3>${board.no}번 게시글</h3><br>
			<p>작성자 : ${board.author}</p><br>
			<p>작성일 : ${board.postdate}</p><br>
			<p>작성IP : ${board.ip}</p><br>
			<p>조회수 : ${board.hit}</p><br>
			<p>제목 :<p><br>
			<input type="text" name="title" value=" ${board.title}"><br>
			<p>내용 </p><br>
			<textarea rows="5" cols="30">${board.content}</textarea>
			<br>
			<input type="hidden" name="no" value="${board.no}">
			<input type="button" value="삭제하기" id="delete_btn">
	
			<input type="button" value="목록보기" onclick="location.href='boardList.do'">
		</div>
	</form>
	<hr>
	<form action="insertReply.do" method="post">	
		<textarea rows="2" cols="30" placeholder="댓글을 입력하세요" name="content"></textarea><br>
		<input type="text" name="author" placeholder="작성자">
		<input type="hidden" name="boardNo" value="${board.no}">
		<button>작성</button>
	</form>
	<table>
		<tbody>
			<c:if test="${empty replyList}">
				<tr>
					<td colspan="4">작성된 댓글이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty replyList}">
				<c:forEach items="${replyList}" var="reply">
					<tr>
						<td>${reply.content}</td>
						<td>${reply.author}</td>
						<td>${reply.ip}</td>
						<td>${reply.postdate}</td>	
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>
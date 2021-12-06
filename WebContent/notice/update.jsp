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
		$('#f').on('submit', function(event){
			if('${notice.title}'== $('#title').val() && '${notice.content}' == $('#content').val()){
				alert('수정할 내용이 없음');
				event.preventDefault();
				return false;
			}
			return true;
			
		});
	});
</script>

</head>
<body>

	<div>
		<form action="update.notice" method="post" id="f">
			작성자 : ${notice.writer}<br>
			<!-- session에 있는 notice사용 -->
			
			<lable for="title">제목
			<input type="text" name="title" id="title" value="${notice.title}"><br>
			
			<textarea rows="5" cols="30" id="content" name="content" placeholder="내용" >${notice.content}</textarea><br><br>
			<input type="hidden" name="nNo" value="${notice.nNo}">
			
			<button>수정 완료</button>
			<input type="reset" value="초기화">
			<input type="button" value="목록이동" onclick="location.href='list.notice'">
		</form>
	</div>
</body>
</html>
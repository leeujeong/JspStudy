<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		setTimeout(() => {
			location.href='/BATCH/studentList.do';
		}, 3000);
	</script>

	<h1>3초후 학생 목록으로 이동합니다!</h1>
	<div>바로 이동하려면 아래 버튼을 클릭하세요~</div>
	<button onclick="location.href='/BATCH/studentlist.do'">바로이동</button>
</body>
</html>
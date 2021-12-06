<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		$('#f').on('submit',function(){	
			if($('#name').val =='${emp.name}' && ($('#hire').val() =='${emp.hire}'){
				alert('변경사항이 없습니다.');
				event.preventDefault;
				return false;
			}else{
				return true;
			}
		});
		
		
	});
</script>
</head>
<body>

<div>
	<form action="/07_JDBC/update.emp" id="f">
		<h1>사원 상세 정보 보기</h1>
		사원번호 : ${emp.num}<br>
		사원이름 : <input type="text" name="name" id ="name" value="${emp.name}"><br>
		입사일자 : <input type="text" name="hire" id ="hire" value="${emp.hire}"><br>
		<input type="hidden" name="num" value="${emp.num}">
		<button>정보수정하기</button>
		<input type="button" value="사원목록보기" onclick="location.href='/07_JDBC/selectList.emp'">
	</form>
</div>
</body>
</html>
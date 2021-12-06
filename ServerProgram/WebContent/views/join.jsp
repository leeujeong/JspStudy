<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

</head>
<style>
	.*{
		margin:0;
		padding:0;
	}
	.wrap{
		margin:100px auto;
		width: 400px;
		text-align:center;
	}
	table{
		width:100%;
	}
	td{
		text-align: center;
		padding: 5px;
	}
</style>
<script>
	$(document).ready(function(event){
			$('#f').on('submit', function(){
				if($('#id').val() == '' || $('#name').val() ==''){
					alert('가입정보를 모두 입력하세요');
					event.preventDefault();
					return false;
				}
				return true;
			})
	})
</script>
<body>

<div class="wrap">

	<form action="views/loginpage.jsp" method="post" id="f">
		<table>
			<thead>
				<tr>
					<td corspan="2"><h3>회원 가입 폼</h3></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><label for="id">아이디</label></td>
					<td><input type="text" name="id" id="id"><td>
				</tr>
				<tr>
					<td><label for="name">이름</label></td>
					<td><input type="text" name="name" id="name"><td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<button> 회원가입 </button>
						<input type="button" value="돌아가기" onclick="location.href='/ServerProgram/loginPage.do'">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.manager_table{
		border-top: 2px solid gray;
		border-bottom : 2px solid gray;
		border-collapse: collapse;
	}
	table td{
		border-top: 1px solid gray;
	
	}
	tfoot td{
		text-align:center;
	}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		$('#modify_btn').on('click', function(event){
			if($('#name').val() == '${member.name}' && $('#point').val() == '${member.point}'){
				alert('수정할 내용이 없습니다');
				event.preventDefault();
				return false;
			}
			return true;
		});
		$('#out_btn').on('click', function(event){
			if (confirm('탈퇴하시겠습니까?') == false) {
				event.preventDefault();
				location.href="veiws/out.jsp"
				return false;
			}
			return true;
		});
	});
</script>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		session.setAttribute("id", request.getParameter("id"));
		session.setAttribute("name", request.getParameter("name"));
		session.setAttribute("no", request.getParameter("no"));
		session.setAttribute("point", request.getParameter("point"));
		session.setAttribute("grade", request.getParameter("grade"));
	%>
	<h3>회원 관리 시스템</h3>
	<a href="views/login.jsp">로그아웃</a>
	<hr>
	<form action="/ServerProgram/update.do" method="post">
		<table class="manager_table">
			<thead>
				<tr>
					<td>아이디</td>
					<td>이름</td>
					<td>등급</td>
					<td>포인트</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${id}</td>
					<td>
						<input type="text" name="name" id="name" value="${name}">
					</td>
					<td>${grade}</td>
					<td>
						<input type="text" name="point" id="point" value="${point}">
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
						<input type="submit" value="수정하기" id="modify_btn">
						<input type="button" value="탈퇴하기" id="out_btn">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>

</body>
</html>
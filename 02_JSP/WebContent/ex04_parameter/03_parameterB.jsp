<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewprot" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		boolean result = false;
		
	%>
	<script>
		let result = <%=result%>;
		if(result == true){
			
		}else{
			alert('일치하는 회원이 없습니다.');
			history.back();
		}
	</script>
</body>
</html>
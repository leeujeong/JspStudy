<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


 
<select name="month">
	<option value="">월선택</option>
	<%for(int i=1; i<=12; i++){%>
	<option value="<%=i %>"><%=i %>월</option>
	<% }%>
</select>



</body>
</html>
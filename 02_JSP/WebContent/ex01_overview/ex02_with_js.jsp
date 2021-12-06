<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--Java 변수를 JavaScrpit 변수로 사용할 수 있다. --%>
<%
	String name = "이유정"; 
	int age = 44;
%>
<script>
	let name = '<%=name%>';
	let age = <%=age%>;
	alert(name + age);
</script>

<%--JavaScript 변수를 Java변수로 사용할 수없다. 없다 없다.!!!! --%>


</body>
</html>
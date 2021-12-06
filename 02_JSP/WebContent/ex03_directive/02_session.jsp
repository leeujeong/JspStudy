<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true" %>

<%@page session="true" %>

<%
session.setAttribute("id","admin");
String id = (String)session.getAttribute("id");

%>
<script>
let id = '<%=id%>';
alert(id);
</script>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
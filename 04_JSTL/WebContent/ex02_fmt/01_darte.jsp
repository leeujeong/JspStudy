<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- SimpleDateFormat 클랙스 pattern 그대로 사용할 수 있다. --%>
	
	<c:set var="now" value="<%=new Date() %>" />
	
	<div>디풀트 <fmt:formatDate value="${now}" /></div>
	<div>날짜 <fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 E요일" /></div>
	<div>12시간 <fmt:formatDate value="${now}" pattern="a h:mm:ss"/></div>
	<div>24시각 <fmt:formatDate value="${now}" pattern="H:mm:ss"/></div>

</body>
</html>
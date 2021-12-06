<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	long timeStamp = System.currentTimeMillis();
	Date today = new Date(timeStamp);
	SimpleDateFormat sdf = new SimpleDateFormat();
	sdf.applyPattern("yyyy-MM-dd a H:mm:ss");
	String fToday = sdf.format(today);

%>
<script>
	let today = '<%=fToday%>';
	alert(today);
</script>
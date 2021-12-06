
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
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

	String realPath = application.getRealPath("ex06_attribute/next_level.txt");
	
	BufferedReader br = new BufferedReader(new FileReader(realPath));
	
	String result = "";
	
	while(true){
		String line = br.readLine();
		if(line ==null){
			break;
		}else{
			result += line + "<br>";
		}
	}if(br != null){
		br.close();
	}
%>
<div><%=result %></div>
</body>
</html>
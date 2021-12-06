<%@page import="java.io.File"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");

	String date = request.getParameter("date");
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	Optional<String> optIp = Optional.ofNullable(request.getHeader("X-Forwarded-For"));
	String ip = optIp.orElse(request.getRemoteAddr());
	
	String filename = ip.replaceAll("\\:", "_") + "_" + date + ".txt";
	
	String realpath = application.getRealPath("ex06_attribute/" + filename);
	
	File dir = new File(realpath);
	if(dir.exists() == false){
		dir.mkdirs();
	}
	File file = new File(dir, filename);
	BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	bw.write("작성일자 : " + date); bw.newLine();
	bw.write("작성자 : " + writer + "\n");
	bw.write("제목 : " + title+"\n");
	bw.write(content + "\n");
	
	if(bw != null){
		bw.close();
	}
	if(file.exists()){
		application.setAttribute("success", true);
	}else{
		application.setAttribute("success", false);
	}
%>
<script>
	let exist = <%=file.exists()%>
	if(exist){
		alert('<%=filename%> 파일이 생성되었습니다.');
	}else{
		alert('생성되지 않았습니다.');
		 
	}history.back();
</script>
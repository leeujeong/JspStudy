<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*forward : 기존 요청을 가지고 대로 전달한다. */

	RequestDispatcher dispatcher = request.getRequestDispatcher("01_requestDispatcherC.jsp");
	dispatcher.forward(request, response);

%>

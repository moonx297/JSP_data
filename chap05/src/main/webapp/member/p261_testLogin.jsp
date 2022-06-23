<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id="heein";    
	String pwd="1234";
	String name="문희인";
	
	if(id.equals(request.getParameter("id")) &&
			pwd.equals(request.getParameter("pwd")) ){
		session.setAttribute("loginUser", name);	//로그인 할때는 꼭 set이 있어야한다.
		response.sendRedirect("p261_main.jsp");
	}
	else{
		response.sendRedirect("p260_loginForm.jsp");
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
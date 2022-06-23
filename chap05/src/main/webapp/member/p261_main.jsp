<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("loginUser")==null){
	response.sendRedirect("p260_loginForm.jsp");
}else{
%>
	<%=session.getAttribute("loginUser") %>님 안녕허새요!<br>
	홈페이지를 방문해 주셔 감사합니다.<br>
	즐거운 시간 되세요...<br>
	<form method="post" action="p262_logout.jsp">
	<input type="submit" value="로그아웃">
	</form>
<%
} 
%>
</body>
</html>
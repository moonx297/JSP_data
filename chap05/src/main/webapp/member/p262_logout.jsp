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
session.invalidate();	//로그아웃할때 비워야하는것.
%>
	<script>
		alert("로그아웃 되었습니다.");
		location.href="p260_loginForm.jsp";
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL과 JSTL</title>
</head>
<body>
<!-- 표현언어 (EL, Expression Language : 이렇게 값을 가져오면 편함) -->

${3+5} <br>				     <!-- 표현어 -->

<%=3+5 %> <br> 				 <!-- 표현식( Expression) -->

<% out.println("Hello"); %> <br> <!-- 스크립트릿 -->

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/style.css" rel="stylesheet">
</head>
<body>
<div class="test">
<img src="./img/수리중.jfif"><br>
<h1>다음과 같은 에러가 발생하였습니다.</h1><br>
<%= exception.getMessage() %>
</div>

</body>
</html>
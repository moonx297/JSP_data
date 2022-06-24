<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="fruitSelect.jsp">
	<label for="fruit">과일을 선택하세요</label><br>
	<select id="fruit" name="fruit">
		<option value="1">멜론</option>
		<option value="2">키위</option>
		<option value="3">체리</option>
	</select>
	<input type="submit" value="전송">
</form>
</body>
</html>
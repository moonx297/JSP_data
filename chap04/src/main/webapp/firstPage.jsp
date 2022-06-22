<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>				<!-- 첫번째 페이지에서는 로그인 -->
    <%
    	pageContext.setAttribute("name", "page man");
    	request.setAttribute("name", "request man");
    	session.setAttribute("name", "session man");
    	application.setAttribute("name", "application man");
    	
    	System.out.println("firstPage.jsp : ");
    	System.out.println("하나의 페이지 속성 :"+pageContext.getAttribute("name"));
    	System.out.println("하나의 요청 속성 :"+request.getAttribute("name"));
    	System.out.println("하나의 세션 속성 :"+session.getAttribute("name"));
    	System.out.println("하나의 애플리케이션 속성 :"+application.getAttribute("name"));
    	
    	request.getRequestDispatcher("secondPage.jsp").forward(request, response);
    	/* --> 이게 없으면 콘솔에만 내용이 뜬다. */
    	/* Dispatcher: 서버. forward: 숨김. firstPage에 가더라도 나는 secondPage를 보여주겠다. */ 
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
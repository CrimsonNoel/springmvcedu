<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
spring start

<ul>
<li> Hello====
<li> <a href="${pageContext.request.contextPath}/hello.do">hello.do</a></li>
<li> <a href="<%=request.getContextPath() %>/hello-raw.do">hello-raw.do</a></li>
<li> <a href="<%=request.getContextPath() %>/hello.do2">hello.do2</a></li>
</ul>

<ul>
<li> model 
<li> <a href="<%=request.getContextPath() %>/event/list">event/list</a></li>
</ul>





</body>
</html>
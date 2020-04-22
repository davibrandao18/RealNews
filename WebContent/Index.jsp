<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Jornal RealNews</title>
	</head>	
	<body>
		<h1>RealNews</h1>
		<hr size="2px" color ="black">
		
		<%String title = (String)request.getAttribute("Titulo"); %>
		<h3><%=title %></h3>
		<br>
		<%String Descricao = (String)request.getAttribute("Descricao"); %>
		<p><%=Descricao %></p>
		<br>
	</body>
</html>
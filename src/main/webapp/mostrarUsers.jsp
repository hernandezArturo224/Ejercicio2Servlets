<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, modelos.*" %>    
    
<%
List<Usuarios> users = (List<Usuarios>) request.getAttribute("listaUsers");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estiloBasico.css" media="screen" />
<title>Insert title here</title>
</head>
<body>
	<div class="div40">
		<h2> Usuarios en la BBDD</h2>
		<p><% out.print(users.get(0).toString()); %></p>
	</div>

</body>
</html>
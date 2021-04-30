<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*, modelos.*" %>
    
<%
Usuarios us = (Usuarios)session.getAttribute("user");
Date fecha = (Date)session.getAttribute("date");
String volver = (String)request.getParameter("volver");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="div30">
	<h2><% out.print(us.getNombre()+" "+us.getApellido1()+" "+us.getApellido2()); %></h2>
</div>
<div class="div20">
	<form action="http://localhost:8080/Ejercicio2Servlets/CerrarSesion" method="post">
		<input type="submit" class="boton_personalizado" value="Cerrar Sesión" />
	</form>
</div>
<div class="div20">
	<form action=<%= volver %> method="post">
		<input type="submit" class="boton_personalizado" value="Volver" />
	</form>
</div>
<div class="div30">
	<h2><% out.print(fecha); %></h2>
</div>

</body>
</html>
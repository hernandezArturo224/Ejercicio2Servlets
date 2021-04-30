<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.*, modelos.*" %>

    
<%
Usuarios us = (Usuarios)session.getAttribute("user");
Date fecha = (Date)session.getAttribute("date");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>menu inicial</title>
<link rel="stylesheet" type="text/css" href="estiloBasico.css" media="screen" />

</head>
<body>
<div class="div30">
	<h2><% out.print(us.getNombre()+" "+us.getApellido1()+" "+us.getApellido2()); %></h2>
</div>
<div class="div40">
	<h1>MENU INICIAL</h1>
</div>
<div class="div30">
	<h2><% out.print(fecha); %></h2>
</div>

<%@ include file="buttonForm.html" %>
</body>
</html>
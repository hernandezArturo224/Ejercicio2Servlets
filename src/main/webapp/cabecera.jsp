<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*, modelos.*" %>
    
<%
Usuarios us = (Usuarios)session.getAttribute("user");
Date fecha = (Date)session.getAttribute("date");
String volver = (String)request.getParameter("volver");
String home="menu.jsp";
if(us == null){
	home = "login.jsp";
}
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="css/headers.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
	<ul class="nav nav-pills">
      	<li class="nav-item"><a href=<%= home %> class="nav-link active">Home</a></li>
      	
      	<%if(us != null){ %>
      	<li class="nav-item"><a href="http://localhost:8080/Ejercicio2Servlets/CerrarSesion" class="nav-link">Cerrar Sesion</a></li>
      	<%
      	}else{ %>
      		<li class="nav-item"><a href="login.jsp" class="nav-link">Login</a></li>
      	<% }
      	if(volver != null){ %>
      	<li class="nav-item"><a href="<%= volver %>" class="nav-link">Volver</a></li>
      	<% 
		}//fin if volver 
      	
      	if(fecha != null){
		%>
      	<li class="nav-item"><p class="nav-link"><% out.print(fecha); %></p></li>
      	<% 
      	}
		if(us != null){
      	%>
      	<li class="nav-item"><p class="nav-link"><% out.print(us.getNombre()+" "+us.getApellido1()+" "+us.getApellido2()); %></p></li>
      	<%
		}//fin if user
      	%>
    </ul>
	</header>
</div>

</body>
</html>
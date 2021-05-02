<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, modelos.*" %>

<%
Usuarios use = (Usuarios)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%if(use.getId_rol()<=2){%>
		<%if(use.getId_rol()<=1){%>
			<a href="registro.jsp?volver=menu.jsp" class="boton_personalizado">Registrarse</a>
			<a href="insercionRol.jsp?volver=menu.jsp" class="boton_personalizado">Agregar Rol</a>
			<a href="insercionCategoria.jsp?volver=menu.jsp" class="boton_personalizado">Agregar Categoria</a>
			<a href="insercionProducto.jsp?volver=menu.jsp" class="boton_personalizado">Agregar Producto</a>
		<%
		}//fin if para ver los registros
		%>
		<a href="http://localhost:8080/Ejercicio2Servlets/MuestraUsers?volver=menu.jsp" class="boton_personalizado">Ver usuarios</a>
		<a href="http://localhost:8080/Ejercicio2Servlets/MuestraRoles?volver=menu.jsp" class="boton_personalizado">Ver roles</a>
		<a href="http://localhost:8080/Ejercicio2Servlets/MuestraCategorias?volver=menu.jsp" class="boton_personalizado">Ver categorias</a>
		<a href="http://localhost:8080/Ejercicio2Servlets/MuestraProductos?volver=menu.jsp" class="boton_personalizado">Ver Productos</a>
	<%
	}//fin if para ver algo
	%>
</body>
</html>
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
<div class="div100">
	<%@ include file="cabecera.jsp" %>
</div>

	<div class="div100">
		<table class="tabla">
			<tr class="bordes">
				<th class="bordes">Id</th>
				<th class="bordes">Rol</th>
				<th class="bordes">E-mail</th>
				<th class="bordes">Clave</th>
				<th class="bordes">Nombre</th>
				<th class="bordes">1 Apellido</th>
				<th class="bordes">2 Apellido</th>
				<th class="bordes">Dirección</th>
				<th class="bordes">Localidad</th>
				<th class="bordes">Provincia</th>
				<th class="bordes">Teléfono</th>
				<th class=bordes>DNI</th>
			</tr>
			<%Iterator<Usuarios> it = users.iterator();
				while(it.hasNext()){
					Usuarios user = it.next();
			%>
			<tr class="bordes">
				<th class="bordes"><%out.print(user.getId()); %></th>
				<th class="bordes"><%out.print(user.getId_rol()); %></th>
				<th class="bordes"><%out.print(user.getEmail()); %></th>
				<th class="bordes"><%out.print(user.getClave()); %></th>
				<th class="bordes"><%out.print(user.getNombre()); %></th>
				<th class="bordes"><%out.print(user.getApellido1()); %></th>
				<th class="bordes"><%out.print(user.getApellido2()); %></th>
				<th class="bordes"><%out.print(user.getDireccion()); %></th>
				<th class="bordes"><%out.print(user.getLocalidad()); %></th>
				<th class="bordes"><%out.print(user.getProvincia()); %></th>
				<th class="bordes"><%out.print(user.getTelefono()); %></th>
				<th class=bordes><%out.print(user.getDni()); %></th>
			</tr>
			<%
				}//fin while
			%>
			
		</table>
	</div>

</body>
</html>
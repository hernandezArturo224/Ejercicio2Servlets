<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import="java.util.*, modelos.*, utilidades.Util" %>
 
 
 <% 
 Provincias[] provincias = Util.getProvincias();
 Usuarios usuarioConectado = (Usuarios)session.getAttribute("user");
 List<Roles> roles = (List<Roles>)request.getAttribute("roles");
 %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
</head>
<body>

	<form method="post" style="text-align: center;" action="http://localhost:8080/Ejercicio2Servlets/Registro">
		<%if(usuarioConectado != null){
			if(usuarioConectado.getId_rol() == 1){
			%>
			<select name="id_rol">
				<%
				Iterator<Roles> it = roles.iterator();
				while(it.hasNext()){
					Roles rol = it.next();
				%>
				<option value=<%= rol.getId() %>><%=rol.getRol() %></option>
				<% 
				}//fin while
				%>
			</select>
		<%
			}//fin comprobar rol
		}//fin comprobar si hay usuario
		%>
		</br>
		<input type="text"  style="margin: 5px;" name="email" placeholder="Introduce el e-mail"/>
		</br>
		<input type="password"  style="margin: 5px;" name="clave" placeholder="Introduce la clave"/>
		</br>
		<input type="text"  style="margin: 5px;" name="nombre" placeholder="Introduce tu nombre"/>
		</br>
		<input type="text"  style="margin: 5px;" name="ap1" placeholder="Introduce primer apellido"/>
		</br>
		<input type="text"  style="margin: 5px;" name="ap2" placeholder="Introduce segundo apellido"/>
		</br>
		<input type="text"  style="margin: 5px;" name="direccion" placeholder="Introduce la dirección"/>
		</br>
		<input type="text"  style="margin: 5px;" name="localidad" placeholder="Introduce la localidad"/>
		</br>
		<select name="provincia" >
			<% for(Provincias provincia: provincias){ %>
				<option value=<%=provincia.getNm() %>><%= provincia.getNm() %></option>
			<%
			} 
			%>
		</select>
		</br>
		<input type="text"  style="margin: 5px;" name="telefono" placeholder="Introduce el telefono"/>
		</br>
		<input type="text"  style="margin: 5px;" name="dni" placeholder="Introduce tu dni"/>
		</br>
		<input type="submit" name="btnSubmit" value="Registrar" />
	</form>

</body>
</html>
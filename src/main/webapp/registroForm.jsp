<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import="java.util.*, modelos.*, utilidades.Util" %>
 
 
 <% 
 Provincias[] provincias = Util.getProvincias();

 %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
</head>
<body>

	<form method="post" style="text-align: center;" action="http://localhost:8080/Ejercicio2Servlets/Registro">
		<input type="text"  style="margin: 5px;" name="id_rol" placeholder="Introduce la id_rol"/>
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
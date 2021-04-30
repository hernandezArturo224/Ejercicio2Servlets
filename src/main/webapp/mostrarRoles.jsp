<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, modelos.*" %> 

<%
List<Roles> roles = (List<Roles>) request.getAttribute("listaRoles");
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="estiloBasico.css" media="screen" />
</head>
<body>
<div class="div100">
	<%@ include file="cabecera.jsp" %>
</div>

<div class="div100">
	<table class="tabla">
		<tr class="bordes">
			<th class="bordes">ID ROL</th>
			<th class="bordes">NOMBRE ROL</th>
		</tr>
		
	<%
	Iterator<Roles> it = roles.iterator();
	while(it.hasNext()){
		Roles rol = it.next();
		%>
		<tr class="bordes">
			<td class="bordes"><%out.print(rol.getId()); %></td>
			<td class="bordes"><%out.print(rol.getRol()); %></td>
		</tr>
	<% 
	}//cierre del while
	%>	
	</table>


</div>

</body>
</html>
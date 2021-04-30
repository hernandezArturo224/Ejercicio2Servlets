<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, modelos.*" %> 
    
<%
List<Categorias> cat = (List<Categorias>) request.getAttribute("listaCategorias");
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
			<th class="bordes">ID CATEGORIA</th>
			<th class="bordes">NOMBRE</th>
			<th class="bordes">DESCRIPCION</th>
		</tr>
		
	<%
	Iterator<Categorias> it = cat.iterator();
	while(it.hasNext()){
		Categorias c = it.next();
		%>
		<tr class="bordes">
			<td class="bordes"><%out.print(c.getId()); %></td>
			<td class="bordes"><%out.print(c.getNombre()); %></td>
			<td class="bordes"><%out.print(c.getDescripcion()); %></td>
		</tr>
	<% 
	}//cierre del while
	%>	
	</table>


</div>


</body>
</html>
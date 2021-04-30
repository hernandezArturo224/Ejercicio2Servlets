<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, modelos.*" %> 
    
<%
List<Productos> cat = (List<Productos>) request.getAttribute("listaProductos");
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
			<th class="bordes">ID</th>
			<th class="bordes">ID CATEGORIA</th>
			<th class="bordes">NOMBRE</th>
			<th class="bordes">DESCRIPCION</th>
			<th class="bordes">PRECIO</th>
			<th class="bordes">STOCK</th>
			<th class="bordes">FECHA ALTA</th>
			<th class="bordes">FECHA BAJA</th>
			<th class="bordes">IMPUESTO</th>
		</tr>
		
	<%
	Iterator<Productos> it = cat.iterator();
	while(it.hasNext()){
		Productos c = it.next();
		%>
		<tr class="bordes">
			<td class="bordes"><%out.print(c.getId()); %></td>
			<td class="bordes"><%out.print(c.getId_categoria()); %></td>
			<td class="bordes"><%out.print(c.getNombre()); %></td>
			<td class="bordes"><%out.print(c.getDescripcion()); %></td>
			<td class="bordes"><%out.print(c.getPrecio()); %></td>
			<td class="bordes"><%out.print(c.getStock()); %></td>
			<td class="bordes"><%out.print(c.getFecha_alta()); %></td>
			<td class="bordes"><%out.print(c.getFecha_baja()); %></td>
			<td class="bordes"><%out.print(c.getImpuesto()); %></td>
		</tr>
	<% 
	}//cierre del while
	%>	
	</table>
</body>
</html>
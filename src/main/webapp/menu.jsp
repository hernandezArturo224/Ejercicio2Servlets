<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>

    <%@ page import="java.util.*, modelos.*" %>
    
<%
	List<Productos> prod = (List<Productos>)request.getAttribute("productos");    
%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>menu inicial</title>

</head>
<body>
<div style="margin-top: 20px;">
	<%@ include file="cabecera.jsp" %>
</div>

<div  style="margin-top: 20px;">
	<%@ include file="buttonForm.jsp" %>
</div>

<div style="margin-top: 20px;">
	<table class="table table-sm table-dark">
  		<div class="table-responsive">
    		<table class="table align-middle">
     		 <thead>
        		<tr>
        			<th>Categoria</th>
        			<th>Nombre</th>
        			<th>Descripcion</th>
        			<th>Precio</th>
        			<th>Impuesto</th>
        		</tr>
      		</thead>
     		 <tbody>
     		<%
     			Iterator<Productos> it = prod.iterator();
     			while(it.hasNext()){
     				Productos producto = it.next();
     		%>
		        <tr>
		        	<td><%= producto.getId_categoria() %></td>
		        	<td><%= producto.getNombre() %></td>
		        	<td><%= producto.getDescripcion() %></td>
		        	<td><%= producto.getPrecio() %></td>
		        	<td><%= producto.getImpuesto() %></td>
		        </tr>
        	<%
        	}//fin while 
        	%>
     		 </tbody>
    </table>
  </div>
</table>
</div>

</body>
</html>
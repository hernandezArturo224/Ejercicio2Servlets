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
	<%=prod.get(0).toString()  %>
</div>

</body>
</html>
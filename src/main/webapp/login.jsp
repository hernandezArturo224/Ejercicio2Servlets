<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<% 
String mensaje = (String)request.getAttribute("mensaje");
if(mensaje==null){
	mensaje="";
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>


    <!-- Bootstrap core CSS -->
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
    <link href="css/signin.css" rel="stylesheet">
    
</head>
<body class="text-center">

	<main class="form-signin">
		<form method="post" style="text-align: center;" action="http://localhost:8080/Ejercicio2Servlets/Login">
			<div class="form-floating">
				<input type="text"  class="form-control" id="email" style="margin: 5px;" name="email" placeholder="Introduce el email"/>
				<label for="email">Email</label>
			</div>
			<div class="form-floating">
				<input type="password"  id="clave" class="form-control" style="margin: 5px;" name="clave" placeholder="Introduce la clave"/>
				<label for="clave">Password</label>
			</div>
			<div class="checkbox mb-3">
		      <%= mensaje %>
    		</div>
			<input type="submit" class="w-100 btn btn-lg btn-primary" name="btnSubmit" value="Entrar" />
		</form>
		<a href= <%=request.getContextPath()%>/GetRolesRegistro class="nav-link">Registrarse</a>
	</main>	
</body>
</html>
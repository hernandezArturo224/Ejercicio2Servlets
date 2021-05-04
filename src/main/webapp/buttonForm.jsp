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
    <link href="css/navbar.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light rounded" aria-label="Eleventh navbar example">
			<div  class="container-fluid">
				 <div class="collapse navbar-collapse" id="navbarsExample09">
				 	<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<%
					if(use != null){
						if(use.getId_rol()<=2){
					%>
						<%if(use.getId_rol()<=1){%>
							<li class="nav-item">
								<a class="nav-link" href="http://localhost:8080/Ejercicio2Servlets/GetRolesRegistro">Registrarse</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="insercionRol.jsp" >Agregar Rol</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="insercionCategoria.jsp" >Agregar Categoria</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="insercionProducto.jsp" >Agregar Producto</a>
							</li>
						<%
						}//fin if para ver los registros
						%>
						<li class="nav-item">
							<a class="nav-link" href="http://localhost:8080/Ejercicio2Servlets/MuestraUsers">Ver usuarios</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="http://localhost:8080/Ejercicio2Servlets/MuestraRoles">Ver roles</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="http://localhost:8080/Ejercicio2Servlets/MuestraCategorias" class="boton_personalizado">Ver categorias</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="http://localhost:8080/Ejercicio2Servlets/MuestraProductos" class="boton_personalizado">Ver Productos</a>
						</li>
					<%
						}//fin if para ver algo
					}//Fin comprobar existencia del usuario	
					%>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</body>
</html>
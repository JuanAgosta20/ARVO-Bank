<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.Model.Administrative"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	if(session.getAttribute("user") == null || !(session.getAttribute("user").getClass().equals(Administrative.class))) response.sendRedirect("redirectIndex.do");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<title>ARVO Bank - Préstamos</title>
</head>
<body>
<jsp:include page="masterMenuAdmin.jsp"></jsp:include>

<div class="container-fluid mt-3">
<div class="row">
 <div class="col">
   <!-- Columna vacía izquierda--> 
    </div>
    <div class="col-6">
      <h4 class="text-blue">Autorizar Préstamos</h4>
      
      <table class="table table-hover">
  <thead>
    <tr class="table-info">
    <th scope="col">Fecha</th>
      <th scope="col">Nombre y Apellido</th>
      <th scope="col">DNI</th>
      <th scope="col">Monto</th>
      <th scope="col">Cuotas</th>
      <th scope="col">Estado</th>
      <th scope="col">Perfil</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>02/05/2020</td>
      <td>Ragnar Lotbrok</td>
      <td>20202020</td>
      <td>$500000</td>
      <td>24</td>
      <td>Aceptado</td>
      <td><a class="btn btn-success" href="#" role="button">Ver</a></td>
    </tr>
    <tr>
     <td>05/01/2019</td>
     <td>Jorge Diaz</td>
     <td>30303030</td>
     <td>$900000</td>
     <td>48</td>
     <td>Pendiente</td>
     <td><a class="btn btn-success" href="#" role="button">Ver</a></td>
     <td><button class="btn btn-outline-success btn-sm">Aceptar</button><button class="btn btn-outline-warning btn-sm">Rechazar</button></td>
    </tr>
    <tr>
  <td>02/02/2019</td>
      <td>Homero Simpson</td>
      <td>40404040</td>
      <td>$1000000</td>
      <td>64</td>
      <td>Rechazado</td>
      <td><a class="btn btn-success" href="#" role="button">Ver</a></td>
    </tr>
  </tbody>
</table>
    </div>
    
    
    <div class="col">
     <!-- Columna vacía derecha --> 
    </div>
    </div>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<title>ARVO Bank - Cuentas</title>
</head>
<body>
<jsp:include page="masterMenuAdmin.jsp"></jsp:include>

<div class="container-fluid mt-3">
<div class="row">
 <div class="col">
   <!-- Columna vacía izquierda--> 
    </div>
    <div class="col-6">
      <h4 class="text-blue">Autorizar cuentas</h4>
      <table class="table table-hover">
  <thead>
    <tr class="table-info">
    <th scope="col">Fecha</th>
        <th scope="col">Nombre y apellido</th>
      <th scope="col">DNI</th>
      <th scope="col">Tipo cuenta</th>
      <th scope="col">Estado</th>
       <th scope="col">Perfil</th>
       <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>02/05/2020</td>
      <td>Ernesto Jumanji</td>
      <td>20202020</td>
      <td>Caja Ahorro en US$</td>
      <td class="text-success">Aceptado</td>
      <td><a class="btn btn-success" href="#" role="button">Ver</a></td>
    </tr>
    <tr>
     <td>05/01/2019</td>
      <td>Ragnar Lotbrok</td>
      <td>1010101</td>
      <td>Caja de ahorro en $</td>
      <td class="text-warning">Pendiente</td>
      <td><a class="btn btn-success" href="#" role="button">Ver</a></td>
      <td><button class="btn btn-outline-success btn-sm">Aceptar</button><button class="btn btn-outline-warning btn-sm">Rechazar</button></td>
    </tr>
    <tr>
  <td>02/02/2019</td>
      <td>Abelardo Dominguez </td>
      <td>1010102</td>
      <td>Caja Ahorro en US$</td>
      <td class="text-danger">Rechazado</td>
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
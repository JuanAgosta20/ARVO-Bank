<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
      
 <h3>Falta modificar tabla</h3>
      <table class="table table-hover">
  <thead>
    <tr class="table-info">
    <th scope="col"></th>
        <th scope="col">Fecha</th>
      <th scope="col">Cliente</th>
      <th scope="col">DNI</th>
      <th scope="col">Monto</th>
       <th scope="col">Cant Cuotas</th>
        <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>02/05/2020</td>
      <td>$40000</td>
      <td>20</td>
        <td>Activo</td>
      <td>$2000</td>
      <td><a>Ver Pagos</a></td>
    </tr>
    <tr>
     <td>05/01/2019</td>
      <td>$5000</td>
      <td>10</td>
       <td class="text-success">Pagado</td>
      <td>$500</td>
      <td><a>Ver Pagos</a></td>
    </tr>
    <tr>
  <td>02/02/2019</td>
      <td>$120000</td>
      <td>30</td>
       <td class="text-danger">Rechazado</td>
      <td>-</td>
      <td><a>-</a></td>
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
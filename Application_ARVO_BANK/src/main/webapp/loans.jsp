<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<title>ARVO Bank - Cuentas</title>
<script src="Resources/js/custom.js"></script>
</head>
<body>
<jsp:include page="masterMenuClient.jsp"></jsp:include>

<div class="container-fluid mt-3">
<div class="row">
 <div class="col">
   <div class="list-group">
  
  <a href="" class="list-group-item list-group-item-action" data-launch-view="pageNewLoan"><i class="material-icons">local_atm</i>  Solicitar Préstamo</a>
  <a href="" class="list-group-item list-group-item-action" data-launch-view="pageMyLoans"><i class="material-icons">payments</i>  Ver Préstamos</a>
</div>
    </div>
    
    
    <div class="col-6">
     
          <div id="Views">

    <div class="view hide" id="pageMyLoans">
             <h4 class="text-blue mb-3">Mis préstamos</h4>
             <table class="table table-hover">
  <thead>
    <tr class="table-warning">
      c      <th scope="col">Fecha</th>
      <th scope="col">Monto Total</th>
      <th scope="col">Cant Cuotas</th>
       <th scope="col">Monto Cuota</th>
        <th scope="col">Pagos</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>02/05/2020</td>
      <td>$40000</td>
      <td>20</td>
      <td>$2000</td>
      <td><a>Ver Pagos</a></td>
    </tr>
    <tr>
     <td>05/01/2019</td>
      <td>$5000</td>
      <td>10</td>
      <td>$500</td>
      <td><a>Ver Pagos</a></td>
    </tr>
    <tr>
  <td>02/02/2019</td>
      <td>$12000</td>
      <td>6</td>
      <td>$2000</td>
      <td><a>Ver Pagos</a></td>
    </tr>
  </tbody>
</table>
             
        </div>
        
    <div class="view hide" id="pageNewLoan">
            <h4 class="text-blue">Solicitar Préstamo</h4>
        </div>


    <div class="view hide" id="page3">
           <!-- Por si hay que hacer una pag de pagos -->>
        </div>

    </div>

        
  
    </div>
   
    
    <div class="col">
      <!-- Columna vacía derecha -->
    </div>
    </div>
</div>


</body>
</html>
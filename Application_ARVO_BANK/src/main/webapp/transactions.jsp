<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<title>ARVO Bank - Transferencias</title>
</head>
<body>
<jsp:include page="masterMenuClient.jsp"></jsp:include>

<div class="container-fluid mt-3">
<div class="row">
 <div class="col">
   <!-- Columna vacía izquierda--> 
    </div>
    <div class="col-8">
      <h4 class="text-blue">Resumen de Movimientos</h4>
   
   <!-- Datos cuenta -->
   <table class="my-4">
   <tr>
   <td><span class="text-blue font-weight-bold">Cuenta:</span> Cuenta Corriente en Pesos</td>
   <td class="ml-4"><span class="text-blue font-weight-bold">    CBU:</span> 3000000000</td>
   </tr>
   </table>
   
   <!-- Resumen Movimientos -->   
 <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Fecha</th>
      <th scope="col">Concepto</th>
      <th scope="col">Monto</th>
      <th scope="col">Saldo</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>04/06/2020</td>
      <td>PAGO CTA 2/20 PRÉSTAMO</td>
      <td>-$2000</td>
      <td>$20000</td>
    </tr>
    <tr>
      <td>02/06/2020</td>
      <td>RECIB. TRANSF CJA AHORRO</td>
      <td>$10000</td>
      <td>$22000</td>
    </tr>
    <tr>
      <td>28/05/2020</td>
      <td>TRANSF. A 3ROS CBU 2020202020</td>
      <td>-$2500</td>
      <td>$12000</td>
    </tr>
    <tr>
      <td>24/05/2020</td>
      <td>ACRED. SALDO</td>
      <td>$14500</td>
      <td>$14500</td>
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
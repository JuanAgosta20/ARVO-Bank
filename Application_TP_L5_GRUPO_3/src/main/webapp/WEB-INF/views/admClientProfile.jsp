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
<title>ARVO Bank - Perfil Cliente</title>
</head>
<body>
<jsp:include page="masterMenuAdmin.jsp"></jsp:include>

<div class="container-fluid mt-3">
<div class="row">
 <div class="col">
   <!-- Columna vacía izquierda--> 
    </div>
    <div  class="col-10">
      <h4 class="text-blue mb-4 ml-4">  Perfil Cliente</h4>
     
     <div class="container">
     <div class="row">
     <div class="col-4"> 
     
    <table id="tbUserProfile" style="width:100%">
   <tr>
        <td colspan="2" class="text-center"><img id="userAvatar" alt="userAvatar" src="Resources/images/user.png"></td>
  </tr>
  <tr>
        <td colspan="2" class="text-center"><h4>Díaz Jorge</h4></td>
  </tr>
  <tr class="mb-3">
    <td class="text-right">
   <button name="btnDelete" type="button" class="btn btn-danger">Eliminar</button></td> 
   <td class="text-center"><button name="btnModify" type="button" class="btn btn-success">Modificar</button>
   </td>
  </tr>
  <tr><td>  </td></tr>
  
   <tr>
   
    <td><b>DNI:</b></td>
     <td><input type="text" style="width: 100px;"></input></td>
    </tr> 
    <tr>
     <tr> 
   <td> <b>Género:</b> </td>
    <td><input type="text" style="width: 100px;"></input></td>
    </tr> 
    <td><b>Email:</b></td>
    <td><input type="text" style="width: 100px;"></input></td>
    </tr>
      <tr>
    <td><b>Fecha Nac:</b></td>
    <td><input type="text" style="width: 100px;"></input></td> 
    </tr> 
    <tr>
    <td><b>Nacionalidad:</b></td>
    <td><input type="text" style="width: 100px;"></input></td>
    </tr> 
     <tr>
    <td><b>Provincia:</b></td>
    <td><input type="text" style="width: 100px;"></input></td> 
    </tr> 
     <tr>
    <td><b>Ciudad:</b></td>
    <td><input type="text" style="width: 100px;"></input></td>
    </tr> 
</table> 
     
     </div>
     
     <div class="col">
      <nav >
  <div class="nav nav-tabs" id="nav-tab" role="tablist">
    <a class="nav-item nav-link active" id="nav-accounts-tab" data-toggle="tab" href="#nav-accounts" role="tab" aria-controls="nav-accounts" aria-selected="true">Cuentas</a>
    <a class="nav-item nav-link" id="nav-loans-tab" data-toggle="tab" href="#nav-loans" role="tab" aria-controls="nav-loans" aria-selected="false">Préstamos</a>
   
  </div>
</nav>
<div class="tab-content" id="nav-tabContent">

<!-- Lista Cuentas -->

  <div class="tab-pane fade show active" id="nav-accounts" role="tabpanel" aria-labelledby="nav-accounts-tab">
  <table class="table">
  <thead class="thead-light">
    <tr>
    <th scope="col">F. Creación</th>
      <th scope="col">CBU</th>
      <th scope="col">Nombre</th>
      <th scope="col">Tipo</th>
      <th scope="col">Monto</th>
      <th scope="col">Estado</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>10/10/2010</td>
      <td>3000000000</td>
      <td>CtaCte</td>
      <td>Cuenta Corriente</td>
      <td>$20000</td>
      <td>Activa</td>
      <td><button class="btn btn-danger">Baja</button></td>
    </tr>
    <tr>
      <td>08/08/2008</td>
      <td>4000000000</td>
      <td>CjaAho</td>
      <td>Caja Ahorro en $</td>
      <td>$30000</td>
      <td>Activa</td>
      <td><button class="btn btn-danger">Baja</button></td>
    </tr>
    <tr>
      <td>08/08/2008</td>
      <td>5000000000</td>
      <td>CjaAhoUS</td>
      <td>Caja Ahorro en US$</td>
      <td>USD 500</td>
      <td>Activa</td>
      <td><button class="btn btn-danger">Baja</button></td>
    </tr>
  </tbody>
</table>
  
  </div>
  
  <!-- Lista Préstamos -->
  <div class="tab-pane fade" id="nav-loans" role="tabpanel" aria-labelledby="nav-loans-tab">
 <table class="table">
  <thead class="thead-light">
    <tr class="table-warning">
        <th scope="col">Fecha</th>
      <th scope="col">Monto Total</th>
      <th scope="col">Cant Cuotas</th>
      <th scope="col">Estado</th>
       <th scope="col">Monto Cuota</th>
        <th scope="col">Pagos</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>02/05/2020</td>
      <td>$40000</td>
      <td>20</td>
        <td>Activo</td>
      <td>$2000</td>
      <td><a>2/20</a></td>
    </tr>
    <tr>
     <td>05/01/2019</td>
      <td>$5000</td>
      <td>10</td>
       <td class="text-success">Pagado</td>
      <td>$500</td>
      <td><a>10/10</a></td>
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
 <!-- Fin Lista Préstamos -->
</div>
 </div>
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
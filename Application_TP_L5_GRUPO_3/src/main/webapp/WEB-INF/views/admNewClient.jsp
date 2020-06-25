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
<title>ARVO Bank - Clientes</title>
</head>
<body>
<jsp:include page="masterMenuAdmin.jsp"></jsp:include>

<div class="container-fluid mt-3">
<div class="row">
 <div class="col-3">
   <div class="list-group">

   <a href="admClients.jsp" class="list-group-item list-group-item-action"><i class="material-icons">supervisor_account</i> Lista Clientes</a>
</div>
    </div>
    
    
    <div class="col-5">
      <h4 class="text-blue">   Nuevo Cliente</h4>
      
       <!-- Form nuevo Cliente --> 
         
      <form class="container mt-3" action="">
      <div class="row">
      <div class="col">
      Nombre/s:</div>
         <div class="col">
       <input type="text" name="txtName" class="form-control"></div>
     </div>
      <div class="row mt-2">
      <div class="col">
      Apellido/s:</div>
         <div class="col">
       <input type="text" name="txtLastName" class="form-control"></div>
     </div>
   
      
  <div class="row mt-2">
    <div class="col">
    Género: 
    </div>
    <div class="col">
        <select id="inputAccType" name="cmbGender" class="form-control">
        <option selected>Seleccione género</option>
        <option>Femenino</option>
        <option>Masculino</option>
      </select>
    </div>
    </div>
        <div class="row mt-2">
      <div class="col">
      DNI:</div>
         <div class="col">
       <input type="number" name="txtDNI" class="form-control"></div>
     </div>
         <div class="row mt-2">
      <div class="col">
     Fecha de Nacimiento:</div>
         <div class="col">
       <input type="date" name="txtBirthDate" class="form-control"></div>
     </div>
     <div class="row mt-2">
      <div class="col">
      Email: </div>
         <div class="col">
       <input type="email" name="txtEmail" class="form-control"></div>
     </div>
  <div class="row mt-2">
      <div class="col">
     Nacionalidad: </div>
         <div class="col">
       <select id="country" name="cmbProvinces" class="form-control">
        <option selected>Seleccione Pais</option>
        <option>Argentina</option>
        <option>Uruguay</option>
        </select>
     </div>
         
  <div class="row mt-2">
    <div class="col">
    Provincia: 
    </div>
    <div class="col">
        <select id="inputAccType" name="cmbProvinces" class="form-control">
        <option selected>Seleccione Provincia</option>
        <option>Buenos Aires</option>
        <option>Chaco</option>
      </select>
    </div>
    </div>
      <div class="row mt-2">
      <div class="col">
      Ciudad: </div>
         <div class="col">
               <select id="city" name="cmbProvinces" class="form-control">
        <option selected>Seleccione ciudad</option>
        <option>Tigre</option>
        <option>San Fernando</option>
      </select>
     </div>
       <div class="row mt-4 justify-content-md-center">
        
      <div class="col-6 align-self-end">
      <input type="submit" class="btn btn-orange" name="btnConfirm" value="Confirmar">
      </div>
      </div>
       
      </form>
 
    </div>
    
    
    <div class="col">
     <!-- Columna vacía derecha --> 
    </div>
    </div>
</div>

</body>
</html>
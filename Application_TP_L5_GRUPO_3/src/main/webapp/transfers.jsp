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
    <div class="col-6">
      <h4 class="text-blue">Nueva Transferencia</h4>
      
         <!-- Form nueva transaccion  --> 
         
      <form class="container mt-3" action="">
  <div class="row">
    <div class="col">
    Cuenta de Origen: 
    </div>
    <div class="col">
        <select id="inputAccType" name="cmbAccount" class="form-control">
        <option selected>Seleccione la cuenta</option>
        <option>...</option>
      </select>
    </div>
    </div>
     <div class="row mt-3">
      <div class="col">
      Monto a transferir: </div>
         <div class="col">
       <input type="text" name="txtAmmount" class="form-control" placeholder="$"></div>
     </div>
  <div class="row mt-3">
      <div class="col">
      CBU Cuenta Destino: </div>
         <div class="col">
       <input type="number" name="txtCBU" class="form-control"></div>
     </div>
      <div class="row mt-3">
      <div class="col">
      Concepto: </div>
         <div class="col">
       <input type="text" name="txtConcept" class="form-control"></div>
     </div>
       <div class="row mt-4 justify-content-md-center">
        
      <div class="col-6 align-self-end">
      <input type="submit" class="btn btn-orange" name="btnConfirmar" value="Confirmar">
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
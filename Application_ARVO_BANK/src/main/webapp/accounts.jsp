<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<title>ARVO Bank - Cuentas</title>
</head>
<body>
<jsp:include page="masterMenuClient.jsp"></jsp:include>

<div class="container-fluid mt-3">
<div class="row">
 <div class="col">
   <div class="list-group">
   <a class="list-group-item list-group-item-action" data-toggle="modal" href="#modalNewAccount">  <i class="material-icons">work_outline</i> Solicitar una cuenta</a>
  <a href="transfers.jsp" class="list-group-item list-group-item-action"><i class="material-icons">compare_arrows</i> Realizar Transferencia</a>
  <a href="#" class="list-group-item list-group-item-action"><i class="material-icons">local_atm</i>  Solicitar Préstamo</a>
  <a href="#" class="list-group-item list-group-item-action"><i class="material-icons">payment</i>  Pagos</a>
</div>
    </div>
    
    <!-- Lista cuentas -->
    <div class="col-6">
      <div class="row card">
  <h6 class="card-header">Cuenta Corriente</h6>
  <div class="card-body">
  
      <div class="container">
      
      <div class="row"><h6 class="card-title">Nombre de la cuenta: </h6></div>
  <div class="row align-items-center">
    <div class="col">
     <b>CBU: </b>3000000000
    </div>
    <div class="col">
    <b>Monto: </b>$2000
    </div>
    <div class="col">
     <button type="button" class="btn btn-success mb-3">Ver Movimientos</button>
    </div>
  </div>
</div>

   
  </div>
</div>
      <div class="row card mt-2">
  <h6 class="card-header">Caja de Ahorro</h6>
  <div class="card-body">
  
      <div class="container">
      
      <div class="row"><h6 class="card-title">Nombre de la cuenta: </h6></div>
  <div class="row align-items-center">
    <div class="col">
     <b>CBU: </b>4000000000
    </div>
    <div class="col">
    <b>Monto: </b>$30000
    </div>
    <div class="col">
     <button type="button" class="btn btn-success mb-3">Ver Movimientos</button>
    </div>
  </div>
</div>
   
  </div>
</div>

<div class="row card mt-2">
  <h6 class="card-header">Caja de Ahorro en US$</h6>
  <div class="card-body">
  
      <div class="container">
      
      <div class="row"><h6 class="card-title">Nombre de la cuenta: </h6></div>
  <div class="row align-items-center">
    <div class="col">
     <b>CBU: </b>5000000000
    </div>
    <div class="col">
    <b>Monto: </b>USD 500
    </div>
    <div class="col">
     <button type="button" class="btn btn-success mb-3">Ver Movimientos</button>
    </div>
  </div>
</div>
   
  </div>
</div>
    </div>
    <!-- Fin lista cuentas -->
    
    <!-- Modal Solicitar cuenta -->
    <div class="modal fade" id="modalNewAccount" tabindex="-1" role="dialog" aria-labelledby="modalNewAccount" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title text-blue" id="modalTitle">Solicitar Cuenta</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
    <div class="row my-3">
     <div class="col">Seleccione el tipo de cuenta: </div>
     <div class="col">
    <select name="cmbAccounts" id="cmbAccounts">
    <option value="">Cuenta Corriente especial</option>
   
</select>
     </div>
    </div>
   
      </div>
      <div class="modal-footer">
      <button type="button" class="btn bkg-orange text-light" name="btnNewAccount">Enviar solicitud</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal" name="btnCancel">Cancelar</button>
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
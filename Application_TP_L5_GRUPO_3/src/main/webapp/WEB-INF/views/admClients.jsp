<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<title>ARVO Bank - Clientes</title>

</head>
<body>
<jsp:include page="masterMenuAdmin.jsp"></jsp:include>

<div class="container-fluid mt-3">
<h4 class="text-blue">Clientes</h4>
<div class="row my-3 justify-content-between">
<div class="col">
<form class="form-inline">
 <label class="my-1 mr-2" for="inlineFormInputName2">Buscar: </label>
  <input type="text" class="form-control my-1 mr-sm-2" id="inlineFormInputName2" placeholder="DNI/Apellido">
  <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Filtrar:  </label>
  <select class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
    <option selected>Apellido</option>
    <option value="1">Estado</option>
    <option value="2">Otra</option>
    
  </select>


  <button type="submit" class="btn btn-info my-1"><i class="material-icons">search</i></button>
</form>
</div>  

<div class="col-auto">
<a class="btn btn-info" href="admNewClient.jsp" role="button"><i class="material-icons">account_circle</i> Nuevo Cliente</a>
</div>  
</div>


<div class="row">
  
   
    <div class="col m-auto">
      
      <!--Table-->
        
<table id="tbClients" class="table table-hover table-striped ">

  <thead>
    <tr>
      <th>Apellido/s</th>
      <th>Nombre/s</th>
      <th>DNI</th>
      <th>F.Nac</th>
      <th>Género</th>
      <th>Email</th>
      <th>Nacionalidad</th>
      <th>Provincia</th>
      <th>Ciudad</th>
      <th>Estado</th>
      <th>Perfil</th>
      
    </tr>
  </thead>
 
  <tbody>
    <tr>
      <td>Díaz</td>
      <td>Jorge</td>
      <td>20000000</td>
      <td>04/04/1970</td>
      <td>M</td>
      <td>jorgediaz@arvomail.com</td>
      <td>Argentino</td>
      <td>Buenos Aires</td>
      <td>Tigre</td>
      <td>Activo</td>
      <td><a class="btn btn-success" href="admClientProfile.jsp" role="button">Ver</a></td>
          </tr>
      <tr>
      <td>Perez</td>
      <td>María</td>
      <td>25000000</td>
       <td>04/05/1975</td>
      <td>F</td>
      <td>perezmaria@arvomail.com</td>
      <td>Argentina</td>
      <td>Buenos Aires</td>
      <td>San Fernando</td>
      <td>Activo</td>
      <td><a class="btn btn-success" href="#" role="button">Ver</a></td>
          </tr>
            <tr>
      <td>Rodriguez</td>
      <td>Marcelo</td>
      <td>30000000</td>
      <td>04/05/1985</td>
      <td>M</td>
      <td>marcerodriguez@arvomail.com</td>
      <td>Argentino</td>
      <td>Buenos Aires</td>
      <td>San Isidro</td>
      <td>Activo</td>
      <td><a class="btn btn-success" href="#" role="button">Ver</a></td>
          </tr>
  </tbody>
  <!--Table body-->
</table>
<!--Table-->
 
    </div>
    
    
   
    </div>
</div>


</body>
</html>
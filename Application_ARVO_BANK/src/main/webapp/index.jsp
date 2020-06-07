<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<title>Iniciar Sesión</title>
</head>


<body class="city">

<div class="container">

<div class="row logo">
<img alt="logo" src="Resources/images/logo.png">
</div>

<form class="form-center px-4 py-5" id="frmLogin">

  <div class="form-row">
    
      <label class="font-weight-bold text-secondary">Usuario</label>
      <input type="email" class="form-control" id="txtUsername" required>
    
      </div>
  <div class="form-row">
    
      <label class="font-weight-bold text-secondary">Contraseña</label>
      <input type="password" class="form-control" id="txtPass" required>
    
    </div>
    <div class="form-row mt-3">
    
       <input type="submit" class="btn btn-primary btn-block font-weight-bold" type="submit" id="btnSubmit" value="Ingresar">
   
    </div>
  
  

</form>


</div>


</body>
</html>

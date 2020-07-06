<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="Include.html"%>
<title>Nueva Contraseña</title>
</head>
<body>
	<form class="form-center px-4 py-5" id="frmNewPass" action="clNewPass.do"
		method="Post">

		<div class="form-row">

			<label class="font-weight-bold text-secondary">Contraseña</label> <input
				type="password" class="form-control" id="pass" name="pass" onchange="checkPass()"
				required>

		</div>
		<div class="form-row">

			<label class="font-weight-bold text-secondary">Confirmar Contraseña</label> <input
				type="password" class="form-control" id="pass2" name="pass2" onchange="checkPass()"
				required>

		</div>
		<div class="form-row mt-3">

			<input type="submit"
				class="btn btn-primary btn-block font-weight-bold" type="submit"
				id="btnSubmit" value="Confirmar" disabled>
			<label id="check" style="display:none">Las constraseñas deben ser iguales.</label>

		</div>
		<input type="hidden" value="${user.user.idUser }" name="id">


	</form>
</body>
<script type="text/javascript">

function checkPass() {
	const pass1 = document.getElementById('pass').value;
	const pass2 = document.getElementById('pass2').value;
	const boton = document.getElementById('btnSubmit');
	const check = document.getElementById('check');
	
	if(pass1 === pass2){
		boton.disabled = false;
		check.style.display = 'none';
	}else{
		boton.disabled = true;
		check.style.display = 'inline-block';
	}
	
	
}
</script>
</html>
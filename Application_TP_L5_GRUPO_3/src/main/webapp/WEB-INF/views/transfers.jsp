<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--<jsp:include page="Include.html"></jsp:include>-->
<%@ include file="Include.html"%>
<script src="Resources/js/transferencias.js"></script>
</head>
<body>
	<jsp:include page="masterMenuClient.jsp"></jsp:include>

	<div class="container-fluid mt-3">
		<div class="row">
			<div class="col">
				<div class="list-group">
					<div class="text-center text-blue mb-2">
						<b>Transferencias</b>
					</div>
					<button class="list-group-item list-group-item-action" name="btnPanel" onClick="enableForm(this, 'T1')" style="color:white; background-color:#1761a0">
						<i class="material-icons mr-2">work_outline</i>Cuenta propia
					</button>
					<button class="list-group-item list-group-item-action" name="btnPanel" onClick="enableForm(this, 'T2')">
						<i class="material-icons mr-2">compare_arrows</i> Otras
					</button>
				</div>
			</div>
			<div class="col-6">
				<h4 class="text-blue mb-4">Nueva Transferencia</h4>

				<!-- Form nueva transaccion  -->

				<form class="container mt-3" action="" id="formT1">
					<div class="row">
						<div class="col">Cuenta origen:</div>
						<div class="col">
							<select id="inputAccType" name="cmbAccount" class="form-control">
								<option selected>Seleccione la cuenta</option>
								<option>...</option>
							</select>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col">Monto a transferir:</div>
						<div class="col">
							<input type="text" name="txtAmmount" class="form-control"
								placeholder="$">
						</div>
					</div>
					<div class="row mt-3">
						<div class="col">CBU Cuenta Destino:</div>
						<div class="col">
							<input type="number" name="txtCBU" class="form-control">
						</div>
					</div>
					<div class="row mt-3">
						<div class="col">Concepto:</div>
						<div class="col">
							<input type="text" name="txtConcept" class="form-control">
						</div>
					</div>
					<div class="row mt-4 justify-content-md-center">

						<div class="col-6 align-self-end">
							<input type="submit" class="btn btn-orange" name="btnConfirmar"
								value="Confirmar">
						</div>
					</div>

				</form>

				<!-- Form nueva transaccion  -->

				<form class="container mt-3" action="" id="formT2" style="display:none">
					<div class="row">
						<div class="col">Cuenta origen:</div>
						<div class="col">
							<select id="inputAccType" name="cmbAccount" class="form-control">
								<option selected>Seleccione la cuenta</option>
								<option>...</option>
							</select>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col">Cuenta destino:</div>
						<div class="col">
							<select id="inputAccType" name="cmbAccount" class="form-control">
								<option selected>Seleccione la cuenta</option>
								<option>...</option>
							</select>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col">Monto a transferir:</div>
						<div class="col">
							<input type="text" name="txtAmmount" class="form-control"
								placeholder="$">
						</div>
					</div>
					<div class="row mt-3">
						<div class="col">Concepto:</div>
						<div class="col">
							<input type="text" name="txtConcept" class="form-control">
						</div>
					</div>
					<div class="row mt-4 justify-content-md-center">

						<div class="col-6 align-self-end">
							<input type="submit" class="btn btn-orange" name="btnConfirmar"
								value="Confirmar">
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
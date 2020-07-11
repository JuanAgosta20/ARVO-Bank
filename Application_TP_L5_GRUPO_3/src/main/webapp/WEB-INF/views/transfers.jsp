<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.Model.Client"%>
<%@page import="com.Model.Transaction"%>
<%@page import="com.Model.Cmd"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	if (session.getAttribute("user") == null || !(session.getAttribute("user").getClass().equals(Client.class)))
	response.sendRedirect("redirectIndex.do");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="Include.html"%>
<script src="Resources/js/multiViewHandler.js"></script>
</head>
<body>
	<jsp:include page="masterMenuClient.jsp"></jsp:include>
<script src="Resources/js/transferForm.js"></script>
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

				<!-- Form nueva transaccion  A TERCEROS-->

				<form class="container mt-3" action="clRequesTransfer3.do"  method="POST" id="formT2" onsubmit=" return requestTransfer3()" style="display:none">
					<div class="row">
						<div class="col">Cuenta origen:</div>
						<div class="col">
							<select id="cmbAccountFrom1" name="cmbAccountFrom1" class="form-control">
								<c:forEach var="acc" items="${accounts }">
										<option value="${acc.getCBU()}">${acc.getTypeAcc().getDescription()}
												 - Saldo $: ${acc.getFunds()}</option>
										</c:forEach>
							</select>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col">CBU Cuenta Destino:</div>
						<div class="col">
							<input type="text" id="txtAccountTo" name="txtAccountTo" class="form-control" onchange="checkCBU()">
						</div>
					</div>
					<div class="row mt-3">
						<div class="col">Monto a transferir:</div>
						<div class="col">
							<input type="text"  id="txtAmmount1" name="txtAmmount1" class="form-control"
								placeholder="$">
						</div>
					</div>
					
					<div class="row mt-3">
						<div class="col">Concepto:</div>
						<div class="col">
							<input type="text" id="txtConcept1" name="txtConcept1" class="form-control">
						</div>
					</div>
					<div class="row mt-3 justify-content-md-center">
						<div id="alertForm1" class="alert alert-danger text-center col-6 hide">Alerta</div>
						
					</div>
					<div class="row mt-4 justify-content-md-center">

						<div class="col-6 align-self-end">
							<input type="submit" class="btn btn-orange" name="btnConfirmar1" id="btnConfimar1"
								value="Confirmar">
						</div>
					</div>

				</form>

				<!-- Form nueva transaccion  CUENTA PROPIA-->

				<form class="container mt-3" action="clRequesTransfer.do" method="POST" id="formT1" onsubmit=" return requestTransfer()">
					<div class="row">
						<div class="col">Cuenta origen:</div>
						<div class="col">
							<select id="cmbAccountFrom" name="cmbAccountFrom" class="form-control">
								
									<c:forEach var="acc" items="${accounts }">
											<option value="${acc.getCBU()}">${acc.getTypeAcc().getDescription()}
												 - Saldo $: ${acc.getFunds()}</option>
										
										</c:forEach>
							</select>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col">Cuenta destino:</div>
						<div class="col">
							<select id="cmbAccountTo" name="cmbAccountTo" class="form-control" required>
							<option value="">Seleccione la cuenta destino</option>
									<c:forEach var="acc" items="${accounts }">
											<option value="${acc.getCBU()}">${acc.getTypeAcc().getDescription()}
												 - Saldo $: ${acc.getFunds()}</option>
										</c:forEach>
							</select>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col">Monto a transferir:</div>
						<div class="col">
							<input type="number" id="txtAmmount" name="txtAmmount" class="form-control" 
								placeholder="$">
						</div>
					</div>
					<div class="row mt-3">
						<div class="col">Concepto:</div>
						<div class="col">
							<input type="text" id="txtConcept" name="txtConcept" class="form-control">
						</div>
					</div>
					<div class="row mt-3 justify-content-md-center">
						<div id="alertForm" class="alert alert-danger text-center col-6 hide">Alerta</div>
						
					</div>
					<div class="row mt-3 justify-content-md-center">

						<div class="col-6 align-self-end">
							<input type="submit" class="btn btn-orange" name="btnConfirmar" id="btnConfirmar"
								value="Confirmar">
						</div>
					</div>
					

				</form>

			</div>


			<div class="col">
				<div class="alert alert-primary mt-5 text-center" id="alert-cbu" style="display:none">
				</div>
			</div>
		</div>
	</div>

</body>
</html>
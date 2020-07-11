<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.Model.Account"%>
<%@page import="com.Model.typeAccount"%>
<%@page import="com.Model.Client"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	if (session.getAttribute("user") == null || !(session.getAttribute("user").getClass().equals(Client.class)))
		response.sendRedirect("redirectIndex.do");
%>

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
					<a class="list-group-item list-group-item-action"
						data-toggle="modal" href="#modalNewAccount"> <i
						class="material-icons">work_outline</i> Solicitar una cuenta
					</a> <a href="clTransfers.do"
						class="list-group-item list-group-item-action"><i
						class="material-icons">compare_arrows</i> Realizar Transferencia</a> 
						<a href="clLoans.do" class="list-group-item list-group-item-action"><i
						class="material-icons">payment</i> Pagos</a>
				</div>
			</div>

			<!-- Lista cuentas -->
			<div class="col-7">

				<c:forEach var="acc" items="${accounts}">

					<div class="row card mt-2">
						<h6 class="card-header">${acc.getTypeAcc().getDescription()}</h6>
						<div class="card-body">
							<div class="container">
								<div class="row">
									<h6 class="card-title">${acc.getNameAccount()}</h6>
								</div>
								<div class="row">
									<div class="col-5 mt-2">
										<b>CBU: </b> ${acc.getCBU()}
									</div>
									<div class="col mt-2">
										<b>Monto: $</b> ${acc.getFunds()}
									</div>
									<div class="col">
									<form action="clTransactions.do" method="POST">
									<input type="hidden" name="CBU" id="CBU" value="${acc.getCBU()}"/>
									<button class="btn btn-success mb-3">Ver Movimientos</button></form>
									
										
									</div>
								</div>
							</div>
						</div>
					</div>

				</c:forEach>

			</div>
			<!-- Fin lista cuentas -->

			<!-- Modal Solicitar cuenta -->
			<div class="modal fade" id="modalNewAccount" tabindex="-1"
				role="dialog" aria-labelledby="modalNewAccount" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title text-blue" id="modalTitle">Solicitar
								Cuenta</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<form action="clRequestAccount.do" method="POST">
							<div class="modal-body">
								<div class="row my-2">
									<div class="form-group text-center">
										<label for="cmbAccounts" class="m-1 ">Seleccione el
											tipo de cuenta: </label> <select name="cmbAccounts" id="cmbAccounts"
											class="m-1 p-1">
											<c:forEach var="atype" items="${ acccountTypes }">
												<option value="${atype.getIdTypeAccount()}">${atype.getDescription()}</option>
											</c:forEach>
										</select>
									</div>

								</div>
								<p class="font-weight-light mb-0 mt-3" style="font-size: 12px">
									Al completar los datos aquí requeridos y avanzar, realiza una
									solicitud a ARVO BANK S.A. La información proporcionada por el
									cliente reviste carácter de declaración jurada y el Banco podrá
									rechazar la solicitud de apertura.</p>
							</div>
							<div class="modal-footer">
								<button class="btn bkg-orange text-light btn-sm"
									name="btnNewAccount">Enviar solicitud</button>
								<button type="button" class="btn btn-secondary btn-sm"
									data-dismiss="modal" name="btnCancel">Cancelar</button>
							</div>
						</form>
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
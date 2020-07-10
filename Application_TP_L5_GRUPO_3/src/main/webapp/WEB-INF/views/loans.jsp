<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.Model.Client"%>
<%@page import="com.Model.Loan"%>
<%@page import="com.Model.FeePayment"%>
<%@page import="com.Model.Cmd"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	if (session.getAttribute("user") == null || !(session.getAttribute("user").getClass().equals(Client.class)))
	response.sendRedirect("redirectIndex.do");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<title>ARVO Bank - Préstamos</title>
<script src="Resources/js/multiViewHandler.js"></script>
<script src="Resources/js/loansHandler.js"></script>
<script src="Resources/js/ValidateLoanForm.js"></script>
</head>
<body>
	<jsp:include page="masterMenuClient.jsp"></jsp:include>

	<div class="container-fluid mt-3">
		<div class="row">
			<div class="col-3">
				<div class="list-group">
					<button class="list-group-item list-group-item-action"
						name="btnPanel" onClick="enableForm(this, 'T2')">
						<i class="material-icons">local_atm</i> Solicitar Préstamo
					</button>
					<button class="list-group-item list-group-item-action"
						name="btnPanel" onClick="enableForm(this, 'T1')"
						style="color: white; background-color: #1761a0">
						<i class="material-icons">payments</i> Ver Préstamos
					</button>
				</div>
			</div>

			<div class="col-8">
				<div id="Views">
					<!-- Tabla Prï¿½stamos -->
					<div class="view" id="formT1">
						<h4 class="text-blue mb-3">Mis préstamos</h4>
						<table class="table table-hover">
							<thead>
								<tr class="table-warning">
									<th scope="col">Fecha</th>
									<th scope="col">Monto Total</th>
									<th scope="col">Monto Cuota</th>
									<th scope="col">Cant Cuotas</th>
									<th scope="col">Estado</th>
									<th scope="col">Pagos</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="loan" items="${ loans }">
									<tr>
										<td>${Cmd.getFormattedDate(loan.getDate(), false)}</td>
										<td>$ ${loan.getAmmount()  }</td>
										<td>$ ${loan.getMonthAmmount()}</td>
										<td>${loan.getFees() }</td>
										<td>${ Cmd.getLoanNameState(loan.getState()) }</td>
										<td><c:if test="${ loan.getState() >= 2 }">
												<button
													onclick="showLoanPayments(this, '${loan.getLoanId()}')"
													class="btn btn-info btn-sm">Ver Pagos</button>
											</c:if></td>
									</tr>
									<c:if test="${ loan.getState() >= 2 }">
										<tr id="loanId${ loan.getLoanId() }" style="display: none">
											<td colspan="6">
												<table class="ml-1">
													<thead>
														<tr>
															<th scope="col">Cuota #</th>
															<th scope="col">Fecha</th>
															<th scope="col">Monto</th>
															<th scope="col">Estado</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="payment" items="${loan.getPayments() }">
															<tr>
																<td>${ payment.getnPayment() }</td>
																<td>${Cmd.getFormattedDate(payment.getDate(), false)}</td>
																<td>$ ${payment.getAmmount()}</td>
																<td><c:if test="${payment.getState() == 0 }">
																		<button
																			onclick="payment(${payment.getFeePaymentId()}, ${loan.getLoanId()})"
																			class="btn btn-sm btn-primary">Pagar</button>
																	</c:if> <c:if test="${payment.getState() == 1 }">
																		<button disabled class="btn btn-sm btn-success">Pago</button>
																	</c:if></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</td>
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<!-- Solicitar Prï¿½stamo -->

					<div class="view hide" id="formT2">
						<h4 class="text-blue">Solicitar Préstamo</h4>
						<form action="clRequestLoan.do" method="POST"
							class="container mt-3" onsubmit=" return requestLoanForm()">
							<div class="row mt-3">
								<div class="col-3">Monto deseado:</div>
								<div class="col-5">
									<input type="number" id="txtAmmount" name="txtAmmount"
										class="form-control" placeholder="$" />
								</div>
							</div>
							<div class="row mt-3">
								<div class="col-3">Cuenta Destino:</div>
								<div class="col-5">
									<select name="cmbAccount" id="cmbAccount" class="form-control">
										<c:forEach var="acc" items="${accounts }">
											<c:if test="${acc.getTypeAcc().getArs()}">
												<option value="${acc.getCBU()}" data-toggle="tooltip"
													title="${acc.getTypeAcc().getDescription()}">$
													${acc.getFunds()} - CBU: ${acc.getCBU()}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="row mt-3">
								<div class="col-3">Cantidad de cuotas:</div>
								<div class="col-5">
									<select name="cmbCuotas" class="form-control">
										<option value="3" selected>3</option>
										<option value="6">6</option>
										<option value="9">9</option>
										<option value="12">12</option>
										<option value="18">18</option>
										<option value="24">24</option>
										<option value="30">30</option>
									</select>
								</div>
							</div>
							<div class="row mt-4 justify-content-md-center">
								<div class="col-6 align-self-end">
									<input type="submit" class="btn btn-orange" name="btnSolicitar"
										value="Solicitar" />
								</div>
							</div>
							<div class="row mt-4">
								<div class="col-2"></div>
								<div id="alertForm" class="alert alert-danger col-6 hide"></div>

							</div>
						</form>
					</div>

					<div class="modal fade" id="modalPayments" tabindex="-1"
						role="dialog" aria-labelledby="modalPayments" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered modal-lg w-50"
							role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title text-blue" id="modalTitle">Pagar
										cuota</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<form action="clPayment.do" method="POST"
									onsubmit="return requestPaymentForm()">
									<div class="modal-body p-0">
										<div class="row my-3 ml-4">
											<div class="form-group text-center">
												<label for="cmbAccounts" class="m-1 ">Seleccione la
													cuenta: </label> <select name="cmbAccPayment" id="cmbAccPayment"
													class="m-1 p-1">
													<c:forEach var="acc" items="${accounts }">
														<c:if test="${acc.getTypeAcc().getArs()}">
															<option value="${acc.getCBU()}" data-toggle="tooltip"
																title="${acc.getTypeAcc().getDescription()}">$
																${acc.getFunds()} - CBU: ${acc.getCBU()}</option>
														</c:if>
													</c:forEach>
												</select>
											</div>
										</div>
										<input type="hidden" name="FeePayment" id="idFeePayment" /> <input
											type="hidden" name="Loan" id="idLoan" />
										<div class="row mt-1">
											<div class="ml-auto mr-auto mb-0 alert alert-danger hide"
												id="alertPayment"></div>
										</div>
									</div>
									<div class="modal-footer">
										<button class="btn bkg-orange text-light btn-sm"
											name="btnNewAccount">Pagar</button>
										<button type="button" class="btn btn-secondary btn-sm"
											data-dismiss="modal" name="btnCancel">Cancelar</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<script type="text/javascript">
	$('#modalPayments').on('hidden.bs.modal', function() {
		let alert = $("#alertPayment")[0];
		alert.style.display = "none";
	});
	</script>
</body>
</html>

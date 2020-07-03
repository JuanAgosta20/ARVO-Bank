<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.Model.Client"%>
<%
	if (session.getAttribute("user") == null || !(session.getAttribute("user").getClass().equals(Client.class)))
	response.sendRedirect("redirectIndex.do");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<title>ARVO Bank - Préstamos</title>
<script src="Resources/js/custom.js"></script>
<script src="Resources/js/loansHandler.js"></script>
</head>
<body>
	<jsp:include page="masterMenuClient.jsp"></jsp:include>

	<div class="container-fluid mt-3">
		<div class="row">
			<div class="col">
				<div class="list-group">
					<a href="" class="list-group-item list-group-item-action"
						data-launch-view="pageNewLoan"><i class="material-icons">local_atm</i>
						Solicitar Préstamo</a> <a href=""
						class="list-group-item list-group-item-action"
						data-launch-view="pageMyLoans"><i class="material-icons">payments</i>
						Ver Préstamos</a>
				</div>
			</div>

			<div class="col-7">
				<div id="Views">
					<!-- Tabla Prï¿½stamos -->
					<div class="view hide" id="pageMyLoans">
						<h4 class="text-blue mb-3">Mis préstamos</h4>
						<table class="table table-hover">
							<thead>
								<tr class="table-warning">
									<th scope="col">Fecha</th>
									<th scope="col">Monto Total</th>
									<th scope="col">Cant Cuotas</th>
									<th scope="col">Estado</th>
									<th scope="col">Monto Cuota</th>
									<th scope="col">Pagos</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>02/05/2020</td>
									<td>$40000</td>
									<td>20</td>
									<td>Activo</td>
									<td>$2000</td>
									<td>
										<button onclick="showLoanPayments(this, 1)"
											class="btn btn-info btn-sm">Ver Pagos</button>
									</td>
								</tr>
								<tr id="loanId1" style="display: none">
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
												<tr>
													<td>1</td>
													<td>02/05/2020</td>
													<td>$2000</td>
													<td class="text-success">Pagado</td>
												</tr>
												<tr>
													<td>2</td>
													<td>02/06/2020</td>
													<td>$2000</td>
													<td><button onclick="payment()"
															class="btn btn-sm btn-primary">Pagar</button></td>
												</tr>
												<tr>
													<td>2</td>
													<td>02/07/2020</td>
													<td>$2000</td>
													<td><button onclick="payment()"
															class="btn btn-sm btn-primary">Pagar</button></td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td>05/01/2019</td>
									<td>$5000</td>
									<td>10</td>
									<td class="text-success">Pagado</td>
									<td>$500</td>
									<td>
										<button class="btn btn-info btn-sm">Ver Pagos</button>
									</td>
								</tr>
								<tr>
									<td>02/02/2019</td>
									<td>$120000</td>
									<td>30</td>
									<td class="text-danger">Rechazado</td>
									<td>-</td>
									<td><a>-</a></td>
								</tr>
							</tbody>
						</table>
					</div>

					<!-- Solicitar Prï¿½stamo -->

					<div class="view hide" id="pageNewLoan">
						<h4 class="text-blue">Solicitar Préstamo</h4>
						<form action="" name="frmNewLoan" class="container mt-3">
							<div class="row mt-3">
								<div class="col">Monto deseado:</div>
								<div class="col">
									<input type="number" name="txtAmmount" class="form-control"
										placeholder="$" />
								</div>
							</div>
							<div class="row mt-3">
								<div class="col">Cuenta Destino:</div>
								<div class="col">
									<select id="inputAccType" name="cmbAccount"
										class="form-control">
										<option selected>Seleccione la cuenta</option>
										<option>...</option>
									</select>
								</div>
							</div>
							<div class="row mt-3">
								<div class="col">Cantidad de cuotas:</div>
								<div class="col">
									<input type="number" name="txtConcept" class="form-control" />
								</div>
							</div>
							<div class="row mt-4 justify-content-md-center">
								<div class="col-6 align-self-end">
									<input type="submit" class="btn btn-orange" name="btnSolicitar"
										value="Solicitar" />
								</div>
							</div>
						</form>
					</div>

					<div class="view hide" id="page3">
						<!-- Por si hay que hacer una pag de pagos -->
					</div>

					<div class="modal fade" id="modalPayments" tabindex="-1"
						role="dialog" aria-labelledby="modalPayments" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title text-blue" id="modalTitle">Pagar
										cuota</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<div class="row my-3">
										<div class="col">Seleccione la cuenta:</div>
										<div class="col">
											<select name="cmbAccounts" id="cmbAccounts">
												<option value="">################</option>
												<option value="">################</option>
											</select>
										</div>
									</div>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn bkg-orange text-light btn-sm"
										name="btnNewAccount">Pagar</button>
									<button type="button" class="btn btn-secondary btn-sm"
										data-dismiss="modal" name="btnCancel">Cancelar</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col">
				<!-- Columna vacï¿½a derecha -->
			</div>
		</div>
	</div>
</body>
</html>

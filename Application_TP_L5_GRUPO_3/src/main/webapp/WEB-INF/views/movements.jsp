<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.Model.Client"%>
<%@page import="com.Model.Account"%>
<%@page import="com.Model.Transaction"%>
<%@page import="com.Model.typeMove"%>
<%@page import="com.Model.Loan"%>
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
<title>ARVO Bank - Movimientos de cuenta</title>
<script src="Resources/js/multiViewHandler.js"></script>

</head>
<body>
	<jsp:include page="masterMenuClient.jsp"></jsp:include>

	<div class="container-fluid mt-3">
		<div class="row">
			<div class="col-3">
				
			</div>

			<div class="col-8">
				<div id="Views">
					<!-- Tabla Movimientos -->
					<div class="view" id="formT1">
						<h4 class="text-blue mb-3">Movimientos Cuenta</h4>
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
												
											</td>
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
					</div>

					

				</div>
			</div>

		</div>
	</div>
	
</body>
</html>

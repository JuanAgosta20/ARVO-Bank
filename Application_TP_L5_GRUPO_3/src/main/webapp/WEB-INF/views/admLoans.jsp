<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.Model.Administrative"%>
<%@page import="com.Model.Client"%>
<%@page import="com.Model.Cmd"%>
<%@page import="com.Model.Loan"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	if (session.getAttribute("user") == null || !(session.getAttribute("user").getClass().equals(Administrative.class)))
	response.sendRedirect("redirectIndex.do");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<title>ARVO Bank - Préstamos</title>
</head>
<body>
	<jsp:include page="masterMenuAdmin.jsp"></jsp:include>

	<div class="container-fluid mt-3">
		<div class="row">
			<div class="col">
				<!-- Columna vacía izquierda-->
			</div>
			<div class="col-10">
				<h4 class="text-blue mb-3">Préstamos pendientes a autorización</h4>

				<table class="table table-hover">
					<thead>
						<tr class="table-info">
							<th scope="col">Fecha</th>
							<th scope="col">Nombre y Apellido</th>
							<th scope="col">DNI</th>
							<th scope="col">Monto</th>
							<th scope="col">Cuotas</th>
							<th scope="col">Perfil</th>
							<th scope="col">Acción</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="loan" items="${loans}">
							<tr>
								<td>${Cmd.getFormattedDate(loan.getDate(), false)}</td>
								<td>${loan.getClient().getFirstName()}
									${loan.getClient().getLastName()}</td>
								<td>${loan.getClient().getDni()}</td>
								<td>$ ${loan.getAmmount()  }</td>
								<td>${loan.getFees() }</td>
								<td><a class="btn btn-success btn-sm pl-3 pr-3"
									href="admClientProfile.do?id=${loan.getClient().getIdClient()}"
									role="button">Ver</a></td>
								<td class="row"><form method="POST"
										action="checkLoan.do">
										<button name="accept" value="${loan.getLoanId()}"
											class="btn btn-outline-success btn-sm ml-2">Aceptar</button>
									</form>
									<form method="POST" action="checkLoan.do">
										<button name="reject" value="${loan.getLoanId()}"
											class="btn btn-outline-danger btn-sm ml-2">Rechazar</button>
									</form></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>


			<div class="col">
				<!-- Columna vacía derecha -->
			</div>
		</div>
	</div>

</body>
</html>
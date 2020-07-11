
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.Model.Administrative"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC >

<%
	if (session.getAttribute("user") == null
			|| !(session.getAttribute("user").getClass().equals(Administrative.class)))
		response.sendRedirect("redirectIndex.do");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<script src="Resources/js/admClientsLib.js"></script>
<title>ARVO Bank - Clientes</title>
</head>

<body>
	<jsp:include page="masterMenuAdmin.jsp"></jsp:include>



	<div class="container-fluid mt-3 ml-0 pl-0">
		<form action="admClientsList.do?" method="POST">
				<h4 class="text-blue">Clientes</h4>
				<div class="row my-3 justify-content-between">
					<div class="col"></div>
	
					<div class="col-auto">
						<a class="btn btn-info" data-toggle="modal" href="#modalNewClient">
							<i class="material-icons">account_circle</i> Nuevo Cliente
						</a>
					</div>
				</div>

			<div class="container ml-0">
				<div class="row">
					<div class="col m-auto">

						<!--Table-->
						<table id="tbClients"
							class="table table-hover table-striped table-sm">

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
								<c:forEach var="client" items="${clients}">
									<tr class="pagination-item">
										<td>${client.lastName}</td>
										<td>${client.firstName}</td>
										<td>${client.dni}</td>
										<td>${client.getFormatedBirthDate()}</td>
										<td>${client.genre.description}</td>
										<td>${client.email}</td>
										<td>${client.nationality.name}</td>
										<td>${client.province.name}</td>
										<td>${client.city.name}</td>
										<td><c:choose>
												<c:when test="${client.state == 1}">
		  										Activo
											</c:when>
												<c:otherwise>
		  										Inactivo
											</c:otherwise>
											</c:choose></td>
										<td><a class="btn btn-success"
											href="admClientProfile.do?id=${client.idClient}"
											role="button">Ver</a></td>
									</tr>
								</c:forEach>
							</tbody>
							<!--Table body-->
						</table>
						<!--Table-->
					</div>
				</div>
			</div>
		</form>
	</div>

	<!-- Modal Nuevo Cliente -->
	<div class="modal fade" id="modalNewClient" tabindex="-1" role="dialog"
		aria-labelledby="modalNewClient" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-blue" id="modalTitle">Agregar
						cliente</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="admClients.do" method="POST">
					<div class="modal-body">
						<div class="row my-3">
							<div class="col">
								<div class="form-group">
									<label for="name">Nombre/s</label> <input class="form-control"
										type="text" id="name" name="name" required></input> <label
										for="lastname">Apellido/s</label> <input class="form-control"
										type="text" id="lastname" name="lastname" required></input> <label
										for="DNI">D.N.I</label> <input class="form-control"
										type="number" id="DNI" name="DNI" placeholder="ej: 40300423" onblur="checkDni();"
										required></input>
									<div class="alert alert-danger" id="baddni"
										style="display: none;">
										<p>Ese DNI ya está registrado</p>
									</div>
									<label for="birthdate">Fecha de nacimiento</label> <input
										class="form-control" type="date" id="birthdate"
										name="birthdate" required></input> <label for="mail">Email</label>
									<input onblur="checkEmail();" class="form-control" type="email"
										id="mail" name="mail" required></input>
									<div class="alert alert-danger" id="badmail"
										style="display: none;">
										<p>Ese email ya está registrado</p>
									</div>
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label for="genre">Género</label> <select class="form-control"
										id="genre" name="genre">
										<option value="1">Femenino</option>
										<option value="2">Masculino</option>
										<option value="3">Otros</option>
									</select> <label for="countries">Nacionalidad</label> <select
										class="form-control" id="countries" name="countries">
										<c:forEach var="country" items="${countries }">
											<option value="${country.idCountrie}">${country.name}</option>
										</c:forEach>
									</select> <label for="province">Provincia</label> <select
										onchange="getCities();" class="form-control" id="province"
										name="province">
										<c:forEach var="prov" items="${province }">
											<option value="${prov.idProvinceApi}">${prov.name}</option>
										</c:forEach>
									</select> <label for="cities">Domicilio</label> <select
										class="form-control" id="cities" name="cities"
										onChange="setName()" onLoad="setName()">
									</select> <label for="username">Nombre de usuario</label> <input
										onblur="checkUserName();" class="form-control" type="text"
										id="username" name="username" required></input>
									<div class="alert alert-danger" id="badusername"
										style="display: none;">
										<p>Ese usuario ya está registrado</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<input name="nameCity" id="nameCity" type="hidden" value="">
					<div class="modal-footer">
						<input type="submit" class="btn btn-info text-light btn-sm"
							name="btnNewClient" value="Agregar" id="agregar" disabled></input>
						<button type="button" class="btn btn-secondary btn-sm"
							data-dismiss="modal" name="btnCancel">Cancelar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!--  Fin modal nuevo cliente -->

</body>
</html>
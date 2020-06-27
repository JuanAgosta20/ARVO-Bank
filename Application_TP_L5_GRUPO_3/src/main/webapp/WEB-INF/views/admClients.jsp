
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.Model.Administrative"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	if (session.getAttribute("user") == null
			|| !(session.getAttribute("user").getClass().equals(Administrative.class)))
		response.sendRedirect("redirectIndex.do");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<title>ARVO Bank - Clientes</title>

</head>
<body>
	<jsp:include page="masterMenuAdmin.jsp"></jsp:include>

	<div class="container-fluid mt-3">
		<h4 class="text-blue">Clientes</h4>
		<div class="row my-3 justify-content-between">
			<div class="col">
				<form class="form-inline">
					<label class="my-1 mr-2" for="inlineFormInputName2">Buscar:
					</label> <input type="text" class="form-control my-1 mr-sm-2"
						id="inlineFormInputName2" placeholder="DNI/Apellido"> <label
						class="my-1 mr-2" for="inlineFormCustomSelectPref">Filtrar:
					</label> <select class="custom-select my-1 mr-sm-2"
						id="inlineFormCustomSelectPref">
						<option selected>Apellido</option>
						<option value="1">Estado</option>
						<option value="2">Otra</option>
					</select>
					<button type="submit" class="btn btn-info my-1">
						<i class="material-icons">search</i>
					</button>
				</form>
			</div>

			<div class="col-auto">
				<a class="btn btn-info"
					data-toggle="modal"
					href="#modalNewClient">
					<i class="material-icons" 
					>account_circle</i> Nuevo Cliente</a>
			</div>
		</div>


		<div class="row">


			<div class="col m-auto">

				<!--Table-->

				<table id="tbClients" class="table table-hover table-striped ">

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
							<tr>
								<td>${client.lastName}</td>
								<td>${client.firstName}</td>
								<td>${client.dni}</td>
								<td>${client.birthdate}</td>
								<td>${client.genre.description}</td>
								<td>${client.email}</td>
								<td>${client.nationality.name}</td>
								<td>${client.province.name}</td>
								<td>${client.city.name}</td>
								<td>
									<c:choose>
										<c:when test="${client.state == 1}">
	  										Activo
										</c:when>
										<c:otherwise>
	  										Inactivo
										</c:otherwise>
									</c:choose>
								</td>
								<td><a class="btn btn-success" href="admClientProfile.do"
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
	
	<!-- Modal Nuevo Cliente -->
	<div class="modal fade" id="modalNewClient" tabindex="-1"
				role="dialog" aria-labelledby="modalNewClient" aria-hidden="true">
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
						<form action="clRequestAccount.do" method="POST">
						<div class="modal-body">
							<div class="row my-3">
								<div class="col">
									<div class="form-group">
										<label for="name">Nombre/s</label>
										<input class="form-control" type="text" id="name"></input>
										<label for="lastname">Apellido/s</label>
										<input class="form-control" type="text" id="lastname"></input>
										<label for="DNI">D.N.I</label>
										<input class="form-control" type="text" id="DNI" placeholder="ej: 403004230"></input>
										<label for="birthdate">Fecha de nacimiento</label>
										<input class="form-control" type="date" id="birthdate"></input>
										<label for="genre">Género</label>
										<select class="form-control" id="genre" name="genre">
											<option value="1">Hombre</option>
											<option value="2">Mujer</option>
											<option value="3">Indefinido</option>
										</select>
										<label for="name">Nombre/s</label>
										<input class="form-control" type="" id="name"></input>
									</div>
								</div>
								<div class="col">
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-info text-light btn-sm"
								name="btnNewAccount">Agregar</button>
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
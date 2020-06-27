<%@page import="com.Model.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.Model.Administrative"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<%
	if (session.getAttribute("user") == null
			|| !(session.getAttribute("user").getClass().equals(Administrative.class)))
		response.sendRedirect("redirectIndex.do");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<script src="Resources/js/getCities.js"></script>
<title>ARVO Bank - Perfil Cliente</title>
</head>
<body>
	<jsp:include page="masterMenuAdmin.jsp"></jsp:include>

	<div class="container-fluid mt-3">
		<div class="row">
			<div class="col">
				<!-- Columna vacía izquierda-->
			</div>
			<div class="col-10">
				<h4 class="text-blue mb-4 ml-4">Perfil Cliente</h4>

				<div class="container">
					<div class="row">
						<div class="col-4">

							<table id="tbUserProfile" style="width: 100%">
								<tr>
									<td colspan="2" class="text-center"><img id="userAvatar"
										alt="userAvatar" src="Resources/images/user.png"></td>
								</tr>
								<tr>
									<td colspan="2" class="text-center"><h4>${client.firstName }
											${client.lastName}</h4></td>
								</tr>
								<tr class="mb-3">
									<td class="text-right">
										<button name="btnDelete" type="button" class="btn btn-danger">Eliminar</button>
									</td>
									<td class="text-center"><button name="btnModify"
											type="button" class="btn btn-success" onclick="Hide()">Modificar</button></td>
								</tr>
								<tr>
									<td></td>
								</tr>

								<tr>
									<td><b>DNI:</b></td>
									<td><label style="width: 100px;" id="lblDni">${client.dni}</label>
										<input value="${client.dni}" id="txtDni" type="text"
										style="display: none; width: 200px;"></input></td>
								</tr>
								<tr>
									<td><b>Género:</b></td>
									<td><label style="width: 100px;" id="lblGenre">${client.genre.description}</label>
										<select name="drpGenre" id="drpGenre"
										style="display: none; width: 200px;">
											<c:forEach var="genre" items="${genres}">
												<c:if test="${genre.idGenre.equals(client.genre.idGenre)}">
													<option selected value="${genre.idGenre}">
														${genre.description }</option>
												</c:if>
												<c:if
													test="${!(genre.idGenre.equals(client.genre.idGenre))}">
													<option value="${genre.idGenre }">
														${genre.description}</option>
												</c:if>
											</c:forEach>
									</select></td>
								</tr>
								<tr>
									<td><b>Email:</b></td>
									<td><label style="width: 100px;" id="lblEmail">${client.email}</label>
										<input value="${client.email}" id="txtEmail" type="email"
										style="display: none; width: 200px;"></input></td>
								</tr>
								<tr>
									<td><b>Fecha Nac:</b></td>
									<td><label style="width: 100px;" id="lblDate"><fmt:formatDate
												value="${client.birthdate }" pattern="dd-MM-yyyy" /></label> <input
										value="<fmt:formatDate value="${client.birthdate }" pattern = "yyyy-MM-dd"  />"
										id="txtDate" type="date" style="display: none; width: 200px;"></input></td>
								</tr>
								<tr>
									<td><b>Nacionalidad:</b></td>
									<td><label style="width: 100px;" id="lblCountry">${client.nationality.name}</label>
										<select name="drpCountry" id="drpCountry"
										style="display: none; width: 200px;">
											<c:forEach var="country" items="${countries}">
												<c:if
													test="${country.idCountrie.equals(client.nationality.idCountrie)}">
													<option selected value="${country.idCountrie}">
														${country.name }</option>
												</c:if>
												<c:if
													test="${!(country.idCountrie.equals(client.nationality.idCountrie))}">
													<option value="${country.idCountrie }">
														${country.name }</option>
												</c:if>
											</c:forEach>
									</select></td>
								</tr>
								<tr>
									<td><b>Provincia:</b></td>
									<td><label style="width: 100px;" id="lblProvince">${client.province.name}</label>
										<select name="drpProvince" id="drpProvince"
										style="display: none; width: 200px;" onchange="getCities()">
											<c:forEach var="p" items="${provinces}">
												<c:if
													test="${p.idProvinceApi.equals(client.province.idProvinceApi)}">
													<option selected value="${p.idProvinceApi }">
														${p.name }</option>
												</c:if>
												<c:if
													test="${!(p.idProvinceApi.equals(client.province.idProvinceApi))}">
													<option value="${p.idProvinceApi }">${p.name }</option>
												</c:if>
											</c:forEach>
									</select></td>
								</tr>
								<tr>
									<td><b>Ciudad:</b></td>
									<td><label style="width: 100px;" id="lblCity">${client.city.name}</label>
										<select name="drpCity" id="drpCity"
										style="display: none; width: 200px;">
											<option value="${client.city.name}">${client.city.name}</option>
									</select></td>
								</tr>
								<tr>
									<td class="text-center"><a
										href="http://localhost:8081/Application_TP_L5_GRUPO_3/admClientProfile.do?id=${client.idClient }"
										name="btnCancel" id="btnCancel" type="button"
										class="btn btn-secondary" style="display: none">Cancelar</a></td>
									<td class="text-center"><button name="btnConfirm"
											id="btnConfirm" type="button" class="btn btn-secondary "
											style="display: none">Confirmar</button></td>
								</tr>
							</table>

						</div>

						<div class="col">
							<nav>
								<div class="nav nav-tabs" id="nav-tab" role="tablist">
									<a class="nav-item nav-link active" id="nav-accounts-tab"
										data-toggle="tab" href="#nav-accounts" role="tab"
										aria-controls="nav-accounts" aria-selected="true">Cuentas</a>
									<a class="nav-item nav-link" id="nav-loans-tab"
										data-toggle="tab" href="#nav-loans" role="tab"
										aria-controls="nav-loans" aria-selected="false">Préstamos</a>

								</div>
							</nav>
							<div class="tab-content" id="nav-tabContent">

								<!-- Lista Cuentas -->

								<div class="tab-pane fade show active" id="nav-accounts"
									role="tabpanel" aria-labelledby="nav-accounts-tab">
									<table class="table">
										<thead class="thead-light">
											<tr>
												<th scope="col">F. Creación</th>
												<th scope="col">CBU</th>
												<th scope="col">Nombre</th>
												<th scope="col">Tipo</th>
												<th scope="col">Monto</th>
												<th scope="col">Estado</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>10/10/2010</td>
												<td>3000000000</td>
												<td>CtaCte</td>
												<td>Cuenta Corriente</td>
												<td>$20000</td>
												<td>Activa</td>
												<td><button class="btn btn-danger">Baja</button></td>
											</tr>
											<tr>
												<td>08/08/2008</td>
												<td>4000000000</td>
												<td>CjaAho</td>
												<td>Caja Ahorro en $</td>
												<td>$30000</td>
												<td>Activa</td>
												<td><button class="btn btn-danger">Baja</button></td>
											</tr>
											<tr>
												<td>08/08/2008</td>
												<td>5000000000</td>
												<td>CjaAhoUS</td>
												<td>Caja Ahorro en US$</td>
												<td>USD 500</td>
												<td>Activa</td>
												<td><button class="btn btn-danger">Baja</button></td>
											</tr>
										</tbody>
									</table>

								</div>

								<!-- Lista Préstamos -->
								<div class="tab-pane fade" id="nav-loans" role="tabpanel"
									aria-labelledby="nav-loans-tab">
									<table class="table">
										<thead class="thead-light">
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
												<td><a>2/20</a></td>
											</tr>
											<tr>
												<td>05/01/2019</td>
												<td>$5000</td>
												<td>10</td>
												<td class="text-success">Pagado</td>
												<td>$500</td>
												<td><a>10/10</a></td>
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
								<!-- Fin Lista Préstamos -->
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col">
				<!-- Columna vacía derecha -->
			</div>
		</div>
	</div>

</body>

<script type="text/javascript">
	function Hide() {

		document.getElementById('lblDni').style.display = 'none';
		document.getElementById('txtDni').style.display = 'inline-block';

		document.getElementById('lblGenre').style.display = 'none';
		document.getElementById('drpGenre').style.display = 'inline-block';

		document.getElementById('lblEmail').style.display = 'none';
		document.getElementById('txtEmail').style.display = 'inline-block';

		document.getElementById('lblDate').style.display = 'none';
		document.getElementById('txtDate').style.display = 'inline-block';

		document.getElementById('lblCountry').style.display = 'none';
		document.getElementById('drpCountry').style.display = 'inline-block';

		document.getElementById('lblProvince').style.display = 'none';
		document.getElementById('drpProvince').style.display = 'inline-block';

		document.getElementById('lblCity').style.display = 'none';
		document.getElementById('drpCity').style.display = 'inline-block';

		document.getElementById('btnCancel').style.display = 'inline-block';
		document.getElementById('btnConfirm').style.display = 'inline-block';
	}
</script>
</html>
<%@page import="com.Model.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.Model.Administrative"%>
<%@page import="com.Model.Account"%>
<%@page import="com.Model.typeAccount"%>
<%@page import="com.Model.Cmd"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<%
	if (session.getAttribute("user") == null || !(session.getAttribute("user").getClass().equals(Administrative.class)))
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
			<div class="col-12">
				<h4 class="text-blue mb-4 ml-4">Perfil Cliente</h4>
				<div class="container-fluid">
					<div class="row">
						<div class="col-4">
							<form action="admUpdateClient.do" method="post">
								<table id="tbUserProfile" style="width: 80%">
									<tr>
										<td colspan="2" class="text-center"><img id="userAvatar"
											alt="userAvatar" src="Resources/images/user.png"></td>
									</tr>
									<tr>
										<td colspan="2" class="text-center"><h4>${client.firstName }
												${client.lastName}</h4> <input type="hidden" name="txtIdClient"
											value="${client.idClient }"></input></td>
									</tr>
									<tr class="mb-3">
										<td class="text-right"><a
											href="admDeleteClient.do?idClient=${client.idClient}&idUser=${client.user.idUser}"
											class="btn btn-danger">Eliminar</a></td>
										<td class="text-center"><button name="btnModify"
												type="button" class="btn btn-success" onclick="Hide()">Modificar</button></td>
									</tr>
									<tr>
										<td></td>
									</tr>

									<tr>
										<td><b>DNI:</b></td>
										<td><label style="width: 100px;" id="lblDni">${client.dni}</label>
											<input value="${client.dni}" id="txtDni" name="txtDni"
											type="text" style="display: none; width: 200px;"
											onchange="ShowConfirm()" readonly></input></td>
									</tr>
									<tr>
										<td><b>Género:</b></td>
										<td><label style="width: 100px;" id="lblGenre">${client.genre.description}</label>
											<select name="drpGenre" id="drpGenre" name="drpGenre"
											onchange="ShowConfirm()" style="display: none; width: 200px;"
											required>
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
											<input value="${client.email}" id="txtEmail" name="txtEmail"
											type="email" style="display: none; width: 200px;"
											onchange="checkEmail()" required></input></td>
										<td><div class="alert alert-danger m-0 p-0"
												style="display: none; margin: 0px" id="badmail">&times</div></td>
									</tr>
									<tr>
										<td><b>Fecha Nac:</b></td>
										<td><label style="width: 100px;" id="lblDate"><fmt:formatDate
													value="${client.birthdate }" pattern="dd-MM-yyyy" /></label> <input
											value="<fmt:formatDate value="${client.birthdate }" pattern = "yyyy-MM-dd"/>"
											id="txtDate" name="txtDate" type="date"
											style="display: none; width: 200px;" onchange="ShowConfirm()"
											required></input></td>
									</tr>
									<tr>
										<td><b>Nacionalidad:</b></td>
										<td><label style="width: 100px;" id="lblCountry">${client.nationality.name}</label>
											<select name="drpCountry" id="drpCountry"
											onchange="ShowConfirm()" style="display: none; width: 200px;"
											required>
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
											style="display: none; width: 200px;"
											onchange="showCitiesandConfirm()" required>
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
											onchange="ShowConfirm(); changeTxt();"
											style="display: none; width: 200px;" required>
												<option value="${client.city.name}">${client.city.name}</option>
										</select> <input type="hidden" name="txtIdCity" id="txtIdCity"></input></td>
									</tr>
									<tr>
										<td><b>Nombre usuario:</b></td>
										<td><label style="width: 100px;" id="lblUser">${client.user.userName}</label>
											<input value="${client.user.userName}" id="txtUser"
											name="txtUser" type="text"
											style="display: none; width: 200px;" readonly></input></td>
									</tr>
									<tr>
										<td><b>Contraseña:</b></td>
										<td><label style="width: 100px;" id="lblPass">*******</label>
											<input value="${client.user.password}" id="txtPass"
											name="txtPass" type="password"
											style="display: none; width: 200px;" onchange="ShowConfirm()"
											required></input></td>
									</tr>
									<tr>
										<td class="text-center"><a
											href="admClientProfile.do?id=${client.idClient }"
											name="btnCancel" id="btnCancel" type="button"
											class="btn btn-secondary" style="display: none">Cancelar</a></td>
										<td class="text-center">
											<button name="btnConfirm" id="btnConfirm" type="submit"
												class="btn btn-secondary " style="display: none">Confirmar</button>
										</td>
									</tr>
								</table>
							</form>
						</div>


						<div class="col-8">
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
												<th scope="col">Fondos</th>
												<th scope="col">Acción</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="acc" items="${accounts}">
												<tr>
													<Form action="admDeleteAccount.do" method="POST">
														<input type="hidden" value="${acc.getIdAccount()}"
															name="idAccount"> <input type="hidden"
															value="${acc.getClient().getIdClient()}" name="idClient">
														<td>${Cmd.getFormattedDate(acc.getCreationDate(), false)}</td>
														<td>${ acc.getCBU() }</td>
														<td>${acc.getNameAccount()}</td>
														<td>${acc.getTypeAcc().getDescription()}</td>
														<td>${acc.getFunds()}</td>
														<td><button class="btn btn-danger btn-sm">Baja</button></td>
													</Form>
												</tr>
											</c:forEach>
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
												<th scope="col">Monto Cuota</th>
												<th scope="col">Estado</th>
												<th scope="col">Pagos</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="loan" items="${ loans }">
												<tr>
													<td>${Cmd.getFormattedDate(loan.getDate(), false)}</td>
													<td>$ ${loan.getAmmount()  }</td>
													<td>${loan.getFees() }</td>
													<td>$ ${loan.getMonthAmmount()}</td>
													<td>${ Cmd.getLoanNameState(loan.getState()) }</td>
													<td>${ Cmd.countPayments(loan.getPayments()) } / ${ loan.getPayments().size() }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<!-- Fin Lista Préstamos -->
							</div>
						</div>
					</div>
				</div>
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
		
		document.getElementById('lblPass').style.display = 'none';
		document.getElementById('txtPass').style.display = 'inline-block';
		
		document.getElementById('lblUser').style.display = 'none';
		document.getElementById('txtUser').style.display = 'inline-block';

		document.getElementById('btnCancel').style.display = 'inline-block';
		//document.getElementById('btnConfirm').style.display = 'inline-block';
	}

async function showCitiesandConfirm() {
	ShowConfirm();
	await getCities();
	changeTxt();
}
	
function ShowConfirm(){
	document.getElementById('btnConfirm').style.display = 'inline-block';
}

function changeTxt(){
	let cities = document.getElementById('drpCity');
	const name = cities.options[cities.selectedIndex].text;
	const txtName = document.getElementById('txtIdCity');
	txtName.value = name;
	console.log(name);
}

async function checkEmail(){
	let value = document.getElementById('txtEmail').value;
	console.log(value);
	
	if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(value))){
		document.getElementById('badmail').title = 'Ej: xxxx@xxxx.xxx'
		document.getElementById('badmail').style.display = 'block';
		return;
	}
	
	await fetch('checkEmail.do?mail=' + value ,
			{
				method:'GET'
			})
			.then(response => response.json())
			.then(data => {
				console.log(data.existe);
				existMail = data.existe;
			
				if(data.existe == true){
					document.getElementById('badmail').title = 'Ese email ya está registrado'
					document.getElementById('badmail').style.display = 'block';
					document.getElementById('btnConfirm').style.display = 'none';
				}else{
					document.getElementById('btnConfirm').style.display = 'inline-block';
					document.getElementById('badmail').style.display = 'none';
				}
	})
	
	
}
</script>
</html>
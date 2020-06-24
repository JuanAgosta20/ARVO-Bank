<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<title>ARVO Bank</title>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	String date = sdf.format(new Date());
%>

</head>

<body>

	<nav class="navbar navbar-light bg-light">
		<a> <img alt="logo" src="Resources/images/logo3.png">
		</a>


		<div class="dropdown align-middle">
			<div id="userMenu">


				<button class="btn dropdown-toggle" type="button" id="btnUser"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="material-icons">account_circle</i> 
						<span id="userName">${user.first_name} ${user.last_name}</span>
				</button>

				<div class="dropdown-menu" aria-labelledby="dropdownMenu2">
					<form>
						<button class="dropdown-item" type="submit" name="btnLogout">
							<span class="material-icons"> exit_to_app</span> Cerrar Sesión
						</button>
					</form>
				</div>
			</div>
		</div>

	</nav>



	<nav class="navbar navbar-expand-lg navbar-dark font-weight-bold"
		style="background-color: #1761a0;">

		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item"><a class="nav-link text-light"
					href="admClients.do">Clientes</a></li>
				<li class="nav-item"><a class="nav-link text-light"
					href="admAccounts.do">Cuentas</a></li>
				<li class="nav-item"><a class="nav-link text-light"
					href="admLoans.do">Préstamos</a></li>
				<li class="nav-item"><a class="nav-link text-light"
					href="admReports.do">Informes</a></li>
			</ul>
		</div>
		<div class="text-light font-weight-normal">
			<%=date%></div>
	</nav>


</body>
</html>
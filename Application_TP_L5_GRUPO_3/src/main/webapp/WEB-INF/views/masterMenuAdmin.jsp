<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="Resources/js/alert.js"></script>

<title>ARVO Bank</title>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	String date = sdf.format(new Date());
	
	// ALERTA
	String className = "";
	String display = "none";
	String msg = "";
	if(request.getAttribute("result") != null){
		display = "block";
		if((Boolean)request.getAttribute("result")){
			className="alert alert-success m-0";
			msg = (request.getAttribute("msg") != null) ? ((String[])request.getAttribute("msg"))[1] : "";
		}else{
			className="alert alert-danger m-0";
			msg = (request.getAttribute("msg") != null) ? ((String[])request.getAttribute("msg"))[0] : "";
		}
	}
%>

</head>

<body>

	<nav class="navbar navbar-light bg-light">
		<a> <img alt="logo" src="Resources/images/logo3.png">
		</a>

	<div class="<%= className %>" role="alert" id="alert" style="display: <%= display %>"><%= msg %></div>

		<div class="dropdown align-middle">
			<div id="userMenu">


				<button class="btn dropdown-toggle" type="button" id="btnUser"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="material-icons">account_circle</i> 
						<span id="userName">${user.first_name} ${user.last_name}</span>
				</button>

				<div class="dropdown-menu" aria-labelledby="dropdownMenu2">
					<form action="logout.do" method="Post">
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
					href="admClientsList.do">Clientes</a></li>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.Model.Administrative"%>
<%@page import="com.Model.Client"%>

<%
	if (session.getAttribute("user") != null){
		if ((session.getAttribute("user").getClass().equals(Administrative.class))){
				response.sendRedirect("admClients.do");
		}
	else if ((session.getAttribute("user").getClass().equals(Client.class))){
	response.sendRedirect("accounts");
		}
	}
%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--<jsp:include page="Include.html"></jsp:include>-->
<%@ include file="Include.html"%>
<title>Iniciar Sesión</title>
</head>


<body class="city">

	<div class="container">

		<div class="row logo">
			<img alt="logo" src="Resources/images/logo.png">
		</div>

		<form class="form-center px-4 py-5" id="frmLogin" action="login.do"
			method="Post">

			<div class="form-row">

				<label class="font-weight-bold text-secondary">Usuario</label> <input
					type="text" class="form-control" id="txtUsername"
					name="txtUsername" required>

			</div>
			<div class="form-row">

				<label class="font-weight-bold text-secondary">Contraseña</label> <input
					type="password" class="form-control" id="txtPass" name="txtPass"
					required>

			</div>
			<div class="form-row mt-3">

				<input type="submit"
					class="btn btn-primary btn-block font-weight-bold" type="submit"
					id="btnSubmit" value="Ingresar">

			</div>
			<br>
			<div class="text-center">
				<c:if test="${NoUser != null}">
					<span id="NoUser" class="text-danger border border-danger">
						${NoUser} </span>
				</c:if>
			</div>



		</form>


	</div>


</body>
</html>

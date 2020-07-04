<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.Model.Administrative"%>

<!DOCTYPE HTML>

<%
	if (session.getAttribute("user") == null
			|| !(session.getAttribute("user").getClass().equals(Administrative.class)))
		response.sendRedirect("redirectIndex.do");
%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<title>ARVO Bank - Reportes</title>
</head>
<body>
	<jsp:include page="masterMenuAdmin.jsp"></jsp:include>

	<div class="container-fluid mt-3" style="text-align: center">
		<h4 class="text-blue" style="height: 50px">Informes</h4>
		<div class="row">

			<div class="col-2">
				<!-- Columna vacía izquierda-->
				<select style="margin-top: 30px">
					<option>Seleccione una opción</option>
					<option>Cuotas abonadas por mes</option>
				</select> <br></br> <label label-for="desde">Desde: </label> <input
					id="desde" type="date"></input> <br></br> <label label-for="hasta">Hasta:
				</label> <input id="hasta" type="date"></input>
			</div>
			<div class="col-10">
				<canvas id="chartContainer" style="height: 370px; width: 100%;"></canvas>
			</div>
		</div>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>
<script src="Resources/js/Charts.js"></script>
<script>

</script>

</html>
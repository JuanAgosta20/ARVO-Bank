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
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>
<script src="Resources/js/Charts.js"></script>
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
				<!-- <select style="margin-top: 30px" >
					<option>Seleccione una opción</option>
					<option>Cuotas abonadas por mes</option>
				</select> -->
				<br></br> <label label-for="desde">Desde: </label></br> <input id="init"
					type="date" onchange="activarEnd()"></input> <br></br> <label
					label-for="hasta">Hasta:</label></br> <input id="end" type="date"
					disabled onchange="buscarDatos()"></input>
			</div>
			<div class="col-10">
				<canvas id="chartContainer" style="height: 370px; width: 100%;"></canvas>
			</div>
		</div>
	</div>

</body>

<script>
	function activarEnd() {
		let init = document.getElementById('init');
		let end = document.getElementById('end');
		end.disabled = false;
		let date = new Date(init.value);
		let year;
		if (!!date.valueOf()) {
			year = date.getFullYear();
			month = date.getMonth() + 1;
			day = date.getDate();
			//console.log(year+' '+month+' '+ day);
			if (month === 12 && day == 31) {
				year = year + 1;
				//console.log(year+'act');
			}
		}
		end.max = year + '-12-31';
		end.min = init.value;

	}
	
	
</script>

</html>
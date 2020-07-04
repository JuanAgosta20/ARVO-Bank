var ctx = document.getElementById('chartContainer').getContext('2d');
var myChart = new Chart(ctx, {
	type : 'line',
	data : {
		labels : [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
				'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre',
				'Diciembre' ],
		datasets : [ {
			label : '# de cuotas abonadas por mes',
			data : [ 12, 19, 3, 5, 2, 3, 30, 15, 9, 6, 8, 0 ],
			backgroundColor : [ 'rgba(255, 0, 0, 0.2)',
					'rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)',
					'rgba(75, 192, 192, 0.2)', 'rgba(153, 102, 255, 0.2)',
					'rgba(255, 159, 64, 0.2)' ],
			borderColor : [ 'rgba(255, 0, 0, 1)', 'rgba(54, 162, 235, 1)',
					'rgba(255, 0, 0, 1)', 'rgba(75, 192, 192, 1)',
					'rgba(153, 102, 255, 1)', 'rgba(255, 159, 64, 1)' ],
			borderWidth : 2
		} ]
	},
	options : {
		scales : {
			yAxes : [ {
				ticks : {
					beginAtZero : true
				}
			} ]
		}
	}
});

async function buscarDatos(){
	await fetch('getTransfers.do?init='+'end='+)
	.then(response => response.json())
	.then(data => {
			console.log(data);
			//actualizarChart(data);
		})
	})
}

function actualizarChart(datos){
	var ctx = document.getElementById('chartContainer').getContext('2d');
	var myChart = new Chart(ctx, {
		type : 'line',
		data : {
			labels : [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
					'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre',
					'Diciembre' ],
			datasets : [ {
				label : '# de cuotas abonadas por mes',
				data : [ datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7], datos[8], datos[9], datos[10], datos[11]],
				backgroundColor : [ 'rgba(255, 0, 0, 0.2)',
						'rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)',
						'rgba(75, 192, 192, 0.2)', 'rgba(153, 102, 255, 0.2)',
						'rgba(255, 159, 64, 0.2)' ],
				borderColor : [ 'rgba(255, 0, 0, 1)', 'rgba(54, 162, 235, 1)',
						'rgba(255, 0, 0, 1)', 'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)', 'rgba(255, 159, 64, 1)' ],
				borderWidth : 2
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
}

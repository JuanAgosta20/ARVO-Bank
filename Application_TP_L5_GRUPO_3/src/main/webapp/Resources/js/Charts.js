/*	var ctx = document.getElementById('chartContainer').getContext('2d');
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
	});*/

	
	async function buscarDatos(){
	let init = document.getElementById('init').value;
	let end = document.getElementById('end').value;
	let months = new Array();
	let quantity = new Array();;
	await fetch('getTransfers.do?init='+init+'&end='+end)
	.then(response => response.json())
	.then(data => {
			console.log(data);
			data.forEach(e =>{
				months.push(e[0]);
				quantity.push(e[1]);
			})
			//console.log(months);
			//console.log(quantity);
			actualizarChart(months, quantity);
		})
}


function actualizarChart(months, quantity){
	var ctx = document.getElementById('chartContainer').getContext('2d');
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : months,
			datasets : [ {
				label : '# de transacciones por mes.',
				data : quantity,
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
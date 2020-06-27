function getCities() {
		let selCities = document.getElementById('drpCity');
		const select = document.getElementById('drpProvince');
		console.log(select)
		const id = select.options[select.selectedIndex].value;
		console.log(id)
		fetch('https://apis.datos.gob.ar/georef/api/localidades?provincia='+id+'&campos=nombre&max=5000&orden=nombre')
		.then(response => response.json())
		.then(data => {
			console.log(data)
			data.localidades.forEach((e,i)=> {
				
				selCities.options[i]=(new Option(e.nombre,e.id))
			})
		})
		
		
	
}
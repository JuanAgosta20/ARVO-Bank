document.addEventListener("DOMContentLoaded",async  function(event) { 
  	let selCities = document.getElementById('drpCity');
	const id = selCities.options[selCities.selectedIndex].value;
	await getCities();
    for(let i=0;i < selCities.options.length;i++){
    	if(selCities.options[i].text === id){
			console.log(i);
			selCities.selectedIndex = i;
			break;
		}
	};
	
});

async function getCities() {
		let selCities = document.getElementById('drpCity');
		const select = document.getElementById('drpProvince');
		const id = select.options[select.selectedIndex].value;
		selCities.options.length = 0;
		await fetch('https://apis.datos.gob.ar/georef/api/localidades?provincia='+id+'&campos=nombre&max=5000&orden=nombre')
		.then(response => response.json())
		.then(data => {
			data.localidades.forEach((e,i)=> {
				
				selCities.options[i]=(new Option(e.nombre,e.id))
			})
		})
		
}
/**
 * 
 */
$(document).ready(function(){
		var table = $('#tbClients')
			.DataTable({
				"paging": "first_last_numbers"
			})
			
	});
	
	var existMail =true ,checkUser = true;
	function setName(){
		
		let dropCities = document.getElementById('cities');
		let nameCity = document.getElementById('nameCity');
		nameCity.value = dropCities.options[dropCities.selectedIndex].text;
		
	}
	
	function enableButton(){
		console.log('enableButton');
		if(!checkEmail && !checkUserName) document.getElementById('agregar').disabled = false;
	}
	
	getCities();
	async function getCities() {
			console.log('Dentro de get cities')
			let selCities = document.getElementById('cities');
			const select = document.getElementById('province');
			const id = select.options[select.selectedIndex].value;
			await fetch('https://apis.datos.gob.ar/georef/api/localidades?provincia='+id+'&campos=nombre&max=5000&orden=nombre')
			.then(response => response.json())
			.then(data => {
				console.log(data)
				data.localidades.forEach((e,i)=> {
					
					selCities.options[i]=(new Option(e.nombre,e.id))
				})
			})
			
	}
	
	async function checkEmail(){
		let value = document.getElementById('mail').value;
		console.log(value);
		
		if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(value))){
			document.getElementById('badmail').textContent = 'Ej: xxxx@xxxx.xxx'
			document.getElementById('badmail').style.display = 'block';
			document.getElementById('agregar').disabled = true;
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
				document.getElementById('badmail').textContent = 'Ese email ya está registrado'
				document.getElementById('badmail').style.display = 'block';
				document.getElementById('agregar').disabled = true;
			}else{
				document.getElementById('badmail').style.display = 'none';
			}
			
			if(!existMail && !checkUser) document.getElementById('agregar').disabled = false;
		})
		
		
	}
	
	async function checkUserName(){
		let value = document.getElementById('username').value;
		console.log(value);
		await fetch('checkUserName.do?username=' + value ,
				{
					method:'GET'
				})
		.then(response => response.json())
		.then(data => {
			console.log(data.existe);
			checkUser = data.existe;
			if(data.existe){
				document.getElementById('badusername').style.display = 'block';
				document.getElementById('agregar').disabled = true;
			}else {
				document.getElementById('badusername').style.display = 'none';
			}
			
			if(!existMail && !checkUser) document.getElementById('agregar').disabled = false;
		})
		
	}
	
	
	
	
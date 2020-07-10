/**
 * 
 */
$(document).ready(function(){
			tableInit();
			getCities();
	});
	
	var existMail =true ,checkUser = true,checkDoc = true;
	
	function tableInit(){
		
		$('#tbClients thead tr').clone(true).appendTo('#tbClients thead');
		$('#tbClients thead tr:eq(1) th').each(function (i){
			var title = $(this).text();
			if(title !== "Perfil")
				$(this).html('<input style="width: 100px;" type="text" placeholder="Buscar '+title+'"/>');
			
			$('input', this).on('keyup change', function(){
				if(table.column(i).search() !== this.value){
					table.column(i).search(this.value).draw();
				}
			});
		});
		
		var table = $('#tbClients')
		.DataTable({
			"paging": "first_last_numbers",
			"oLanguage":{
				"oPaginate":{
					"sNext":"&raquo;",
					"sPrevious": "&laquo;"
				},
					"sSearch":"Buscar...",
					"sEmptyTable" : "No se encontraron datos.",
					"sLengthMenu" : 'Mostrar <select><option value="10">10</option></select>',
					"sZeroRecords": "No hay nada para mostrar",
					"sInfo":""
			
			},
			fixedHeader: true,
			orderCellsTop: true
		})
	}
	
	function setName(){
		
		let dropCities = document.getElementById('cities');
		let nameCity = document.getElementById('nameCity');
		nameCity.value = dropCities.options[dropCities.selectedIndex].text;
		
	}
	
	function enableButton(){
		console.log('enableButton');
		if(!checkEmail && !checkUserName) document.getElementById('agregar').disabled = false;
	}
	
	
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
			
			setName();
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
			
			if(!existMail && !checkUser && !checkDoc) document.getElementById('agregar').disabled = false;
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
			
			if(!existMail && !checkUser && !checkDoc) document.getElementById('agregar').disabled = false;
		})
		
	}
	
	
	async function checkDni(){
		let value = document.getElementById('DNI').value;
		console.log(value);
		await fetch('checkDni.do?dni=' + value ,
				{
					method:'GET'
				})
		.then(response => response.json())
		.then(data => {
			console.log(data.existe);
			checkDoc = data.existe;
			if(data.existe){
				document.getElementById('baddni').style.display = 'block';
				document.getElementById('agregar').disabled = true;
			}else {
				document.getElementById('baddni').style.display = 'none';
			}
			
			if(!existMail && !checkUser && !checkDoc) document.getElementById('agregar').disabled = false;
		})
		
	}
	
	
	
	
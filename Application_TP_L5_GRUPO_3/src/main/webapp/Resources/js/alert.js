
setTimeout(alertTimeOut, 3000);

function alertTimeOut(){
	
	let alert = document.getElementById('alert');
	console.log(alert)
	if(alert){
		alert.style.display = 'none';
	}
	
}
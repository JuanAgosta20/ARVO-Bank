
function reset(){
	let el = document.getElementById('alert-cbu');
	if(el){
		el.style.diplay = 'none';
	}
	document.getElementById('formT1').style.display = "none";
	document.getElementById('formT2').style.display = "none";
	let form = document.getElementsByName("btnPanel");
	form.forEach((e)=>{
		e.style.backgroundColor = "white";
		e.style.color = "#495057";
	})
}

function enableForm(obj, name){
	reset();
	obj.style.backgroundColor = "#1761a0";
	obj.style.color = "white";
	document.getElementById('form'+name).style.display = "block";
}

function requestTransfer() {
	let ammount = $('#txtAmmount')[0];
	let acc = $("#cmbAccountFrom")[0];
	let acc2 =  $("#cmbAccountTo")[0];
	let alert = $("#alertForm")[0];
	let concept = $("#txtConcept")[0];
	
	
	if (acc.value === acc2.value) {
		alert.textContent = "Debe seleccionar cuentas distintas";
		alert.style.display = "block";
		return false;
	}
	if (ammount.value === "" || ammount.value <= 0) {
		alert.textContent = "Debe ingresar un monto válido";
		alert.style.display = "block";
		return false;
	}
	if (concept.value === ""){
		alert.textContent = "Debe colocar el concepto";
		alert.style.display = "block";
		return false;
	}
	
	return true;
}

function requestTransfer3() {
	
	console.log("entra");
	let ammount = $('#txtAmmount1')[0];
	let acc2 = $('txtAccountTo')[0];
	let alert = $("#alertForm1")[0];
	let concept = $("#txtConcept1")[0];
	
	if (acc2.value === "" || acc2.value.lenght != 22){
		alert.textContent = "Debe ingresar un CBU válido";
		alert.style.display = "block";
		return false;
	}

	if (ammount.value === "" || ammount.value <= 0) {
		alert.textContent = "Debe ingresar un monto válido";
		alert.style.display = "block";
		return false;
	}
	if (concept.value === ""){
		alert.textContent = "Debe colocar el concepto";
		alert.style.display = "block";
		return false;
	}
	
	return true;
}


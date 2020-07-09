function requestLoanForm() {
	let ammount = $('#txtAmmount')[0];
	let acc = $("#cmbAccount")[0];
	let alert = $("#alertForm")[0];
	if (ammount.value === "" || ammount.value < 0) {
		alert.textContent = "Debe ingresar un monto valido";
		alert.style.display = "block";
		return false;
	}
	if (acc.options.length === 0) {
		alert.textContent = "Debe seleccionar una cuenta";
		alert.style.display = "block";
		return false;
	}
	return true;
}

function requestPaymentForm() {
	let acc = $("#cmbAccPayment")[0];
	let alert = $("#alertPayment")[0];
	if (acc.options.length === 0) {
		alert.textContent = "Debe seleccionar una cuenta";
		alert.style.display = "block";
		return false;
	}
	return true;
}
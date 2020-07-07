
function showLoanPayments(btn, id) {
	if (btn.textContent.includes("Ver")) {
		btn.textContent = "Ocultar Pagos";
		$('#loanId' + id).show();
	} else {
		btn.textContent = "Ver Pagos";
		$('#loanId' + id).hide();
	}
}

function payment(FeePaymentId, LoanId) {
	$('#idFeePayment').val(FeePaymentId);
	$('#idLoan').val(LoanId);
	$('#modalPayments').modal('show');
}


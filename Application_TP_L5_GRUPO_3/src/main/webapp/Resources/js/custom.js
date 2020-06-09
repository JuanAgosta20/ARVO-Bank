/**
 * 
 */

$(document).ready(function (e) {
	var queryString = window.location.search;
	var urlParams = new URLSearchParams(queryString);	
	
		
    function showView(viewName) {
        $('.view').hide();
$('#' + viewName).show();
}
    var viewName = urlParams.get('view');
	showView(viewName);

    $('[data-launch-view]').click(function (e) {
        e.preventDefault();
        var viewName = $(this).attr('data-launch-view');
        showView(viewName);
    });

});
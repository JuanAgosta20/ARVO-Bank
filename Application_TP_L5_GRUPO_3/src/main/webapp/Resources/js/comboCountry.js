
$(function(){
	
	
	document.getElementById("countries").addEventListener("change",function(){
		console.log('asd');
		var prov = document.getElementById("province");
		prov.disabled = false;
		axios.post('getProvince.do').then(()=>function(response){
			console.log('respone: ' + response);
		}).catch(err =>{
			console.log(err)
		})
		
})
});

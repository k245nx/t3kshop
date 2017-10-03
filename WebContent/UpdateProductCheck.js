function updateProduct() {
	var x=document.forms["UpdateProduct"]["nome"].value;
		if(x.length<3 || x.length>200){
			alert("Inserire un nome valido");
			return false;
		}
	
	
	x=document.forms["UpdateProduct"]["modello"].value;
		if(x.length<3 || x.length>50){
			alert("Inserire modello valido");
			return false;
		}
	
	
	x=document.forms["UpdateProduct"]["marca"].value;
		if(x.length<3 || x.length>15){
			alert("Inserire una marca valida");
			return false;
		}
	
	
	x=document.forms["UpdateProduct"]["categoria"].value;
		if(x.length<3 || x.length >30){
			alert("Inserire una categoria valida");
			return false;
		}
	
	
	
	x=document.forms["UpdateProduct"]["breveDescrizione"].value;
		if(x.length<3 || x.length >300){
			alert("Inserire una breve descrizione valida");
			return false;
		}
	
	x=document.forms["UpdateProduct"]["descrizione"].value;
		if(x.length<3 || x.length >1500){
			alert("Inserire una breve descrizione valida");
			return false;
		}
	
	
	x=document.forms["UpdateProduct"]["quantita"].value;
	if(!x.match(/^[0-9]{1,7}$/)){
		alert("Inserire una quantità valida");
		return false;
	}
	
	x=document.forms["UpdateProduct"]["prezzo"].value;
	if(!x.match(/^([0-9]{1,10}).([0-9]{0,2})$/)){
		alert("Inserire un prezzo valido");
		return false;
	}
}








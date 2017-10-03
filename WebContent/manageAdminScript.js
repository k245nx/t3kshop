function ManageAdmins(){
	x=document.forms["InsertAdmin"]["username"].value;
	if(!x.match(/^[A-Za-z0-9 ]{3,30}$/)){
		alert("Inserire un username");
		return false;
	}
	
	x=document.forms["InsertAdmin"]["email"].value;
	if(!x.match(/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i)){
		alert("Inserire un email valida");
		return false;
	}
	
	x=document.forms["InsertAdmin"]["password"].value;
	if(!x.match(/^[A-Za-z0-9]{5,50}$/)){
		alert('Inserire una password valida. Lunga almeno 5 caratteri');
	}
	
	x=document.forms["InsertAdmin"]["nome"].value;
	if(!x.match(/^[A-Za-z ]{3,30}$/)){
		alert("Inserire un nome valido");
		return false;
	}
	
	x=document.forms["InsertAdmin"]["cognome"].value;
	if(!x.match(/^[A-Za-z ]{3,30}$/)){
		alert("Inserire un cognome valido");
		return false;
	}
	
	x=document.forms["InsertAdmin"]["telefono"].value;
	if(!x.match(/^[0-9]{5,10}$/)){
		alert("Inserire un numero di telefono valido");
		return false;
	}
	

}
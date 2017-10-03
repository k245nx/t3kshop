function LoginForm(){
	var x=document.forms["RegistrationForm"]["username"].value;
	if(!x.match(/^[A-Za-z ]{3,30}$/)){
		alert("Inserire un username");
		return false;
	}
	
	x=document.forms["RegistrationForm"]["email"].value;
	if(!x.match(/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,50}(?:\.[a-z]{2})?)$/i)){
		alert("Inserire un'email valida");
	}
	
	x=document.forms["RegistrationForm"]["password"].value;
	if(!x.match(/^[A-Za-z0-9]{5,12}$/)){
		alert('Inserire una password valida. Lunga almeno 5 caratteri');
	}

		x=document.forms["RegistrationForm"]["nome"].value;
		if(!x.match(/^[A-Za-z ]{3,30}$/)){
			alert("Inserire un nome valido");
			return false;
		}
		
		x=document.forms["RegistrationForm"]["cognome"].value;
		if(!x.match(/^[A-Za-z ]{3,30}$/)){
			alert("Inserire un nome valido");
			return false;
		}
		
		x=document.forms["RegistrationForm"]["dataNascita"].value;
		if(x==null||x==""){
			alert("Inserire una data di nascita valida");
			return false;
		}
	
	x=document.forms["RegistrationForm"]["indirizzo"].value;
	if(!x.match(/^[A-Z a-z 0-9 ]{4,150}$/)){
		alert("Inserire un indirizzo valido");
		return false;
	}
	
	x=document.forms["RegistrationForm"]["cap"].value;
	if(!x.match(/^[0-9]{1,8}$/)){
		alert("Inserire una cap valida");
		return false;
	}
	
	
	x=document.forms["RegistrationForm"]["citta"].value;
	if(!x.match(/^[A-Z a-z]{2,50}$/)){
		alert("inserire una città valida");
		return false;
	}
	
	
	x=document.forms["RegistrationForm"]["telefono"].value;
	if(!x.match(/^[0-9]{5,10}$/)){
		alert("Inserire un numero di telefono valido");
		return false;
	}
	
	if(!document.getElementById('termsagree').checked){
		alert("Accettare le indicazioni sul trattamento dei dati personali");
		return false;
	}
	

		
}

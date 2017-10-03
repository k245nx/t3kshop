package model;

public class Admin {
	
	public Admin(){}
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
	
	public void setCognome(String cognome){
		this.cognome=cognome;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public void setTelefono(String telefono){
		this.telefono=telefono;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}

	public String getNome(){
		return nome;
	}
	
	public String getCognome(){
		return cognome;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getTelefono(){
		return telefono;
	}
	
	String username,password,nome,cognome,email,telefono;
}

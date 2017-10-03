package model;

public class Cliente {
	
	public Cliente(){
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
	
	public String getIndirizzo(){
		return indirizzo;
	}
	
	public String getCap(){
		return cap;
	}
	
	public String getCitta(){
		return citta;
	}
	
	public String getStato(){
		return stato;
	}
	
	public String getDatanascita(){
		return dataNascita;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getTelefono(){
		return telefono;
	}
	
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
	
	public void setIndirizzo(String indirizzo){
		this.indirizzo=indirizzo;
	}
	
	public void setCap(String cap){
		this.cap=cap;
	}
	
	public void setCitta(String citta){
		this.citta=citta;
	}
	
	public void setStato(String stato){
		this.stato=stato;
	}
	
	public void setDatanascita(String dataNascita){
		this.dataNascita=dataNascita;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public void setTelefono(String telefono){
		this.telefono=telefono;
	}
	
	String username,password,nome,cognome,indirizzo,cap,citta,stato,dataNascita,email,telefono;
}

package model;

import java.text.DecimalFormat;

public class Articolo {
	public Articolo(){}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public void setQuantita(int quantita){
		this.quantita = quantita;
	}
	
	public void setPrezzo(double prezzo){
		DecimalFormat df = new DecimalFormat("#.00");
		this.prezzo = df.format(prezzo);
	}
	
	public String getPrezzo(){
		return prezzo;
	}
	
	public int getQuantita(){
		return quantita;
	}
	
	private String id;
	private int quantita;
	private String prezzo;
}

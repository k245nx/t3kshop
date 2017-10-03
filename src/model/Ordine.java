package model;
import java.util.ArrayList;

public class Ordine {
	public Ordine(){}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public void setArticoli(ArrayList<Articolo> articoli){
		this.articoli = articoli;
	}
	
	public ArrayList<Articolo> getArticoli(){
		return articoli;
	}

	
	private String id;
	private ArrayList<Articolo> articoli;
}

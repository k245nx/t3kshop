package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsiemeProdotti {
	public InsiemeProdotti(){}
	
	public void setSqlAppend(String sqlAppend) throws SQLException{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url=JDBC.url;
			Connection con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			insiemeProdotti = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("select * from prodotto " + sqlAppend + ";");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Prodotto p = new Prodotto();
				p.setId(rs.getString("id"));
				p.setNome(rs.getString("nome"));
				p.setModello(rs.getString("modello"));
				p.setMarca(rs.getString("marca"));
				p.setCategoria(rs.getString("categoria"));
				p.setImmagine(rs.getString("immagine"));
				p.setBreveDescrizione(rs.getString("brevedescrizione"));
				p.setDescrizione(rs.getString("descrizione"));
				p.setQuantita(rs.getInt("quantita"));
				p.setPrezzo(rs.getDouble("prezzo"));
				p.setnVolteAcquistato(rs.getInt("nvolteacquistato"));
				insiemeProdotti.add(p);
			}
			rs.close();
			ps.close();
			con.close();
		}
		catch(Exception e){	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
		}
	}
	
	public ArrayList<Prodotto> getProdotti(){
		return insiemeProdotti;
	}
	
	public int getSize(){
		return insiemeProdotti.size();
	}
	
	private ArrayList<Prodotto> insiemeProdotti;
}
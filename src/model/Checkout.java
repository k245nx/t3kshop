package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

public class Checkout {
	public Checkout(){}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setOrdine(ArrayList<Articolo> carrello){
		try{
			idOrdine = 1;
			String indirizzo=null, cap=null, citta=null, stato=null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = JDBC.url;	
			Connection con=DriverManager.getConnection(url,JDBC.user,JDBC.password);	
			System.out.println("Connessione	OK	\n");
			
			PreparedStatement ps=con.prepareStatement("select max(id) as maxid from ordine;");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				idOrdine = rs.getInt("maxid") + 1;
			ps=con.prepareStatement("select indirizzo from cliente where username='" + username + "';");
			rs=ps.executeQuery();
			while(rs.next())
			    indirizzo = rs.getString("indirizzo");
			ps=con.prepareStatement("select cap from cliente where username='" + username + "';");
			rs=ps.executeQuery();
			while(rs.next())
			    cap = rs.getString("cap");
			ps=con.prepareStatement("select citta from cliente where username='" + username + "';");
			rs=ps.executeQuery();
			while(rs.next())
			    citta = rs.getString("citta");
			ps=con.prepareStatement("select stato from cliente where username='" + username + "';");
			rs=ps.executeQuery();
			while(rs.next())
			    stato = rs.getString("stato");
			String sql="insert into ordine values(?,?,?,?,?,?,?);";
			ps=con.prepareStatement(sql);
			ps.setInt(1,idOrdine);
			ps.setString(2,username);
			ps.setString(3,indirizzo);
			ps.setString(4,cap);
			ps.setString(5,citta);
			ps.setString(6, stato);
			ps.setTimestamp(7, new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
			ps.executeUpdate();
			
			quantitaTotale=0;
			for(int i=0; i<carrello.size(); i++){
				sql="insert into articolo values(?,?,?,?);";
				ps=con.prepareStatement(sql);
				ps.setInt(1,idOrdine);
				ps.setString(2,carrello.get(i).getId());
				ps.setInt(3,carrello.get(i).getQuantita());
				quantitaTotale+=carrello.get(i).getQuantita();
				InsiemeProdotti prodotto = new InsiemeProdotti();
				prodotto.setSqlAppend("where id='" + carrello.get(i).getId() + "';");
				ps.setString(4, (prodotto.getProdotti().get(0).getPrezzo()).replace(",", "."));
				ps.executeUpdate();
				sql="update prodotto set quantita = quantita-" + carrello.get(i).getQuantita() + " where id='" + carrello.get(i).getId() + "';";
				ps.executeUpdate(sql);
				sql="update prodotto set nvolteacquistato = nvolteacquistato+" + carrello.get(i).getQuantita() + " where id='" + carrello.get(i).getId() + "';";
				ps.executeUpdate(sql);
			}
			ps=con.prepareStatement("select nome from cliente where username='" + username + "';");
			rs=ps.executeQuery();
			while(rs.next())
			    nome = rs.getString("nome");
			ps=con.prepareStatement("select cognome from cliente where username='" + username + "';");
			rs=ps.executeQuery();
			while(rs.next())
			    cognome = rs.getString("cognome");
			con.close();
		}catch(Exception e)	{
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);	
		}
	}
	
	public int getQuantitaTotale(){
		return quantitaTotale;
	}
	
	public int getIdOrdine(){
		return idOrdine;
	}
	
	public String getNome(){
		return nome + " " + cognome;
	}
	
	String username, nome, cognome;
	int quantitaTotale, idOrdine;
}


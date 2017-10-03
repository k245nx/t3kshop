package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageOrder {
	ArrayList<Ordine> ordini;
	public ManageOrder(){}
	ArrayList<String> users;
	
	public	void setUserOrder(String username)throws SQLException{
		try{
			Connection con;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			String idOrdine;
			ordini=new ArrayList<Ordine>();
			PreparedStatement ps = con.prepareStatement("select id from ordine where idcliente=?;");
			PreparedStatement ps2 = con.prepareStatement("select * from articolo where idordine=?;");
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				idOrdine=rs.getString("id");
				ps2.setString(1,idOrdine);
				ResultSet rs2=ps2.executeQuery();
				ArrayList<Articolo> articoliOrdine= new ArrayList<Articolo>();
				while(rs2.next()){
					Articolo a=new Articolo();
					a.setId(rs2.getString("idprodotto"));
					a.setQuantita(Integer.parseInt(rs2.getString("quantita")));
					a.setPrezzo(rs2.getDouble("prezzo"));
					articoliOrdine.add(a);
				}
				Ordine o=new Ordine();
				o.setId(idOrdine);
				o.setArticoli(articoliOrdine);
				ordini.add(o);
			}
			
		ps.close();
		ps2.close();
		con.close();
	}catch(Exception e)	{	
		System.out.println("Connessione	Fallita	\n");				
		System.out.println(e);
		}
	
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public ArrayList<Ordine> getOrdine(){
		System.out.println(ordini.size());
		return ordini;
	}
	
	public void setAdminOrder(){
		try{
			Connection con;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			String idOrdine;
			ordini=new ArrayList<Ordine>();
			PreparedStatement ps = con.prepareStatement("select id from ordine;");
			PreparedStatement ps2 = con.prepareStatement("select * from articolo where idordine=?;");
			PreparedStatement ps3=con.prepareStatement("select idcliente from ordine where id=?;");
			ResultSet rs=ps.executeQuery();
			ResultSet rs2;
			ResultSet rs3;
			users=new ArrayList<String>();
			while(rs.next()){
				idOrdine=rs.getString("id");
				ps3.setString(1,idOrdine);
				rs3=ps3.executeQuery();
				while(rs3.next()){
					users.add(rs3.getString("idcliente"));
				}
				ps2.setString(1,idOrdine);
				rs2=ps2.executeQuery();
				ArrayList<Articolo> articoliOrdine= new ArrayList<Articolo>();
				while(rs2.next()){
					Articolo a=new Articolo();
					a.setId(rs2.getString("idprodotto"));
					a.setQuantita(Integer.parseInt(rs2.getString("quantita")));
					a.setPrezzo(rs2.getDouble("prezzo"));
					articoliOrdine.add(a);
				}
				Ordine o=new Ordine();
				o.setId(idOrdine);
				o.setArticoli(articoliOrdine);
				ordini.add(o);
			}
			
		ps.close();
		ps2.close();
		con.close();
	}catch(Exception e)	{	
		System.out.println("Connessione	Fallita	\n");				
		System.out.println(e);
		}
	}
	
	public ArrayList<String> getUser(){
		System.out.println(ordini.size());
		return users;
	}
	
	public void setDeleteOrder(String id){
		try{
			Connection con;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("delete from articolo where idordine=?;");
			PreparedStatement ps2 = con.prepareStatement("delete from ordine where id=? and idcliente=?;");
			ps.setString(1,id);
			ps2.setString(1,id);
			ps2.setString(2,username);
			ps.executeUpdate();
			ps2.executeUpdate();
			ps.close();
			ps2.close();
			con.close();
	}catch(Exception e)	{	
		System.out.println("Connessione	Fallita	\n");				
		System.out.println(e);
		}
	}
	
	public void setIdOrdine(String idOrdine){
		this.idOrdine=idOrdine;
	}
	
	public void setDeleteItemOrder(String idProdotto){
		try{
			Connection con;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("delete from articolo where idordine=? and idprodotto=?;");
			ps.setString(1,idOrdine);
			ps.setString(2,idProdotto);
			ps.executeUpdate();
			ps.close();
			con.close();
	}catch(Exception e)	{	
		System.out.println("Connessione	Fallita	\n");				
		System.out.println(e);
		}
	}
	
	public void setUpdateItemOrder(String idProdotto){
		try{
			Connection con;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("delete from articolo where idordine=? and idprodotto=?;");
			ps.setString(1,idOrdine);
			ps.setString(2,idProdotto);
			ps.executeUpdate();
			ps.close();
			con.close();
	}catch(Exception e)	{	
		System.out.println("Connessione	Fallita	\n");				
		System.out.println(e);
		}
	}
	
	public String idOrdine,username;

}

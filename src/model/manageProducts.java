package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class manageProducts {
	
	public manageProducts(){}
	
	public void setdeleteProduct(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url=JDBC.url;
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);	
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("update prodotto set quantita=0 where id=?;");
			ps.setString(1,id);
			if(ps.executeUpdate()>0)
				System.out.println("ok");
		}
		catch(Exception e){	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
		}
	}
	
	public void setUpdateProductName(String name){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url=JDBC.url;
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);	
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("update prodotto set nome=? where id=?;");
			ps.setString(1,name);
			ps.setString(2,id);
			if(ps.executeUpdate()>0)
				System.out.println("ok");
		}catch(Exception e){	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
		}
		
	}
	
	public void setUpdateProductModel(String modello){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url=JDBC.url;
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);	
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("update prodotto set modello=? where id=?;");
			ps.setString(1,modello);
			ps.setString(2,id);
			if(ps.executeUpdate()>0)
				System.out.println("ok");
		}
		catch(Exception e){	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
		}
		
	}
	
	public void setUpdateProductMarca(String marca){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url=JDBC.url;
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);	
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("update prodotto set marca=? where id=?;");
			ps.setString(1,marca);
			ps.setString(2,id);
			if(ps.executeUpdate()>0)
				System.out.println("ok");
		}
		catch(Exception e){	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
		}
		
	}
	
	public void setUpdateProductCategory(String categoria){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url=JDBC.url;
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);	
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("update prodotto set categoria=? where id=?;");
			ps.setString(1,categoria);
			ps.setString(2,id);
			if(ps.executeUpdate()>0)
				System.out.println("ok");
		}
		catch(Exception e){	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
		}
		
	}
	
	public void setUpdateProductShortDesc(String breveDescrizione){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url=JDBC.url;
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);	
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("update prodotto set brevedescrizione=? where id=?;");
			ps.setString(1,breveDescrizione);
			ps.setString(2,id);
			if(ps.executeUpdate()>0)
				System.out.println("ok");
		}
		catch(Exception e){	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
		}
		
	}
	
	public void setUpdateProductDesc(String descrizione){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url=JDBC.url;
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);	
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("update prodotto set descrizione=? where id=?;");
			ps.setString(1,descrizione);
			ps.setString(2,id);
			if(ps.executeUpdate()>0)
				System.out.println("ok");
		}
		catch(Exception e){	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
		}
		
	}
	
	public void setUpdateProductQuantita(String quantita){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url=JDBC.url;
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);	
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("update prodotto set quantita=? where id=?;");
			ps.setString(1,quantita);
			ps.setString(2,id);
			if(ps.executeUpdate()>0)
				System.out.println("ok");
		}
		catch(Exception e){	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
		}
		
	}
	
	public void setUpdateProductPrice(String prezzo){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url=JDBC.url;
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);	
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("update prodotto set prezzo=? where id=?;");
			ps.setString(1,prezzo);
			ps.setString(2,id);
			if(ps.executeUpdate()>0)
				System.out.println("ok");
		}
		catch(Exception e){	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
		}
		
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	Connection con;
	String id;

}

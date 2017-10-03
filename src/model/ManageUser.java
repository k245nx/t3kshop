package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class ManageUser {
	
	public ManageUser(){}
	

	// USER
	public void updatePassword(String password){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("update cliente set password=? where username=?;");
			ps.setString(1,password);
			ps.setString(2,username);
			if(ps.executeUpdate()>0){
				System.out.println("Modifica avvenuta con successo");
			}
			ps.close();
			con.close();
		}catch(Exception e)	{	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
			}
	}
	
	public Cliente getCliente(String username){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("select * from cliente where username=?;");
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				cliente=new Cliente();
				cliente.setUsername(rs.getString("username"));
				cliente.setPassword(rs.getString("password"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCognome(rs.getString("cognome"));
				cliente.setIndirizzo(rs.getString("indirizzo"));
				cliente.setCap(rs.getString("cap"));
				cliente.setStato(rs.getString("stato"));
				cliente.setDatanascita(rs.getString("datanascita"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setEmail(rs.getString("email"));
			}
			ps.close();
			con.close();
		}catch(Exception e)	{	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
			}
		
		return cliente;
	}
	
	// USER
	public void updateEmail(String email){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("update cliente set email=? where username=?;");
			ps.setString(1,email);
			ps.setString(2,username);
			if(ps.executeUpdate()>0){
				System.out.println("Modifica avvenuta con successo");
			}
			ps.close();
			con.close();
		}catch(Exception e)	{	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
			}
	}
	
	// USER
	public void updateAddress(String address){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("update cliente set indirizzo=? where username=?;");
			ps.setString(1,address);
			ps.setString(2,username);
			if(ps.executeUpdate()>0){
				System.out.println("Modifica avvenuta con successo");
			}
			ps.close();
			con.close();
		}catch(Exception e)	{	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
			}
	}
	
	// USER
	public void updateState(String state){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("Update cliente set stato=? where username=?;");
			ps.setString(1,state);
			ps.setString(2,username);
			if(ps.executeUpdate()>0){
				System.out.println("Modifica avvenuta con successo");
			}
			ps.close();
			con.close();
		}catch(Exception e)	{	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
			}
	}
	
	// USER
	public void updateCap(String cap){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("Update cliente set cap=? where username=?;");
			ps.setString(1,cap);
			ps.setString(2,username);
			if(ps.executeUpdate()>0)
				System.out.println("Modifica avvenuta con successo");
			ps.close();
			con.close();
		}catch(Exception e)	{	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
			}
	}
	
	public void updateTelefono(String telefono){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("Update cliente set telefono=? where username=?;");
			ps.setString(1,telefono);
			ps.setString(2,username);
			if(ps.executeUpdate()>0)
				System.out.println("Modifica avvenuta con successo");
			ps.close();
			con.close();
		}catch(Exception e)	{	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
			}
	}	
	

	
	public void setUsername(String username){
		this.username=username;
	}
	
	public ArrayList<Cliente> clienti;
	public ArrayList<Admin> adminArray;
	public Cliente cliente;
	public Admin admin;
	public String username;
	Connection con;
}

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageAdmin {
	
	public ManageAdmin(){}
	
	public ArrayList<Cliente> getUsers(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	= JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			clienti=new ArrayList<Cliente>();
			PreparedStatement ps = con.prepareStatement("select * from cliente;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Cliente c=new Cliente();
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("Password"));
				c.setNome(rs.getString("nome"));
				c.setCognome(rs.getString("cognome"));
				c.setIndirizzo(rs.getString("indirizzo"));
				c.setCap(rs.getString("cap"));
				c.setCitta(rs.getString("citta"));
				c.setTelefono(rs.getString("telefono"));
				c.setEmail(rs.getString("email"));
				clienti.add(c);
				
			}
			ps.close();
			con.close();
		}catch(Exception e)	{	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
			}
		return clienti;
	}
	
	public ArrayList<Admin> getAdmins(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			adminArray=new ArrayList<Admin>();
			PreparedStatement ps = con.prepareStatement("select * from amministratore;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				admin=new Admin();
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setNome(rs.getString("nome"));
				admin.setCognome(rs.getString("cognome"));
				admin.setTelefono(rs.getString("telefono"));;
				admin.setEmail(rs.getString("email"));
				adminArray.add(admin);
			}
			ps.close();
			con.close();
		}catch(Exception e)	{	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
			}
		
		return adminArray;

	}
	
	public void deleteUser(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("DELETE from cliente where username=?;");
			ps.setString(1,username);
			ps.executeUpdate();
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
	
	public Admin getAdmin(String username){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("select * from amministratore where username=?;");
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				admin=new Admin();
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setNome(rs.getString("nome"));
				admin.setCognome(rs.getString("cognome"));
				admin.setTelefono(rs.getString("telefono"));
				admin.setEmail(rs.getString("email"));
			}
			ps.close();
			con.close();
		}catch(Exception e)	{	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
			}
		
		return admin;
	}
	
	public void updateAdminPassword(String password){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("update amministratore set password=? where username=?;");
			ps.setString(1,password);
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
	
	public void updateAdminEmail(String email){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("update amministratore set email=? where username=?;");
			ps.setString(1,email);
			ps.setString(2,username);
			System.out.println(email);
			System.out.println(username);

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
	

	public void deleteAdmin(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("delete from amministratore where username=?;");
			ps.setString(1,username);
			ps.executeUpdate();
			con.close();
		}catch(Exception e)	{	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
			}
	}
	
	public void updateAdminTelefono(String telefono){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps = con.prepareStatement("update amministratore set telefono=? where username=?;");
			ps.setString(1,telefono);
			ps.setString(2,username);
			System.out.println(telefono);
			System.out.println(username);

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
	
	public boolean setInsertAdmin()throws SQLException{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);	
			System.out.println("Connessione	OK	\n");

		}catch(Exception e)	{	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);	
		}
		PreparedStatement ps=con.prepareStatement("insert into amministratore values(?,?,?,?,?,?);");
		ps.setString(1,username);
		ps.setString(2,password);
		ps.setString(3,nome);
		ps.setString(4,cognome);
		ps.setString(6,email);
		ps.setString(5,telefono);
		if(ps.executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	
	public ArrayList<Cliente> clienti;
	public ArrayList<Admin> adminArray;
	public Cliente cliente;
	public Admin admin;
	public String username,password,nome,cognome,email,telefono;
	Connection con;
}

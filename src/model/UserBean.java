package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class UserBean {
	
	public UserBean(){}
	
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
	
	public void setdataNascita(String dataNascita){
		this.dataNascita=dataNascita;
	}
	
	public void setTelefono(String telefono){
		this.telefono=telefono;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public boolean insertUser()throws SQLException{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String	url	=	JDBC.url;	
			Connection	con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
			String sql="insert into cliente values(?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setString(3,nome);
			ps.setString(4,cognome);
			ps.setString(5,indirizzo);
			ps.setString(6,cap);
			ps.setString(7,citta);
			ps.setString(8,stato);
			ps.setString(9,dataNascita);
			ps.setString(10,telefono);
			ps.setString(11,email);
			if(ps.executeUpdate()>0)
				return true;	
			ps.close();
			con.close();
		}catch(Exception e)	{	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
		}
		return false;
	}
	
	String username,password,nome,cognome,indirizzo,cap,citta,stato,dataNascita,telefono,email;
}

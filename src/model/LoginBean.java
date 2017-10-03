package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LoginBean {
	String username,password;
	Connection	con;
	String	url	=	JDBC.url;
	public LoginBean(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = JDBC.url;	
			con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			System.out.println("Connessione	OK	\n");
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
	
	public boolean checkUser()throws SQLException{
		boolean found = false;
		String sql="select * from cliente where username=? and password=?;";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,username);
		ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			if(username.equals(rs.getString("username"))&& password.equals(rs.getString("password")))
				found=true;
		}
		ps.close();
		return found;
		
	}
	
	public boolean checkAdmin()throws SQLException{
		boolean found = false;
		String sql="select * from amministratore where username=? and password=?;";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,username);
		ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			if(username.equals(rs.getString("username"))&& password.equals(rs.getString("password")))
				found=true;
		}
		ps.close();
		return found;
		
	}
	
	public void close()throws SQLException{
		con.close();
	}
	

}

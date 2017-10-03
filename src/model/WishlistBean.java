package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WishlistBean {
	public WishlistBean(){}
	
	public void setUser(String username){
		this.username = username;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url=JDBC.url;
			Connection con=DriverManager.getConnection(url,JDBC.user,JDBC.password);	
			wishlist = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("select idprodotto from wishlist where username='" + username + "';");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				wishlist.add(rs.getString("idProdotto"));
			rs.close();
			ps.close();
			con.close();
		}
		catch(Exception e){	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
		}
	}
	
	public void add(String id){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url=JDBC.url;
			Connection con=DriverManager.getConnection(url,JDBC.user,JDBC.password);	
			String sql="insert into wishlist values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,username);
			ps.executeUpdate();
			wishlist = new ArrayList<>();
			ps = con.prepareStatement("select idprodotto from wishlist where username='" + username + "';");
			ResultSet rs= ps.executeQuery();
			while(rs.next())
				wishlist.add(rs.getString("idprodotto"));
			rs.close();
			ps.close();
			con.close();
		}
		catch(Exception e){	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
		}
	}
	
	public void remove(String id){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url=JDBC.url;
			Connection con=DriverManager.getConnection(url,JDBC.user,JDBC.password);
			String sql="DELETE FROM wishlist WHERE idprodotto='" + id + "' AND username='" + username + "';";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.executeUpdate();
			wishlist = new ArrayList<>();
			ps = con.prepareStatement("select idprodotto from wishlist where username='" + username + "';");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				wishlist.add(rs.getString("idProdotto"));
			rs.close();
			ps.close();
			con.close();
		}
		catch(Exception e){	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);
		}
	}
	
	public ArrayList<String> getWishlist(){
		return wishlist;
	}
	
	private ArrayList<String> wishlist;
	private String username;
}

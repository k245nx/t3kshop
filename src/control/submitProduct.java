package control;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.JDBC;

public class submitProduct extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("Text/html");
		
		int id = 1;
		String nome=request.getParameter("nome");
		String modello=request.getParameter("modello");
		String marca=request.getParameter("marca");
		String categoria=request.getParameter("categoria");
		String breveDescrizione=request.getParameter("breveDescrizione");
		String descrizione=request.getParameter("descrizione");
		String quantita=request.getParameter("quantita");
		String prezzo=request.getParameter("prezzo");

		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = JDBC.url;	
			Connection con=DriverManager.getConnection(url,JDBC.user,JDBC.password);	
			System.out.println("Connessione	OK	\n");
			PreparedStatement ps=con.prepareStatement("select max(id) as maxid from Prodotto;");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			    id = rs.getInt("maxid") + 1;
			String sql="insert into prodotto values(?,?,?,?,?,?,?,?,?,?,?);";
			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			ps.setString(2,nome);
			ps.setString(3,modello);
			ps.setString(4,marca);
			ps.setString(5,categoria);
			ps.setString(6, String.valueOf(id) + ".jpg");
			ps.setString(7,breveDescrizione);
			ps.setString(8,descrizione);
			ps.setString(9,quantita);
			ps.setString(10,prezzo.replace(',', '.'));
			ps.setInt(11,0);
			ps.executeUpdate();
			con.close();
			getServletContext().getRequestDispatcher("/manageProducts.jsp").forward(request, response);
		}catch(Exception e)	{	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);	
		}
	}
}

	
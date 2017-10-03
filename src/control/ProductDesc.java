package control;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InsiemeProdotti;

public class ProductDesc extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		InsiemeProdotti product=new InsiemeProdotti();
		String id = (String)request.getParameter("id");
		try {
			product.setSqlAppend("where id='" + id + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().write(product.getProdotti().get(0).getDescrizione());
	}
}
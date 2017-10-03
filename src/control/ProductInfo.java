package control;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InsiemeProdotti;
import model.Prodotto;

public class ProductInfo extends HttpServlet {
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
		Prodotto p = product.getProdotti().get(0);
		String jsonString = "{\"id\" : \""+ p.getId() +"\", \"nome\" : \""+ p.getNome() +"\", \"modello\" : \""+ p.getModello() +"\", \"marca\" : \""+ p.getMarca() +"\", \"categoria\" : \""+ p.getCategoria() +"\", \"breveDescrizione\" : \""+ p.getBreveDescrizione() +"\", \"quantita\" : \""+ p.getQuantita() +"\", \"prezzo\" : \""+ p.getPrezzo() +"\"}";
		response.getWriter().write(jsonString);
	}
}
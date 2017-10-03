package control;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.manageProducts;
public class deleteProduct extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		manageProducts mp=new manageProducts();
		mp.setId(request.getParameter("idProdotto"));
		mp.setdeleteProduct();
		
		getServletContext().getRequestDispatcher("/manageProducts.jsp").forward(request, response);
	}
}

package control;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ManageOrder;
public class DeleteItemOrder extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		ManageOrder mo=new ManageOrder();
		mo.setIdOrdine(request.getParameter("idOrdine"));
		mo.setDeleteItemOrder(request.getParameter("idArticolo"));
		getServletContext().getRequestDispatcher("/manageOrders.jsp").forward(request, response);
	}
}

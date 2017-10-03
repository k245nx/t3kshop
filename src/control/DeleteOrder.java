package control;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ManageOrder;
public class DeleteOrder extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		ManageOrder mo=new ManageOrder();
		String id=request.getParameter("id");
		mo.setUsername(request.getParameter("username"));
		mo.setDeleteOrder(id);
		getServletContext().getRequestDispatcher("/manageOrders.jsp").forward(request, response);
	}
}

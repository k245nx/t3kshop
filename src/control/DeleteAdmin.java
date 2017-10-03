package control;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ManageAdmin;
public class DeleteAdmin extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		ManageAdmin mg=new ManageAdmin();
		mg.setUsername(request.getParameter("admin"));
		mg.deleteAdmin();
		getServletContext().getRequestDispatcher("/manageAdmins.jsp").forward(request, response);
	}
}
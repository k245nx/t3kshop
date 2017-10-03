package control;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ManageAdmin;

public class UpdateAdmin extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		ManageAdmin mg=new ManageAdmin();
		mg.setUsername(request.getParameter("adminUsername"));
		if(request.getParameter("modificaPassword")!=null)
			mg.updateAdminPassword( request.getParameter("adminPassword"));
		else if(request.getParameter("modificaEmail")!=null)
			mg.updateAdminEmail(request.getParameter("adminEmail"));
		else if(request.getParameter("modificaTelefono")!=null)
			mg.updateAdminTelefono(request.getParameter("adminTelefono"));
		getServletContext().getRequestDispatcher("/adminAccount.jsp").forward(request, response);

	}
}

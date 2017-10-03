package control;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ManageAdmin;

/* Aggiunge un nuovo admin al db */

public class addAdmin extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html");
		ManageAdmin mg= new ManageAdmin();
		mg.setUsername(request.getParameter("username"));
		mg.setPassword(request.getParameter("password"));
		mg.setNome(request.getParameter("nome"));
		mg.setCognome(request.getParameter("cognome"));
		mg.setTelefono(request.getParameter("telefono"));
		mg.setEmail(request.getParameter("email"));

		try{
			if(mg.setInsertAdmin()){
				HttpSession session=request.getSession();
				getServletContext().getRequestDispatcher("/manageAdmins.jsp").forward(request, response);

			}
		}catch(Exception e)	{	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);	
		}

		
	}
}
	
	
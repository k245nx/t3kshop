package control;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ManageUser;

public class UpdateUser extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		ManageUser mg=new ManageUser();
		mg.setUsername(request.getParameter("username"));;
		if(request.getParameter("modificaPassword")!=null){
			mg.updatePassword(request.getParameter("password"));

		}else if(request.getParameter("modificaEmail")!=null){
			mg.updateEmail(request.getParameter("email") );

		}else if(request.getParameter("modificaIndirizzo")!=null){
			mg.updateAddress(request.getParameter("address"));

		}else if(request.getParameter("modificaCap")!=null){
			mg.updateCap(request.getParameter("cap"));

		}else if(request.getParameter("modificaStato")!=null){
			mg.updateState(request.getParameter("state"));
		}else if(request.getParameter("modificaTelefono")!=null){
			mg.updateTelefono(request.getParameter("telefono"));
		}
		
		getServletContext().getRequestDispatcher("/userAccount.jsp").forward(request, response);

	}
}

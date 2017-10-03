package control;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginBean;


public class Login extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		LoginBean login= new LoginBean();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		login.setUsername(username);
		login.setPassword(password);
		HttpSession session=request.getSession();
		try{
			synchronized(session){
				if(login.checkAdmin()){
					session.setAttribute("adminRole", new Boolean(true));
					session.setAttribute("username", username);
				}
				else if(login.checkUser()){
					session.setAttribute("username", username);
					session.setAttribute("adminRole", new Boolean(false));
				}else{
					getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
				}
			}
			login.close();
		}catch(Exception e)	{	
			System.out.println("Connessione	Fallita	\n");				
			System.out.println(e);	
		}
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}

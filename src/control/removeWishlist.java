package control;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.WishlistBean;
public class removeWishlist extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		HttpSession session=request.getSession();
		if((String)session.getAttribute("username")==null)
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		else{
			WishlistBean wishlistControl = new WishlistBean();
			wishlistControl.setUser((String)session.getAttribute("username"));
			wishlistControl.remove((String)request.getParameter("id"));
			getServletContext().getRequestDispatcher("/wishlist.jsp").forward(request, response);
		}
	}	
}



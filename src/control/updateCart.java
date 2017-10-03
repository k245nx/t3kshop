package control;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Articolo;
import model.Checkout;
import model.InsiemeProdotti;

public class updateCart extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		HttpSession session=request.getSession();
		ArrayList<Articolo> carrello = new ArrayList<Articolo>();
		synchronized(session){
			if((ArrayList<Articolo>)session.getAttribute("carrello")==null)
				session.setAttribute("carrello", carrello);
			carrello = (ArrayList<Articolo>)session.getAttribute("carrello");
			
			InsiemeProdotti checkQuantita = new InsiemeProdotti();
			for(int i=0; i<carrello.size(); i++){
				int quantita = Integer.parseInt(request.getParameter("quantita" + i));
				try {
					checkQuantita.setSqlAppend("where id='" + carrello.get(i).getId() + "'");
					if(checkQuantita.getProdotti().get(0).getQuantita()<quantita)
						quantita = checkQuantita.getProdotti().get(0).getQuantita();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				carrello.get(i).setQuantita(quantita);
				if(request.getParameter("deleteItem" + i)!=null || carrello.get(i).getQuantita()==0)
					carrello.remove(i);
			}
			if(request.getParameter("update")!=null)
				getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
			else if(request.getParameter("checkout")!=null && (String)session.getAttribute("username")!=null && carrello.size()>0){
				try{
					Checkout manageCheckout = new Checkout();
					manageCheckout.setUsername((String)session.getAttribute("username"));
					manageCheckout.setOrdine(carrello);
					request.setAttribute("idOrdine", manageCheckout.getIdOrdine());
					request.setAttribute("quantita", manageCheckout.getQuantitaTotale());
					request.setAttribute("nome", manageCheckout.getNome());
					carrello.clear();
					getServletContext().getRequestDispatcher("/checkout.jsp").forward(request, response);
				}catch(Exception e)	{
					System.out.println("Connessione	Fallita	\n");				
					System.out.println(e);	
				}
			}else{
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
	}	
}



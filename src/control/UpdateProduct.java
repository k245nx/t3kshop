package control;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.manageProducts;

public class UpdateProduct extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		manageProducts mp=new manageProducts();
		mp.setId(request.getParameter("idProdotto"));
		mp.setUpdateProductName(request.getParameter("nome"));
		mp.setUpdateProductModel(request.getParameter("modello"));
		mp.setUpdateProductMarca(request.getParameter("marca"));
		mp.setUpdateProductCategory(request.getParameter("categoria"));
		mp.setUpdateProductDesc(request.getParameter("descrizione"));
		mp.setUpdateProductShortDesc(request.getParameter("breveDescrizione"));
		mp.setUpdateProductQuantita(request.getParameter("quantita"));
		String fixedprice=((String)request.getParameter("prezzo")).replace(',', '.');
		mp.setUpdateProductPrice(fixedprice);
		getServletContext().getRequestDispatcher("/manageProducts.jsp").forward(request, response);
	}

}

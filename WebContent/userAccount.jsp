<%	
	//role check
	if(session.getAttribute("adminRole")==null){
		response.sendRedirect("login.jsp");
		return;
	}
	else if((Boolean)session.getAttribute("adminRole")){
		response.sendRedirect("adminPanel.jsp");
		return;
	}
	String  username= (String) session.getAttribute("username");
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-15" pageEncoding="UTF-8" session="true"%>
<jsp:useBean id="prodotti" class="model.InsiemeProdotti" scope="page" />
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Articolo" %>
<jsp:useBean id="wishlist" class="model.WishlistBean" scope="page" />
<jsp:useBean id="manageUser" class="model.ManageUser" scope="page" />
<jsp:useBean id="cliente" class="model.Cliente" scope="page" />

<%
	cliente=manageUser.getCliente(username);

	ArrayList<String> currentWishlist = new ArrayList<String>();
	if(session.getAttribute("adminRole")!=null){
		if(!(Boolean)session.getAttribute("adminRole")){
			wishlist.setUser((String)session.getAttribute("username"));
			currentWishlist = wishlist.getWishlist();
		}
	}
%>
<!doctype html>
<html lang="it">
	<head>
		<link rel="stylesheet" type="text/css" href="index.css">
		<meta charset="UTF-8">
		<title>t3k-shop</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="jquery.js"></script>
		<script src="responsiveNav.js"></script>
	</head>
	<body>
		<div id="main">
			<header>
				<div id="logoblock">
						<img id="logo" src="images/logo.png" alt="logo">
				</div>	
				<div id="side">
						<form action="search" id="search-form">
							<input type="hidden" name="page" value="1">
							<input type="hidden" name="type" value="nome">
							<input id="searchbutton" type="submit" value="Vai" style=" float: right;">
							<input name="text-search" id="text-search" type="text" placeholder="Cerca">
						</form>
						<div id="welcome">Benvenuto, <a href="userPanel.jsp"><%=(String)session.getAttribute("username")%></a> 
							<span>-</span>
							<form style="float: right; display: inline-block; margin-top: -2px;" action="Logout" method="post">
								<input id=actionLogout type="submit" name="logout" value="Logout">
							</form>
						</div>
						
						<div id="userpanel">
							<img style="width: 13px;" src="images/star06.gif">
							<% 	if(currentWishlist==null || currentWishlist.size()==0){%>
								<a id="wishlist" href="wishlist.jsp">Wishlist</a>
							<% 	}else{%>
									<a id="cart" href="wishlist.jsp">Wishlist (<%=currentWishlist.size()%>)</a>
							<% 	}%>
							<img style="width: 13px;" id="cartimg" src="images/carrello.gif">
							<%
								ArrayList<Articolo> currentCart = (ArrayList<Articolo>)session.getAttribute("carrello"); 
							%>
							<% 	if(currentCart==null || currentCart.size()==0){%>
									<a id="cart" href="cart.jsp">Carrello</a>
							<% 	}else{%>
									<% 	int count=0;
										for(int i=0; i<currentCart.size(); i++)	
											count += currentCart.get(i).getQuantita();
									%>
									<a id="cart" href="cart.jsp">Carrello (<%=count%>)</a>
							<% 	}%>
						</div>
					</div>
			</header>
			<div id="centralblock">
				<section id=categories>
					<h4>Componenti</h4>
					<ul style="list-style-type:none;">
						<li><a href="search?page=1&type=categoria&text-search=Alimentatori">Alimentatori</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Case">Case</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Cuffie-Mic">Cuffie/Mic</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Dissipatori">Dissipatori</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Gaming">Gaming</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Lettori">Lettori BD/DVD/CD</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Hard+Disk+Interni">Hard Disk Interni</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Hard+Disk+Esterni">Hard Disk Esterni</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Monitor">Monitor</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Memorie">Memorie</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Processori">Processori</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Schede+Audio">Schede Audio</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Schede+Madri">Schede Madri</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Schede+Video">Schede Video</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Software">Software</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Speaker">Speaker</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Stampanti">Stampanti</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Tastiere+Mouse">Tastiere Mouse</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Webcam">Webcam</a></li>
					</ul>
					<h4>Computer Assemblati</h4>
					<ul style="list-style-type:none;">
						<li><a href="search?page=1&type=categoria&text-search=Desktop">Desktop</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Notebook">Notebook</a></li>
						<li><a href="search?page=1&type=categoria&text-search=Netbook">Netbook</a></li>
					</ul>
					<h4>I più venduti</h4>
					<ol>
						<jsp:setProperty name="prodotti" property="sqlAppend" value="order by nvolteacquistato desc"/>
						<% for(int i=0; i<5 && i<(prodotti.getProdotti()).size();i++){ %>
							<li><a href="<%="product?id=" + (prodotti.getProdotti()).get(i).getId() %>"><%=(prodotti.getProdotti()).get(i).getNome()%></a></li>
						<%} %>
					</ol>
				</section>
				<aside id="centrale">
					<div id="navigationbar">
						<nav>
							<ul class="topnav" id="myTopnav">
								<li><a href="index.jsp">Home</a></li>
								<li><a href="">Promozioni</a></li>
								<li><a href="">Buoni Regalo</a></li>
								<li><a href="">Servizio Clienti</a></li>
								<li><a href="register.jsp">Registrati</a></li>
								<li style="margin-right: 0px;"><a href="login.jsp">Accedi</a></li>
								<li id="expand"><a href="javascript:void(0);" onclick="expand()">&#9776;</a></li> 
							</ul>
						</nav>
					</div>
					<section id="adaptivesection">
						<h3>Modifica impostazioni account</h3><br>
						<form action="UpdateUser" method="post">
							<div id=registerattributes>
								<div id="registerattribute">Username</div>
								<div id="registerattribute">Nome</div>
								<div id="registerattribute">Cognome</div>
								<div id="registerattribute">Password</div>
								<div id="registerattribute">Indirizzo</div>
								<div id="registerattribute">Cap</div>
								<div id="registerattribute">Stato</div>
								<div id="registerattribute">Email</div>
								<div id="registerattribute">Telefono</div>
							</div>
							<div id=registerfields>
								<input id=registerfield type="text" name="username" value="<%=cliente.getUsername()%>" readonly>
								<input id=registerfield type="text" name="nome" value="<%=cliente.getNome()%>" readonly>
								<input id=registerfield type="text" name="cognome" value="<%=cliente.getCognome()%>" readonly>
								<input id=registerfield type="password" name="password" value="<%=cliente.getPassword()%>">
								<input id=registerfield type="text" name="address" value="<%=cliente.getIndirizzo()%>">
								<input id=registerfield type="text" name="cap" value="<%=cliente.getCap()%>">
								<input id=registerfield type="text" name="state" value="<%=cliente.getStato()%>">
								<input id=registerfield type="text" name="email" value="<%=cliente.getEmail()%>">
								<input id=registerfield type="text" name="telefono" value="<%=cliente.getTelefono()%>">
								<input type="hidden" name="username" value="<%=cliente.getUsername()%>">
							</div>
							<div style="float: left; width: 1px;">
								<button style="height: 21px; margin-bottom: 10px; margin-top: 93px;" name="modificaPassword">Modifica</button>
								<button style="height: 21px; margin-bottom: 10px;" name="modificaIndirizzo">Modifica</button>
								<button style="height: 21px; margin-bottom: 10px;" name="modificaCap">Modifica</button>
								<button style="height: 21px; margin-bottom: 10px;" name="modificaStato">Modifica</button>
								<button style="height: 21px; margin-bottom: 10px;" name="modificaEmail">Modifica</button>
								<button style="height: 21px; margin-bottom: 10px;" name="modificaTelefono">Modifica</button>
							</div>
						</form>
						<br>
						<form style="clear:both;"action="userPanel.jsp">
						    <input type="submit" value="Torna indietro">
						</form>
					</section>
					<section id="categoriesresponsive">
						<div id="listaresponsive">
							<h4>Componenti</h4>
							<ul style="list-style-type:none;">
								<li><a href="search?page=1&type=categoria&text-search=Alimentatori">Alimentatori</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Case">Case</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Cuffie-Mic">Cuffie/Mic</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Dissipatori">Dissipatori</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Gaming">Gaming</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Lettori">Lettori BD/DVD/CD</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Hard+Disk+Interni">Hard Disk Interni</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Hard+Disk+Esterni">Hard Disk Esterni</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Monitor">Monitor</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Memorie">Memorie</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Processori">Processori</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Schede+Audio">Schede Audio</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Schede+Madri">Schede Madri</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Schede+Video">Schede Video</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Software">Software</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Speaker">Speaker</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Stampanti">Stampanti</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Tastiere+Mouse">Tastiere Mouse</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Webcam">Webcam</a></li>
							</ul>
						</div>
						<div id="listaresponsive">
							<h4>Computer Assemblati</h4>
							<ul style="list-style-type:none;">
								<li><a href="search?page=1&type=categoria&text-search=Desktop">Desktop</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Notebook">Notebook</a></li>
								<li><a href="search?page=1&type=categoria&text-search=Netbook">Netbook</a></li>
							</ul>
						</div>
						<div id="listaresponsive">
							<h4>I più venduti</h4>
							<ol>
								<jsp:setProperty name="prodotti" property="sqlAppend" value="order by nvolteacquistato desc"/>
								<% for(int i=0; i<(prodotti.getProdotti()).size() && i<5;i++){ %>
									<li><a href="<%="product?id=" + (prodotti.getProdotti()).get(i).getId() %>"><%=(prodotti.getProdotti()).get(i).getNome()%></a></li>
								<%} %>
							</ol>
						</div>
					</section>
				</aside>
			</div>
			<footer>
				<table id="footer">
					<th>Informazioni</th>
					<th>Pagamenti e Consegna</th>
					<th>Garanzie</th>
					<th>Area Clienti</th> 
					<tr>
						<td><a href="">Chi Siamo</a></td>
						<td><a href="">Modalità di Pagamento</a></td>
						<td><a href="">Diritto di Recesso</a></td>
						<td id="area"><a href="">I tuoi Dati</a></td>
					</tr>
					<tr>
						<td><a href="">Contatti</a></td>
						<td><a href="">Modalità di Consegna</a></td>
						<td><a href="">Condizioni di Garanzia</a></td>
						<td id="area"><a href="">Stato ordini</a></td>
					</tr>
					<tr>
						<td><a href="">Condizioni di Vendita</a></td>
						<td><a href="">Tempi di evasione</a></td>
						<td><a href="">Anomalie alla consegna</a></td>
						<td id="area"><a href="">Iscriviti alla Newsletter</a></td>
					</tr>
					<tr>
						<td><a href="">Come Acquistare</a></td>
						<td><a href="">Tempi di consegna</a></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</footer>
		</div>
	</body>
</html>
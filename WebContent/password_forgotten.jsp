<%	
	//role check
	if((Boolean)session.getAttribute("adminRole")!=null){
		if((Boolean)session.getAttribute("adminRole"))
			response.sendRedirect("adminPanel.jsp");
		else if(!(Boolean)session.getAttribute("adminRole"))
			response.sendRedirect("userPanel.jsp");
	}
	String  username= (String) session.getAttribute("username");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-15" pageEncoding="UTF-8" session="true"%>
<jsp:useBean id="prodotti" class="model.InsiemeProdotti" scope="page" />
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Articolo" %>
<jsp:useBean id="wishlist" class="model.WishlistBean" scope="page" />
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
						<div id="welcome">Effettua l'<a href="login.jsp">accesso</a> o <a href="register.jsp">registrati</a></div>
						<div id="userpanel">
							<img style="width: 13px;" src="images/star06.gif">
							<a id="wishlist" href="wishlist.jsp">Wishlist</a>
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
						<h3>Password dimenticata</h3>
						<p id="registerdesc">
							Questa sezione ti permette di resettare la password nel caso l'avessi smarrita. Compilando questo modulo ti verrá inviata una mail all'indirizzo indicato, se presente nel nostro archivio, contenente la nuova password di accesso.
						</p>
						<form style="text-align:center; margin-top: 20px;" action="RegServlet" method="post" name="LoginForm" onsubmit="return LoginForm()">
							<div id=loginattributes>
								<div id="loginattribute">Indirizzo Email</div>
							</div>
							<div id=loginfields>
								<input id=loginfield type="text" name="email">
							</div>
							<input id="loginbutton" type="submit" name="Accedi" value="Invia">
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
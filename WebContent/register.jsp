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
		<script src="RegisterFormCheck.js"></script>
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
						<h3>Creazione nuovo account</h3>
						<p id="registerdesc">
							Se desideri acquistare su t3k-shop o utilizzare tutte le funzionalità 
							a disposizione la registrazione è obbligatoria. L'<strong>username</strong> 
							indicato diventerà la nuova <strong>chiave di accesso</strong> alle aree 
							riservate insieme alla password scelta.<br><br>I dati raccolti sono utilizzati
							al solo fine di completare il tuo ordine o permettere l'uso di funzionalità 
							avanzate come le recensioni dei prodotti. Se vuoi avere maggiori informazioni 
							sulla sicurezza e la privacy dei tuoi dati consulta la nostra sezione 
							<a href="">informazioni.</a><br><br>Verificare i dati inseriti attentamente. 
							La registrazione è gratuita e non Vi obbliga ad effettuare acquisti.
						</p>
						<h4>Modulo di iscrizione</h4>
						<form action="RegServlet" method="post" name="RegistrationForm" onsubmit="return LoginForm()">
							<div id=register1>
								<div id=registerattributes>
									<div id="registerattribute">Username</div>
									<div id="registerattribute">Indirizzo E-mail</div>
									<div id="registerattribute">Password</div>
									
									<div id="registerattribute">Nome</div>
									<div id="registerattribute">Cognome</div>
									<div id="registerattribute">Data di Nascita</div>
								</div>
								<div id=registerfields>
									<input id=registerfield type="text" name="username">
									<input id=registerfield type="text" name="email">
									<input id=registerfield type="password" name="password">
									
									<input id=registerfield type="text" name="nome">
									<input id=registerfield type="text" name="cognome">
									<input id=registerfield type="date" name="dataNascita">
									
								</div>
							</div>
							<div id=register2>
								<div id=registerattributes>
									<div id="registerattribute">Indirizzo e N° Civico</div>
									<div id="registerattribute">CAP</div>
									<div id="registerattribute">Città</div>
									<div id="registerattribute">Telefono</div>
									<div id="registerattribute">Provincia</div>
									<div id="registerattribute">Nazione</div>
								</div>
								<div id=registerfields>
									<input id=registerfield type="text" name="indirizzo">
									<input id=registerfield type="text" name="cap">
									<input id=registerfield type="text" name="citta">
									<input id=registerfield type="text" name="telefono">
									<select id=registerselectfield name="provincia">
										<option value="Agrigento">Agrigento</option><option value="Alessandria">Alessandria</option><option value="Ancona">Ancona</option><option value="Aosta">Aosta</option><option value="Aquila">Aquila</option><option value="Arezzo">Arezzo</option><option value="Ascoli Piceno">Ascoli Piceno</option><option value="Asti">Asti</option><option value="Avellino">Avellino</option><option value="Bari">Bari</option><option value="Barletta Andria Trani">Barletta Andria Trani</option><option value="Belluno">Belluno</option><option value="Benevento">Benevento</option><option value="Bergamo">Bergamo</option><option value="Biella">Biella</option><option value="Bologna">Bologna</option><option value="Bolzano">Bolzano</option><option value="Brescia">Brescia</option><option value="Brianza">Brianza</option><option value="Brindisi">Brindisi</option><option value="Cagliari">Cagliari</option><option value="Caltanissetta">Caltanissetta</option><option value="Campobasso">Campobasso</option><option value="Caserta">Caserta</option><option value="Catania">Catania</option><option value="Catanzaro">Catanzaro</option><option value="Chieti">Chieti</option><option value="Como">Como</option><option value="Cosenza">Cosenza</option><option value="Cremona">Cremona</option><option value="Crotone">Crotone</option><option value="Cuneo">Cuneo</option><option value="Enna">Enna</option><option value="Fermo">Fermo</option><option value="Ferrara">Ferrara</option><option value="Firenze">Firenze</option><option value="Foggia">Foggia</option><option value="Forlì">Forlì</option><option value="Frosinone">Frosinone</option><option value="Genova">Genova</option><option value="Gorizia">Gorizia</option><option value="Grosseto">Grosseto</option><option value="Imperia">Imperia</option><option value="Isernia">Isernia</option><option value="La Spezia">La Spezia</option><option value="Latina">Latina</option><option value="Lecce">Lecce</option><option value="Lecco">Lecco</option><option value="Livorno">Livorno</option><option value="Lodi">Lodi</option><option value="Lucca">Lucca</option><option value="Macerata">Macerata</option><option value="Mantova">Mantova</option><option value="Massa-Carrara">Massa-Carrara</option><option value="Matera">Matera</option><option value="Messina">Messina</option><option value="Milano">Milano</option><option value="Modena">Modena</option><option value="Monza">Monza</option><option value="Napoli">Napoli</option><option value="Novara">Novara</option><option value="Nuoro">Nuoro</option><option value="Oristano">Oristano</option><option value="Padova">Padova</option><option value="Palermo">Palermo</option><option value="Parma">Parma</option><option value="Pavia">Pavia</option><option value="Perugia">Perugia</option><option value="Pesaro e Urbino">Pesaro e Urbino</option><option value="Pescara">Pescara</option><option value="Piacenza">Piacenza</option><option value="Pisa">Pisa</option><option value="Pistoia">Pistoia</option><option value="Pordenone">Pordenone</option><option value="Potenza">Potenza</option><option value="Prato">Prato</option><option value="Ragusa">Ragusa</option><option value="Ravenna">Ravenna</option><option value="Reggio di Calabria">Reggio di Calabria</option><option value="Reggio Emilia">Reggio Emilia</option><option value="Rieti">Rieti</option><option value="Rimini">Rimini</option><option value="Roma">Roma</option><option value="Rovigo">Rovigo</option><option value="Salerno">Salerno</option><option value="Sassari">Sassari</option><option value="Savona">Savona</option><option value="Siena">Siena</option><option value="Siracusa">Siracusa</option><option value="Sondrio">Sondrio</option><option value="Taranto">Taranto</option><option value="Teramo">Teramo</option><option value="Terni">Terni</option><option value="Torino">Torino</option><option value="Trapani">Trapani</option><option value="Trento">Trento</option><option value="Treviso">Treviso</option><option value="Trieste">Trieste</option><option value="Udine">Udine</option><option value="Varese">Varese</option><option value="Venezia">Venezia</option><option value="Verbania">Verbania</option><option value="Vercelli">Vercelli</option><option value="Verona">Verona</option><option value="Vibo Valentia">Vibo Valentia</option><option value="Vicenza">Vicenza</option><option value="Viterbo">Viterbo</option>
									</select>
									<select id=registerselectfield name="stato">
									<option value="">Selezionare</option><option value="Afghanistan">Afghanistan</option><option value="Albania">Albania</option><option value="Algeria">Algeria</option><option value="American Samoa">American Samoa</option><option value="Andorra">Andorra</option><option value="Angola">Angola</option><option value="Anguilla">Anguilla</option><option value="Antarctica">Antarctica</option><option value="Antigua and Barbuda">Antigua and Barbuda</option><option value="Argentina">Argentina</option><option value="Armenia">Armenia</option><option value="Aruba">Aruba</option><option value="Australia">Australia</option><option value="Austria">Austria</option><option value="Azerbaijan">Azerbaijan</option><option value="Bahamas">Bahamas</option><option value="Bahrain">Bahrain</option><option value="Bangladesh">Bangladesh</option><option value="Barbados">Barbados</option><option value="Belarus">Belarus</option><option value="Belgium">Belgium</option><option value="Belize">Belize</option><option value="Benin">Benin</option><option value="Bermuda">Bermuda</option><option value="Bhutan">Bhutan</option><option value="Bolivia">Bolivia</option><option value="Bosnia and Herzegowina">Bosnia and Herzegowina</option><option value="Botswana">Botswana</option><option value="Bouvet Island">Bouvet Island</option><option value="Brazil">Brazil</option><option value="British Indian Ocean Territory">British Indian Ocean Territory</option><option value="Brunei Darussalam">Brunei Darussalam</option><option value="Bulgaria">Bulgaria</option><option value="Burkina Faso">Burkina Faso</option><option value="Burundi">Burundi</option><option value="Cambodia">Cambodia</option><option value="Cameroon">Cameroon</option><option value="Canada">Canada</option><option value="Cape Verde">Cape Verde</option><option value="Cayman Island">Cayman Islands</option><option value="Central African Republic">Central African Republic</option><option value="Chad">Chad</option><option value="Chile">Chile</option><option value="China">China</option><option value="Christmas Island">Christmas Island</option><option value="Cocos (Keeling) Islands">Cocos (Keeling) Islands</option><option value="Colombia">Colombia</option><option value="Comoros">Comoros</option><option value="Congo">Congo</option><option value="Cook Islands">Cook Islands</option><option value="Costa Rica">Costa Rica</option><option value="Croazia">Croazia</option><option value="Cuba">Cuba</option><option value="Cyprus">Cyprus</option><option value="Czech Republic">Czech Republic</option><option value="Denmark">Denmark</option><option value="Djibouti">Djibouti</option><option value="Dominica">Dominica</option><option value="Dominican Republic">Dominican Republic</option><option value="East Timor">East Timor</option><option value="Ecuador">Ecuador</option><option value="Egypt">Egypt</option><option value="El Salvador">El Salvador</option><option value="Equatorial Guinea">Equatorial Guinea</option><option value="Eritrea">Eritrea</option><option value="Estonia">Estonia</option><option value="Ethiopia">Ethiopia</option><option value="Falkland Islands (Malvinas)">Falkland Islands (Malvinas)</option><option value="Faroe Islands">Faroe Islands</option><option value="Fiji">Fiji</option><option value="Finland">Finland</option><option value="France">France</option><option value="France, Metropolitan">France, Metropolitan</option><option value="French Guiana">French Guiana</option><option value="French Polynesia">French Polynesia</option><option value="French Southern Territories">French Southern Territories</option><option value="Gabon">Gabon</option><option value="Gambia">Gambia</option><option value="Georgia">Georgia</option><option value="Germany">Germany</option><option value="Ghana">Ghana</option><option value="Gibraltar">Gibraltar</option><option value="Greece">Greece</option><option value="Greenland">Greenland</option><option value="Grenada">Grenada</option><option value="Guadeloupe">Guadeloupe</option><option value="Guam">Guam</option><option value="Guatemala">Guatemala</option><option value="Guinea">Guinea</option><option value="Guinea-bissau">Guinea-bissau</option><option value="Guyana">Guyana</option><option value="Haiti">Haiti</option><option value="Heard and Mc Donald Islands">Heard and Mc Donald Islands</option><option value="Honduras">Honduras</option><option value="Hong Kong">Hong Kong</option><option value="Hungary">Hungary</option><option value="Iceland">Iceland</option><option value="India">India</option><option value="Indonesia">Indonesia</option><option value="Iran (Islamic Republic of)">Iran (Islamic Republic of)</option><option value="Iraq">Iraq</option><option value="Ireland">Ireland</option><option value="Israel">Israel</option><option value="Italy" SELECTED>Italy</option><option value="Jamaica">Jamaica</option><option value="Japan">Japan</option><option value="Jordan">Jordan</option><option value="Kazakihstan">Kazakihstan</option><option value="Kenya">Kenya</option><option value="Kiribati">Kiribati</option><option value="Korea, Democratic Peoples Republic of">Korea, Democratic Peoples Republic of</option><option value="Korea, Republic of">Korea, Republic of</option><option value="Kuwait">Kuwait</option><option value="Kyrgyzstan">Kyrgyzstan</option><option value="Lao Peoples Democratic Republic">Lao Peoples Democratic Republic</option><option value="Latvia">Latvia</option><option value="Lebanon">Lebanon</option><option value="Lesotho">Lesotho</option><option value="Liberia">Liberia</option><option value="Libyan Arab Jamahiriya">Libyan Arab Jamahiriya</option><option value="Liechtenstein">Liechtenstein</option><option value="Lithuania">Lithuania</option><option value="Luxembourg">Luxembourg</option><option value="Macau">Macau</option><option value="Macedonia, The Former Yugoslav Republic of">Macedonia, The Former Yugoslav Republic of</option><option value="Madagascar">Madagascar</option><option value="Malawi">Malawi</option><option value="Malaysia">Malaysia</option><option value="Maldives">Maldives</option><option value="Mali">Mali</option><option value="Malta">Malta</option><option value="Marshall Islands">Marshall Islands</option><option value="Martinique">Martinique</option><option value="Mauritania">Mauritania</option><option value="Mauritius">Mauritius</option><option value="Mayotte">Mayotte</option><option value="Mexico">Mexico</option><option value="Micronesia, Federated States of">Micronesia, Federated States of</option><option value="Moldova, Republic of">Moldova, Republic of</option><option value="Monaco">Monaco</option><option value="Mongolia">Mongolia</option><option value="Montserrat">Montserrat</option><option value="Morocco">Morocco</option><option value="Mozambique">Mozambique</option><option value="Myanmar">Myanmar</option><option value="Namibia">Namibia</option><option value="Nauru">Nauru</option><option value="Nepal">Nepal</option><option value="Netherlands">Netherlands</option><option value="Netherlands Antilles">Netherlands Antilles</option><option value="New Caledonia">New Caledonia</option><option value="New Zealand">New Zealand</option><option value="Nicaragua">Nicaragua</option><option value="Niger">Niger</option><option value="Nigeria">Nigeria</option><option value="Niue">Niue</option><option value="Norfolk Island">Norfolk Island</option><option value="Northern Mariana Islands">Northern Mariana Islands</option><option value="Norway">Norway</option><option value="Oman">Oman</option><option value="Pakistan">Pakistan</option><option value="Palau">Palau</option><option value="Panama">Panama</option><option value="Papua New Guinea">Papua New Guinea</option><option value="Paraguay">Paraguay</option><option value="Peru">Peru</option><option value="Philippines">Philippines</option><option value="Pitcairn">Pitcairn</option><option value="Poland">Poland</option><option value="Portugal">Portugal</option><option value="Puerto Rico">Puerto Rico</option><option value="Qatar">Qatar</option><option value="Reunion">Reunion</option><option value="Romania">Romania</option><option value="Russian Federation">Russian Federation</option><option value="Rwanda">Rwanda</option><option value="Saint Kitts and Nevis">Saint Kitts and Nevis</option><option value="Saint Lucia">Saint Lucia</option><option value="Saint Vincent and the Grenadines">Saint Vincent and the Grenadines</option><option value="Samoa">Samoa</option><option value="San Marino">San Marino</option><option value="Sao Tome and Principe">Sao Tome and Principe</option><option value="Saudi Arabia">Saudi Arabia</option><option value="Senegal">Senegal</option><option value="Seychelles">Seychelles</option><option value="Sierra Leone">Sierra Leone</option><option value="Singapore">Singapore</option><option value="Slovakia">Slovakia (Slovak Republic)</option><option value="Slovenia">Slovenia</option><option value="Solomon Islands">Solomon Islands</option><option value="Somalia">Somalia</option><option value="South Africa">South Africa</option><option value="Spain">Spain</option><option value="Sri Lanka">Sri Lanka</option><option value="St. Helena">St. Helena</option><option value="St. Pierre and Miquelon">St. Pierre and Miquelon</option><option value="Sudan">Sudan</option><option value="Suriname">Suriname</option><option value="Svalbard and Jan Mayen Islands">Svalbard and Jan Mayen Islands</option><option value="Swaziland">Swaziland</option><option value="Sweden">Sweden</option><option value="Switzerland">Switzerland</option><option value="Syrian Arab Republic">Syrian Arab Republic</option><option value="Taiwan">Taiwan</option><option value="Tajikistan">Tajikistan</option><option value="Tanzania">Tanzania, United Republic of</option><option value="Thailand">Thailand</option><option value="Togo">Togo</option><option value="Tokelau">Tokelau</option><option value="Tonga">Tonga</option><option value="Trinidad and Tobago">Trinidad and Tobago</option><option value="Tunisia">Tunisia</option><option value="Turkey">Turkey</option><option value="Turkmenistan">Turkmenistan</option><option value="Turks and Caicos Islands">Turks and Caicos Islands</option><option value="Tuvalu">Tuvalu</option><option value="Uganda">Uganda</option><option value="Ukraine">Ukraine</option><option value="United Aran Emirates">United Arab Emirates</option><option value="United Kingdom">United Kingdom</option><option value="United States">United States</option><option value="Uruguay">Uruguay</option><option value="Uzbekistan">Uzbekistan</option><option value="Vanuatu">Vanuatu</option><option value="Vaticano">Vatican City State (Holy See)</option><option value="Venezuela">Venezuela</option><option value="Vietnam">Vietnam</option><option value="Virgin Islands">Virgin Islands (British)</option><option value="Virgin Islands (U.S)">Virgin Islands (U.S.)</option><option value="Wallis and Futuna Islands">Wallis and Futuna Islands</option><option value="Western Sahara">Western Sahara</option><option value="Yemen">Yemen</option><option value="Yugoslavia">Yugoslavia</option><option value="Zaire">Zaire</option><option value="Zambia">Zambia</option><option value="Zimbabwe">Zimbabwe</option>
									</select>
								</div>
							</div>
							<h4>Consenso al trattamento dei dati personali</h4>
							<p id="registerterms">
								I dati personali sono raccolti con la finalita' di registrare il cliente ed attivare nei suoi confronti le procedure per l'esecuzione del contratto e le relative necessarie comunicazioni; tali dati sono trattati elettronicamente nel rispetto delle leggi vigenti e potranno essere esibiti soltanto su richiesta della autorita' giudiziaria ovvero di altre autorita' all'uopo per legge autorizzante. L'interessato gode dei diritti di cui all'art. 7 d. lgs. 196/2003, e cioè: di chiedere conferma della esistenza presso la sede di t3k-shop dei propri dati personali; di conoscere la loro origine, la logica e le finalità del loro trattamento; di ottenere l'aggiornamento, la rettifica, e l'integrazione; di chiederne la cancellazione, la trasformazione in forma anonima o il blocco in caso di trattamento illecito; di opporsi al loro trattamento per motivi legittimi o nel caso di utilizzo dei dati per invio di materiale pubblicitario, informazioni commerciali, ricerche di mercato, di vendita diretta e di comunicazione commerciale interattiva. L'ottenimento della cancellazione dei propri dati personali e' subordinato all'invio di una comunicazione scritta inviata tramite fax (0226684755) o spedizione postale alla sede della societa'. Titolare alla raccolta dei dati personali e' t3k-shop via Leonardo da Vinci, 22 83040 Conza della Campania (AV).
								<br><br>t3k-shop garantisce che ogni informazione fornita a fini promozionali verrà trattata in conformità al Decreto LGS. 196/2003. t3k-shop comunica inoltre che ai sensi del decreto Lgs. 196/2003 i dati degli utenti forniti al momento della sottoscrizione dell'ordine di acquisto e/o della compilazione della fattura sono esclusi dal consenso dell'interessato in quanto raccolti in base agli obblighi fiscali/tributari previsti dalla legge, dai regolamenti e dalla normativa comunitaria e, in ogni caso, al solo fine di consentire degli obblighi derivanti dal contratto di acquisto cui e' parte interessato e/o per l'acquisizione delle necessarie informative contrattuali sempre ed esclusivamente attivate su richiesta di quest'ultimo (Art. 24, Lett. A e B, D. LGS. 196/2003).
							</p>
							
							<p id=acceptterms><input type="checkbox" id="termsagree" name="termsagree" value="termsagree">Accetto le indicazioni sul trattamento dei miei dati personali indicate</p>
							<input type="submit" name="Invia" value="Conferma e registrati">
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
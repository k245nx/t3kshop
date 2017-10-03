//effetto brand
$(document).ready(function(){
	$("*#brand").hover(function(){
		$(this).css("border","1px dashed #0075ab");
	},function(){
		$(this).css({
			"display": "inline-block",
			"height":"100px",
			"width": "100px",
			"margin": "5px",
			"margin-left": "5px",
			"margin-bottom": "5px",
			"border": "1px dotted gray",
		});
	});
});



//effetto navigationbar
$(document).ready(function(){
	 $("nav ul li a").hover(function(){
		 $(this).css({"background-image":"url(images/navbuttons/buttonactive.png)"});
	 }, function(){
		 $(this).css({"background-image":"url(images/navbuttons/buttonNOTactive.png)"});
	 });
});


//effetto bordo prodotti
$(document).ready(function(){
	 $("*#productPic").hover(function(){
		 $(this).css({"border":"1px dashed #0075ab"});
	 },
	 function(){
		 $(this).css({"border":"1px solid #D3D3D3"});
	 });
	
});

// lunghezza dinamica
$(document).ready(function(){
	// lunghezza iniziale
	var lenght = $("#navigationbar").outerHeight(true) + $("#adaptivesection").outerHeight(true) + $("#searchsection").outerHeight(true) + $("#internalsection").outerHeight(true)*2 + $("#squaresection1").outerHeight(true);
	if($("#squaresection1").css("padding-bottom")=="10px"){
		lenght += $("#squaresection2").outerHeight(true);
	}
	if($("#categoriesresponsive").css("display")=="block"){
		lenght += $("#categoriesresponsive").outerHeight(true);
	}
	if(lenght<850 && !($("#categoriesresponsive").css("display")=="block"))
		lenght = 850;
	$("#centralblock").css("height", lenght+"px");
});

//lunghezza al ridimensionare della finestra
$(window).on('resize', function(){
	var lenght = $("#navigationbar").outerHeight(true) + $("#adaptivesection").outerHeight(true) + $("#searchsection").outerHeight(true) + $("#internalsection").outerHeight(true)*2 + $("#squaresection1").outerHeight(true);
	if($("#squaresection1").css("padding-bottom")=="10px"){
		lenght += $("#squaresection2").outerHeight(true);
	}
	if($("#categoriesresponsive").css("display")=="block"){
		lenght += $("#categoriesresponsive").outerHeight(true);
	}
	if(lenght<850 && !($("#categoriesresponsive").css("display")=="block"))
		lenght = 850;
	$("#centralblock").css("height", lenght+"px");
});
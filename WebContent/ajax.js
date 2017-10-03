$(document).ready(function(){
	$('#idSelector').change( function() {
		$.post("ProductInfo", 'id=' + $("#idSelector").val(),
		function(data, textStatus, jqXHR){
			var obj = JSON.parse(data);
			$('#idfield').attr('value', obj.id);
			$('#nomefield').attr('value', obj.nome);
			$('#modellofield').attr('value', obj.modello);
			$('#marcafield').attr('value', obj.marca);
			$('#categoriafield').attr('value', obj.categoria);
			$('#brevedescrizionefield').attr('value', obj.breveDescrizione);
			$('#quantitafield').attr('value', obj.quantita);
			$('#prezzofield').attr('value', obj.prezzo);
		});
	});
	$('#idSelector').change( function() {
		$.post("ProductDesc", 'id=' + $("#idSelector").val(),
		function(data, textStatus, jqXHR){
			$('#descrizionefield').attr('value', data);
		});
	});
});

	
function renderTemplate(ctx){
	console.log(ctx);
	var source   = $("#resultsTemplate").html();
	var template = Handlebars.compile(source);
	$.ajax({
		   url: ctx+'/rest/v1/clients',
		   error: function() {
		      $('#resultsDiv').html('<p>An error has occurred</p>');
		   },
		   success: function(data) {
			   var html = template(data);
				$('#resultsDiv').html(html);
		   },
		   type: 'GET'
		});
	
}
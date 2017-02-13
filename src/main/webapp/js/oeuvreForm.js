$("#etatSpan").css('display', 'none');
$("#prixSpan").css('display', 'none');
$("#selectType").change(function(){
	if($("#selectType").val() == "loan")
	{
		$("#etatSpan").css('display', 'none');
		$("#prixSpan").css('display', 'none');
	}
	else
	{
		$("#etatSpan").css('display', 'inline');
		$("#prixSpan").css('display', 'inline');
	}
});
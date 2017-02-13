<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<jsp:include page="../layout/head.jsp"></jsp:include>
	<body>
		<jsp:include page="../layout/nav.jsp"></jsp:include>
		<h1 class="Tcenter josefin"> Ajout d'un adhérent </h1> 
	
		<div class="pageinner Tleft">
			<form  name='identification' method="post" action="AdherentController?action=insertOrUpdate" onsubmit="return teste()">
				<span class="col-xs-6 col-xs-offset-3 noPadding mTop2em">
				    <input class="col-xs-12 inputStyle noOutline input-customPlaceholder" type="text" name="lastname" 
				    	value="" placeholder="Nom" id ="name" customplaceholder="0" autocomplete="off" required>
			    </span>
			    <span class="col-xs-6 col-xs-offset-3 noPadding mTop2em">
			        <input class="col-xs-12 inputStyle noOutline input-customPlaceholder" type="text" name="firstname"
			        	placeholder="Prénom" id ="firstname" customplaceholder="0" autocomplete="off" required>
		        </span>
		        <span class="col-xs-6 col-xs-offset-3 noPadding mTop2em">
				  <input class="col-xs-12 inputStyle noOutline input-customPlaceholder" type="text" name="city"
					placeholder="Ville" id ="city" customplaceholder="0" autocomplete="off" required>	 
			    </span>         
		        <button type="submit" name="bt" class="btn btn-expo col-xs-6 col-xs-offset-3 mTop2em" > 
		        	<span class="glyphicon glyphicon-ok"></span> Ajouter
		        </button>
			</form>
			<a class="aStyle col-xs-4 col-xs-offset-4 Tcenter" href="AdherentController?action=list"><span class="glyphicon glyphicon-remove"></span> Retour à la liste</a>
		</DIV>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</body>
</html>
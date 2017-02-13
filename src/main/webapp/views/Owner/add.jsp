<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<jsp:include page="../layout/head.jsp"></jsp:include>


	<body>
		<jsp:include page="../layout/nav.jsp"></jsp:include>
		<h1 class="Tcenter josefin"> Ajout d'un propriétaire </h1> 
		
		<div class="pageinner Tleft">
			<form  name='owner' method="post" action="OwnerController?action=insertOrUpdate" onsubmit="return teste()">
			    <span class="col-xs-6 col-xs-offset-3 noPadding mTop2em">
				    <input class="col-xs-12 inputStyle noOutline input-customPlaceholder" type="text" name="firstname" 
				    	value="" placeholder="Prénom" id ="firstname" customplaceholder="0" autocomplete="off" required>
			    </span>
			    <span class="col-xs-6 col-xs-offset-3 noPadding mTop2em">
				    <input class="col-xs-12 inputStyle noOutline input-customPlaceholder" type="text" name="lastname" 
				    	value="" placeholder="Nom" id ="lastname" customplaceholder="0" autocomplete="off" required>
			    </span>
		        <input type="submit" name="bt"  value="Ajouter" class="btn btn-expo col-xs-6 col-xs-offset-3 mTop2em" > 
			</form>
			<a class="aStyle col-xs-4 col-xs-offset-4 Tcenter" href="OwnerController?action=list">Retour à la liste</a>
		</div>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
		<script type="text/javascript" src="js/oeuvreForm.js"></script>
	</body>
</html>
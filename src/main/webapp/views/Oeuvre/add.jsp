<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<jsp:include page="../layout/head.jsp"></jsp:include>


	<body>
		<jsp:include page="../layout/nav.jsp"></jsp:include>
		<h1 class="Tcenter josefin"> Ajout d'une oeuvre </h1> 
		
		<div class="pageinner Tleft">
			<form  name='oeuvre' method="post" action="OeuvreController?action=insertOrUpdate" onsubmit="return teste()">
				<span class="col-xs-6 col-xs-offset-3 noPadding mTop2em">
					<span class="customPlaceHolder">Type d'oeuvre</span>
				    <select id="selectType" class="col-xs-12 inputStyle noOutline" name="type" id ="type">
				    	<option value="loan">Oeuvre en prêt</option>
				    	<option value="sell">Oeuvre en vente</option>
				    </select>
			    </span>
			    <span class="col-xs-6 col-xs-offset-3 noPadding mTop2em">
				    <input class="col-xs-12 inputStyle noOutline input-customPlaceholder" type="text" name="title" 
				    	value="" placeholder="Nom de l'oeuvre" id ="title" customplaceholder="0" autocomplete="off" required>
			    </span>
			    <span class="col-xs-6 col-xs-offset-3 noPadding mTop2em">
					<span class="customPlaceHolder">Propriétaire</span>
				    <select class="col-xs-12 inputStyle noOutline" name="owner" id ="owner">
			    		<c:forEach items="${owners}" var="owner">
			    			<option value="${owner.id}">${owner.firstname} ${owner.lastname} (${owner.id})</option>
			    		</c:forEach>
				    </select>
			    </span>
			     <span id="etatSpan" class="col-xs-6 col-xs-offset-3 noPadding mTop2em">
					<span class="customPlaceHolder">Etat</span>
				    <select class="col-xs-12 inputStyle noOutline" name="condition" id ="condition">
			    		<option value="L">L</option>
			    		<option value="R">R</option>
				    </select>
			    </span>
			    <span id="prixSpan" class="col-xs-6 col-xs-offset-3 noPadding mTop2em">
				    <input class="col-xs-12 inputStyle noOutline input-customPlaceholder" type="number" name="price" 
				    	value="" placeholder="Prix" id ="price" customplaceholder="0" autocomplete="off" step="0.01">
			    </span>
		        <input type="submit" name="bt"  value="Ajouter" class="btn btn-expo col-xs-6 col-xs-offset-3 mTop2em" > 
			</form>
			<a class="aStyle col-xs-4 col-xs-offset-4 Tcenter" href="OeuvreController?action=listSell">Retour à la liste</a>
		</div>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
		<script type="text/javascript" src="js/oeuvreForm.js"></script>
	</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<jsp:include page="../layout/head.jsp"></jsp:include>


	<body>
		<jsp:include page="../layout/nav.jsp"></jsp:include>
		<h1 class="Tcenter josefin"> Suppression d'un propriétaire </h1> 
	
		<div class="pageinner Tleft">
			<div class="col-xs-10 col-xs-offset-1 noPadding Tcenter">
				<p class="Dinline">Êtes-vous sur de vouloir supprimer le propriétaire</p>
				<p class="uppercase Dinline">${owner.lastname}</p>
				<p class="capitalize Dinline">${owner.firstname}</p>
				<p class="Dinline">?</p>
			</div>
			<div class="col-xs-10 col-xs-offset-1">
				<c:if test="${fn:length(loanOeuvres)>0}">
					Oeuvres en prêt allant être supprimées :<br/>
					<ul>
						<c:forEach items="${loanOeuvres}" var="loanOeuvre">
							<li>${loanOeuvre.title}</li>
						</c:forEach>
					</ul><br/>
				</c:if>
				<c:if test="${fn:length(sellOeuvres)>0}">
					Oeuvres en vente allant être supprimées :<br/>
					<ul>
						<c:forEach items="${sellOeuvres}" var="sellOeuvre">
							<li>${sellOeuvre.title}</li>
						</c:forEach>
					</ul><br/>
				</c:if>
			</div>
			<a class="aStyle col-xs-4 col-xs-offset-4 Tcenter btn btn-expo" href="OwnerController?action=delete&id=${owner.id}"><span class="glyphicon glyphicon-ok"></span> Confirmer la suppression</a>
			<a class="aStyle col-xs-4 col-xs-offset-4 Tcenter" href="OwnerController?action=list"><span class="glyphicon glyphicon-remove"></span> Retour à la liste</a>
		</DIV>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<jsp:include page="../layout/head.jsp"></jsp:include>


	<body>
		<jsp:include page="../layout/nav.jsp"></jsp:include>
		<h1 class="Tcenter josefin">
			Détails de ${owner.firstname} ${owner.lastname}
			<br/>
			<a class="glyphicon glyphicon-edit DiBlock aStyle" href="OwnerController?action=edit&id=${owner.id}"></a>
            <a class="fa fa-user-times col-xs-offset-1 aStyle" href="OwnerController?action=deleteConfirmation&id=${owner.id}"></a>
		</h1> 
	
		<div class="pageinner Tleft jumbotron">
			<c:if test="${not empty loanOeuvres}">
				<p>Oeuvres en prêt possédées :</p><br/>
				<table class="col-xs-12 noPadding">
					<tbody class="col-xs-12 noPadding">
						<c:forEach items="${loanOeuvres}" var="oeuvre">
							<tr class="col-xs-12 noPadding">
								<td class="col-xs-12 Tcenter">
									${oeuvre.title} (${oeuvre.id})
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${not empty sellOeuvres}">
				<p>Oeuvres en vente possédées :</p><br/>
				<table class="col-xs-12 noPadding">
					<tbody class="col-xs-12 noPadding">
						<c:forEach items="${sellOeuvres}" var="oeuvre">
							<tr class="col-xs-12 noPadding">
								<td class="col-xs-12 Tcenter">
									<a class="glyphicon glyphicon-book aStyle" href="OeuvreController?action=sellDetails&id=${oeuvre.id}"></a>
									${oeuvre.title} (${oeuvre.id})
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<br/>
			<h4>
				<a class="aStyle col-xs-4 col-xs-offset-4 Tcenter mTop2em" href="OwnerController?action=list">
					<i class="fa fa-list"></i>
					Liste des propriétaires
				</a>
			</h4>
		</div>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</body>
</html>
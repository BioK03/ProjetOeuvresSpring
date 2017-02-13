<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<jsp:include page="../layout/head.jsp"></jsp:include>
	<body>
		<jsp:include page="../layout/nav.jsp"></jsp:include>
		<c:set var="menu" scope="session" value="sell"/>
		<jsp:include page="../General/oeuvreMenu.jsp"></jsp:include>
		<h1 class="Tcenter josefin col-xs-4 col-xs-offset-4 noPadding">Listing des oeuvres en vente</h1>
		<h1>
			<a class="col-xs-1 aStyle Tcenter" href="OeuvreController?action=add">
				<span class="glyphicon glyphicon-plus"></span>
			</a>
		</h1>
		<div class="pageinner jumbotron">
			<table class="tablePerso Tcenter tableList">
				<tr class="col-xs-12 noPadding josefin">
					<th class="col-xs-1 DiBlock noPadding Tcenter">NUMERO</th>
					<th class="col-xs-3 DiBlock noPadding Tcenter">TITRE</th>
					<th class="col-xs-2 DiBlock noPadding Tcenter">ETAT</th>
					<th class="col-xs-2 DiBlock noPadding Tcenter">PRIX</th>
					<th class="col-xs-3 DiBlock noPadding Tcenter">PROPRIETAIRE</th>
					<th class="col-xs-1 DiBlock noPadding Tcenter"></th>
				</tr>
		
				<c:forEach items="${sellOeuvres}" var="oeuvre">
					<tr class="col-xs-12 noPadding">
						<td class="col-xs-1 DiBlock noPadding">
							<a class="aStyle" href="OeuvreController?action=sellDetails&id=${oeuvre.id}">
								<span class="glyphicon glyphicon-book"></span>
							</a>
							${oeuvre.id}
						</td>
						<td class="col-xs-3 DiBlock noPadding">${oeuvre.title}</td>
						<td class="col-xs-2 DiBlock noPadding">${oeuvre.condition}</td>
		                <td class="col-xs-2 DiBlock noPadding"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${oeuvre.price}"/> €</td>
		                <td class="col-xs-3 DiBlock noPadding">${oeuvre.owner.lastname} ${oeuvre.owner.firstname} (${oeuvre.owner.id})</td>
		                <td class="col-xs-1 DiBlock noPadding">
		                	<a class="glyphicon glyphicon-edit col-xs-6 noPadding DiBlock aStyle" href="OeuvreController?action=edit&id=${oeuvre.id}&type=sell"></a>
		                	<a class="glyphicon glyphicon-remove col-xs-6 noPadding DiBlock aStyle" href="OeuvreController?action=deleteConfirmation&id=${oeuvre.id}"></a>
		                </td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</body>
</html>
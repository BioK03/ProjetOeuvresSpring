<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<jsp:include page="../layout/head.jsp"></jsp:include>
	<body>
		<jsp:include page="../layout/nav.jsp"></jsp:include>
		<h1 class="Tcenter josefin col-xs-4 col-xs-offset-4 noPadding">Listing des Adhérents</h1>
		<h1>
			<a class="col-xs-1 aStyle Tcenter" href="AdherentController?action=add">
				<i class="fa fa-user-plus"></i>
			</a>
		</h1>
		<div class="pageinner jumbotron">
			<table class="tablePerso Tcenter tableList">
				<tr class="col-xs-12 noPadding josefin">
					<th class="col-xs-2 DiBlock noPadding Tcenter">NUMERO</th>
					<th class="col-xs-3 DiBlock noPadding Tcenter">NOM</th>
					<th class="col-xs-3 DiBlock noPadding Tcenter">PRENOM</th>
					<th class="col-xs-3 DiBlock noPadding Tcenter">VILLE</th>
					<th class="col-xs-1 DiBlock noPadding Tcenter"></th>
				</tr>
		
				<c:forEach items="${adherents}" var="adherent">
					<tr class="col-xs-12 noPadding">
						<td class="col-xs-2 DiBlock noPadding">
							<a class="aStyle" href="AdherentController?action=details&id=${adherent.id}">
								<i class="fa fa-user"></i>
							</a>
							${adherent.id}
						</td>
						<td class="col-xs-3 DiBlock noPadding">${adherent.lastname}</td>
						<td class="col-xs-3 DiBlock noPadding">${adherent.firstname}</td>
		                <td class="col-xs-3 DiBlock noPadding">${adherent.city}</td>
		                <td class="col-xs-1 DiBlock noPadding">
		                	<a class="glyphicon glyphicon-edit col-xs-6 noPadding DiBlock aStyle" href="AdherentController?action=edit&id=${adherent.id}"></a>
		                	<a class="fa fa-user-times col-xs-6 noPadding DiBlock aStyle" href="AdherentController?action=deleteConfirmation&id=${adherent.id}"></a>
		                </td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</body>
</html>
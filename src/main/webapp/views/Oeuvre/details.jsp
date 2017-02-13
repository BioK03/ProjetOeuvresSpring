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
			Détails de ${oeuvre.title}
			<br/>
			<a class="glyphicon glyphicon-edit noPadding DiBlock aStyle" href="OeuvreController?action=edit&id=${oeuvre.id}&type=sell"></a>
            <a class="glyphicon glyphicon-remove col-xs-offset-1 noPadding DiBlock aStyle" href="OeuvreController?action=deleteConfirmation&id=${oeuvre.id}"></a>
		</h1>
		
		<div class="pageinner jumbotron">
			<span class="col-xs-6">Numéro: ${oeuvre.id}</span>
			<span class="col-xs-6">Etat: ${oeuvre.condition}</span>
			<span class="col-xs-6">Prix: <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${oeuvre.price}"/> €</span>
			<span class="col-xs-6">Propriétaire: ${oeuvre.owner.firstname} ${oeuvre.owner.lastname}</span>
			<c:if test="${not empty bookings}">
				<h4 class="Tcenter josefin col-xs-12">Réservations</h4>
				<table class="col-xs-12 noPadding mTop2em tableExpo">
					<tbody class="col-xs-12 noPadding">
						<tr class="col-xs-12 noPadding josefin">
							<th class="col-xs-4 noPadding Tcenter">ADHERENT</th>
							<th class="col-xs-2 noPadding Tcenter">DATE</th>
							<th class="col-xs-3 noPadding Tcenter">STATUT</th>
						</tr>
						<c:forEach items="${bookings}" var="booking">
							<tr class="col-xs-12 noPadding">
								<td class="col-xs-4 noPadding Tcenter">
									<a class="aStyle" href="AdherentController?action=details&id=${booking.adherent.id}">
										<span class="glyphicon glyphicon-user"></span>
									</a>
									${booking.adherent.firstname} ${booking.adherent.lastname} (${booking.adherent.id})
								</td>
								<td class="col-xs-2 noPadding Tcenter"><fmt:formatDate value="${booking.date}" pattern="dd/MM/yyyy" /></td>
								<td class="col-xs-3 noPadding Tcenter">${booking.status}</td>
								<td class="col-xs-3">
									<a class="glyphicon glyphicon-edit col-xs-6 DiBlock aStyle" href="BookingController?action=edit&oeuvreId=${booking.sellOeuvre.id}&adherentId=${booking.adherent.id}"></a>
	            					<a class="glyphicon glyphicon-remove col-xs-6 aStyle" href="BookingController?action=deleteConfirmation&oeuvreId=${booking.sellOeuvre.id}&adherentId=${booking.adherent.id}"></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${empty bookings}">
				<h4>Pas encore de réservations</h4>
			</c:if>
			<h4>
				<a class="aStyle col-xs-4 Tcenter mTop2em" href="OeuvreController?action=listSell">
					<i class="fa fa-list"></i>
					Liste des oeuvres en vente
				</a>
				<a class="aStyle col-xs-4 col-xs-offset-4 Tcenter mTop2em" href="BookingController?action=add&returnPage=selloeuvre&id=${oeuvre.id}">
					<i class="fa fa-bookmark"></i>
					Réservez cette oeuvre !
				</a>
			</h4>
		</div>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</body>
</html>
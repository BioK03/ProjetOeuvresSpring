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
			Détails de ${adherent.firstname} ${adherent.lastname}
			<br/>
			<a class="glyphicon glyphicon-edit DiBlock aStyle" href="AdherentController?action=edit&id=${adherent.id}"></a>
            <a class="fa fa-user-times col-xs-offset-1 aStyle" href="AdherentController?action=deleteConfirmation&id=${adherent.id}"></a>
		</h1> 
	
		<div class="pageinner Tleft jumbotron">
			<p class="Tcenter">Ville : ${adherent.city}</p><br/>
			<c:if test="${not empty bookings}">
				<p class="Tcenter">Oeuvres réservées :</p><br/>
				<table class="col-xs-12 noPadding tableExpo">
					<tbody class="col-xs-12 noPadding">
						<tr class="col-xs-12 noPadding josefin">
							<th class="col-xs-4 Tcenter">OEUVRE</th>
							<th class="col-xs-2 Tcenter">DATE</th>
							<th class="col-xs-3 Tcenter">STATUT</th>
						</tr>
						<c:forEach items="${bookings}" var="booking">
							<tr class="col-xs-12 noPadding">
								<td class="col-xs-4 Tcenter">
									<a class="aStyle" href="OeuvreController?action=sellDetails&id=${booking.sellOeuvre.id}">
										<span class="glyphicon glyphicon-book"></span>
									</a>
									${booking.sellOeuvre.title} (${booking.sellOeuvre.id})
								</td>
								<td class="col-xs-2 Tcenter"><fmt:formatDate value="${booking.date}" pattern="dd/MM/yyyy" /></td>
								<td class="col-xs-3 Tcenter">${booking.status}</td>
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
				<h4 class="Tcenter">Pas encore de réservations</h4>
			</c:if>
			<br/>
			<h4>
				<a class="aStyle col-xs-4 Tcenter mTop2em" href="AdherentController?action=list">
					<i class="fa fa-list"></i>
					Liste des adéhrents
				</a>
				<a class="aStyle col-xs-4 col-xs-offset-4 Tcenter mTop2em" href="BookingController?action=add&returnPage=adherent&id=${adherent.id}">
					<i class="fa fa-bookmark"></i>
					Réservez avec cet adhérent !
				</a>
			</h4>
		</div>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</body>
</html>
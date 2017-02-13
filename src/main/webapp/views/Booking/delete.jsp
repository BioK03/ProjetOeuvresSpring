<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<jsp:include page="../layout/head.jsp"></jsp:include>


	<body>
		<jsp:include page="../layout/nav.jsp"></jsp:include>
		<h1 class="Tcenter josefin"> Suppression d'une réservation</h1> 
	
		<div class="pageinner Tleft">
			<div class="col-xs-10 col-xs-offset-1 noPadding Tcenter">
				<p class="Dinline">
					Êtes-vous sur de vouloir supprimer cette réservation ?<br/>
					<p class="Dinline">Adhérent : </p>
					<p class="uppercase Dinline">${booking.adherent.lastname}</p>
					<p class="capitalize Dinline">${booking.adherent.firstname}</p><br/>
					<p class="Dinline">Oeuvre : </p>
					<p class="capitalize Dinline">${booking.sellOeuvre.title}</p>
					<p>Date : ${booking.date}</p>
					
				</p>
				
			</div>
			<a class="aStyle col-xs-4 col-xs-offset-4 Tcenter btn btn-expo" href="BookingController?action=delete&oeuvreId=${booking.sellOeuvre.id}&adherentId=${booking.adherent.id}">
				<span class="glyphicon glyphicon-ok"></span> Confirmer la suppression
			</a>
			<a class="aStyle col-xs-4 col-xs-offset-4 Tcenter" href="OeuvreController?action=sellDetails&id=${booking.sellOeuvre.id}"><span class="glyphicon glyphicon-remove"></span> Aller à l'oeuvre</a>
			<a class="aStyle col-xs-4 col-xs-offset-4 Tcenter" href="AdherentController?action=details&id=${booking.adherent.id}"><span class="glyphicon glyphicon-remove"></span> Aller à l'adhérent</a>
		</DIV>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</body>
</html>
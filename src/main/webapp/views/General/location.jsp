<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<jsp:include page="../layout/head.jsp"></jsp:include>
	<link rel="stylesheet" href="lib/leaflet/leaflet.css"/>

	<body>
		<jsp:include page="../layout/nav.jsp"></jsp:include>
		<div class="container">
			<h1 class="Tcenter josefin"> ACCES </h1>
			<div id="map"></div>
			<a class="aStyle col-xs-12 Tcenter"
				href="https://www.google.fr/maps/dir//Polytech+Lyon,+B%C3%A2timent+Istil,+15+Boulevard+Andr%C3%A9+Latarget,+69100+Villeurbanne,+France"
				target="_blank">
				Itinéraire Google Maps
			</a>
			
		</div>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
		<script type="text/javascript" src="lib/leaflet/leaflet.js"></script>
		<script type="text/javascript" src="js/map.js"></script>
	</body>
</html>
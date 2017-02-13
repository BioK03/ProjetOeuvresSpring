<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<jsp:include page="../layout/head.jsp"></jsp:include>


	<body>
		<jsp:include page="../layout/nav.jsp"></jsp:include>
		<h1 class="Tcenter josefin"> Réservation d'une oeuvre </h1> 
	
		<div class="pageinner Tleft">
			<form  name='identification' method="post" action="BookingController?insertOrUpdate" onsubmit="return teste()">
				<span class="col-xs-6 col-xs-offset-3 noPadding mTop2em">
				    <select class="col-xs-12 inputStyle noOutline input-customPlaceholder" type="text" name="adherentId" 
				    	placeholder="adherent" id ="adherent" customplaceholder="0" autocomplete="off">
				    	<c:forEach items="${adherents}" var="adherent">
				    		<option value="${adherent.id}" <c:if test="${adherent.id == booking.adherent.id}">selected</c:if>>${adherent.firstname} ${adherent.lastname}</option>
				    	</c:forEach>
			    	</select>
			    </span>
			    <span class="col-xs-6 col-xs-offset-3 noPadding mTop2em">
			        <select class="col-xs-12 inputStyle noOutline input-customPlaceholder" type="text" name="oeuvreId"
			        	placeholder="Oeuvre" id ="oeuvre" customplaceholder="0" autocomplete="off">
			        	<c:forEach items="${oeuvres}" var="oeuvre">
				    		<option value="${oeuvre.id}" <c:if test="${oeuvre.id == booking.sellOeuvre.id}">selected</c:if>>${oeuvre.title}</option>
				    	</c:forEach>
			        </select>
		        </span>
		        <span class="col-xs-6 col-xs-offset-3 noPadding mTop2em">
				  <input class="col-xs-12 inputStyle noOutline input-customPlaceholder datepicker" type="text" name="date"
					placeholder="Date" id ="date" customplaceholder="0" autocomplete="off" value="${booking.date}" required>	 
			    </span>         
		        <input type="submit" name="bt"  value="R�server" class="btn btn-expo col-xs-6 col-xs-offset-3 mTop2em" > 
			</form>
		</div>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
		<script type="text/javascript">
			$('.datepicker').datepicker();
		</script>
	</body>
</html>
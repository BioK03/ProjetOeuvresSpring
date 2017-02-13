<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<jsp:include page="../layout/head.jsp"></jsp:include>
	<body>
		<jsp:include page="../layout/nav.jsp"></jsp:include>
		<c:set var="menu" scope="session" value="owner"/>
		<jsp:include page="../General/oeuvreMenu.jsp"></jsp:include>
		<h1 class="Tcenter josefin col-xs-4 col-xs-offset-4 noPadding">Listing des propriétaires</h1>
		<h1>
			<a class="col-xs-1 aStyle Tcenter" href="OwnerController?action=add">
				<i class="fa fa-user-plus"></i>
			</a>
		</h1>
		<div class="pageinner jumbotron">
			<table class="tablePerso Tcenter tableList">
				<tr class="col-xs-12 noPadding josefin">
					<th class="col-xs-2 DiBlock noPadding Tcenter">NUMERO</th>
					<th class="col-xs-8 DiBlock noPadding Tcenter">NOM</th>
					<th class="col-xs-2 DiBlock noPadding Tcenter"></th>
				</tr>

				<c:forEach items="${owners}" var="owner">
					<tr class="col-xs-12 noPadding">
						<td class="col-xs-2 DiBlock noPadding">
							<a class="aStyle" href="OwnerController?action=details&id=${owner.id}">
								<i class="fa fa-user"></i>
							</a>
							${owner.id}
						</td>
						<td class="col-xs-8 DiBlock noPadding">${owner.firstname} ${owner.lastname}</td>
		                <td class="col-xs-2 DiBlock noPadding">
		                	<a class="glyphicon glyphicon-edit col-xs-6 noPadding DiBlock aStyle" href="OwnerController?action=edit&id=${owner.id}"></a>
		                	<a class="fa fa-user-times col-xs-6 noPadding DiBlock aStyle" href="OwnerController?action=deleteConfirmation&id=${owner.id}"></a>
		                </td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</body>
</html>
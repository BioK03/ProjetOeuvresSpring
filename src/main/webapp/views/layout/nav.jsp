<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand josefin" href="Controller?action=index">Expo : Médiathèque de Polytech</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="AdherentController?action=list"><span class="glyphicon glyphicon-user"></span> Adhérents</a></li>
        <li><a href="OeuvreController?action=listSell"><span class="glyphicon glyphicon-book"></span> Oeuvres</a></li>
        <li><a href="BookingController?action=add&returnPage=other"><i class="fa fa-bookmark"></i> Réserver !</a></li>
        <c:if test="${not empty flashbag && not empty flashbagType}">
        	<li class="flashbag flashbag${flashbagType}">
        		<c:if test="${flashbagType == 'success'}">
        			<span class="glyphicon glyphicon-ok"></span>
        		</c:if>
        		<c:if test="${flashbagType == 'error'}">
        			<span class="glyphicon glyphicon-remove"></span>
        		</c:if>
        		${flashbag}
        	</li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>

<svg class="svg1" height="250" width="250">
	<polygon points="0,0 250,0 0,250" style="fill:#932611;stroke:purple;stroke-width:0" />
</svg>

<svg class="svg2" height="250" width="250">
	<polygon points="250,250 250,0 0,250" style="fill:#932611;stroke:purple;stroke-width:0" />
</svg>
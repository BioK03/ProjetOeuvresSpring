<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="nav nav-tabs mTop2em Dblock col-xs-6 col-xs-offset-3">
  <li role="presentation" <c:if test="${menu=='sell'}">class="active"</c:if>><a class="aStyle" href="OeuvreController?action=listSell"><i class="fa fa-eur"></i> Vente</a></li>
  <li role="presentation" <c:if test="${menu=='loan'}">class="active"</c:if>><a class="aStyle" href="OeuvreController?action=listLoan"><i class="fa fa-university"></i> Prêt</a></li>
  <li role="presentation" <c:if test="${menu=='owner'}">class="active"</c:if>><a class="aStyle" href="OwnerController?action=list"><i class="fa fa-users"></i> Propriétaires</a></li>
</ul>
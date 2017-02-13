<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--  expo.polytech.lyon@gmail.com    --    polytech2015 -->
<html>
	<jsp:include page="layout/head.jsp"></jsp:include>
	<body>
		<jsp:include page="layout/nav.jsp"></jsp:include>
		
		<div class="containerHome">
			
			<!-- <img class="imgHome" src="img/fullGalerie.jpg"/> -->
			<!--<div class="subContainerHomeExpo josefin">
				EXPO
			</div>
			<div class="subContainerHomePoly josefin">
				POLYTECH' LYON
			</div>-->
		</div>
		<div id="scene" class="scene anim">
			<ul>
           		<li class="layer plan4" data-depth="0.50"><img src="img/whitehome.png"></li>
              	<li class="layer plan3" data-depth="0.70"><img src="img/redhome.png"></li>
              	<li class="layer plan2" data-depth="0.85"><img src="img/blackhome.png"></li>
          	</ul>
    	</div>
		<!--<div class="containerHomeTop">
			<div class="subContainerHomeExpo josefin">
				EXPO
			</div>
			<div class="subContainerHomePoly josefin">
				POLYTECH' LYON
			</div>
		</div>
		<div class="containerHomeSuperTop">
			<div class="subContainerHomeExpo josefin">
				EXPO
			</div>
			<div class="subContainerHomePoly josefin">
				POLYTECH' LYON
			</div>
		</div>-->
		<jsp:include page="layout/footer.jsp"></jsp:include>
		<script type="text/javascript" src="lib/parallax/parallax.js"></script>
		<script type="text/javascript">
			var scene = document.getElementById('scene');
		    var parallax = new Parallax(scene);
		</script>
		<script type="text/javascript" src="js/home.js"></script>
	</body>
</html>
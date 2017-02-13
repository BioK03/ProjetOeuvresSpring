<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<jsp:include page="../layout/head.jsp"></jsp:include>

	<body>
		<jsp:include page="../layout/nav.jsp"></jsp:include>
		<div class="pageinner">
			<h1 class="Tcenter josefin"> CONTACT </h1> 
			<form  name='contact' method="post" action="Controller?action=contactValidation">
				<span class="col-xs-6 col-xs-offset-3 noPadding mTop2em">
				    <input class="col-xs-12 inputStyle noOutline input-customPlaceholder" type="text" name="name" 
				    	value="" placeholder="Votre nom (facultatif)" id ="name" customplaceholder="0" autocomplete="off">
			    </span>
			    <span class="col-xs-6 col-xs-offset-3 noPadding mTop2em">
			        <input class="col-xs-12 inputStyle noOutline input-customPlaceholder" type="email" name="mail"
			        	placeholder="Votre e-mail" id ="mail" customplaceholder="0" autocomplete="on" required>
		        </span>
		        <span class="col-xs-6 col-xs-offset-3 noPadding mTop2em">
				  <textarea line="5" class="col-xs-12 inputStyle noOutline input-customPlaceholder" type="text" name="content"
					placeholder="Votre message" id ="content" customplaceholder="0" autocomplete="off" required></textarea>
			    </span>         
		        <input type="submit" name="bt"  value="Envoyer" class="btn btn-expo col-xs-6 col-xs-offset-3 mTop2em" > 
			</form>
		</div>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</body>
</html>
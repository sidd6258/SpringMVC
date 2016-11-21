<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Create User</title>
<script type="text/javascript">
	function changeAction() {
			document.createForm.action = "${pageContext.request.contextPath}/user/"+0;
			document.forms["createForm"].submit();	
	}
	$(function(){
		
		$(document.body).on('click', '.changeType' ,function(){
			$(this).closest('.phone-input').find('.type-text').text($(this).text());
			$(this).closest('.phone-input').find('.type-input').val($(this).data('type-value'));
		});
		
		$(document.body).on('click', '.btn-remove-phone' ,function(){
			$(this).closest('.phone-input').remove();
		});
		
		
		$('.btn-add-phone').click(function(){

			var index = $('.phone-input').length + 1;
			
			$('.phone-list').append(''+
					'<div class="input-group phone-input">'+
						'<input type="text" name="phone[]" class="form-control" placeholder="+1 (999) 999 9999" />'+
						'<span class="input-group-btn">'+
							'<button class="btn btn-danger btn-remove-phone" type="button"><span class="glyphicon glyphicon-remove"></span></button>'+
						'</span>'+
					'</div>'
			);

		});
		
	});	
</script>
<style type="text/css">
.phone-input{
	margin-bottom:8px;
}
</style>
</head>
<body>
<div class="container">
	<h1 align="center">Create User</h1><br>
	<form class="form-horizontal" name="createForm" method="post" style="max-width:450px;">
		<div class="form-group">
			<label class="col-sm-4 control-label">Id</label>
			<div class="col-sm-8">
				<input type="text" name="id" id="id" readonly class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">First Name</label>
			<div class="col-sm-8">
				<input type="text" name="firstname" id="firstname" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Last Name</label>
			<div class="col-sm-8">
				<input type="text" name="lastname" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Title</label>
			<div class="col-sm-8">
				<input type="text" name="title" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Street</label>
			<div class="col-sm-8">
				<input type="text" name="street" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">City</label>
			<div class="col-sm-8">
				<input type="text" name="city" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">State</label>
			<div class="col-sm-8">
				<input type="text" name="state" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Zip</label>
			<div class="col-sm-8">
				<input type="text" name="zip" class="form-control">
			</div>
		</div>		
		<div class="form-group">
			<label class="col-sm-4 control-label">Phone</label>
			<div class="col-sm-8">			
				<div class="phone-list">				
					<div class="input-group phone-input">
						<input type="text" name="phone[]" class="form-control" placeholder="+1 (999) 999 9999" />
					</div>					
				</div>
				<button type="button" class="btn btn-success btn-sm btn-add-phone"><span class="glyphicon glyphicon-plus"></span> Add Phone</button>
			</div>
			
		</div>
		
	</form>
	<label class="col-sm-4 control-label"></label>
		<button type="button" value="Create" onclick="changeAction()" class="col-sm-2 btn btn-success ">Create</button>
		
</div>
<hr>
</body>
</html>
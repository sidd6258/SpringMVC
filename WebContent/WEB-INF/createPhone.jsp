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

<title>Create Phone</title>
<script type="text/javascript">
	function changeAction() {
		if(document.getElementById("id").value == ''){
			alert("ID is mandatory");
		}else{
			document.createForm.action = "${pageContext.request.contextPath}/phone/"+document.getElementById("id").value;
			document.forms["createForm"].submit();	
		}
	}
</script>
<style type="text/css">
.phone-input{
	margin-bottom:8px;
}
</style>
</head>
<body>
<div class="container">
	<h1 align="center">Create Phone</h1><br>
	<form class="form-horizontal" name="createForm" method="post" style="max-width:450px;">
		<div class="form-group">
			<label class="col-sm-4 control-label">Id</label>
			<div class="col-sm-8">
				<input type="text" name="id" id="id" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Phone Number</label>
			<div class="col-sm-8">
				<input type="text" name="number" id="number" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Description</label>
			<div class="col-sm-8">
				<input type="text" name="description" class="form-control">
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
	</form>
	<label class="col-sm-4 control-label"></label>
		<button type="button" value="Create" onclick="changeAction()" class="col-sm-2 btn btn-success ">Create</button>
		
</div>
<hr>
</body>
</html>
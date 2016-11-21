<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function changeMethod(action_name) {
		if (action_name == "update") {
			$.ajax({
				url : '${phone.id}' + "?number="
						+ document.updateForm.number.value + "&description="
						+ document.updateForm.description.value + "&street="
						+ document.updateForm.street.value + "&city="
						+ document.updateForm.city.value + "&state="
						+ document.updateForm.state.value + "&zip="
						+document.updateForm.zip.value,
				method : 'POST',
				success : function(data){
					location.pathname = "${pageContext.request.contextPath}/phone/"+document.getElementById("id").value;
				}
			});
		} else if (action_name == "delete") {
			$.ajax({
				url : '${phone.id}',
				method : 'DELETE',
				dataType:'html',
				success : function(data) {
					location.pathname = "${pageContext.request.contextPath}/"+data;
					
				}
			});
			
		}
		else if (action_name == "adduser") {
			document.updateForm.action = "${pageContext.request.contextPath}/phone/1?adduser=true";
			document.forms["updateForm"].submit();	
	}
		else {
			var i=document.getElementById("removebutton").value;
			$.ajax({
				url : 'removeuser'+ "?id="
						+ document.updateForm.id.value + "&removebutton="
						+ action_name,
				method : 'POST',
				dataType:'html',
				success : function(data) {
					location.pathname = "${pageContext.request.contextPath}/phone/"+document.getElementById("id").value;
				}
			});
	}
	}
</script>
</head>
<body>
<div class="container">
	<h1 align="center">Update/Delete Phone</h1><br>
	<form class="form-horizontal" name="updateForm" method="post" >
		<div class="form-group">
			<label class="col-sm-4 control-label">Id</label>
			<div class="col-sm-8">
				<input type="text" name="id" id="id" value="${phone.id }" readonly class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Phone Number</label>
			<div class="col-sm-8">
				<input type="text" name="number" id="number" value="${phone.number}" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Description</label>
			<div class="col-sm-8">
				<input type="text" name="description" value="${phone.description}" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Street</label>
			<div class="col-sm-8">
				<input type="text" name="street" value="${address.street}" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">City</label>
			<div class="col-sm-8">
				<input type="text" name="city" value="${address.city}" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">State</label>
			<div class="col-sm-8">
				<input type="text" name="state" value="${address.state}" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Zip</label>
			<div class="col-sm-8">
				<input type="text" name="zip" value="${address.zip}" class="form-control">
			</div>
		</div>	
		<div id="user">
		<div class="form-group">
			<label style="margin-left:75px;" class="col-sm-4 control-label">Users</label>
			</div>
		<c:forEach items="${user}" var="current">	
		<div class="form-group">
			<label class="col-sm-4 control-label">Id</label>
			<div class="col-sm-8">
				<input type="text" name="userid[]" id="userid" value="${current.id}" class="form-control">
				<button type="button" id="removebutton" value="${current.id}" onclick="changeMethod('${current.id}')" class="col-sm-2 btn btn-success ">Remove User</button>
			</div>
		</div>
 		<div class="form-group">
			<label class="col-sm-4 control-label">Firstname</label>
			<div class="col-sm-8">
					<input type="text" id="user1" name="user" value="${current.firstname}" class="form-control" />		
			</div>
			
		</div> 
		</c:forEach>
		</div>
			<label class="col-sm-2 control-label"></label>
		<button type="button" value="AddUser" onclick="changeMethod('adduser')" class="col-sm-2 btn btn-success ">Add User</button>		
	<label class="col-sm-2 control-label"></label>
		<button type="button" value="Update" onclick="changeMethod('update')" class="col-sm-2 btn btn-success ">Update</button>		
		<label class="col-sm-2 control-label"></label>
		<button type="button" value="Delete" onclick="changeMethod('delete')" class="col-sm-2 btn btn-success ">Delete</button>
</form>
</div>
</body>
</html>
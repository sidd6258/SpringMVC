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
				url : '${user.id}' + "?firstname="
						+ document.updateForm.firstname.value + "&lastname="
						+ document.updateForm.lastname.value + "&title="
						+ document.updateForm.title.value + "&street="
						+ document.updateForm.street.value + "&city="
						+ document.updateForm.city.value + "&state="
						+ document.updateForm.state.value + "&zip="
						+ document.updateForm.zip.value + "&phone[]="
						+ document.updateForm.phone1.value,
				method : 'POST',
				success : function(data){
					console.log(data);
					location.pathname = "${pageContext.request.contextPath}/user/"+${user.id};
				}
			});
		} else if (action_name == "delete") {
			$.ajax({
				url : '${user.id}',
				method : 'DELETE',
				dataType:'html',
				success : function(data) {
					location.pathname = "${pageContext.request.contextPath}/"+data;
					
				}
			});
		}
	}
</script>
</head>
<body>
<div class="container">
	<h1 align="center">Update/Delete User</h1><br>
	<form class="form-horizontal" name="updateForm" action="${user.id}" >
		<div class="form-group">
			<label class="col-sm-4 control-label">Id</label>
			<div class="col-sm-8">
				<input type="text" name="id" id="id" value="${user.id}" readonly class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">First Name</label>
			<div class="col-sm-8">
				<input type="text" name="firstname" id="firstname" value="${user.firstname}" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Last Name</label>
			<div class="col-sm-8">
				<input type="text" name="lastname" value="${user.lastname}" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Title</label>
			<div class="col-sm-8">
				<input type="text" name="title" value="${user.title}" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Street</label>
			<div class="col-sm-8">
				<input type="text" name="street" value="${user.address.street}" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">City</label>
			<div class="col-sm-8">
				<input type="text" name="city" value="${user.address.city}" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">State</label>
			<div class="col-sm-8">
				<input type="text" name="state" value="${user.address.state}" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Zip</label>
			<div class="col-sm-8">
				<input type="text" name="zip" value="${user.address.zip}" class="form-control">
			</div>
		</div>	
		<div id="phone">
		<c:forEach items="${phone}" var="current">	
 		<div class="form-group">
			<label class="col-sm-4 control-label">Phone</label>
			<div class="col-sm-8">							
					<div class="input-group phone-input">
						<input type="text" id="phone1" name="phone[]" value="${current.number}" class="form-control" />
					</div>					
			</div>
			
		</div> 
		</c:forEach>
		</div>
	<label class="col-sm-4 control-label"></label>
		<button type="button" value="Update" onclick="changeMethod('update')" class="col-sm-2 btn btn-success ">Update</button>		
		<label class="col-sm-4 control-label"></label>
		<button type="button" value="Delete" onclick="changeMethod('delete')" class="col-sm-2 btn btn-success ">Delete</button>
</form>
</div>
</body>
</html>
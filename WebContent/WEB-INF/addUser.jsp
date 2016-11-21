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
	if (action_name == "adduser") {
			$.ajax({
				url : 'adduser'+ "?id="
						+ document.updateForm.id.value + "&userid="
						+ document.updateForm.userid.value,
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
	<h1 align="center">Add User</h1><br>
	<form class="form-horizontal" name="updateForm" action="${phone.id}" >
		<div class="form-group">
			<label class="col-sm-4 control-label">Id</label>
			<div class="col-sm-8">
				<input type="text" name="id" id="id" value="${id}" readonly class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">User Id</label>
			<div class="col-sm-8">
				<input type="text" name="userid" id="userid" value="" class="form-control">
			</div>
		</div>
			<label class="col-sm-2 control-label"></label>
		<button type="button" value="AddUser" onclick="changeMethod('adduser')" class="col-sm-2 btn btn-success ">Add User</button>		
</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath}/EmployeeController" method="post">  
			<div class="form-group">		<!-- bootstrap -->
				Enter Name:<input type="text" class="form-control" name="name"  value="${employee.name}" /><br> 
				Enter DOB:<input type="date" class="form-control" name="dob" value="${employee.dob}" /><br>
				Enter Department<input type="text" class="form-control" name="department"value="${employee.department}" /><br>
				<input type="hidden" value="${employee.id}" name="id"> <br><!-- it is used to update value  ,,Employee obj is present only when we use "EDIT" -->	
			</div>
			<button class="btn btn-primary" type="submit">Save employye</button>
		</form>
	</div>
</body>
</html>


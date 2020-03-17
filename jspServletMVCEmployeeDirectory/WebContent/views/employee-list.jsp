<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.css"/>
 



</head>
<body>
	
	<%
		String string=(String)session.getAttribute("email");
		if(string==null){
			response.sendRedirect("index.jsp");
		}
	%>
	
	
	
	
	<div class="container">   <!-- bootstarp class to allow adding style to the all 4 side -->
		<div class="float-right">
			<a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
		</div>
		<p>${message}</p>	  <!--note: this message is pass by post,update & delete methode -->
		<button type="button" class="btn btn-primary" onclick="window.location.href='views/employee-add.jsp'">Add Employee</button> 
		<table class="table table-bordered" id="datatable">
		<thead>
			<tr class="thead-dark">
				<th>NAME</th>
				<th>DOB</th>
				<th>Department</th>
				<th>Update</th>
				<th>Delete</th>
				<!-- <th>Action</th> -->
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="i">
			<tr>
				<td><c:out value="${i.name}"></c:out></td>
				<td><c:out value="${i.dob}"></c:out></td>
				<td><c:out value="${i.department}"></c:out></td>
				<td>
					<a href="${pageContext.request.contextPath}/EmployeeController?action=EDIT&id=${i.id}" class="btn btn-info">Update</a> <!-- text(update) is set to style of buttons -->
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/EmployeeController?action=DELETE&id=${i.id}" class="btn btn-danger">Delete</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	<script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.js"></script>
	
	<script>
			$(document).ready(function(){
				$("#datatable").DataTable();
			})
	
	</script>
</body>
</html>
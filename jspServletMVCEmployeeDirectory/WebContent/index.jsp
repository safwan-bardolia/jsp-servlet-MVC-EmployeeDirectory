
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
	
	<%
		//we get email from session attribute 
		String email=(String)session.getAttribute("email"); 
		
		//this will execute when user already logged in
		if(email != null){
			response.sendRedirect("EmployeeController?action=LIST");
		}
	
	%>
	
	<div class="container" >
		<form action="${pageContext.request.contextPath}/loginController" method="post">  
			<div class="form-group">		<!-- bootstrap -->
				Email:<input type="email" class="form-control" name="email" /><br> 
				Password:<input type="password" class="form-control" name="password" /><br>
				<button class="btn btn-primary" type="submit">Login</button>	
			</div>
		</form>
	</div>
	
	<div style="color: red" align="center">		<!-- or use scriplets and " request.getParameter("action").equals("false")   " -->
		<c:if test = "${param.action eq 'false'}">	<!-- equal to false? -->
  	       <h2>!!Login failed<h2>			<!-- param: Maps a request parameter name to a single value -->
		</c:if>								<!--paramValues: Maps a request parameter name to an array of values -->
	</div>
	
</body>
</html>


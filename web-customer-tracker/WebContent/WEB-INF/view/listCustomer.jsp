<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>List all the customers</title>
<!-- Reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Management</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
		<!-- Add our HTML Button here to add the data in form and save it  -->
		<input type="button" value="Add New Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button">
		
		<!-- Add our HTML Table to show the list here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>

				<!-- Loop over model variable received and print the customer -->

				<c:forEach var="tempCustomer" items="${customers}">

					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
					</tr>

				</c:forEach>


			</table>
		</div>
	</div>

</body>

</html>
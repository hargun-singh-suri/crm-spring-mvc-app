<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Save Customer</title>
<!-- Reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

<!-- Reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Management</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>
		<form:form action="saveCustomer" modelAttribute="customer"
			method="POST">
			
			<!-- Need to associate this data with Customer - in case if update is performed this is used -->
			<form:hidden path="id"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>First name :</label></td>
						<td><form:input path="firstName" /></td>
					</tr>

					<tr>
						<td><label>Last Name :</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>Email :</label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"></td>
					</tr>
				</tbody>
			</table>
			
		</form:form>

		<div style="clear; both;"></div>
		<p>
		<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
		
	</div>

</body>

</html>
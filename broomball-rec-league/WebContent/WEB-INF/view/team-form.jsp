<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Team</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-player-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Player</h3>
	
		<form:form action="saveTeam" modelAttribute="team" method="POST">
		
			<!-- need to associate this data with team id -->
			<form:hidden path="id" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Team name:</label></td>
						<td><form:input path="teamName" /></td>
					</tr>
				
					<tr>
						<td><label>Wins:</label></td>
						<td><form:input path="wins" /></td>
					</tr>
					
					<tr>
						<td><label>Losses:</label></td>
						<td><form:input path="losses" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/team/standings">Back to List</a>
		</p>
	
	</div>

</body>

</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Save Player</title>

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
	
		<form:form action="saveGame" modelAttribute="game" method="POST">
		
			<!-- need to associate this data with player id -->
			<form:hidden path="id" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Location:</label></td>
						<td><form:input path="location" /></td>
					</tr>
				
					<tr>
						<td><label>Date:</label></td>
						<td><form:input type="date" path="date" /></td>
					</tr>
					
					
					<tr>
						<td><label>Team 1:</label></td>
						<td><form:select path="team1.id"> 
							
						<c:forEach var="tempTeam" items="${teams}">
        				<form:option value="${tempTeam.id}" label="${tempTeam.teamName}"/>    
       					</c:forEach>
       					
       					</form:select>  
					</tr>
					
					<tr>
						<td><label>Team 2:</label></td>
						<td><form:select path="team2.id"> 
							
						<c:forEach var="tempTeam" items="${teams}">
        				<form:option value="${tempTeam.id}" label="${tempTeam.teamName}"/>    
       					</c:forEach>
       					
       					</form:select>  
					</tr>
					
					<tr>
						<td><label>Team 1 score:</label></td>
						<td><form:input path="team1Score" /></td>
					</tr>
					
					<tr>
						<td><label>Team 2 score:</label></td>
						<td><form:input path="team2Score" /></td>
					</tr>
					
					<tr>
						<td><label>Final:</label></td>
						<td><form:select path="gFinal">  
        				<form:option value="True" label="Yes"/>  
       					<form:option value="False" label="No"/>  
       					</form:select>  
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
			<a href="${pageContext.request.contextPath}/game/schedule">Back to List</a>
		</p>
	
	</div>

</body>

</html>
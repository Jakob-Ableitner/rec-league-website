<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Rochester Broomball</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home-page.css">
    <!-- <link rel="preconnect" href="https://fonts.gstatic.com" /> -->
  </head>

    <body>
    
        <div class="head-container">
        
            <div class="menu-bar">
              <li class="nav-item dropdown">
                
                <svg xmlns="http://www.w3.org/2000/svg" class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" width="30" height="35" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
                  <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
                </svg>
    
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">Home</a></li>
                  <li><a class="dropdown-item" href="./logIn.html">Log in</a></li>
                  <li><a class="dropdown-item" href="#">Standings</a></li>
                  <li><a class="dropdown-item" href="#">Schedule</a></li>
                  <li><a class="dropdown-item" href="#">Team Page</a></li>
                </ul>
              </li>
    
              <div class="container-top-left">
                &emsp;
                <a href="#" class="top-links">Home Page</a>
                &emsp;
                <a href="${pageContext.request.contextPath}/team/standings" class="top-links">Standings</a>
                &emsp;
              </div>
            </div>
          </div>

      
 	<h3>Schedule</h3>
 	
 	<div id="container">
 		<div id="content">
 			<input type="button" value="Register"
 			onclick="window.location.href='showFormForAdd'; return false;"
 			class="add-button">

    <table class="table table-striped">
        <thead>
          <tr>
			<th>Location</th>
			<th>Date</th>
			<th>Team 1</th>
			<th>Team 2</th>
			<th>Action</th>
		</tr>
        
        </thead>
        <tbody>
          
          <c:forEach var="tempGame" items="${games}">
          
           <!-- construct an "update" link with game id -->
					<c:url var="updateLink" value="/game/showFormForUpdate">
						<c:param name="gameId" value="${tempGame.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="/game/deleteGame">
						<c:param name="gameId" value="${tempGame.id}" />
					</c:url>
          
          <c:choose>
    		<c:when test="${tempGame.gFinal}">
       
          	
   
				
			<tr>
				<td> ${tempGame.location} </td>
				<td> ${tempGame.date} </td>
				<td> ${tempGame.team1.teamName}: ${tempGame.team1Score} </td>
				<td> ${tempGame.team2.teamName}: ${tempGame.team2Score} </td>
				<td>
					<a href="${updateLink}">Update</a>
					<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this game?'))) return false">Delete</a>
				</td>
			</tr>
		
		
    </c:when>    
    <c:otherwise>
				
			<tr>
				<td> ${tempGame.location} </td>
				<td> ${tempGame.date} </td>
				<td> ${tempGame.team1.teamName}</td>
				<td> ${tempGame.team2.teamName}</td>
				<td>
					<a href="${updateLink}">Update</a>
					<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this game?'))) return false">Delete</a>
				</td>
			</tr>
        <br />
    </c:otherwise>
</c:choose>
</c:forEach>
         
     
		
		
	
        </tbody>
      </table>
     </div>
    </div>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
  </body>
</html>

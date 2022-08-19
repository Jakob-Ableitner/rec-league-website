<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Rochester Broomball</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/master.css">
    <!-- <link rel="preconnect" href="https://fonts.gstatic.com" /> -->
  </head>

<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
        <div class="dropdown">
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
          
        </div>
          <div class="collapse navbar-collapse navbar-extra" id="navbarNavAltMarkup">
            <div class="navbar-nav">
              <a class="nav-link active" href="${pageContext.request.contextPath}/home">Home</a>
              <a class="nav-link active" href="${pageContext.request.contextPath}/team/standings">Standings/Schedule</a>
              <a class="nav-link active" href="${pageContext.request.contextPath}/player/list">Contacts</a>
              <a class="nav-link active" href="<c:url value = "http://localhost:8080/spring-crm-rest/api/teams"/>">B2B</a>
          </div>
          <div>
            <a class="nav-link active" href="<c:url value = "http://localhost:8081/admin/home"/>">Admin Log In</a>
        </div>
        </div>
      </nav>
	
	<div class="body">
  		<div class="centerBox"> 
	<div id="container">
	
	<form:form action="savePlayer" modelAttribute="player" method="POST">
		
			<!-- need to associate this data with player id -->
			<form:hidden path="id" />
		
	<div class="sign-up bg-light">
      <h3>Create Player</h3>
      <br/><form id="signUp">
        <div class="row">
          <div class="col">
            <label>First name:</label>
			<form:input path="firstName" />
          </div>
          <div class="col">
            <label>Last name:</label>
			<form:input path="lastName" />
          </div>
        </div>
  	
  		<br>
        <div class="row">
          <div class="col">
            <label>Email:</label>
			<form:input path="email" />
        </div>
          <div class="col">
            <label for="teams">Team:</label>
				<form:select path="team.id"> 
					
				<c:forEach var="tempTeam" items="${teams}">
     				<form:option value="${tempTeam.id}" label="${tempTeam.teamName}"/>    
    			</c:forEach>
    					
    			</form:select>  
            </div>
           </div>
          </form>
        <br>
        <div class="row">
        <div class="col">
          <label></label>
          
          
          <button type="submit" class="btn btn-outline-success">Save</button>
      </div>
    </div>
    </div>
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/player/list">Back to List</a>
		</p>
	
	</div>
	</div>
    </div>
    
	
	 <footer class="d-flex flex-wrap justify-content-center py-3 border-top border-bottom">

    <ul class="nav col-md-4 justify-content-center list-unstyled d-flex">
      <li class="ms-3"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-facebook" viewBox="0 0 16 16">
  		<path d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z"/>
		</svg></li>
      <li class="ms-3"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
  		<path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z"/>
		</svg></li>
      <li class="ms-3"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-instagram" viewBox="0 0 16 16">
  		<path d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z"/>
		</svg></li>
    </ul>
  </footer>

</body>

</html>











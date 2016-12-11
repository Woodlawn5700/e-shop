<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"
		  type="text/css">
	<link rel="stylesheet" href="../../resources/style.css" type="text/css">
</head>
<body>

<c:import url="Header.jsp"/>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<table cellspacing="0" align="center">
	<tr style="margin: 15%">
		<td>
			<c:if test="${not empty error}">
			${error}
		</c:if>
			<form action="${pageContext.request.contextPath}/j_spring_security_check" id="sd" method="post">
				<div class="form-element">
					<label for="username">Username: </label>
					<input type="text" name="username" id="username"/>
				</div>

				<div class="form-element">
					<label for="password">Password: </label>
					<input type="password" name="password" id="password"/>
				</div>
				<div style="-webkit-flex-flow: row wrap;
    -ms-flex-flow: row wrap;
    flex-flow: row wrap;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flexbox;
    display: flex;
    -webkit-justify-content: center;
    -moz-justify-content: center;
    -ms-justify-content: center;
    -webkit-box-pack: center;
    -ms-flex-pack: center;
    justify-content: center;">
					<div id="loginButton" class="loginDiv">
						<button type="submit" name="action" value="login" id="LogButt">Login</button>
					</div>
					<div id="registrationButton" class="loginDiv">
						<button onclick="location.href='<c:url value="/RegustrationUserPage"/>'; return false; "
								id="registration">
							Registration
						</button>
					</div>
				</div>
			</form>
		</td>
	</tr>
</table>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="../../resources/jsfiles/IndexJs.js"></script>

</body>
</html>

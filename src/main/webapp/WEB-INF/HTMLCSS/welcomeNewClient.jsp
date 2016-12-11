<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
	<title>Greetings</title>
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"
		  type="text/css">
	<link rel="stylesheet" href="../../resources/style.css" type="text/css">
</head>

<body>
<c:import url="Header.jsp"/>

<div id="thankForRegistrationDiv">
	<h1>Thank you for Registration</h1>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="../../resources/jsfiles/IndexJs.js"></script>
</body>
</html>


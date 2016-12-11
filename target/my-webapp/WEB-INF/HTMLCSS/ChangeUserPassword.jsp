<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pavelpetrov
  Date: 15.10.16
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Change Password</title>
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">

</head>
<body>


<c:import url="Header.jsp"/>

<div class="container">
	<form action="" method="post" >
		<div class="form-group box-shadow">
			<label for="oldPas">Old Password</label>
			<input type="password" class="form-control" id="oldPas" name="olsPas" placeholder="Old Password" >
		</div>
		<div class="form-group">
			<label for="newPas">New Password</label>
			<input type="password" class="form-control" id="newPas" name="newPas" placeholder="New Password">
		</div>
		<div class="form-group">
			<label for="newPasAgain">Repeat</label>
			<input type="password" class="form-control" id="newPasAgain" name="newPasAgain" placeholder="Repeat new Password">
		</div>
		<button type="submit" class="btn btn-default" id="changePassword">Submit</button>
	</form>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="../../resources/jsfiles/ScriptMain.js"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: pavelpetrov
  Date: 15.10.16
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Change profile information</title>
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>

<c:import url="Header.jsp"/>

<div class="container">
	<form action="${pageContext.request.contextPath}/ChangeUserProfile" method="post">
		<c:set var="ClientName" value="${client}"/>
		<div class="form-group box-shadow">
			<label for="firstName">First Name</label>
			<input type="text" class="form-control" id="firstName" name="firstName"
				   value="<c:out value="${ClientName.firstName}"/>">
		</div>
		<div class="form-group box-shadow">
			<label for="secondName">Second Name</label>
			<input type="text" class="form-control" id="secondName" name="secondName"
				   value="<c:out value="${ClientName.secondName}"/>">
		</div>
		<div class="form-group">
			<label for="clientAddress">Address:</label>
			<input type="text" class="form-control" id="clientAddress" name="clientAddress"
				   value="<c:out value="${ClientName.clientAddress}"/>">
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
</div>
</body>
</html>

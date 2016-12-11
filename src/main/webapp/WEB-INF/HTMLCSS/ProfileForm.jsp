<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pavelpetrov
  Date: 15.10.16
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>My Profile</title>
	<head>
		<meta charset="UTF-8">
		<title>ProductList</title>
		<link rel="stylesheet"
			  href="${pageContext.request.contextPath}//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
	</head>
<body>

<c:import url="Header.jsp"/>

<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<h3>
				<p class="text-center">My profile</p>
			</h3>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<p class="text-left text-profile">
				<strong>Name:</strong> <c:out value="${client.firstName}"/>
			</p>

			<p class="text-left text-profile">
				<strong>Last Name:</strong> <c:out value="${client.secondName}"/></p>
			<p class="text-left text-profile"><strong>Address is:</strong> <c:out value="${client.clientAddress}"/></p>
		</div>
	</div>
	<h3>Change user profile</h3>
	<a href="<c:url value="/ChangeUserProfileInformationPage"/> " class="btn btn-primary btn-block btn-info" role="button">Change personal information</a>
	<a href="<c:url value="/ChangeUserPasswordPage"/>" class="btn btn-primary btn-block btn-info" role="button">Change password</a>

	<div class="col-xs-12">
		<h3>
			<p class="text-center">History of orders</p>
		</h3>
	</div>
	<div class="col-xs-12">
		<c:if test="${orderListByClientName ne null}">
			<table class="table table-hover">
				<thead>
				<tr>
					<th class="text-left">Payment Method</th>
					<th class="text-left">Payment State</th>
					<th class="text-left">Order State</th>
					<th class="text-left">Delivery Method</th>
					<th class="text-left">Date of order</th>
					<th class="text-left">Comments</th>
				</tr>
				</thead>
				<c:forEach var="orderAdminList" items="${orderListByClientName}" varStatus="productListCount">
				<tbody class="table-hover">
				<tr>
				<tr>
					<td class="text-left">${orderAdminList.paymentMethod.paymetnMethod}</td>
					<td class="text-left">${orderAdminList.paymentState.paymentState}</td>
					<td class="text-left">${orderAdminList.orderState.orderState}</td>
					<td class="text-left">${orderAdminList.deliveryMethod.deliveryMethod}</td>
					<td class="text-left">${orderAdminList.dateOfOrder}</td>
					<td class="text-left">${orderAdminList.comments}</td>
				</tr>
				</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${orderListByClientName eq null}">
			<p class="text-center">You didn't buy nothig here yet!!!!</p>
		</c:if>
	</div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="../../resources/jsfiles/ProfileJS.js"></script>
</body>
</html>

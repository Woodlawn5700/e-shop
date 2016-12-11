<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
	<title>Header</title>
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>

<nav class="navbar navbar-inverse">
	<div class="container-fluid" id="header">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">E-Shop Google</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="<c:url value="/"/> " id="homeHeader">Home</a></li>
			<c:if test="${sessionScope.get('username') eq 'Admin' || sessionScope.get('username') eq 'admin'}">
				<li><a href="/admin/OrderCreatorListAdmin" id="orderListHeader">Order List
					Admin</a></li>
				<li><a href="<c:url value="/admin/CreateCategoryList"/> " id="prodcutRegistrationHeader">Product
					registration</a>
				</li>
				<li><a href="<c:url value="/CreateNewCategoryAdminPage"/> "
					   id="createCategoryHeader">Crate new Category</a>
				</li>
				</li><li><a href="${pageContext.request.contextPath}/admin/StatisticAdmin" id="statisticHeader">Statistic</a>
				</li>
				<li><a href="http://localhost:8081/JavaServerFaces/" id="statisticAPP">Statistic App</a>
				</li>
			</c:if>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li>
				<a href="<c:url value="/MyCartUser"/> " id="cartHeader">
					<span class="glyphicon glyphicon-shopping-cart shopping-cart-image">
						<c:if test="${ProductsOnCardQuantity ne null}">
						<span class="badge">
							<c:out value="${ProductsOnCardQuantity}"/>
						</span>
						</c:if>
					</span>
				</a>
			</li>

			<li><a href="<c:url value="/MyCartUser"/>" id="priceHeader"><c:out value="${TotalPrice}"/></a></li>
			<c:choose>
				<c:when test="${sessionScope.get('username') ne null}">
					<li><a href="<c:url value="/ProfileFormUser"/>" id="profileHeader"><span
							class="glyphicon glyphicon-user"></span>My profile</a></li>
					<li><a href="<c:url value="/LogOutSetrvlet"/> "><span
							class="glyphicon glyphicon-log-out"></span>Log out</a></li>
				</c:when>
				<c:when test="${sessionScope.get('username') eq null}">
					<li><a href="<c:url value="/LoginUser"/> " id="logInHeader"><span class="glyphicon glyphicon-log-in"
																					  id="prudctHeader"></span>Login</a>
					</li>
				</c:when>
			</c:choose>
		</ul>
	</div>

</nav>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>
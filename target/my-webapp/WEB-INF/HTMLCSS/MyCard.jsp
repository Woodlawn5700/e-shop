<%@ page import="tables.Params" %>
<%@ page import="tables.Product" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>My Cart</title>
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>

<c:import url="Header.jsp"/>

<div class="container">
	<form action="${pageContext.request.contextPath}/OrderServlet" method="post">
		<div class="col-xs-12">
			<table class="table table-hover">
				<tr>

					<th colspan="2">
						<div style="padding-left: 50%">Category</div>
					</th>
					<th style="width: 150px">
						<div>Product Name</div>
					</th>
					<th>Price</th>
					<th>Brand</th>
					<th>Description</th>
				</tr>
				<c:forEach var="orderAdminList" items="${ListOfProductOnCard}" varStatus="productListIndex">
				<tbody class="table-hover">
				<tr>

					<td class="Button_add_to_card">
                <span data-toggle="tooltip"
					  title="Choose quantity of product">
                <input value="${orderAdminList.quantityOfProductsOnCart}" name="OrederCheckBox" type="number"
					   onkeydown="return false" class="myCheckBox" id="myCheckBox-${productListIndex.index}"
					   onchange="myFunction(this)" min="0" max="${orderAdminList.quantity}"/>
					</td>

					<td class="text-left">${orderAdminList.category.category}</td>
					<td class="text-left">${orderAdminList.productName}</td>
					<td class="text-left">${orderAdminList.price}</td>
					<td class="text-left">${orderAdminList.parametr.brand}</td>
					<td class="text-left">${orderAdminList.description}</td>

				</tr>
				</c:forEach>
			</table>

			<c:if test="${ListOfProductOnCard eq null}">
				<center id="imSorry">I'm sorry but you have nothing on your cart!!((</center>
			</c:if>
		</div>
		<div>
			<button type="submit" name="Order" id="OrderButton">Order</button>
		</div>
	</form>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="../../resources/jsfiles/MyCardJs.js"></script>
<script>
	$(function () {
		$('[data-toggle="tooltip"]').tooltip()
	})
</script>
</body>

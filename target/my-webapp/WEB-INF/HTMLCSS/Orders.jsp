
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Order</title>
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>

<c:import url="Header.jsp"/>

<c:if test="${username eq null}">
	<c:redirect url="http://localhost:8080/index.jsp"/>
</c:if>

<div class="container">
	<table class="table table-hover">
		<thead>
		<tr>
			<th class="text-left">Category</th>
			<th class="text-left">Product Name</th>
			<th class="text-left">Price</th>
			<th class="text-left">Quantity</th>
			<th class="text-left">Description</th>
		</tr>
		</thead>
		<c:forEach var="orderAdminList" items="${poductsAreReadyToBuy}">
		<tbody class="table-hover">
		<tr>
			<td class="text-left">${orderAdminList.category.category}</td>
			<td class="text-left">${orderAdminList.productName}</td>
			<td class="text-left-price">${orderAdminList.price}</td>
			<td class="text-left">${orderAdminList.quantityOfProductsOnCart}</td>
			<td class="text-left">${orderAdminList.description}</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<h2>Total price is:  <c:out value="${TotalPrice}"/></h2>
	<form action="" method="post">
		<div class="row">
			<div id="DeliveryMethod">
				<select id="delivery" name="delivery">
					<option value="delivery service">Delivery Service</option>
					<option value="pick up in the nearest shop">Pick up in the shop</option>
				</select>
				<select id="payment" name="payment">
					<option value="cash">By Cash</option>
					<option value="credit card">By credit card</option>
				</select>
			</div>
			<div class="divText1">
				<p><textarea rows="10" cols="45" name="description" id="Text1" class="descriptionOrder">Comments</textarea></p>
			</div>
		</div>
		<button type="submit" class="btn btn-primary btn-block" name="orderSumbitButton" id="orderSumbitButton">Buy</button>
	</form>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="../../resources/jsfiles/OrdersJs.js"></script>
</body>
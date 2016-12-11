<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<title>OrderListAdmin</title>
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>

<body>

<c:import url="Header.jsp"/>

<div class="container">
	<div class="row">

		<div class="col-xs-12">
			<h4>Sort by:</h4>
			<a href="javascript: void(0)" class="sort-predicate2 btn btn-info" data-predicate="in the stock" id="inStockSort">Unprocessed
				orders</a>
			<a href="javascript: void(0)" class="sort-predicate2 btn btn-info" data-predicate="orderState" id="orderStateSort">Order
				state</a>
			<a href="javascript: void(0)" class="sort-predicate2 btn btn-info" data-predicate="deliveryMethod" id="deliveryMethodSort">Delivery
				method</a>
			<a href="javascript: void(0)" class="sort-predicate2 btn btn-info" data-predicate="login" id="byClietnSort">By Client</a>
			<a href="javascript: void(0)" class="sort-predicate2 btn btn-info" data-predicate="dateOfOrder" id="dateIfOrderSort">Date of
				order</a>
		</div>
		<div id="orderDiv">
			<table class="table table-hover">
				<thead>
				<tr>
					<th class="text-left">Change information</th>
					<th class="text-left">Client</th>
					<th class="text-left">Payment Method</th>
					<th class="text-left">Payment State</th>
					<th class="text-left">Order State</th>
					<th class="text-left">Delivery Method</th>
					<th class="text-left">Date of order</th>
					<th class="text-left">Comments</th>
				</tr>
				</thead>
				<c:forEach var="orderAdminList" items="${OrderListAdmin}" varStatus="productListCount">
				<tbody class="table-hover">
				<tr>
						<td class="Button_add_to_card">
							<button class="Change_information" type="button" name="orderButton"
									value="${productListCount.index}" id="change_${productListCount.index}">Change
								information
							</button>
						</td>
					<td class="text-left">${orderAdminList.client.login}</td>
					<td class="text-left">${orderAdminList.paymentMethod.paymetnMethod}</td>
					<td class="text-left">${orderAdminList.paymentState.paymentState}</td>
					<td class="text-left">${orderAdminList.orderState.orderState}</td>
					<td class="text-left">${orderAdminList.deliveryMethod.deliveryMethod}</td>
					<td class="text-left">${orderAdminList.dateOfOrder}</td>
					<td class="text-left">${orderAdminList.comments}</td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="../../resources/jsfiles/OrderListAdminJs.js"></script>

</body>
</html>


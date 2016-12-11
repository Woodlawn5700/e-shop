<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Statistic</title>

	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>

<c:import url="Header.jsp"/>

<div class="container">
	<center>
		<div class="row">
			<form action="">
				<p><big>Choose dates</big><br>
					From <input type="text" value="dd-mm-yy" onfocus="this.select();lcs(this)"
								onclick="event.cancelBubble=true;this.select();lcs(this)" id="firstDate" readonly>
					TO <input type="text" value="dd-mm-yy" onfocus="this.select();lcs(this)"
							  onclick="event.cancelBubble=true;this.select();lcs(this)" id="lastDate" readonly>
				</p>
				<div id="profitDiv">
					<p> Profit is:
						<c:out value="${prifitForData}"/>
					</p>
				</div>

				<button type="button" class="btn btn-primary" id="getProfitBtn">Get the profit</button>
			</form>
		</div>
	</center>

	<div class="row">
		<div class="col-xs-12 " id="tableDiv">
			<table class="table table-hover">
				<thead>
				<tr>
					<th class="text-left">Client's Name</th>
					<th class="text-left">Client's lastName</th>
					<th class="text-left">Client's login/Email</th>
					<th class="text-left">Number Of Orders</th>

				</tr>
				</thead>
				<c:forEach var="orderAdminList" items="${StatisticClient}" varStatus="counter">
				<c:set var="longList" value="${LongList}"/>
				<c:if test="${counter.index < 10}">
				<tbody class="table-hover">
				<tr>
					<td class="text-left">${orderAdminList.firstName}</td>
					<td class="text-left">${orderAdminList.secondName}</td>
					<td class="text-left">${orderAdminList.login}</td>
					<td class="text-left">${longList[counter.index]}</td>
				</tr>
				</c:if>
				</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="col-xs-12 ">
			<table class="table table-hover">
				<thead>
				<tr>
					<th class="text-left">Product Name</th>
					<th class="text-left">Product Price</th>
					<th class="text-left">Number Of Orders</th>
					<th class="text-left">Product Brand</th>


				</tr>
				</thead>
				<c:forEach var="productStatisticList" items="${ProductTopList}" varStatus="productCounter">
				<c:set var="longList" value="${ProductCountList}"/>
				<c:if test="${ProductTopList[productCounter.index] ne null && productCounter.index < 10}">
				<tbody class="table-hover">
				<tr>
					<td class="text-left">${productStatisticList.productName}</td>
					<td class="text-left">${productStatisticList.price}</td>
					<td class="text-left">${longList[productCounter.index]}</td>
					<td class="text-left">${productStatisticList.parametr.brand}</td>

				</tr>
				</c:if>
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
<script src="../../resources/jsfiles/StatisticAdminJs.js"></script>


</body>
</html>

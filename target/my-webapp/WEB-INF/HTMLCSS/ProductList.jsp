<%@ page import="tables.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="tables.Params" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>ProductList</title>
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="/resources/style.css">
</head>
<body>

<c:import url="Header.jsp"/>

<div class="container">

	<div class="row">
		<button class="btn btn-primary btn-block" id="sortBtn">Make a Sort</button>
		<div id="demo">
			<div class="col-xs-12">
				<h4>Sort by:</h4>
				<a href="javascript: void(0)" class="sort-predicate btn btn-info"
				   data-predicate="productName">product name</a>
				<a href="javascript: void(0)" class="sort-predicate btn btn-info" data-predicate="price">price</a>
				<a href="javascript: void(0)" class="sort-predicate btn btn-info" data-predicate="brand">brand</a>
				<a href="javascript: void(0)" class="sort-predicate btn btn-info" data-predicate="category">category</a>
			</div>
		</div>
		<br>
		<button id="makeAFilterBtn" class="btn btn-primary btn-block">Make a Filter</button>
		<div id="filterDiv">
			<h4>Filter by:</h4>
			<div class="row">
				<div class="col-xs-2">
					<div class="divText1">
						<select class="form-control" id="categoryFilter2" name="categoryFilter">
							<option var="defoult" value="">Choose category</option>
							<c:forEach var="categoryListFilter" items="${UniqueCategoryList}"
									   varStatus="categoryListCount">
								<option value="${categoryListFilter.category}">${categoryListFilter.category}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-xs-2">
					<div class="divText1">
						<select class="form-control" id="brandFilter" name="brandFilter">
							<option var="defoult" value="">Choose brad</option>
							<c:forEach var="brandFilter" items="${UniqueBrandList}" varStatus="categoryListCount">
								<option value="${brandFilter}">${brandFilter}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-xs-2">
					<div class="divText1">
						<select class="form-control" id="colorFilter" name="brandFilter">
							<option var="defoult" value="">Choose color</option>
							<c:forEach var="colorFilter" items="${UniqueColorList}" varStatus="categoryListCount">
								<option value="${colorFilter}">${colorFilter}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-xs-2">
					<div class="divText1">
						<select class="form-control" id="powerFilter" name="brandFilter">
							<option var="defoult" value="">Choose power</option>
							<c:forEach var="powerFilter" items="${UniquePowerList}" varStatus="categoryListCount">
								<option value="${powerFilter}">${powerFilter}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-xs-2">
					<div class="divText1">
						<select class="form-control" id="weightFilter" name="brandFilter">
							<option var="defoult" value="">Choose weight</option>
							<c:forEach var="weightFilter" items="${UniqueWeightList}" varStatus="categoryListCount">
								<option value="${weightFilter}">${weightFilter}</option>
							</c:forEach>
						</select>
					</div>
					</div>
				<div class="col-xs-2">
					<section class="range-slider" id="sliderFilter">
						<span class="rangeValues"></span>
						<input value="0" min="0" max="5000" step="1" type="range" id="priceMinFilter">
						<input value="5000" min="0" max="5000" step="1" type="range" id="priceMaxFilter">
					</section>
				</div>
				<button type="button" class="btn btn-primary btn-block" id="doFilterBtn">Do filter</button>
			</div>


		</div>
		<div class="col-xs-12 " id="tableDiv">
			<table class="table table-hover" id="product-list">
				<thead>
				<tr>
					<th class="text-left" colspan="2">Category</th>
					<th class="text-left">Product Name</th>
					<th class="text-left">Price</th>
					<th class="text-left">Brand</th>
					<th class="text-left">Description</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="orderAdminList" items="${ProductList}" varStatus="productListCount">

					<tr>
						<td class="Button_add_to_card">
							<span data-toggle="tooltip"
								  title="Add To Cart">
								<c:if test="${orderAdminList.quantity > 0}">
								<button class="addTocartButton"
										type="button"
										name="Button"
										value="${productListCount.index}"
										id="btn-${productListCount.index}">
									<span class="glyphicon glyphicon-plus"></span>
								</button>
								</c:if>
							</span>
						</td>

						<!-- Modal -->
						<div class="modal fade" id="modal-product-${productListCount.index}" tabindex="-1" role="dialog"
							 aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
												aria-label="Close"><span
												aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="myModalLabel">Technical characteristics</h4>
									</div>
									<div class="modal-body">
											<div class="container">
												<h4>Brand of product</h4>
											<p>${orderAdminList.parametr.brand}</p>
												<h4>Power of product</h4>
												<p>${orderAdminList.parametr.power}</p>
												<h4>Color of product</h4>
												<p>${orderAdminList.parametr.color}</p>
												<h4>Weight of product</h4>
												<p>${orderAdminList.parametr.weigth}</p>
												<h4>Quantity in the stock</h4>
												<c:if test="${orderAdminList.quantity > 0}">
													<p>${orderAdminList.quantity}</p>
												</c:if>
												<c:if test="${orderAdminList.quantity == 0}">
													<p>Out of stock</p>

												</c:if>
											</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>

						<td class="text-left">${orderAdminList.category.category}</td>
						<td class="text-left"><a href="javascript: void(0)" data-toggle="modal"
												 data-target="#modal-product-${productListCount.index}">${orderAdminList.productName}</a>
						</td>
						<td class="text-left">${orderAdminList.price}</td>
						<td class="text-left">${orderAdminList.parametr.brand}</td>
						<td class="text-left">${orderAdminList.description}</td>
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
<script src="../../resources/jsfiles/ProductListJs.js"></script>

</body>
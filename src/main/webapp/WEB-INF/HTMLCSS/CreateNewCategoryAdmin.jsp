<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pavelpetrov
  Date: 18.10.16
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>CreateNewCategory</title>
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>

<c:import url="Header.jsp"/>

<div class="container"  id="createNewCategoryDiv" >
	<div class="row" id="creaNEwCategoryRow">
		<center><form class="form-inline" role="form" id="createNewCategoryForm">
		<div class="form-group">
			<h5>Create new Category</h5>
		</div>
		<div class="form-group">
			<label class="sr-only" for="createNewCategoryInput">New Category</label>
			<input type="text" class="form-control" id="createNewCategoryInput" placeholder="New Category">
		</div>
		<button type="submit" class="btn btn-default" id="createNewCategoryBtn">Create</button>
	</form>
	</center>
	</div>
</div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="../../resources/jsfiles/CreateCategoryAdminJs.js"></script>
</body>
</html>

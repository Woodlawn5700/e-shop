<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Pruduct registration</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>

<c:import url="Header.jsp"/>

<div class="container">
    <form  method="POST" class="RegistrationForm2">



        <input type="text" name="productName" placeholder="Name of product" class="inputText productInputClass" id="productNameInput">


        <%--<input type="text" name="productCategory" placeholder="Category of product" class="inputText">--%>
        <div class="divText1">
        <h5>Select category list (select one):</h5>
        </div>
        <div class="divText1">
        <select class="form-control" id="sel1" name="productCategory">
            <c:forEach var="categoryList" items="${CategoryList}" varStatus="categoryListCount">
            <option value="${categoryList.category}">${categoryList.category}</option>
            </c:forEach>
        </select>
        </div>

        <input type="text" name="quantity" placeholder="Quantity" class="inputText productInputClass" id="quantityProduct">

        <input type="text" name="price" placeholder="Price" class="inputText productInputClass" id="priceProduct">

        <input type="text" name="brand" placeholder="Brand" class="inputText productInputClass" id="brandProduct">

        <input type="text" name="power" placeholder="Power" class="inputText productInputClass" id="powerProduct">

        <input type="text" name="color" placeholder="Color" class="inputText productInputClass" id="colorProduct">

        <input type="text" name="weight" placeholder="Weight" class="inputText productInputClass" id="weightProduct">

        </br>
        <div class="divText1"><h5>Description</h5></div>
        <% if (request.getAttribute("Exeption") != (null)) {
        %>
        <p id="invalideInputParams" class="invalidateInput"> <%= request.getAttribute("Exeption") %> </p>
        <%
            }
        %>
        <div class="divText1">
            <p><textarea rows="10" cols="45" name="description" id="Text1" class="productInputClass"></textarea></p>
        </div>
        <div class="divText1">
        <button type="submit" name="registration" value="registo" id="productRegistrationButton" >Add product to BD</button>
        </div>
    </form>
</div>




<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="../../resources/jsfiles/ProdcutRegistrationAdminJs.js"></script>

</body>
</html>
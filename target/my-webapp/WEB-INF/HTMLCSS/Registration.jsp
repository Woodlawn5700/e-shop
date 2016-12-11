<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>

<c:import url="Header.jsp"/>

<div class="container">
<form action="" method="" class="RegistrationForm">


    <input type="text" name="firstName" placeholder="first name" class="inputText" id="firstNameClient">

    <input type="text" name="seconName" placeholder="second name" class="inputText" id="secondNameClient">

    <p></p>

    <input type="text" name="email" placeholder="eMail/Login" class="inputText" id="emailClient">

    <input type="text" name="clientAddress" placeholder="address" class="inputText" id="clientAddressClient">

    <p></p>

    <input type="password" name="password" placeholder="password" class="inputText" id="passwordClient">

    <input type="password" name="password_confirm" placeholder="passwod comfirm" class="inputText" id="passwordAgainClient">

    </br>

    <button type="submit" name="registration" value="registo" id="registrationButton2">Registration</button>

</form>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="../../resources/jsfiles/RegistrationJs.js"></script>
</body>
</html>
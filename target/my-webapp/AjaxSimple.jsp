<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="${pageContext.request.contextPath}Login.css" rel="stylesheet" type="text/css"/>
    <script   src="http://code.jquery.com/jquery-3.1.1.min.js" crossorigin="anonymous"></script>
</head>
<body>
<form action="" method="post" id="sd">

    <div class="form-element">
        <label for="username">Username: </label>
        <input type="text" name="username" id="username"/>
    </div>

    <div class="form-element">
        <label for="password">Password: </label>
        <input type="password" name="password" id="password"/>
    </div>


    <div style="-webkit-flex-flow: row wrap;
    -ms-flex-flow: row wrap;
    flex-flow: row wrap;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flexbox;
    display: flex;
    -webkit-justify-content: center;
    -moz-justify-content: center;
    -ms-justify-content: center;
    -webkit-box-pack: center;
    -ms-flex-pack: center;
    justify-content: center;">
        <div id="loginButton">
            <button type="submit" name="action" value="login" id="LogButt">Login</button>
        </div>
        <div id="registrationButton">
            <button onclick="location.href='WEB-INF/HTMLCSS/Registration.jsp'; return false; " id="registration" >Registration</button>
        </div>
    </div>
</form>

<input type="button" id="idButton">Click me</input>

<script   src="http://code.jquery.com/jquery-3.1.1.min.js" crossorigin="anonymous"></script>
<script src="AjaxSimpleJSP.js"></script>
</body>
</html>

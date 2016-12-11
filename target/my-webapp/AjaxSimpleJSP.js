
var userName;
var userPassword;

$(function () {
    userName = $("#username")
    userPassword = $("#password")
})

function checkPassword() {
    $.ajax({
        method: "POST",
        url: "/AjaxSimleServlet",
        data: {
            login: userName.val(),
            secret: userPassword.val()
        },
        success: function (result) {
           location.href='WEB-INF/HTMLCSS/Registration.jsp';
        },
        error:function (jqXHR, textStatus, errorThrown) {
            alert(textStatus)
            alert(errorThrown)
        }
        
    })
}
document.getElementById("idButton").onclick=checkPassword;
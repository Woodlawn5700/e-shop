/**
 * Created by pavelpetrov on 17.10.16.
 */
var firstName;
var seconName;
var email;
var clientAddress;
var password;
var password_confirm;

$(function () {
    firstName = $("#firstNameClient");
    seconName = $("#secondNameClient");
    email = $("#emailClient");
    clientAddress = $("#clientAddressClient");
    password = $("#passwordClient");
    password_confirm = $("#passwordAgainClient");


    $("#registrationButton2").click(function(event) {
        clientRegistration(event);
    });
});

function clientRegistration (event) {
    event.preventDefault();
    $.ajax({
        method: "POST",
        url: "/Registration",
        data: {
            firstName: firstName.val(),
            seconName: seconName.val(),
            email: email.val(),
            clientAddress: clientAddress.val(),
            password: password.val(),
            password_confirm: password_confirm.val()
        },
        success: function (result) {
            if (!result.success) {
                alert(result.message);
            } else {
                alert("Dear Client.Mail have been sent to your email. \n Please confirm the registration");
                location.href='/LoginUser';
            }
        },
        error:function (a,b,c) {
            alert(a.responseText);
        }
    })
}
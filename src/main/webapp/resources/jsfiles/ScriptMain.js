/**
 * Created by pavelpetrov on 16.10.16.
 */
var oldPassword;
var newPassword;
var repitePassword;

$(function () {
    oldPassword = $("#oldPas");
    newPassword = $("#newPas");
    repitePassword = $("#newPasAgain");

    $("#changePassword").click(function(event) {
        changePassword(event);
    });
});

function changePassword(event) {
    event.preventDefault();
    $.ajax({
        method: "POST",
        url: "/ChangeUserPassword",
        data: {
            oldPas: oldPassword.val(),
            newPas: newPassword.val(),
            newPasAgain: repitePassword.val()
        },
        success: function (result) {

            if (!result.success) {
                alert(result.message);

            } else {
                alert("Password have been changed");
                location.href='/ProfileFormUser';
            }
        },
        error:function (a,b,c) {
          alert(a.responseText);
        }
    })
}
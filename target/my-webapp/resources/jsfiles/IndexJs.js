/**
 * Created by pavelpetrov on 17.10.16.
 */
var username;
var password;
changeColor();
// $(function () {
//     username = $("#username");
//     password = $("#password");
//     $("#LogButt").click(function(event) {
//         login(event);
//     });
// });

function changeColor() {
    document.getElementById("logInHeader").style.background = "#2e6da4";
}
// function login(event) {
//     event.preventDefault();
//     $.ajax({
//         method: "POST",
//         url: "/login2",
//         data: {
//             username: username.val(),
//             password: password.val()
//            
//         },
//         success: function (result) {
//             if (!result.success) {
//                 alert(result.message);
//
//             } else {
//                 location.href='/';
//             }
//         },
//         error:function (a,b,c) {
//             alert(a.responseText);
//         }
//     })
// }
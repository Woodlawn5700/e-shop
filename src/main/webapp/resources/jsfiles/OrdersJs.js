var deliveryMethodOrder;
var paymentMethodOrder;
var descriptionOrder;


$(function () {

    deliveryMethodOrder = $("#delivery");
    paymentMethodOrder = $("#payment");
    descriptionOrder = $(".descriptionOrder");


    $("#orderSumbitButton").click(function(event) {
        makeAnOrder(event);
    });
});

function makeAnOrder (event) {
    event.preventDefault();
    $.ajax({
        method: "POST",
        url: "/BuyProducts",
        data: {
            delivery: deliveryMethodOrder.val(),
            payment: paymentMethodOrder.val(),
            description: descriptionOrder.val()
        },
        success: function (result) {
            if (!result.success) {
                alert(result.message);
            } else {
                alert("Thank you for ordering our products!");
                location.href='/';
            }
        },
        error:function (a,b,c) {
            alert(a.responseText);
        }
    })
}
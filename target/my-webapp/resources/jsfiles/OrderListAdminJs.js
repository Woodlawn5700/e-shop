/**
 * Created by pavelpetrov on 19.10.16.
 */

changeColor();
$(function () {
    assignClickHandler($(".Change_information"), function() {
        var buttonValue = $(this).val();
        changeOrderInformation(buttonValue);
    });

    // $(".Change_information").click(function(event) {
    //     changeOrderInformation(this);
    // });
});


function changeOrderInformation(orderId) {
    event.preventDefault();
    $.ajax({
        method: "POST",
        url: "/admin/ChangeOrderInformationServletAdmin",
        data: {
            "orderId": orderId
        },
        success: function (responce) {
            location.href = '/OrderChangeInfromationAdminPage';
        }
    }); 
} 

var sendFilterRequest2 = function (predicate) {
    $.ajax({
        method: "POST",
        url: "/admin/OrderSelectServlet",
        data: {
            "orderSort": predicate
        },
        success: function (response) {
				// window.location.reload();
            $('#orderDiv').load('../../OrderListAdminPage #orderDiv', function () {
                removeClickHandler($(".Change_information"), function() {
                    var buttonValue = $(this).val();
                    changeOrderInformation(buttonValue);
                });
                assignClickHandler($(".Change_information"), function() {
                    var buttonValue = $(this).val();
                    changeOrderInformation(buttonValue);
                });
            });
        },
        error: function (xhr, status, error) {
            alert(error);
        }
    });
};

$(".sort-predicate2").click(function (event) {
    $(".sort-predicate2").removeClass("active");
    $(this).addClass("active");
    var predicate = $(this).attr("data-predicate");
    sendFilterRequest2(predicate);
});

var assignClickHandler = function (selector, handler) {
    // selector is a jquery object
    selector = selector || $(".some-class-which-doesnot-exist");
    handler = handler || function () {
        };
    selector.on("click", handler);
};

var removeClickHandler = function (selector, handler) {
    // selector is a jquery object
    selector = selector || $(".some-class-which-doesnot-exist");
    handler = handler || function () {
        };
    selector.off("click", handler);

};

function changeColor() {
    document.getElementById("orderListHeader").style.background = "#2e6da4";
}
/**
 * Created by pavelpetrov on 18.10.16.
 */
var productName;
var productCategory;
var quantity;
var price;
var productBrand;
var power;
var color;
var weight;
var description;
changeColor();
$(function () {
    productName = $("#productNameInput");
    productCategory = $("#sel1");
    quantity = $("#quantityProduct");
    price = $("#priceProduct");
    productBrand = $("#brandProduct");
    power = $("#powerProduct");
    color = $("#colorProduct");
    weight = $("#weightProduct");
    description = $("#Text1");
    
    $("#productRegistrationButton").click(function(event) {
        productregistrationAdminFunction(event);
    });
});

function productregistrationAdminFunction (event) {
    event.preventDefault();
    $.ajax({
        method: "POST",
        url: "/admin/ProductRegistrationAdmin",
        data: {
            productName: productName.val(),
            productCategory: productCategory.val(),
            quantity: quantity.val(),
            price: price.val(),
            brand: productBrand.val(),
            power: power.val(),
            color: color.val(),
            weight: weight.val(),
            description: description.val()
        },
        success: function (result) {
            if (!result.success) {
                alert(result.message);
            } else {
                alert("New product have been insert to DB");
                $(".productInputClass").each(function() {
                    $(this).val("");
                })
            }
        },
        error:function (a,b,c) {
            alert(a.responseText);
        }
    })
}

function changeColor() {
    document.getElementById("prodcutRegistrationHeader").style.background = "#2e6da4";
}
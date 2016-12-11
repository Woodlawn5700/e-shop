/**
 * Created by pavelpetrov on 19.10.16.
 */
var categoryFilter;
var brandFilter;
var colorFilter;
var powerFilter;
var weightFilter;
var priceMinFilter;
var priceMaxFilter;
changeColor();

var assignClickHandler = function(selector, handler) {
    // selector is a jquery object
    selector = selector || $(".some-class-which-doesnot-exist");
    handler = handler || function() {};
    selector.on("click", handler);
}

var removeClickHandler = function(selector, handler) {
    // selector is a jquery object
    selector = selector || $(".some-class-which-doesnot-exist");
    handler = handler || function() {};
    selector.off("click", handler);
};

function changeColor() {
        document.getElementById("homeHeader").style.background = "#2e6da4";
}

var addToCart_Handler = function() {
    var buttonValue = this.value;
    addToCard(buttonValue);
}
$(function () {

    categoryFilter = $("#categoryFilter2");
    brandFilter = $("#brandFilter");
    colorFilter = $("#colorFilter");
    powerFilter = $("#powerFilter");
    weightFilter = $("#weightFilter");
    priceMinFilter = $("#priceMinFilter");
    priceMaxFilter = $("#priceMaxFilter");
    
    assignClickHandler($("#doFilterBtn"), doFilterProduct);
    assignClickHandler($(".addTocartButton"), addToCart_Handler);
    
   
});


var sendFilterRequest = function (predicate) {
    $.ajax({
        method: "POST",
        url: "/SelectServlet",
        data: {
            "sort": predicate
        },
        success: function (response) {
//				window.location.reload();
            $('#tableDiv').load('ProductListPage #tableDiv', function () {
                removeClickHandler($(".addTocartButton"), addToCart_Handler);
                assignClickHandler($(".addTocartButton"), addToCart_Handler);
            });

        },
        error: function (xhr, status, error) {
            alert(error);
        }
    });
};

$(".sort-predicate").click(function (event) {
    $(".sort-predicate").removeClass("active");
    $(this).addClass("active");
    var predicate = $(this).attr("data-predicate");
    sendFilterRequest(predicate);
});

$(function () {
    $('[data-toggle="tooltip"]').tooltip()
});

//$("#myModal").modal();
$('#sortBtn').click(function () {
    $("#demo").slideToggle("slow");
});

$('#makeAFilterBtn').click(function () {
    $("#filterDiv").slideToggle("slow");
});


function doFilterProduct (event) {
    event.preventDefault();
    $.ajax({
        method: "POST",
        url: "/FilterProductServlet",
        data: {
            categoryFilter : categoryFilter.val(),
            brandFilter : brandFilter.val(),
            colorFilter : colorFilter.val(),
            powerFilter : powerFilter.val(),
            weightFilter : weightFilter.val(),
            priceMinFilter : priceMinFilter.val(),
            priceMaxFilter : priceMaxFilter.val()
        },
        success: function (result) {
            if (!result.success) {
                alert(result.message);
            } else {
                $('#tableDiv').load('ProductListPage #tableDiv', function () {
                    removeClickHandler($(".addTocartButton"), addToCart_Handler);
                    assignClickHandler($(".addTocartButton"), addToCart_Handler);
                    // $(".addTocartButton").click(function() {
                    //     var buttonValue = this.value;
                    //     addToCard(buttonValue);
                    // });
                });
            }
        },
        error:function (a,b,c) {
            alert(a.responseText);
        }
    })
}

function addToCard(productIndex) {
    
    $.ajax({
        method: "POST",
        url: "/AddTOCard",
        data: {
            productIndex : parseInt(productIndex)
        },
        success: function (result) {
            if (!result.success) {
                alert(result.message);
            } else {
                $('#header').load('/ProductListPage #header', function () {
                    removeClickHandler($(".addTocartButton"), addToCart_Handler);
                    assignClickHandler($(".addTocartButton"), addToCart_Handler);  
                });
                
            }
        },
        error:function (a,b,c) {
            alert(a.responseText);
        }
    })
    
}



function getVals(){
    // Get slider values
    var parent = this.parentNode;
    var slides = parent.getElementsByTagName("input");
    var slide1 = parseFloat( slides[0].value );
    var slide2 = parseFloat( slides[1].value );
    // Neither slider will clip the other, so make sure we determine which is larger
    if( slide1 > slide2 ){ var tmp = slide2; slide2 = slide1; slide1 = tmp; }

    var displayElement = parent.getElementsByClassName("rangeValues")[0];
    displayElement.innerHTML = slide1 + " - " + slide2;
}

window.onload = function(){
    // Initialize Sliders
    var sliderSections = document.getElementsByClassName("range-slider");
    for( var x = 0; x < sliderSections.length; x++ ){
        var sliders = sliderSections[x].getElementsByTagName("input");
        for( var y = 0; y < sliders.length; y++ ){
            if( sliders[y].type ==="range" ){
                sliders[y].oninput = getVals;
                // Manually trigger event first time to display values
                sliders[y].oninput();
            }
        }
    }
};






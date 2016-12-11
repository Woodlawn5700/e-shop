/**
 * Created by pavelpetrov on 18.10.16.
 */
var category;
changeColor();
$(function () {
    category = $("#createNewCategoryInput");
    $("#createNewCategoryBtn").click(function(event) {
        clientRegistration(event);
    });
});

function clientRegistration (event) {
    event.preventDefault();
    $.ajax({
        method: "POST",
        url: "/admin/CreateNewCategoryServlet",
        data: {
            category: category.val()
          
        },
        success: function (result) {
            if (!result.success) {
                alert(result.message);
            } else {
                alert("New Category have been added");
                clean();
            }
        },
        error:function (a,b,c) {
            alert(a.responseText);
        }
    })
}
function clean() {
    $("#createNewCategoryInput").val('');
}

function changeColor() {
    document.getElementById("createCategoryHeader").style.background = "#2e6da4";
}
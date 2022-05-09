$('#acceptTermsCheck').on("submit", function (e) {
    var arr = $(this).serialize().toString();
    if(arr.indexOf("hobbies") < 0){
        e.preventDefault();
        alert("You must select at least one hobbie");
    }
});

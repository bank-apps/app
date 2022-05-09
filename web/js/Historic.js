$.getJSON("../assets/json/historic.json", function (result) {

    /*
console.log("JSDKDJSDJSJSJSK");
console.log(${pageContext.request.contextPath});

        $.get('${pageContext.request.contextPath}/myservlet', function(data) {
        alert(data);
    });

     */

    /*
    var button = document.getElementById("botonTRANS");
    button.addEventListener("click", function(){
        window.location.href="http:larutadelservletedeG10"
    });
    */

    $.each(result.transactions, function (key, val) {

        let grandiv = "";

        if (val.Quantity < 0) {
            grandiv='<div class="Cart-Items pad">' +
                '<i class="fa-solid fa-people-arrows-left-right"></i>' +

                '<div class="typeRED">Debit</div>' +

                '<div class="about">'+
                '<h1 class="title">' +
                val.Involved + '</h1>' +

                '<div class="prices"><div class="amount">' +
                val.Quantity + '$ </div>' +

                '</div>' +

                '<div class="dropdown">' +
                '   <button class="btn btn-secondary" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">' +
                '       <i class="fas fa-ellipsis-v"></i>' +
                '   </button>' +
                '   <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">' +
                '       <a class="dropdown-item generate" href="#">Generate Receipt</a>' +
                '   </div>' +
                '</div>'

        }

        if (val.Quantity > 0) {
            grandiv='<div class="Cart-Items pad">' +
                '<i class="fa-solid fa-people-arrows-left-right"></i>' +

                '<div class="typeGREEN">Credit</div>' +

                '<div class="about">'+
                '<h1 class="title">' +
                val.Involved + '</h1>' +

                '<div class="prices"><div class="amount">' +
                val.Quantity + '$ </div>' +

                '</div>' +

                '<div class="dropdown">' +
                '   <button class="btn btn-secondary" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">' +
                '       <i class="fas fa-ellipsis-v"></i>' +
                '   </button>' +
                '   <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">' +
                '       <a class="dropdown-item generate" href="#">Generate Receipt</a>' +
                '   </div>' +
                '</div>'
        }





        $("#Carrito2").append(grandiv);



    });
});
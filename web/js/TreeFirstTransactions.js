$.getJSON("../assets/json/historic.json", function (result) {

    for(var i=0;i<3;i++){
        console.log(result.transactions[i]);
        let grandiv = "";

        if (result.transactions.val.Quantity < 0) {
            grandiv='<div class="Cart-Items pad">' +
                '<i class="fa-solid fa-people-arrows-left-right"></i>' +

                '<div class="typeRED">Debit</div>' +

                '<div class="about">'+
                '<h1 class="title">' +
                result.transactions.val.Involved + '</h1>' +

                '<div class="prices"><div class="amount">' +
                result.transactions.val.Quantity + '$ </div>' +

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

        if (result.transactions.val.Quantity > 0) {
            grandiv='<div class="Cart-Items pad">' +
                '<i class="fa-solid fa-people-arrows-left-right"></i>' +

                '<div class="typeGREEN">Credit</div>' +

                '<div class="about">'+
                '<h1 class="title">' +
                result.transactions.val.Involved + '</h1>' +

                '<div class="prices"><div class="amount">' +
                result.transactions.val.Quantity + '$ </div>' +

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

        /**
         $.each(result.transactions, function (key, val) {


        }
         */




        $("#Carrito2").append(grandiv);



    }
});
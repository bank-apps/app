<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
    <script src="https://kit.fontawesome.com/5647d2b0bd.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/js/sidebarLoader.js"></script>
    <script src="${pageContext.request.contextPath}/js/Historic.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dashboard.css">

    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.0/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.0/css/bootstrap.min.css" rel="stylesheet" />



    <title>BankApp-Dashboard</title>

</head>

<body>
<div id="sidebarLoaded"></div>

<!--<div class="temp"> HERE GOES DASHBOARD. <br> COMING SOON</div>-->

<a href="${pageContext.request.contextPath}/jsp/viewcards.jsp">View your cards</a>

<section class="contentHistorical">
    <div class="CartContainer" id="Carrito2">
        <div class="HeaderCart">
            <h3 class="Heading">Transactions</h3>
            <h5 class="Action">Show All</h5>
        </div>

        <!--
                <div class="Cart-Items pad">

                    <i class="fa-solid fa-people-arrows-left-right"></i>

                    <div class="typeRED">Debit</div>
                    <div class="about">
                        <h1 class="title">Sebastian Fernandez</h1>
                        <div class="amount">900$






                    </div>

                        <div class="dropdown">
                            <button class="btn btn-success" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-ellipsis-v"></i>
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </div>


                </div>


-->
            </div>

        </section>

</body>
</html>
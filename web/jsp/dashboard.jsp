<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
        <title>BankApp-Dashboard</title>
        <script src="https://kit.fontawesome.com/5647d2b0bd.js" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="${pageContext.request.contextPath}/js/sidebarLoader.js"></script>

    </head>

    <body>
        <div id="sidebarLoaded"></div>
        <div class="temp"> HERE GOES DASHBOARD. <br> COMING SOON</div>

        <div class id="transactions">
            <img src="${pageContext.request.contextPath}/images/transactions.png"
                style="position:absolute;
                width:600px;
                height:400px;
                top: 380px;
                left:10%;" alt="image">
        </div>
    </body>
</html>
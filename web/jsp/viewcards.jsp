<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View cards</title>
    <script src="https://kit.fontawesome.com/5647d2b0bd.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/b269aa07db.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
    <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="../css/viewcards.css">
    <script src="../js/sidebarLoader.js"></script>

</head>
<body>

<div id="sidebarLoaded"></div>

<main>
    <div id="view-cards-content">
        <div id="page-title">
            <h1>Your cards</h1>
        </div>
        <div id="card-display">
            <div id="card-display-slide">
                <img src="/web/assets/img/addnewcard.png">
                <img src="/web/assets/img/Card.png">
            </div>

            <div id="card-info">
                <h1>Card Information</h1>
                <div class="card-info-row">
                    <h2>Card number</h2>
                    <h3>1234 1234 1234 2345</h3>
                </div>

                <div class="card-info-row">
                    <h2>Expiry date</h2>
                    <h3>1234 1234 1234 2345</h3>
                </div>
                <div class="card-info-row">
                    <h2>CVV code</h2>
                    <h3>123</h3>
                </div>

                <div class="card-info-row">
                    <h2>PIN</h2>
                    <h3>1234</h3>
                </div>

                <div class="card-info-row">
                    <h2>Card holder</h2>
                    <h3>Name Lastname</h3>
                </div>
                <button>Activate</button>
            </div>
        </div>
    </div>
</main>
</body>
</html>
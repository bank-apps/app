<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Transfer</title>
    <script src="https://kit.fontawesome.com/5647d2b0bd.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/b269aa07db.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="../css/transfer.css">
    <script src="../js/sidebarLoader.js"></script>
    <script src="../js/transfer.js"></script>
    <script src="../js/requieredCheckbox.js"></script>

</head>
<body>

<div id="sidebarLoaded"></div>

<main>
    <div id="transfer-content">
        <div id="login-info">
            <h1>Send Money</h1>
            <h2>Pay anyone, anywhere</h2>
        </div>

        <form id="form-login" action="${pageContext.request.contextPath}/TransferServlet" method="post" class="was-validated">
            <div class="LowForm">
                <div class="grande">
                    <div class="chico1"><label for="quantity"></label><input onkeyup="getVal()" type="currency" required class="input-sign-in form-control" name="quantity" id="quantity" placeholder="1500$ " onfocus="changeIconColorFocus('fa-user')" onfocusout="changeIconColorFocusOut('fa-user')"></div>
                    <div class="chico2">
                        <div class="arrow">
                            <i class="fa-solid fa-circle-arrow-right fa-3x"></i>
                        </div>
                    </div>
                    <div class="chico3"><label for="result"></label><input disabled type="number" required class="input-sign-in form-control" name="result" id="result" placeholder="1500$ " onfocus="changeIconColorFocus('fa-user')"></div>
                </div>


                <div class="Recipient">
                    <label for="recipient"></label><input type="text" required class="input-sign-in form-control" name="recipient" id="recipient" placeholder="IBAN ES66 0019 0020 9612 3456 7890" onfocus="changeIconColorFocus('fa-user')" onfocusout="changeIconColorFocusOut('fa-user')">
                </div>

                <div class="Name">
                    <label for="name"></label><input type="text" required class="input-sign-in form-control" name="firstname" id="name" placeholder="Your firstname and lastname" onfocus="changeIconColorFocus('fa-user')" onfocusout="changeIconColorFocusOut('fa-user')">
                </div>

                <div class="Message">
                    <label for="message"></label><input type="text" required class="input-sign-in form-control" name="message" id="message" placeholder="Place here the concept of the transfer" onfocus="changeIconColorFocus('fa-user')" onfocusout="changeIconColorFocusOut('fa-user')">
                </div>
            </div>

            <div id="form-login-features">
                <div class="form-check">
                    <label for="acceptTermsLabel" id="acceptTermsLabel">
                        I accept the terms and confirm the data provided is valid
                    </label>
                    <input class="form-check-input" type="checkbox" value="" id="acceptTermsCheck">
                </div>
                <div id="notworking-link">
                    <a href="../html/helpPage">Not working?</a>
                </div>
            </div>
            <button type="submit" value="Login">Confirm Transfer</button>
        </form>
    </div>
</main>

<script src="../js/transfer.js"></script>

</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/b269aa07db.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signup.css">
    <title>Sign Up</title>
</head>x
<body>

<main>
    <div id="signup2-content">
        <div id="signup2-info">
            <h1>Sign up</h1>
            <h2>You are just one step away from enjoying your benefits</h2>
        </div>

        <form action="${pageContext.request.contextPath}/SignUpServlet" method="post" id="form-slide-2" class="was-validated">
            <input type="hidden" name="second-slide" value="y" />
            <i class="fa-solid fa-house"></i>
            <div class="row">
                <input type="text" required class="input-address form-control" name="address" placeholder="Address" onfocus="changeIconColorFocus('fa-house')" onfocusout="changeIconColorFocusOut('fa-house')">
            </div>
            <i class="fa-solid fa-phone"></i>
            <div class="row">
                <input type="tel" required class="input-phone form-control" name="phone" placeholder="Phone number" onfocus="changeIconColorFocus('fa-phone')" onfocusout="changeIconColorFocusOut('fa-phone')">
            </div>
            <i class="fa-solid fa-lock"></i>
            <div class="row">
                <input type="password" required class="input-password form-control" name="password" placeholder="Password" onfocus="changeIconColorFocus('fa-lock')" onfocusout="changeIconColorFocusOut('fa-lock')">
            </div>
            <button type="submit" value="Register">Register</button>
        </form>
    </div>
</main>

<img src="${pageContext.request.contextPath}/images/Vectors-login.png" class="image-footer-background">

</body>
</html>
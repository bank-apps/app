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
    <script src="${pageContext.request.contextPath}/js/signup.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/failedsignup.css">

    <title>Sign Up</title>
</head>
<body>

<main>
    <div id="signup1-content">
        <div id="signup1-info">
            <h1>Sign up</h1>
            <h2>Register and start getting benefits</h2>
        </div>
        
        <div id="signup-error-message">
            Another user with same data exists
        </div>

        <form action="${pageContext.request.contextPath}/SignUpServlet" method="post" id="form-slide-1" class="was-validated">
            <input type="hidden" name="second-slide" value="n" />
            <div class="input-name">
                <div>
                    <input type="text" required class="input-firstname form-control" name="firstname" placeholder="Name">
                </div>
                <div>
                    <input type="text" required class="input-lastname form-control" name="lastname" placeholder="Last name">
                </div>
            </div>
            <i class="fa-solid fa-user"></i>
            <div class="row">
                <input type="text" required class="input-dni form-control" name="dni" placeholder="DNI" aria-describedby="material-addon1" onfocus="changeIconColorFocus('fa-user')" onfocusout="changeIconColorFocusOut('fa-user')">
            </div>
            <i class="fa-solid fa-at"></i>
            <div class="row">
                <input type="email" required class="input-email form-control" name="email" placeholder="Email" onfocus="changeIconColorFocus('fa-at')" onfocusout="changeIconColorFocusOut('fa-at')">
            </div>
            <button type="submit" value="Continue">Continue</button>
        </form>

    </div>
</main>

<img src="${pageContext.request.contextPath}/images/Vectors-login.png" class="image-footer-background">
</body>

</html>
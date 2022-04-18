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
    <script src="../js/signup.js"></script>
    <link rel="stylesheet" href="../css/signup.css">
    <link rel="stylesheet" href="../css/login.css">
    <title>Sign in</title>
</head>
<body>

<main>
  <div id="login-content">
    <div id="login-info">
      <h1>Sign in</h1>
      <h2>Sign in and start managing your money</h2>
    </div>


    <form id="form-login" action="${pageContext.request.contextPath}/LoginServlet" method="post" class="was-validated">
        <div class="input-form">
            <i class="fa-solid fa-user"></i>
            <input type="text" required class="input-sign-in form-control" name="dni" placeholder="DNI" onfocus="changeIconColorFocus('fa-user')" onfocusout="changeIconColorFocusOut('fa-user')">
            <i class="fa-solid fa-lock"></i>
            <input type="password" required class="input-password form-control" name="password" placeholder="Password" onfocus="changeIconColorFocus('fa-lock')" onfocusout="changeIconColorFocusOut('fa-lock')">
        </div>
        <div id="form-login-features">
            <div class="form-check">
                <label for="remember-me-check" id="remember-me-check-label">
                    Remember me
                </label>
                <input class="form-check-input" type="checkbox" value="" id="remember-me-check">
            </div>
            <div id="forgot-password-link">
                <a href="#">Forgot password?</a>
            </div>
        </div>
        <button type="submit" value="Login">Login</button>
    </form>



  </div>
</main>

<img src="../images/Vectors-login.png" class="image-footer-background">
</body>
</html>
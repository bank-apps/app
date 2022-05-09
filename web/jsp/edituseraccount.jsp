<%@page import="model.UserData"%>
<%@page import="model.UserAccount"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit user account</title>
    <script src="https://kit.fontawesome.com/5647d2b0bd.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/b269aa07db.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/edituseraccount.css">
    <script src="${pageContext.request.contextPath}/js/sidebarLoader.js"></script>

</head>
<body>
    
    <% UserAccount account = (UserAccount) session.getAttribute("user"); %>
    <% UserData userData = account.getData();%>

<div id="sidebarLoaded"></div>

<main>
    <div id="edit-user-content">
        <div id="page-title">
            <i class="fa-regular fa-circle-user fa-3x"></i>
            <h1>Edit profile</h1>
        </div>
        <form action="${pageContext.request.contextPath}/EditUserAccountServlet" method="post">
            <div class="data-row">
                <div class="user-data-display">
                    <label for="name-display">Name</label>
                    <input class="form-control" required type="text" name="new-name" value="<%= userData.getName() %>" id="name-display">
                </div>
                <div class="user-data-display">
                    <label for="name-display">Last name</label>
                    <input class="form-control" required type="text" name="new-surname" value="<%= userData.getSurnames() %>" id="lastname-display">
                </div>
            </div>

            <div class="data-row">
                <div class="user-data-display">
                    <label for="dni-display">DNI</label>
                    <input class="form-control" required type="text" readonly name="new-dni" value="<%= userData.getDNI() %>" id="dni-display">
                </div>
                <div class="user-data-display">
                    <label for="email-display">Email</label>
                    <input class="form-control" required type="text" name="new-email" value="<%= userData.getEmail() %>" id="email-display">
                </div>
            </div>

            <div class="data-row">
                <div class="user-data-display">
                    <label for="address-display">Address</label>
                    <input class="form-control" required type="text" name="new-address" value="<%= userData.getAddress() %>" id="address-display">
                </div>
                <div class="user-data-display">
                    <label for="phone-display">Phone number</label>
                    <input class="form-control" required type="text" name="new-phone" value="<%= userData.getPhoneNumber() %>" id="phone-display">
                </div>
            </div>

            <div id="change-password-title">
                <h2>Change password</h2>
            </div>

            <div class="data-row">
                <div class="user-data-display">
                    <label for="password-display">New password</label>
                    <input class="form-control" name="new-password" type="password" value="" id="password-display">
                </div>
                <div class="user-data-display">
                    <label for="repeat-password-display">Confirm password</label>
                    <input class="form-control" name="new-password-repeat" type="password" value="" id="repeat-password-display">
                </div>
            </div>
            <button type="submit">Save</button>
        </form>

    </div>
</main>
</body>
</html>
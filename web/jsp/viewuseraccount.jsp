<%@page import="model.UserData"%>
<%@page import="model.UserAccount"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View user account</title>
    <script src="https://kit.fontawesome.com/5647d2b0bd.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/b269aa07db.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewuseraccount.css">
    <script src="${pageContext.request.contextPath}/js/sidebarLoader.js"></script>

</head>
<body>

<div id="sidebarLoaded"></div>

<main>
    <div id="view-user-content">
        <div id="page-title">
            <h1>My profile</h1>
        </div>
        <div id="icons">
            <i class="fa-regular fa-circle-user fa-7x"></i>
            <button onclick="window.location.href='${pageContext.request.contextPath}/jsp/edituseraccout.jsp'">
                <i class="fa-solid fa-pen fa-lg"></i>
            </button>
        </div>

        <% session.getAttribute("user"); %>
        <% UserAccount account = (UserAccount) session.getAttribute("user"); %>
        <% UserData userData = account.getData();%>
    
        <div class="data-row">
            <div class="user-data-display">
                <label for="name-display">Name</label>
                <input class="form-control" type="text" placeholder="<%= userData.getName() %>" readonly id="name-display">
            </div>
            <div class="user-data-display">
                <label for="name-display">Last name</label>
                <input class="form-control" type="text" placeholder="<%= userData.getSurnames() %>" readonly id="lastname-display">
            </div>
        </div>

        <div class="data-row">
            <div class="user-data-display">
                <label for="dni-display">DNI</label>
                <input class="form-control" type="text" placeholder="<%= userData.getDNI() %>" readonly id="dni-display">
            </div>
            <div class="user-data-display">
                <label for="email-display">Email</label>
                <input class="form-control" type="text" placeholder="<%= userData.getEmail() %>" readonly id="email-display">
            </div>
        </div>

        <div class="data-row">
            <div class="user-data-display">
                <label for="address-display">Address</label>
                <input class="form-control" type="text" placeholder="<%= userData.getAddress() %>" readonly id="address-display">
            </div>
            <div class="user-data-display">
                <label for="phone-display">Phone number</label>
                <input class="form-control" type="text" placeholder="<%= userData.getPhoneNumber() %>" readonly id="phone-display">
            </div>
        </div>
    </div>
</main>

</body>
</html>
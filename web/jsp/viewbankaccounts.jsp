<%@page import="java.util.ArrayList"%>
<%@page import="model.BankAccount"%>
<%@page import="model.UserData"%>
<%@page import="model.UserAccount"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View bank accounts</title>
    <script src="https://kit.fontawesome.com/5647d2b0bd.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/b269aa07db.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
    <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewbankaccounts.css">
    <script src="${pageContext.request.contextPath}/js/sidebarLoader.js"></script>
</head>
<body>
<div id="sidebarLoaded"></div>

    <% UserAccount account = (UserAccount) session.getAttribute("user"); %>
    <% UserData userData = account.getData();%>
<main>
    <div id="view-bank-accounts-content">
        <div id="page-title">
            <h1>Your bank accounts</h1>
        </div>
        
        <% for (BankAccount bankAccount : (ArrayList<BankAccount>)session.getAttribute("bankAccounts")) { %>
        <div id="bank-account-info">
            <div class="info-row">
                <h1>IBAN</h1>
                <h2><%= bankAccount.getIBAN() %></h2>
            </div>
            <div class="info-row">
                <h1>Holder</h1>
                <h2><%= userData.getName() + " " + userData.getSurnames() %></h2>
            </div>
        </div>
         <% } %>
        <form action="${pageContext.request.contextPath}/CreateAccountServlet" method="post">
            <button type="submit"><i class="fa-solid fa-plus"></i> Add new bank account</button>
        </form>
    </div>
</main>
</body>
</html>

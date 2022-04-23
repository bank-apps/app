<%@page import="model.UserAccount"%>
<%@page import="model.UserData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <body>
        <h1>Your dashboard page</h1>
        <h2>You are: <% session.getAttribute("user"); %></h2>
        <% UserAccount account = (UserAccount) session.getAttribute("user"); %>
        <% UserData userData = account.getData();%>
        <p>DNI: <%= userData.getDNI()%></p>
        <p>Name: <%= userData.getName() %></p>
        <p>Surnames: <%= userData.getSurnames() %></p>
        <p>Email: <%= userData.getEmail() %></p>
        <p>Address: <%= userData.getAddress() %></p>
        <p>Phone number: <%= userData.getPhoneNumber()%></p>
        <p>Password: <%= userData.getPassword()%></p>
    </body>
</html>

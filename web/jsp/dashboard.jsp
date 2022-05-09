<%@page import="model.BankAccount"%>
<%@page import="model.UserData"%>
<%@page import="model.UserAccount"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
    <script src="https://kit.fontawesome.com/5647d2b0bd.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/js/sidebarLoader.js"></script>
    <script src="${pageContext.request.contextPath}/js/Historic.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dashboard.css">

    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.0/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.0/css/bootstrap.min.css" rel="stylesheet" />


    <link href="https://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
    <link rel="stylesheet" href="https://pattern.kivan-works.com/fonts/kredit.css">
    <link href='https://fonts.googleapis.com/css?family=Lexend Deca' rel='stylesheet'>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dynamicCard.css">
    <script src="${pageContext.request.contextPath}/js/dynamicCard.js"></script>


    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

    <title>BankApp-Dashboard</title>

</head>

<body>
<div id="sidebarLoaded"></div>
<div class="allDashboard">
<div class="Trestarjetas">
    
    <% UserAccount account = (UserAccount) session.getAttribute("user"); %>
    <% UserData userData = account.getData();%>
    <% BankAccount bankAccount = (BankAccount)session.getAttribute("bankAccount");%>

    <form id="form-cards" action="${pageContext.request.contextPath}/CardServlet" method="post">
        <button type="submit">
            <div class="tarjeta">
                <div class="floating floating1">
                    <div class="thickness"></div>
                    <div class="thickness"></div>
                    <div class="thickness"></div>
                    <div class="card_body">
                        <div class="logo svg"></div>
                        <div class="paywave svg"></div>
                        <div class="chips svg"></div>
                        <div class="card_no text">
                            1234-5678-9012-3456
                        </div>

                        <div class="valid text">
                            VALID <br> THUR
                        </div>
                        <div class="valid_date text">
                            02/25
                        </div>
                        <div class="holder text"><%= userData.getName() + " " + userData.getSurnames() %></div>
                        <div class="mastercard_icon svg"></div>
                    </div>
                </div>
            </div>
        </button>
    </form>

    <a href="otro2.html">
        <div class="tarjeta">
            <div class=" floating floating2">
                <div class="thickness"></div>
                <div class="thickness"></div>
                <div class="thickness"></div>
                <div class="card_body">
                    <div class="logo2 svg"></div>
                    <div class="paywave svg"></div>
                    <div class="chips svg"></div>
                    <div class="card_no2 text">
                        TOTAL SPENT <br> THIS MONTH
                    </div>
                    <div class="valid_date2 text">
                        $ 234,59
                    </div>
                    <div class="mastercard_icon svg"></div>
                </div>
            </div>
        </div>
    </a>

    <a href="otro3.html">
        <div class="tarjeta">
            <div class="floating floating3">
                <div class="thickness"></div>
                <div class="thickness"></div>
                <div class="thickness"></div>
                <div class="card_body">
                    <div class="logo3 svg"></div>
                    <div class="paywave svg"></div>
                    <div class="chips svg"></div>
                    <div class="card_no2 text">
                        YOUR TOTAL <br> BALANCE
                    </div>
                    <div class="valid_date3 text">
                        $ <%= bankAccount.getBalance() %>
                    </div>
                    <div class="mastercard_icon svg"></div>
                </div>
            </div>
        </div>
    </a>
</div>



    <div class="contentHistorical">
        <div class="CartContainer" id="Carrito2">
            <div class="HeaderCart">
                <h3 class="Heading">Transactions</h3>
                <h5 class="Action">Show All</h5>
            </div>
        </div>
    </div>

    <div class="dosbotones">
        <a href="prestamo.jsp">
            <div class="contentHistorical11">
                <div class="CartContainer2" id="Carrito3">
                    <div class="HeaderCart">
                        <h3 class="Heading2">Solicitar Préstamo</h3>
                    </div>
                </div>
            </div>
        </a>

        <a href="transfer.jsp">
            <div class="contentHistorical22">
                <div class="CartContainer3" id="Carrito4">
                    <div class="HeaderCart">
                        <h3 class="Heading2">Realizar transferencia</h3>
                    </div>
                </div>
            </div>
        </a>
    </div>
    
    <div></div>

</div>
</body>
</html>
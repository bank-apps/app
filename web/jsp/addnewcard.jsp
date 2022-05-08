<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Add new cards</title>
  <script src="https://kit.fontawesome.com/5647d2b0bd.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://kit.fontawesome.com/b269aa07db.js" crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
  <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewcards.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/addnewcard.css">
  <script src="${pageContext.request.contextPath}/js/sidebarLoader.js"></script>

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
          <form action="#" method="post">
              <button type="submit"><img src="${pageContext.request.contextPath}/assets/img/addnewcard.png"></button>
          </form>
      </div>

      <div id="card-info">
        <h1>Get started</h1>
        <h2>Etiam vulputate, purus sit amet bibendum elementum, tortor augue placerat ipsum, ut pharetra nisi nulla non mauris.
          Integer fermentum libero condimentum malesuada rhoncus.
          Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.
          </h2>
      </div>
    </div>
  </div>


</main>
</body>
</html>
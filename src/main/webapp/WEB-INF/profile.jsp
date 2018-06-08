
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <jsp:include page="partials/navbar.jsp" >
        <jsp:param name="title" value="Your Profile"></jsp:param>
    </jsp:include>

</head>
<body>

<<<<<<< HEAD
    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>
=======
<h1 id="welcome-banner">Welcome to your profile page ${sessionScope.user}</h1>

>>>>>>> user-input-exercise

</body>
</html>
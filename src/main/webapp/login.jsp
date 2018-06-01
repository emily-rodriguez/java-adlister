<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    if("POST".equals(request.getMethod())) {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("password")) {
        response.sendRedirect("/profile.jsp");
    }
}

%>

<html>
<head>
    <jsp:include page="partials/navbar.jsp" >
        <jsp:param name="title" value="Please Log In"></jsp:param>
    </jsp:include>
    <title>Login</title>
</head>
<body>
<div id="login-input">
    <form action="/login.jsp" method="POST">
        Username: <input class="form-control" name="username"/>
        Password: <input class="form-control" type="password" name="password"><br>
        <button class="btn btn-success" type="submit">Login</button>
    </form>
</div>


<%--<p>"username" parameter: ${param.username}</p>--%>
<%--<p>"password" parameter: ${param.password}</p>--%>


</body>
</html>

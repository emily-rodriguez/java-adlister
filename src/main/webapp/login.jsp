<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% if("POST".equals(request.getMethod())) {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("password")) {
        String redirectURL = "http://localhost:8080/profile.jsp";
        response.sendRedirect(redirectURL);
    } else {
        response.sendRedirect("http://localhost:8080/login.jsp");
    }
}
%>
<%@ include file="partials/navbar.jsp" %>

<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="/login.jsp" method="POST">
    Username: <input name="username"/>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>


<%--<p>"username" parameter: ${param.username}</p>--%>
<%--<p>"password" parameter: ${param.password}</p>--%>


</body>
</html>

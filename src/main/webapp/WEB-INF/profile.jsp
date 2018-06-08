<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    <div class="container">
        <h1>Welcome, <c:out value="${sessionScope.user.username}"/>!</h1>
    </div>

</body>
</html>
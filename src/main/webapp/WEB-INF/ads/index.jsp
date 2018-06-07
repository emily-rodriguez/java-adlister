<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../partials/navbar.jsp" %>
<%@ include file="../partials/head.jsp" %>
<html>
<head>
    <title>Index</title>
</head>
<body>


<c:forEach var="ad" items="${ads}">
    <div class="card">
        <div class="card-header">
            com.codeup.adlister.models.Ad # ${ad.id}
        </div>
        <div class="card-body">
            <h5>${ad.title}</h5>
            <p>${ad.description}</p>
        </div>
    </div>
</c:forEach>


</body>
</html>

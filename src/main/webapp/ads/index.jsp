<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
        </div>
    </c:forEach>
</div>
=======
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/partials/navbar.jsp" %>
<%@ include file="/partials/head.jsp" %>
<html>
<head>
    <title>Index</title>
</head>
<body>


<c:forEach var="ad" items="${ads}">
    <div class="card">
        <div class="card-header">
            Ad # ${ad.id}
        </div>
        <div class="card-body">
            <h5>${ad.title}</h5>
            <p>${ad.description}</p>
        </div>
    </div>
</c:forEach>

>>>>>>> mvc-exercise

</body>
</html>

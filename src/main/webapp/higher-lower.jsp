<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Random number: ${answer}</h1>
<h1>Guess: ${guess}</h1>


<c:set var="rand" value="${answer}"/>
<c:set var="userGuess" value="${guess}"/>

<c:if test="${rand == userGuess}">
    <h2>Good guess! You're correct!</h2>
</c:if>

<c:if test="${rand > userGuess}">
    <h2>Higher!</h2>
    <form action="/guess" method="POST">
        <div class="form-group">
            <label for="guess">Guess again: </label>
            <input id="guess" name="guess" type="number">
        </div>
        <input type="submit" value="Guess">
    </form>

</c:if>

<c:if test="${rand < userGuess}">
    <h2>Lower!</h2>
    <form action="/guess" method="POST">
        <div class="form-group">
            <label for="guess">Guess again: </label>
            <input id="guess" name="guess" type="number">
        </div>
        <input type="submit" value="Guess">
    </form>

</c:if>

</body>
</html>

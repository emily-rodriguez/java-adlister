<%--
  Created by IntelliJ IDEA.
  User: emilyrodriguez
  Date: 6/1/18
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/guess" method="POST">
    <div class="form-group">
        <label for="guess">Please enter a number between 1 and 100: </label>
        <input id="guess" name="guess" type="number">
    </div>
    <input type="submit" value="Guess">
</form>

</body>
</html>

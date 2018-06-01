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

<form action="/addition" method="POST">
    <div class="form-group">
        <label for="summand1">Please enter a number: </label>
        <input id="summand1" name="summand1" type="number">
        <label for="summand2">Please enter another number: </label>
        <input id="summand2" name="summand2" type="number">
    </div>
    <input type="submit" value="Add my numbers!">
</form>

</body>
</html>

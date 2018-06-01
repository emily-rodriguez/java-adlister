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

<form action="/multiplication" method="POST">
    <div class="form-group">
        <label for="operand1">Please enter a number: </label>
        <input id="operand1" name="operand1" type="number">
        <label for="operand2">Please enter another number: </label>
        <input id="operand2" name="operand2" type="number">
    </div>
    <input type="submit" value="Multiply my numbers!">
</form>

</body>
</html>

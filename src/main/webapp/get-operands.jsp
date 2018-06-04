<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/calculator" method="POST">
    <div class="form-group">
        <label for="operand1">Please enter a number: </label>
        <input id="operand1" name="operand1" type="number">
        <label for="operand2">Please enter another number: </label>
        <input id="operand2" name="operand2" type="number">
    </div>
    <input type="submit" value="Add" name="operator">
    <input type="submit" value="Multiply" name="operator">
    <input type="submit" value="Subtract" name="operator">
    <input type="submit" value="Divide" name="operator">
</form>

</body>
</html>

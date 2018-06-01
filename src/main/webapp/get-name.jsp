<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter name</title>
</head>
<body>

<form action="/name" method="POST">
    <div class="form-group">
        <label for="name">Please enter your name</label>
        <input id="name" name="name" type="text">
    </div>
    <input type="submit" value="Submit name">
</form>

</body>
</html>

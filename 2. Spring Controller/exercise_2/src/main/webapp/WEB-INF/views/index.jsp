<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator </h1>
<form action="/calculator" method="post">
    <input type="number" name="number1" value="${number1}">
    <input type="number" name="number2" value="${number2}">
    <div>
        <input type="submit" name="calculator" value="addition">
        <input type="submit" name="calculator" value="subtraction">
        <input type="submit" name="calculator" value="multiplication">
        <input type="submit" name="calculator" value="division">
    </div>
</form>
<h4 style="color: green">Result: ${result}</h4>
</body>
</html>

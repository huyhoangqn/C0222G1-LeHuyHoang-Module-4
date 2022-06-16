<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lehuy
  Date: 6/16/2022
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form:form action="login" method="post" modelAttribute="login">
    <table>
        <h3>LOGIN</h3>
        <tr>
            <td><label>Account</label></td>
            <td>
                <form:input path="account"/>
            </td>
        <tr>
            <td><label>Password</label></td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td></td>
            <td><form:button>Login</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>

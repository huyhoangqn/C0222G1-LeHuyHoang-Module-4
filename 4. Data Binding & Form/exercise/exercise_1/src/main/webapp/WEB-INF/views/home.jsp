<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Settings</h2>
<form:form action="mail" method="post" modelAttribute="mail">
    <table>
        <tr>
            <td>
                <lable>Language</lable>
            </td>

            <td>
                <form:select path="language">
                    <form:options items="${languages}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><label>Page Size</label></td>
            <td>
                <form:select path="pageSize">
                    <form:options items="${pageSizes}"/>
                </form:select>
                <label>emails per page</label>
            </td>
        </tr>
        <tr>
            <td><label>Spam filter </label></td>
            <td>
                <form:checkbox path="spamFilter"/>
                <label>Enable spams filter</label>
            </td>
        </tr>
        <tr>
            <td><label>Signature: </label>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td><input style="background:#0f86ff" type="submit" value="Update"></td>
            <td><input type="reset" value="Cancel"></td>
        </tr>
    </table>
</form:form>


</body>
</html>

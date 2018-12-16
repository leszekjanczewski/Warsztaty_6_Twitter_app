<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: leszek
  Date: 16.12.18
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
<%--@elvariable id="user" type="pl.coderslab.model.User"--%>
<form:form modelAttribute="user" method="post">
    <form:errors path="*"/>
    Email: <form:input path="email"/> <br>
    Username: <form:input path="username"/> <br>
    Password: <form:password path="password"/> <br>
    <input type="submit" value="Submit"/>
    <form:hidden path="id"/>
</form:form>
</body>
</html>

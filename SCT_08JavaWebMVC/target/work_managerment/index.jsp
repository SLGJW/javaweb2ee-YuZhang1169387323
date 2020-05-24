<%--
  Created by IntelliJ IDEA.
  User: 13609
  Date: 2020/5/23
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<h1>用户登录</h1>
<form action="${pageContext.request.contextPath}/user/login.action" method="post">
    编号：<input type="text" name="id">
    姓名：<input type="text" name="name">
    <br>
    <input type="radio" name="status" value="1">我是学生
    <br>
    <input type="radio" name="status"  value="2">我是老师
    <br>
    <input type="radio" name="status" checked value="3">我是管理员
    <br>
    <input type="submit" value="登录">
</form>
<div style="color: red; font-weight: 900;">${message}</div>
</body>
</html>

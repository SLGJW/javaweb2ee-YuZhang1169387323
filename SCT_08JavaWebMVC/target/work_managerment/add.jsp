<%--
  Created by IntelliJ IDEA.
  User: 13609
  Date: 2020/5/24
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/save.action">
    姓名: <input type="text" name="name">
    身份：
    <input type="radio" name="status" value="3">添加课程
    <input type="radio" name="status" value="2">添加老师
    <input type="radio" name="status" value="1">添加学生
    <input type="submit" value="提交">
</form>
</body>
</html>

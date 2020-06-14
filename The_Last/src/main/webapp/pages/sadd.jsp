<%--
  Created by IntelliJ IDEA.
  User: 13609
  Date: 2020/6/14
  Time: 7:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/student/add.action" method="post">
    姓名：<input type="text" name="sname">
    <br>
    密码：<input type="password" name="password">
    <br>
    班级：
        <input type="radio" name="sdept" value="1">实验一班
        <input type="radio" name="sdept" value="2">实验二班
        <input type="radio" name="sdept" value="3">实验三班
        <input type="radio" name="sdept" value="4">实验四班
    <br>
    入学日期：<input type="date" name="sdate">
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>

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
    <title>添加教师</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/teacher/add.action" method="post">
    姓名：<input type="text" name="tname">
    <br>
    密码：<input type="password" name="password">
    <br>
    所授科目：<input type="text" name="tsubject">
    <br>
    入职日期：<input type="date" name="tdate">
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>

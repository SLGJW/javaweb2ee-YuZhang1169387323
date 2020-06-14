<%--
  Created by IntelliJ IDEA.
  User: 13609
  Date: 2020/6/14
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/student/update.action" method="post">
    <input type="hidden" name="id" value="${param.id}">
    新密码：<input type="text" name="newPassword">
    再次输入：<input type="text" name="confirmPassword">
    <input type="submit" value="提交">
</form>
</body>
</html>

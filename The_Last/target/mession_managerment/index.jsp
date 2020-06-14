<%--
  Created by IntelliJ IDEA.
  User: 13609
  Date: 2020/6/11
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/login.action" method="post">
    用户名：<input type="text" name="username" value="苏一一">
    <br>
    密码：<input type="password" name="password" value="000000">
    <br>

    <img src="${pageContext.request.contextPath}/checkCode" alt="" id="checkImg" onclick="changeCheckCode(this)">
    <br>
    验证码：<input type="text" name="checkCode">
    <br>
    <br>
    <div style="color: red;">${errorMsg}</div>
    <br>
    <br>
    <input type="submit" value="提交">

    <script src="js/jquery-2.2.4.min.js"></script>
    <script>
        //图片点击事件
        function changeCheckCode(img) {
            img.src = "${pageContext.request.contextPath}/checkCode?" + new Date().getTime();
        }

    </script>
</form>
</body>
</html>

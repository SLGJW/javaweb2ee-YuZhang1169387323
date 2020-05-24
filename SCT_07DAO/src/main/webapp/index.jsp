
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/loginServlet" method="post">
    账号：<input type="text" name="account"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="提交"><br>
    <!--返回后台信息-->
    <div style="color: red; font-size: 25px;">${message}</div>
</form>
</body>
</html>

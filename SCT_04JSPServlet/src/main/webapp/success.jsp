<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 13609
  Date: 2020/4/18
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录成功-session</title>
</head>
<body>
<h1>${sessionScope.sessionInfo}</h1>
<a href="/invalidateSession">注销</a>
当前时间：<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>
</body>
</html>

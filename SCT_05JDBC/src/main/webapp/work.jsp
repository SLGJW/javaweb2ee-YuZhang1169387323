<%--
  Created by IntelliJ IDEA.
  User: 13609
  Date: 2020/5/9
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>操作</title>
</head>
<body>
<a href="add.jsp">添加学生</a><br>
<div style="color: red;">${message}</div>
<a href="findStudents">查看所有学生信息</a><br>
<table style="border: 1px solid #cccccc;">
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>修改信息</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${list}" var="s">
        <tr>
            <td>${s.username}</td>
            <td>${s.age}</td>
            <td><a href="${pageContext.request.contextPath}/update.jsp?id=${s.id}&username=${s.username}&age=${s.age}">修改信息</a></td>
            <td><a href="${pageContext.request.contextPath}/deleteById?id=${s.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

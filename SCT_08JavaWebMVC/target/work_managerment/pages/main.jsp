<%--
  Created by IntelliJ IDEA.
  User: 13609
  Date: 2020/5/23
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>操作界面</title>
</head>
<body>
<h1>欢迎您，${name}</h1>
<br>
<br>
<br>


<a href="${pageContext.request.contextPath}/add.jsp">添加学生</a>
<a href="${pageContext.request.contextPath}/student/findAll.action">查看所有学生信息</a>
<br>
<table style="border: 1px solid #cccccc;">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${studentList}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.sname}</td>
            <td><a href="${pageContext.request.contextPath}/student/remove.action?id=${s.id}" onclick="del()">移除学生</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<br>


<a href="${pageContext.request.contextPath}/add.jsp">添加老师</a>
<a href="${pageContext.request.contextPath}/teacher/findAll.action">查看所有老师信息</a>
<br>
<table style="border: 1px solid #cccccc;">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${teacherList}" var="t">
        <tr>
            <td>${t.id}</td>
            <td>${t.tname}</td>
            <td><a href="${pageContext.request.contextPath}/teacher/remove.action?id=${t.id}" onclick="del()">移除老师</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<br>


<a href="${pageContext.request.contextPath}/add.jsp">添加课程</a>
<a href="${pageContext.request.contextPath}/course/findAll.action">查看所有课程信息</a>
<br>
<table style="border: 1px solid #cccccc;">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${courseList}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.cname}</td>
            <td><a href="${pageContext.request.contextPath}/course/remove.action?id=${c.id}" onclick="del()">移除课程</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<script>
    function del() {
        if (confirm("确实要删除吗？")) {
            alert("已经删除！");
        } else {
            alert("已经取消了删除操作");
        }
    }
</script>
</body>
</html>

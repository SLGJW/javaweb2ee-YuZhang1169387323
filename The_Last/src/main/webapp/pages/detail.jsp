<%--
  Created by IntelliJ IDEA.
  User: 13609
  Date: 2020/6/14
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>详情</title>
</head>
<body>
<h1>详情展示</h1>
<c:if test="${student != null}">
    <br>编号：${student.id}
    <br>姓名：${student.sname}
    <br>班级：${student.sdeptStr}
    <br>注册日期：${student.sdateStr}
    <br>状态：${student.statusStr}
</c:if>
<c:if test="${student.courses.size() > 0}">
    <br>所选课程：
    <c:forEach items="${student.courses}" var="c">
        <span style="padding: 5px">${c.cname}</span>
    </c:forEach>
</c:if>

<c:if test="${teacher != null}">
    <br>编号：${teacher.id}
    <br>姓名：${teacher.tname}
    <br>所授科目：${teacher.tsubject}
    <br>入职日期：${teacher.tdateStr}
    <br>状态：${teacher.statusStr}
</c:if>
</body>
</html>

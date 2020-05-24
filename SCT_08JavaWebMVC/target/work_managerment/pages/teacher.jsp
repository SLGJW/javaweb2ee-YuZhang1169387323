<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 13609
  Date: 2020/5/23
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>教师中心</title>
</head>
<body>
<h1>欢迎您,${sessionScope.teacher.tname}</h1>
<br>
<br>
<br>
<a href="${pageContext.request.contextPath}/teacher/findCloseCourse.action?tid=${sessionScope.teacher.id}">查看未开设课程</a>
<table style="border: 1px solid #cccccc;">
    <tr>
        <td>编号</td>
        <td>课程名称</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${closeList}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.cname}</td>
            <td><a href="${pageContext.request.contextPath}/teacher/beginCourse.action?tid=${sessionScope.teacher.id}&cid=${c.id}">开设课程</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<br>


<a href="${pageContext.request.contextPath}/teacher/findBeginCourse.action?tid=${sessionScope.teacher.id}">查看已开课程</a>
<table style="border: 1px solid #cccccc;">
    <tr>
        <td>编号</td>
        <td>课程名称</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${beginList}" var="b">
        <tr>
            <td>${b.id}</td>
            <td>${b.cname}</td>
            <td><a href="${pageContext.request.contextPath}/teacher/closeCourse.action?tid=${sessionScope.teacher.id}&cid=${b.id}">关闭课程</a></td>
        </tr>
    </c:forEach>


</table>
<br>
<br>
<br>
<script>
    function del() {
        if (confirm("确认移除选课吗？")) {
            alert("移除成功");
        } else {
            alert("操作已取消");
        }
    }
</script>

</body>
</html>

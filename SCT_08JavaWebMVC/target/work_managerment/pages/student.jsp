<%--
  Created by IntelliJ IDEA.
  User: 13609
  Date: 2020/5/23
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生中兴</title>
</head>
<body>
<h1>欢迎您,${sessionScope.student.sname}</h1>
<br>
<br>
<br>
<a href="${pageContext.request.contextPath}/student/findOtherCourse.action?sid=${sessionScope.student.id}">查看未选课程</a>
<table style="border: 1px solid #cccccc;">
    <tr>
        <td>编号</td>
        <td>课程名称</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${otherList}" var="o">
        <tr>
            <td>${o.id}</td>
            <td>${o.cname}</td>
            <td><a href="${pageContext.request.contextPath}/student/addCourse.action?sid=${sessionScope.student.id}&cid=${o.id}">添加选课</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<br>


<a href="${pageContext.request.contextPath}/student/findSelectedCourse.action?sid=${sessionScope.student.id}">查看已选课程</a>
<table style="border: 1px solid #cccccc;">
    <tr>
        <td>编号</td>
        <td>课程名称</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${selectList}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.cname}</td>
            <td><a href="${pageContext.request.contextPath}/student/removeCourse.action?sid=${sessionScope.student.id}&cid=${s.id}" onclick="del()">移除选课</a></td>
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
        }else{
            alert("操作已取消");
        }
    }
</script>
</body>
</html>

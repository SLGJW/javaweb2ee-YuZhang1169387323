<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 13609
  Date: 2020/4/18
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户登录</title>
    <style>
        div {
            color: red;
            font-weight: 700;
        }

        input {
            border: 0px;
            outline: none;
            border: 1px solid yellowgreen;
            width: 300px;
            height: 30px;
            padding: 5px;
            border-radius: 8px;
            margin: 3px
        }
    </style>
    <script>
        /**
         * 账号验证
         */
        function accountTest() {
            var account = document.getElementById("account").value;
            if (account.length == 0 || account == "") {
                document.getElementById("errorInfo").innerHTML = "请输入账户";
                return false;
            } else {
                document.getElementById("errorInfo").innerHTML = "";
                return true;
            }
        }

        /**
         * 密码验证
         */
        function passwordTest() {
            var password = document.getElementById("password").value;
            if (password.length == 0 || password == "") {
                document.getElementById("errorInfo").innerHTML = "请输入密码";
                return false;
            } else {
                document.getElementById("errorInfo").innerHTML = "";
                return true;
            }
        }

        /**
         * 表单提交数据验证
         * @returns {boolean}
         */
        function loginTest() {
            var accountFlag = accountTest();
            var passwordFlag = passwordTest();
            if (accountFlag && passwordFlag){
                return true;
            }
            else{
                return false;
            }
        }
    </script>
</head>
<body>

<form action="/loginServlet" method="post" onsubmit="return loginTest()">
    账户：<input type="text" id="account" name="account" placeholder="请输入账户" onblur="accountTest()">
    <br>
    密码：<input type="password" id="password" name="password" placeholder="请输入密码" onblur="passwordTest()">
    <br>
    &nbsp;&nbsp;<input type="submit" value="登录">
</form>
<div id="errorInfo"></div>
<div>${requestScope.loginInfo}</div>
当前时间：<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>
</body>
</html>

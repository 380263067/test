<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/9/16
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/servlet3" method="get">
        用户名:<input type="text" name="username"><br>
        密码:<input type="password" name="pas"><br>
        <input type="submit" value="登陆">
    </form>
</body>
</html>

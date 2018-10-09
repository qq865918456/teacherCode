<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 2018/8/31
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <h1>登录页</h1>
    <form action="${pageContext.request.getContextPath()}/index/login" method="post">
        用户名:<input name="username" type="text"/><br/>
        密码:<input name="password" type="password"/><br/>
        <button type="submit">登录</button>
    </form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 2018/8/31
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    首页

    <shiro:guest>
        注册 登录
    </shiro:guest>
    <shiro:user>
        欢迎<shiro:principal property="name"/>登录 <a href="/abc/logout">注销</a>
    </shiro:user>

    <hr/>
    <shiro:hasPermission name="/add">
        <a href="${pageContext.request.contextPath}/index/add">增加</a>
    </shiro:hasPermission>

    <shiro:hasPermission name="/delete">
        <a href="${pageContext.request.contextPath}/index/delete">删除</a>
    </shiro:hasPermission>

    <shiro:hasPermission name="/update">
        <a href="${pageContext.request.contextPath}/index/update">修改</a>
    </shiro:hasPermission>

    <shiro:hasPermission name="/query">
        <a href="${pageContext.request.contextPath}/index/query">查询</a>
    </shiro:hasPermission>
</body>
</html>

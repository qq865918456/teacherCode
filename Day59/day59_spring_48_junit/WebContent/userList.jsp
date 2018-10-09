<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getContextPath()+"/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>用户展示列表</h1>
<a href="addUser.jsp">添加用户</a>
<table border="1" class="layui-table">
	<tr>
		<th>id</th>
		<th>username</th>
		<th>password</th>
		<th>操作</th>
	</tr>
	
	<c:forEach items="${page.data}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.username}</td>
			<td>${user.password}</td>
			<td>
				<a href="UserServlet?action=getUserById&id=${user.id}">编辑</a>
				<a href="UserServlet?action=deleteUser&id=${user.id}">删除</a>
			</td>
		</tr>
	</c:forEach>
</table>
	<jsp:include page="/common/page.jsp"/>
</body>
</html>
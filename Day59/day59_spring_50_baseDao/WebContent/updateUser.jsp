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
<form action="UserServlet?action=updateUser" method="post">
	<input type="hidden" name="id" value="${user.id}">
	<input type="text" name="username" value="${user.username}"><br>
	<input type="text" name="password" value="${user.password}"><br>
	<input type="submit" value="更新">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getContextPath()+"/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
index
<form action="UserServlet?action=addUser" method="post">
	id:<input type="text" name="id" value="11"><br>
	username:<input type="text" name="username" value="admin"><br>
	password:<input type="text" name="password" value="123"><br>
	balance:<input type="text" name="balance" value="11.1"><br>
	<input type="submit" value="提交">
</form>
</body>
</html>
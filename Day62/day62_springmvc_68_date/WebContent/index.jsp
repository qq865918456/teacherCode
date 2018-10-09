<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getContextPath() + "/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addUser" method="post">
	username:<input type="text" name="username" value="admin"><br>
	password:<input type="text" name="password" value="123"><br>
	age:<input type="text" name="age"><br>
	brithday:<input type="text" name="brithday"><br>
	heigh:<input type="text" name="heigh"><br>
	flag:<input type="checkbox" name="flag"><br>
	
	<input type="submit" value="添加">
</form>
</body>
</html>
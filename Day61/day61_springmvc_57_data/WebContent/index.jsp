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
<h3>表单中的属性和方法形参一致</h3>
<form action="addUser1" method="post">
	username:<input type="text" name="username"><br>
	password:<input type="text" name="password"><br>
	<input type="submit" value="添加" >
</form>

<h3>表单中的属性和方法形参不一致</h3>
<form action="addUser2" method="post">
	username:<input type="text" name="username"><br>
	password:<input type="text" name="password"><br>
	<input type="submit" value="添加" >
</form>

<h3>表单中的中写对象的属性，方法上面接收对象</h3>
<form action="addUser3" method="post">
	username:<input type="text" name="username"><br>
	password:<input type="text" name="password"><br>
	<input type="submit" value="添加" >
</form>
<h3>表单中有级联</h3>
<form action="addUser4" method="post">
	username:<input type="text" name="username"><br>
	password:<input type="text" name="password"><br>
	address:<input type="text" name="address.address"><br>
	<input type="submit" value="添加" >
</form>

</body>
</html>
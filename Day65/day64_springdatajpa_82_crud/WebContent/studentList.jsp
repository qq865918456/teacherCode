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
<table border="1" class="layui-table">
	<tr>
		<td>姓名</td>
		<td>密码</td>
		<td>性别</td>
		<td>邮箱</td>
	</tr>
	<c:forEach items="${page.content}" var="stu">
		<tr>
			<td>${stu.name}</td>
			<td>${stu.password}</td>
			<td>${stu.sex eq '1'?'男':'女'}</td>
			<td>${stu.email}</td>
		</tr>
	</c:forEach>
</table>
<jsp:include page="/common/page.jsp"/>
</body>
</html>
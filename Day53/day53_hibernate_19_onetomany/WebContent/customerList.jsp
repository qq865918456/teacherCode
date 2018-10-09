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
<h1>客户展示列表</h1>
<table border="1">
	<tr>
		<th>id</th>
		<th>name</th>
		<th>password</th>
		<th>订单</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${page.data}" var="cus">
		<tr>
			<td>${cus.id}</td>
			<td>${cus.name}</td>
			<td>${cus.password}</td>
			<td>
				<c:forEach items="${cus.orderInfos}" var="o">
					${o.orderName}<br>
				</c:forEach>
			</td>
			<td>
				<a href="#">编辑</a>
				<a href="#">删除</a>
			</td>
		</tr>
	</c:forEach>
</table>
<jsp:include page="/common/page.jsp"/>
</body>
</html>
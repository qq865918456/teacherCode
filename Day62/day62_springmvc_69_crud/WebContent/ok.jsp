<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <base href="<%=request.getContextPath()+"/"%>"> --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${sessionScope.user != null }">
		<h3>欢迎:${sessionScope.user}</h3>
	</c:when>
	<c:otherwise>
		<h3>
			<a href="login.jsp">你还没有登录，请先登录。。</a>
		</h3>
	</c:otherwise>
</c:choose>
<a href="userController/add">添加操作</a>
</body>
</html>
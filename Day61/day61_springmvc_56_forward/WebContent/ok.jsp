<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getContextPath()+"/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String msg = request.getParameter("msg");

	out.println(new String(msg.getBytes("iso-8859-1")));
	
%>
</head>
<body>
ok<br>
${requestScope.msg}<br>
${param.msg}<br>
</body>
</html>
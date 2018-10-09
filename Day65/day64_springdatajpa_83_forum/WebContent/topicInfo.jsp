<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>     
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getContextPath()+"/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>标题:${topic.title }</h1>
<h4>内容:${topic.content}</h4>
<h4>作者:${topic.user.username}</h4>
<div>
	<c:forEach items="${page.content}" var="reply">
		<ul>
			<li>回复内容:${reply.content}<br>
			<li>回复时间:<fm:formatDate value="${reply.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/><br>
			<li>回复人:${reply.replyUser.username}<br>
		</ul>
		===========================================================<br>
		
	</c:forEach>
<jsp:include page="/common/page.jsp"/>
</div>


<div>
	<form action="replyController/addReply" method="post">
		<input type="hidden" name="replyTopic.id" value="${topic.id}">
		<textarea  name="content" rows="10" cols="40"></textarea>
		<input type="submit" value="提交">
	</form>
</div>

</body>
</html>
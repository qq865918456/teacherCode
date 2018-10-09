<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getContextPath()+"/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	
	if("${sessionScope.user}"){
		// 1.查询出当前登录用户的消息数量
		$.post("InfoMationServlet?action=getInfoMationCount",function(data){
			$("#infoCount").append(data);
		})
	}
	
})
</script>
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionScope.user != null}">
	<h3>欢迎:${sessionScope.user.username}</h3>
	<h3>
		<a href="InfoMationServlet?action=getInfoMactionList">消息:</a>
		<font id="infoCount" color="red"></font>
	</h3>
</c:if>
<c:if test="${sessionScope.user == null}">
	<a href="login.jsp">请登录</a>
</c:if>

<table border="1" class="layui-table">
	<tr>
		<th>帖子编号</th>
		<th>标题</th>
		<th>发帖人</th>
		<th>发帖时间</th>
	</tr>
	<c:forEach items="${page.data}" var="topic">
		<tr>
			<td>${topic.id}</td>
			<td>
				<a href="TopicServlet?action=getTopicById&id=${topic.id}">${topic.title}</a>
			</td>
			<td>${topic.user.username}</td>
			<td>${topic.createDate}</td>
		</tr>
	</c:forEach>
</table>
<jsp:include page="/common/page.jsp"/>
</body>
</html>
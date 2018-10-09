<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    	
<!-- 分页导航 -->
<div>
	<c:if test="${page.pageSum > 1}">
		<c:if test="${page.page == 1 }">
			<a>首页</a>
			<a>上一页</a>
		</c:if>
		<c:if test="${page.page > 1}">
			<a href="${page.url }&page=1">首页</a>
			<a href="${page.url }&page=${page.page - 1 }">上一页</a>
		</c:if>
		
		<c:forEach items="${page.indexs }" var="index">
			<c:if test="${page.page == index }">
				<a>${index }</a>
			</c:if>
			<c:if test="${page.page != index }">
				<a href="${page.url }&page=${index}">${index }</a>
			</c:if>
		</c:forEach>


		<c:if test="${page.page < page.pageSum }">
			<a href="${page.url }&page=${page.page + 1 }">下一页</a>
			<a href="${page.url }&page=${page.pageSum }">尾页</a>
		</c:if>
		<c:if test="${page.page == page.pageSum }">
			<a>下一页</a>
			<a>尾页</a>
		</c:if>
			
			当前第${page.page }页/共${page.pageSum }页  
		</c:if>
</div>
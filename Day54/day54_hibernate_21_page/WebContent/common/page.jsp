<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--  <a href="${page.url}&currentPage=1">首页</a> --%>
<%--     <c:if test="${page.currentPage >1 }"> --%>
<%-- 	    <a href="${page.url}&currentPage=${page.currentPage -1 }">上一页</a> --%>
<%--     </c:if> --%>
<%--     <c:if test="${page.currentPage < page.totalPage }"> --%>
<%-- 	    <a href="${page.url}&currentPage=${page.currentPage +1 }">下一页</a> --%>
<%--     </c:if> --%>
<%--     <a href="${page.url}&currentPage=${page.totalPage}">尾页</a> --%>
<%--     当前页【${page.currentPage}】 --%>
<%--   总条数：【${page.totalCount }】 --%>
  <!-- 样式文件 -->
<html>
<head>
<base href="<%=request.getContextPath()+"/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 样式文件 -->
<link rel="stylesheet" href="js/layui/css/layui.css">
<!-- js文件 -->
<script src="js/layui/layui.js"></script>

<script type="text/javascript">

// 初始化分页
layui.use('laypage', function(){
  var laypage = layui.laypage;
  
  //执行一个laypage实例
  laypage.render({
    elem: 'test1' //注意，这里的 test1 是 ID，不用加 # 号
    ,count: "${page.totalCount}" //数据总数，从服务端得到
    ,limit:"${page.pageSize}"
    ,curr:"${page.currentPage}"
    ,layout: ['prev', 'page', 'next','limit','count']
    ,jump: function(obj, first){ // 切换页码的时候调用
    	debugger
        //obj包含了当前分页的所有参数，比如：
        console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
        console.log(obj.limit); //得到每页显示的条数
        
        //首次不执行
        if(!first){
        	// 点击下一页发送的请求
        	location.href="${page.url}&currentPage="+obj.curr+"&pageSize="+obj.limit;
        }
      }
  });
});
</script>
<title>Insert title here</title>
</head>
<body>
	<!-- div就是放分页导航条 -->
	<div id="test1"></div>
</body>
</html>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
	String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/backstyle.css" rel="stylesheet" type="text/css" />

<!-- 引入jquery文件 -->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){

// 	$.get("GoodsServlet?action=getParentGoodsList",function(data){},"JSON");

	// 返回的就是JSON数据
	$.getJSON("GoodsServlet?action=getParentGoodsList",function(data){
		debugger
		// 1.获取父类别元素对象
		var parentIdEle = $("#parentId")
		
		// 2.动态创建option
		for(var i =0;i<data.length;i++){
			var optionEle = document.createElement("option");
			
			// 3.赋值
			optionEle.value = data[i].id;
			optionEle.text = data[i].goodsname;
			
			// 4.把option添加到下拉框中
			parentIdEle.append(optionEle);
		}
		
		// 5.选中当前类别的父类别
		var paretnId = "${goods.goodsparentid}";
		$("#parentId").val(paretnId);
	})
})
</script>
</head>
<!-- 

	1.初始化父类别
	2.获取当前类别的父类别(${""})
	3.$("#GoodsPatnetId").val(${""});
 -->

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>修改商品类别信息</span></div>
    <form method="post">
    	<ul class="forminfo">
    	<input type="hidden" name="id" value="${goods.id}"></input>
	    <li><label>商品类别名称</label><input name="goodsname"  value="${goods.goodsname}" type="text" class="dfinput"/><i>标题不能超过30个字符</i></li>
	    	
	    <li><label>父类别</label>
	    		<select name="parentId" id="parentId" >
   				<option value="0">无</option>
	    		</select>
	    </i></li>
	    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    
    </form>
    </div>


<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>


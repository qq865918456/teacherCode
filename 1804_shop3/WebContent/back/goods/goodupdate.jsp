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
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	
	// 1.初始化大类
	var goods_parentidEle = $("#goods_parentid");
	
	// 大类id
	var goods_parentidValue ="${goodsInfo.goods_parentid}";
	// 小类id
	var goods_fatheridValue ="${goodsInfo.goods_fatherid}";
	
	$.getJSON("GoodsServlet?action=getParentGoodsList",function(data){
		// 2.动态创建option
		for(var i =0;i<data.length;i++){
			var optionEle = document.createElement("option");
			
			// 3.赋值
			optionEle.value = data[i].id;
			optionEle.text = data[i].goodsname;
			
			// 4.把option添加到下拉框中
			goods_parentidEle.append(optionEle);
			
			// 5.选中大类
			$("#goods_parentid").val("${goodsInfo.goods_parentid}");
		}
	})
	
	
	$("#goods_parentid").change(function(){
		
		// 1.获取选中的id
		var paretnId = $(this).val();
		
		initfatherid(paretnId);
		
	});
	
	// 根据大类id初始化小类
	initfatherid(goods_parentidValue,goods_fatheridValue);
	
	
	// 给上传文件组件动态绑定时间
	$("#uploadFile").change(function(){
		
		debugger
		
		// 1.获取当前上传文件的对象
		var fileObj = this.files[0];
		
		// 2.获取当前上传文件名称
// 		var fileName = fileObj.name;
		
		// 2.把文件对象转成一个utl，通过url可以访问图片
		var urlPng = window.URL.createObjectURL(fileObj);
		
		// 3.显示图片
// 		$("#png").attr("src","images/"+fileName);
		$("#png").attr("src",urlPng);
	});
	
})

	// 初始化小类
	function initfatherid(paretnId,fatherid){
		// 2.根据id查询小类
		$.getJSON("GoodsServlet?action=getGoodsListByParentId&id="+paretnId,function(data){
			
			// 清空之前的数据
			$("#goods_fatherid").find("option").remove();
			
			// 获取小类的元素的对象
			var goods_fatheridEle = $("#goods_fatherid");
			goods_fatheridEle.append("<option value = ''>请选择</option>");
			
			if(data.length > 0){ // 有些大类别下面没有小类别
				
				for(var i =0;i<data.length;i++){
					var optionEle = document.createElement("option");
					
					// 3.赋值
					optionEle.value = data[i].id;
					optionEle.text = data[i].goodsname;
					
					// 4.把option添加到下拉框中
					goods_fatheridEle.append(optionEle);
				}
			
				if(fatherid){
					$("#goods_fatherid").val(fatherid);	
				}
			}
		});
	}
	

</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>修改商品信息</span></div>
    <form method="post">
    	<input type="hidden" name="id" value="${goodsInfo.id}"/>
    	<ul class="forminfo">
	    <li><label>商品名称</label><input name="goods_name" value="${goodsInfo.goods_name}"  type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
	    <li><label>所属大类</label>
	    		<select name="goods_parentid" id ="goods_parentid">
	    			<option value="0">无</option>
	    		</select>
	    		
	    </i></li>
	    <li><label>所属小类</label>
	    	<select name="goods_fatherid" id="goods_fatherid">
	    		<option value="0">无</option>
	    		<option value=""></option>
	    	</select>
	    </i></li>
	    <li><label>商品价格</label><input name="goods_price" type="text" class="dfinput" value="${goodsInfo.goods_price}"/><i>标题不能超过30个字符</i></li>
	    <li><label>商品图片</label><input id="uploadFile" name="goods_pic" type="file"/><i>标题不能超过30个字符</i></li>
	    <li>
	    	<img id="png" src="images/${goodsInfo.goods_pic }"  style="width: 200px; height:200px;"alt="" />
	    </li>
	    <li><label>商品描述</label><textarea rows="8" cols="40" name="goods_description"  >${goodsInfo.goods_descrip}</textarea><i>标题不能超过30个字符</i></li>
	    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    
    </form>
    </div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>


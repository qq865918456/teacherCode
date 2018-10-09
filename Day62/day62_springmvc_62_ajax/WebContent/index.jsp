<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getContextPath() + "/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$("#but1").click(function(){
		// 发起请求
		$.get("getString1",function(data){
			$("#textId").html(data);
		});
	});
	
	$("#but2").click(function(){
		// 发起请求
		$.get("getJson",function(data){
			var temp = "";
			for(var i =0;i<data.length;i++){
				temp +="<tr><td>"+data[i].id+"</td><td>"+data[i].username+"</td><td>"+data[i].password+"</td></tr>"
			}
			$("#table").append(temp); // 往后追加
		},"JSON");
	});
})
</script>
</head>
<body>
<a href="test">test</a>
<button id="but1">获取普通字符串</button>
<button id="but2">获取JSON字符串</button>
<div id="textId"></div>
<div id="textId2">
	<table border="1" id="table">
		<tr>
			<th>id</th>
			<th>username</th>
			<th>password</th>
		</tr>
	</table>
</div>
</body>
</html>
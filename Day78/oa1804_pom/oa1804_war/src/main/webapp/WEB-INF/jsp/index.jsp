<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="${pageContext.request.contextPath}/"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Simpla Admin</title>
	<!--                       CSS                       -->
	<!-- Reset Stylesheet -->
	<link rel="stylesheet" href="resources/css/reset.css" type="text/css"
		  media="screen" />
	<!-- Main Stylesheet -->
	<link rel="stylesheet" href="resources/css/style.css" type="text/css"
		  media="screen" />
	<link rel="stylesheet" href="resources/css/invalid.css" type="text/css"
		  media="screen" />
	<!--                       Javascripts                       -->
	<!-- jQuery -->
	<script type="text/javascript"
			src="resources/scripts/jquery-1.8.3.min.js"></script>
	<!-- jQuery Configuration -->
	<script type="text/javascript"
			src="resources/scripts/simpla.jquery.configuration.js"></script>

	<!-- 引入dialog的js -->
	<link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css"/>
	<script type="text/javascript" src="resources/widget/dialog/jquery-ui-1.9.2.custom.min.js"></script>

	<!-- 引入融云的webSDK -->
	<script src="http://cdn.ronghub.com/RongIMLib-2.3.3.min.js"></script>

	<!-- Facebox jQuery Plugin -->
	<script type="text/javascript" src="resources/scripts/facebox.js"></script>
	<!-- jQuery WYSIWYG Plugin -->
	<script type="text/javascript" src="resources/scripts/jquery.wysiwyg.js"></script>
	<style>
		body {
			overflow-x: hidden;
			overflow-y: hidden;
		}
	</style>




	<script type="text/javascript">
        $(function(){
            $("#homeframe").css("height", $(window).height());
        });

        function itemclick(ele){
            $("#homeframe").attr("src", ele.name);
            $(".current").removeClass("current");
            $(ele).addClass("current");
        }


        /**
		 * 初始化融云的SDK
		 */
		$(function(){
		    //初始化SDK
            RongIMLib.RongIMClient.init("qf3d5gbjqhruh");

            //监听有没有连接上融云的服务器
            // 设置连接监听状态 （ status 标识当前连接状态 ）
            // 连接状态监听器
            RongIMClient.setConnectionStatusListener({
                onChanged: function (status) {
                    switch (status) {
                        case RongIMLib.ConnectionStatus.CONNECTED:
                            console.log('链接成功');
                            break;
                        case RongIMLib.ConnectionStatus.CONNECTING:
                            console.log('正在链接');
                            break;
                        case RongIMLib.ConnectionStatus.DISCONNECTED:
                            console.log('断开连接');
                            break;
                        case RongIMLib.ConnectionStatus.KICKED_OFFLINE_BY_OTHER_CLIENT:
                            console.log('其他设备登录');
                            break;
                        case RongIMLib.ConnectionStatus.DOMAIN_INCORRECT:
                            console.log('域名不正确');
                            break;
                        case RongIMLib.ConnectionStatus.NETWORK_UNAVAILABLE:
                            console.log('网络不可用');
                            break;
                    }
                }});

            //监听有没有人给我发消息
            // 消息监听器
            RongIMClient.setOnReceiveMessageListener({
                // 接收到的消息
                onReceived: function (message) {
                    // 判断消息类型
                    switch(message.messageType){
                        case RongIMClient.MessageType.TextMessage:
                            // message.content.content => 消息内容
							console.log("接受到消息：" + message.content.content);
							console.log("谁给我发送的消息：" + message.senderUserId);

							//判断当前有没有打开和 message.senderUserId 这个人的聊天窗口
							var toid = $("#toid").val();
							if(toid == message.senderUserId){
								//正在和这个人聊天
								var content = message.content.content;
								var toname = $("#toname").val();
                                var time = new Date().getFullYear() + "-" + (new Date().getMonth() + 1) + "-" + new Date().getDate();
                                $("#msg_content_id").append(toname + " " +  time + "<br/> " + content + "<br/><br/>");

							} else {
							    //并没有和这个人再聊天
								var length = $("#number_" + message.senderUserId).length;
								if(length > 0){
                                    var number = $("#number_" + message.senderUserId).html();
                                    number++;
                                    $("#number_" + message.senderUserId).html(number);
								} else {
                                    var username = $("#user_" + message.senderUserId).html();
                                    username = username + "(<span id='number_" + message.senderUserId + "'>1</span>)";
                                    $("#user_" + message.senderUserId).html(username);
								}
							}

                            break;
                        default:
                            break;
                    }
                }
            });


            RongIMClient.connect('${emp.token}', {
                onSuccess: function(userId) {
                    console.log("Connect successfully. " + userId);
                },
                onTokenIncorrect: function() {
                    console.log('token无效');
                },
                onError:function(errorCode){
                    var info = '';
                    switch (errorCode) {
                        case RongIMLib.ErrorCode.TIMEOUT:
                            info = '超时';
                            break;
                        case RongIMLib.ConnectionState.UNACCEPTABLE_PAROTOCOL_VERSION:
                            info = '不可接受的协议版本';
                            break;
                        case RongIMLib.ConnectionState.IDENTIFIER_REJECTED:
                            info = 'appkey不正确';
                            break;
                        case RongIMLib.ConnectionState.SERVER_UNAVAILABLE:
                            info = '服务器不可用';
                            break;
                    }
                    console.log(errorCode);
                }
            });
		});


        /**
		 * 弹出框显示除了自己之外的所有的职工信息
         */
        function openDialog(){

            $("#friend_div").html("");

            $.ajax({
				url:"${pageContext.request.contextPath}/emp/queryAllNoMyself",
				success:function(data){
                    $("#friend_div").append("<ul>");
					for(var i = 0; i < data.length; i++){
						$("#friend_div").append("<li><a id='user_" + data[i].id + "' ondblclick='openMsgDialog(" + data[i].id + ", \"" + data[i].name + "\");'>" + data[i].name + "</a></li>");
					}
                    $("#friend_div").append("</ul>");
				},
				dataType:"json"
			});

			$("#friend_div_id").dialog({
				title:"我的同事",
				width:300,
				height:500
			});
		}

		function openMsgDialog(toid, toname){
            //发送消息的目标职工的id
            $("#toid").val(toid);
            $("#toname").val(toname);
            $("#to_div").dialog({
				title:"与" + toname + "聊天",
				width:700,
				height:600
			});
		}

		//发送消息
		function sendMsg(){
            var toid = $("#toid").val();

			//将消息内容转到聊天框中
			var content = $("#content").val();
            $("#content").val("");//清空输入框
			var time = new Date().getFullYear() + "-" + (new Date().getMonth() + 1) + "-" + new Date().getDate();
			$("#msg_content_id").append("${emp.name} " +  time + "<br/> " + content + "<br/><br/>");

			//通过ajax将消息发送给服务器
			$.ajax({
				type:"POST",
				url:"${pageContext.request.contextPath}/im/sendmsg",
				data:{toid:toid, content:content}
			});
		}
	</script>
</head>
<body>
<div id="body-wrapper">
	<!-- Wrapper for the radial gradient background -->
	<div id="sidebar">
		<div id="sidebar-wrapper">
			<!-- Sidebar with logo and menu -->
			<h1 id="sidebar-title">
				<a href="#">Simpla Admin</a>
			</h1>
			<!-- Logo (221px wide) -->
			<a href="#"><img id="logo" src="resources/images/logo.png"
							 alt="Simpla Admin logo" /></a>
			<!-- Sidebar Profile links -->
			<div id="profile-links">
				你好, <a title="Edit your profile">
					<shiro:user>
						<shiro:principal property="name"/>
					</shiro:user>
				</a>, 你有 <a>0 条消息</a><br />
				<br /> <a title="我的消息" onclick="openDialog();">我的消息</a> | <a href="/oa/logout"
													 title="Sign Out">注销</a>

			</div>
			<!-- 好友列表的弹出框 -->
			<div id="friend_div_id" style="display: none;">
				<div id="friend_div"></div>
			</div>

			<!-- 聊天窗口 -->
			<div id="to_div" style="display: none">
				<input type="hidden" name="toid" id="toid" value="-1"/>
				<input type="hidden" name="toname" id="toname" value=""/>
				<div id="msg_content_id"
					 style="width: 100%; height: 60%; border: #7d7d7d solid 1px; margin-bottom: 20px; padding: 20px 20px 20px 20px"></div>
				<textarea class="text-input textarea" id="content"
						  name="content" cols="60" rows="10"></textarea>
				<button class="mybutton" onclick="sendMsg();">发送</button>
			</div>

			<!-- 引入菜单 -->
			<ul id="main-nav">
				<li><a onclick="itemclick(this);" name="/index/home"
					   class="nav-top-item no-submenu"> 主页 </a></li>
				<%--<li><a class="nav-top-item"> 组织管理 </a>
					<ul>
						<li><a onclick="itemclick(this);" name="dep/deplist">部门管理</a></li>
						<li><a onclick="itemclick(this);" name="emp/emplist">职工管理</a></li>
						<li><a onclick="itemclick(this);" name="role/rolelist">角色管理</a></li>
						<li><a onclick="itemclick(this);" name="resc/resclist">权限管理</a></li>
					</ul>
				</li>--%>

				<!-- 获得所有的权限，循环生产菜单的标签 -->
				<c:forEach items="${emp.rescs}" var="resc">
					<c:if test="${resc.rstate == 1}">
						<!-- 一级菜单 -->
						<li><a class="nav-top-item"> ${resc.rname} </a>
							<ul>
								<!-- 二级菜单 -->
								<c:forEach items="${emp.rescs}" var="resc2">
									<c:if test="${resc2.rstate == 2 && resc2.pid == resc.id}">
										<li><a onclick="itemclick(this);" name="${resc2.rpath}">${resc2.rname}</a></li>
									</c:if>
								</c:forEach>
							</ul>
						</li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
	</div>
	<!-- End #sidebar -->
	<iframe id="homeframe" name="homeframe" src="/index/home"
			width="100%" scrolling="auto" />

</div>

</body>
<!-- Download From www.exet.tk-->
</html>

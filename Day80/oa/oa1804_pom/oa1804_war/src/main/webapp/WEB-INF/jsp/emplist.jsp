<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 2018/8/28
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="${pageContext.request.contextPath}/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>职工管理</title>
    <!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
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
    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script type="text/javascript" src="resources/widget/dialog/jquery-ui-1.9.2.custom.min.js"></script>

    <!-- 时间控件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/widget/My97DatePicker/WdatePicker.js"></script>


    <!-- ztree树形结构 -->
    <link rel="stylesheet" href="resources/widget/zTree/zTreeStyle/zTreeStyle.css">
    <script type="text/javascript" src="resources/widget/zTree/jquery.ztree.all.min.js"></script>


    <!-- webuploader的上传控件 -->
    <link rel="stylesheet" href="resources/widget/webuploader/webuploader.css">
    <script type="text/javascript" src="resources/widget/webuploader/webuploader.min.js"></script>


    <script type="text/javascript">

        //webuploader的控件对象
        var uploader;

        //弹出添加职工的弹出框
        function openDialog(){

            //清空弹出框的内容
            $("#id").val("");

            //处理照片
            $("#header").attr("src", "resources/images/icons/header.jpg");

            //职工姓名
            $("#name_id").val("");

            //邮箱
            $("#email_id").val("");

            //密码
            $("#password_id").val("");

            //性别
            $("input[name='sex'][value='1']").attr("checked","checked");

            //电话
            $("#phone_id").val("");

            //所属部门
            //<input type="button" value="xx"/>
            //<button>xxxxx</button>
            $("#select_dep_id").html("无");
            $("#did").val("");


            //个人简介
            $("#einfo_id").val("");


            //通过js将时间进行转换
            //生日
            $("#birthday_id").val("");

            //入职时间
            $("#entrytime_id").val("");




            $("#emp_dialog").dialog({
                title:"新增职工",
                width:600,
                height:500,
                modal:true
            });

            //刷新weuploader
            uploader.flush();
        }


        //选择部门
        function query_deps_ajax(){
            $.ajax({
                url:"${pageContext.request.contextPath}/dep/queryall",
                success:function(data){
                    //初始化ztree
                    var settings = {
                        data:{
                            key:{
                                name:"dname"
                            },
                            simpleData:{
                                enable:true,//启用简单json模式
                                pIdKey:"pid"
                            }
                        },
                        view:{
                            showIcon:false//隐藏图标
                        },
                        callback:{
                            onClick:function(event, treeId, treeNode){
                                //ztree点击事件 treeNode - 代表当前被点击的节点json对象
                                $("#select_dep_id").html(treeNode.dname);
                                $("#did").val(treeNode.id);
                                //关闭弹出框
                                $("#ztree_dialog").dialog("close");
                            }
                        }
                    };
                    var zNodes = data;
                    var ele = $("#ztree");

                    //初始化ztree
                    var ztreeObject = $.fn.zTree.init(ele, settings, zNodes);
                    ztreeObject.expandAll(true);

                    //选择部门的回显
                    var did = $("#did").val();
                    if(did != null && did != ""){
                        //说明已经选中了一个部门

                        //通过部门id找到被选中的节点
                        var nodes = ztreeObject.getNodesByParam("id", did, null);

                        //让该节点呈现被选中的状态
                        ztreeObject.selectNode(nodes[0]);
                    }


                    //弹出dialog
                    $("#ztree_dialog").dialog({
                        title:"选择部门",
                        width:300,
                        height:200,
                        modal:false
                    });

                },
                dataType:"json"
            });
        }


        //修改职工的数据
        function update_emp(eid){
            //使用ajax通过职工id获取到该职工的信息
            $.get("${pageContext.request.contextPath}/emp/queryById",{eid:eid},function(data){
                //将职工信息填充到dialog上
                $("#id").val(data.id);//id

                //处理照片
                if(data.image != null && data.image != ""){
                    $("#header").attr("src", "${pageContext.request.contextPath}/img/getImg?path=" + data.image);
                    $("#image").val(data.image);
                } else {
                    $("#header").attr("src", "resources/images/icons/header.jpg")
                }

                //职工姓名
                $("#name_id").val(data.name);

                //邮箱
                $("#email_id").val(data.email);

                //密码
                $("#password_id").val(data.password);

                //性别
                $("input[name='sex'][value='" + data.sex + "']").attr("checked","checked");

                //电话
                $("#phone_id").val(data.phone);

                //所属部门
                //<input type="button" value="xx"/>
                //<button>xxxxx</button>
                $("#select_dep_id").html(data.did);
                $("#did").val(data.did);


                //个人简介
                $("#einfo_id").val(data.einfo);


                //通过js将时间进行转换
                var birthday = new Date(data.birthday);
                //生日
                $("#birthday_id").val(birthday.getFullYear() + "-" + (birthday.getMonth() + 1) + "-" + birthday.getDate());

                //入职时间
                var entrytime = new Date(data.entrytime);
                $("#entrytime_id").val(entrytime.getFullYear() + "-" + (entrytime.getMonth() + 1) + "-" + entrytime.getDate());

                //弹出dialog
                $("#emp_dialog").dialog({
                    title:"修改职工",
                    width:600,
                    height:500,
                    modal:true
                });

            },"json");
        }


        /**
         * 弹出角色的选择框
         */
        function open_roles_dialog(eid){

            //给隐藏域设置职工的id
            $("input[name='eid']").val(eid);

            /**
             * 职工已经拥有的角色回显的功能
             *
             * 方式一：
             * 1、通过ajax获得所有角色信息 - 使用同步的ajax
             * 2、再通过ajax获得该职工拥有的角色信息 - 使用同步的ajax
             * 3、生成角色列表时，根据两个结果集判断，当前角色是否需要被勾选
             *
             * 同步ajax
             * var xmlhttprequest  =$.ajax({
             *    async:false
             * });
             * var result = xmlhttprequest.responseText;
             *
             *
             * 方式二:
             * 1、通过ajax获得角色列表信息
             *      1）传入eid(职工的id)
             *      2）返回的结果出了角色列表以外，每个角色后面都跟着一个boolean类型，这个Boolean表示这个角色是否是这个职工所拥有
             *
             *
             *
             */

            //获得角色信息
            $.get("${pageContext.request.contextPath}/role/queryall",{eid:eid},function(data){

                var html = "<ul>";
                for(var i = 0; i < data.length; i++){
                    html += "<li>";
                    if(data[i].isHave){
                        html += "<input type='checkbox' name='rid' value='" + data[i].id + "' checked/>";
                    } else {
                        html += "<input type='checkbox' name='rid' value='" + data[i].id + "'/>";
                    }

                    html += data[i].rolename;
                    html + "</li>";
                }
                html += "</ul>";

                //将拼接好的html放入到弹出框当中
                $("#role_list").html(html);

                //弹出dialog
                $("#role_dialog").dialog({
                    title:"选择角色",
                    width:300,
                    height:200,
                    modal:true
                });

            },"json");

            //获得职工拥有的角色
            $.get()

        }
    </script>

</head>
<body>
<div id="main-content">
    <div class="content-box">
        <!-- End .content-box-header -->
        <div class="content-box-content">
            <div class="tab-content default-tab" id="tab1">

                <h1>职工管理</h1>
                <table>
                    <thead>
                    <tr>
                        <th><input class="check-all" type="checkbox" /></th>
                        <th>编号</th>
                        <th>姓名</th>
                        <th>照片</th>
                        <th>性别</th>
                        <th>所属部门</th>
                        <th>入职时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>

                    <!-- 表的内容 -->
                    <tbody>
                        <c:forEach items="${emps}" var="emp">
                            <tr>
                                <th><input type="checkbox" /></th>
                                <th>${emp.id}</th>
                                <th>${emp.name}</th>
                                <th>
                                    <c:if test="${emp.image == null}">
                                        <img src="resources/images/icons/header.jpg" width="100">
                                    </c:if>
                                    <c:if test="${emp.image != null}">
                                        <img src="${pageContext.request.contextPath}/img/getImg?path=${emp.image}" width="100" height="90">
                                    </c:if>
                                </th>
                                <th>${emp.sex == 1 ? '男' : '女'}</th>
                                <th>${emp.did}</th>
                                <th><fmt:formatDate value="${emp.entrytime}" pattern="yyyy-MM-dd"/></th>
                                <th>
                                    <!-- Icons
                                     修改：
                                     1、ajax -> 通过用户的id查询该用户的信息
                                     2、数据的填充
                                     3、弹出弹出框
                                     4、提交修改内容
                                       1）根据是否有id判断当前是增加还是修改
                                       2）准备两个url insert update
                                       3) 不管是修改还是增加都用insert
                                     -->
                                    <a title="Edit" onclick="update_emp(${emp.id});"><img
                                        src="resources/images/icons/pencil.png" alt="Edit" /></a>
                                    <a href="#" title="Delete"><img
                                            src="resources/images/icons/cross.png" alt="Delete" />
                                    </a>

                                    <!-- 选择相应的职工的角色：
                                        1、查询所有的角色信息 - ajax
                                        2、将ajax查询的结果输出到弹出框中，前面加上checkbox
                                        3、用户勾选角色，点击提交按钮
                                        4、发送请求给服务器(form? href? ajax?)form, 发送哪些数据给服务器？ eid rid[]
                                        5、将eid - rid[] 插入到中间表 怎么插入？
                                               根据eid 删除中间表

                                               eid - rid[0]
                                               eid - rid[1]
                                               ....

                                     -->
                                    <a title="Edit Meta" onclick="open_roles_dialog(${emp.id});"><img
                                            src="resources/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a>
                                </th>
                            </tr>
                        </c:forEach>
                    </tbody>


                    <!-- 表的尾部 -->
                    <tfoot>
                    <tr>
                        <td colspan="6">
                            <div class="bulk-actions align-left">
                                <shiro:hasPermission name="/emp/insert">
                                    <a class="mybutton" onclick="openDialog();">新增职工</a>
                                </shiro:hasPermission>
                            </div>
                            <%--<div class="pagination">
                                <a href="#" title="First Page">&laquo; First</a>
                                <a href="#" title="Previous Page">&laquo; Previous</a>
                                <a href="#" class="number" title="1">1</a>
                                <a href="#" class="number" title="2">2</a>
                                <a href="#" class="number current" title="3">3</a>
                                <a href="#" class="number" title="4">4</a>
                                <a href="#" title="Next Page">Next &raquo;</a>
                                <a href="#" title="Last Page">Last &raquo;</a>
                            </div>--%> <!-- End .pagination -->

                            <!-- 分页导航 -->
                            <%@ include file="page.jsp"%>
                            <div class="clear"></div>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
        <!-- End .content-box-content -->
    </div>
</div>
<!-- End #main-content -->

<!-- 新增职工的弹出框 -->
<div id="emp_dialog" style="display: none;">
    <form action="${pageContext.request.contextPath}/emp/insert" method="post">
        <fieldset>
            <!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
            <input name="id" id="id" type="hidden" value=""/>

            <p>
                <label>照片</label>

                <img id="header" src="resources/images/icons/header.jpg" width="100"/>
                <input type="hidden" id="image" name="image" value=""/>

                <div id="filePicker">选择图片</div>
            </p>

            <p>
                <label>职工姓名</label>
                <input
                        class="text-input small-input" type="text" id="name_id"
                        name="name" />
            </p>

            <p>
                <label>邮箱</label>
                <input
                        class="text-input small-input" type="text" id="email_id"
                        name="email" />
            </p>

            <p>
                <label>密码</label>
                <input
                        class="text-input small-input" type="password" id="password_id"
                        name="password" />
            </p>

            <p>
                <label>性别</label>
                <input type="radio" name="sex" value="1" checked/>男<br/>
                <input type="radio" name="sex" value="0"/>女
            </p>

            <p>
                <label>电话</label>
                <input
                        class="text-input small-input" type="text" id="phone_id"
                        name="phone" />
            </p>

            <p>
                <label>选择部门</label>
                <button id="select_dep_id" class="mybutton" type="button" onclick="query_deps_ajax();">无</button>
                <input type="hidden" id="did" name="did" value="-1"/>
            </p>
            <p>
                <label>个人简介</label>
                <textarea class="text-input textarea wysiwyg" id="einfo_id"
                          name="einfo" cols="79" rows="15"></textarea>
            </p>

            <p>
                <label>生日</label>
                <input
                        class="text-input small-input Wdate" type="text" id="birthday_id"
                        name="birthday" onclick="WdatePicker()"/>
            </p>

            <p>
                <label>入职时间</label>
                <input
                        class="text-input small-input Wdate" type="text" id="entrytime_id"
                        name="entrytime" onclick="WdatePicker()"/>
            </p>



            <p>
                <input class="mybutton" type="submit" value="提交" />
            </p>
        </fieldset>
        <div class="clear"></div>
        <!-- End .clear -->
    </form>
</div>

<!-- 树形结构的弹出框 -->
<div id="ztree_dialog" style="display: none;">
    <div id="ztree" class="ztree"></div>
</div>


<!-- 角色列表的弹出框 -->
<div id="role_dialog" style="display: none;">
    <form action="${pageContext.request.contextPath}/role/selectroles" method="post">
        <!-- 职工的id的隐藏域 -->
        <input type="hidden" name="eid" value=""/>
        <!-- 角色列表 -->
        <div id="role_list"></div>
        <button class="mybutton" type="submit">提交</button>
    </form>
</div>

<script type="text/javascript">
    //初始化webuploader
    uploader = WebUploader.create({
        // 选完文件后，是否自动上传。
        auto: true,
        // swf文件路径
        swf: '${pageContext.request.contextPath}/resources/widget/webuploader/Uploader.swf',
        // 文件接收服务端。
        server: '${pageContext.request.contextPath}/img/upload',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#filePicker'
    });

    //处理上传的缩略图
    //绑定事件
    //fileQueued - 当选择一个文件进入队列中的时候 触发
    uploader.on('fileQueued', function(file){
        //生成缩略图，并且显示到指定的位置

        //显示头像的控件
        var img = $("#header");

        // 创建缩略图
        // 如果为非图片文件，可以不用调用此方法。
        // thumbnailWidth x thumbnailHeight 为 100 x 100
        uploader.makeThumb( file, function( error, src ) {
            if ( error ) {
                return;
            }

            img.attr( 'src', src );
        }, 100, 100 );
    });

    //图片上传成功之后的回调
    uploader.on('uploadSuccess', function(file, response){
        $("#image").val(response.fileuploader);
    });

    uploader.on('error', function(type){
        //文件上传失败！！！！
    });

</script>

</body>
</html>
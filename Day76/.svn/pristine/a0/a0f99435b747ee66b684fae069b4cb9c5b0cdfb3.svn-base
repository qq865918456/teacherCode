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
    <title>角色管理</title>
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

    <script type="text/javascript">

        /**
         * 打开弹出框
         */
        function openDialog(){
            $("#dialog_div").dialog({
                title:"新增部门",
                width:600,
                height:500,
                modal:true
            });
        }

        //角色id
        var rid;
        var ztreeObject;
        /**
         * 根据角色id选择权限
         * @param rid
         */
        function select_resc(lrid){

            rid = lrid;

            /**
             * 1、根据ajax找出多有的权限
             * 2、以ztree的形式展示出来，并且带有复选框
             * 3、提交请求（ajax）， rid reid[]
             * 4、删除数据中该角色的所有权限管理
             * 5、插入最新的关联关系
             */
            //查询所有权限 - ajax
            //dialog弹出ztree
            $.get("${pageContext.request.contextPath}/resc/queryall", {rid: rid}, function (data) {
                //初始化ztree
                var settings = {
                    data: {
                        key: {
                            name: "rname"
                        },
                        simpleData: {
                            enable: true,//启用简单json模式
                            pIdKey: "pid"
                        }
                    },
                    view: {
                        showIcon: false//隐藏图标
                    },
                    callback: {

                    },
                    check:{
                        enable: true,
                        chkboxType: {"Y": "ps", "N":"s" }
                    }
                };
                var zNodes = data;
                var ele = $("#ztree");

                //初始化ztree
                ztreeObject = $.fn.zTree.init(ele, settings, zNodes);
                ztreeObject.expandAll(true);

                //弹出dialog
                $("#ztree_dialog").dialog({
                    title: "选择权限",
                    width: 300,
                    height: 200,
                    modal: false
                });


            }, "json");
        }

        /**
         * 提交角色所关联的权限
         */
        function submit_resc(){
            //角色id rid
            //权限ids
            var reids = new Array();
            var nodes = ztreeObject.getCheckedNodes(true);
            for(var i = 0; i < nodes.length; i++){
                reids.push(nodes[i].id);
            }

            //ajax提交权限
            $.ajax({
                type:"POST",
                traditional: true,
                url:"${pageContext.request.contextPath}/resc/selectresc",
                data: {rid:rid, reids: reids},
                success:function(data){
                    if(data > 0){
                        alert("权限修改成功！");
                        $("#ztree_dialog").dialog("close");
                    } else {
                        alert("权限修改失败！");
                    }
                }
            });
        }

    </script>

</head>
<body>
<div id="main-content">
    <div class="content-box">
        <!-- End .content-box-header -->
        <div class="content-box-content">
            <div class="tab-content default-tab" id="tab1">

                <h1>角色管理</h1>
                <table>
                    <thead>
                        <tr>
                            <th><input class="check-all" type="checkbox" /></th>
                            <th>编号</th>
                            <th>角色名称</th>
                            <th>角色秒杀</th>
                            <th>角色状态</th>
                            <th>操作</th>
                        </tr>
                    </thead>

                    <!-- 表的内容 -->
                    <tbody>
                        <c:forEach items="${roles}" var="role">
                            <tr>
                                <td><input type="checkbox" /></td>
                                <td>${role.id}</td>
                                <td>${role.rolename}</td>
                                <td>${role.roledesc}</td>
                                <td>${role.rolestate}</td>
                                <td>
                                    <!-- Icons -->
                                        <a href="#" title="Edit"><img
                                            src="resources/images/icons/pencil.png" alt="Edit" /></a>
                                        <a
                                            href="#" title="Delete"><img
                                            src="resources/images/icons/cross.png" alt="Delete" />
                                            </a>
                                        <a
                                            onclick="select_resc(${role.id});" title="Edit Meta"><img
                                            src="resources/images/icons/hammer_screwdriver.png"
                                            alt="Edit Meta" /></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>


                    <!-- 表的尾部 -->
                    <tfoot>
                    <tr>
                        <td colspan="6">
                            <div class="bulk-actions align-left">
                                <shiro:hasPermission name="/role/insert">
                                    <a class="mybutton" onclick="openDialog();">新增角色</a>
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


<!-- 弹出框的区域 -->
<div id="dialog_div" style="display: none;">
                <form action="${pageContext.request.contextPath}/role/insert" method="post">
                    <fieldset>
                        <!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
                        <p>
                            <label>角色名称</label>
                            <input
                                class="text-input small-input" type="text" id="rolename_id"
                                name="rolename" />
                        </p>
                        <p>
                            <label>角色描述</label>
                            <textarea class="text-input textarea wysiwyg" id="roledesc_id"
                                      name="roledesc" cols="79" rows="15"></textarea>
                        </p>
                        <p>
                            <input class="mybutton" type="submit" value="提交" />
                        </p>
                    </fieldset>
                    <div class="clear"></div>
                    <!-- End .clear -->
                </form>
            <!-- End #tab2 -->
        <!-- End .content-box-content -->
</div>

<!-- 树形结构的弹出框 -->
<div id="ztree_dialog" style="display: none;">
    <div id="ztree" class="ztree"></div>
    <button type="button" class="mybutton" onclick="submit_resc();">提交</button>
</div>

</body>
</html>
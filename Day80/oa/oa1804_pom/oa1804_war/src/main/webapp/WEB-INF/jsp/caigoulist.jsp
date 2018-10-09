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
    <!-- jQuery Configuration
    <script type="text/javascript"
            src="resources/scripts/simpla.jquery.configuration.js"></script> -->

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
                title:"申请采购",
                width:600,
                height:500,
                modal:true
            });
        }

        /**
         * 查询所有职工
         */
        $(function(){
            $.ajax({
                url:"${pageContext.request.contextPath}/emp/queryall",
                success:function(data){
                    for(var i = 0; i < data.length; i++){
                        $("#sname_id").append("<option value='" + data[i].id + "'>" + data[i].name + "</option>");
                    }
                },
                type:"json"
            });
        });




    </script>

</head>
<body>
<div id="main-content">
    <div class="content-box">
        <!-- End .content-box-header -->
        <div class="content-box-content">
            <div class="tab-content default-tab" id="tab1">

                <h1>采购管理</h1>
                <table>
                    <thead>
                    <tr>
                        <th><input class="check-all" type="checkbox" /></th>
                        <th>编号</th>
                        <th>标题</th>
                        <th>明细</th>
                        <th>预算</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>

                    <!-- 表的内容 -->
                    <tbody>
                    <c:forEach items="${clist}" var="caigou">
                        <tr>
                            <th><input class="check-all" type="checkbox" /></th>
                            <th>${caigou.id}</th>
                            <th>${caigou.title}</th>
                            <th>${caigou.info}</th>
                            <th>${caigou.money}</th>
                            <th>
                                <c:if test="${caigou.cstate == 1}">
                                    <font color="#9acd32">正在审批...</font>
                                </c:if>
                                <c:if test="${caigou.cstate == 2}">
                                    <font color="#7cfc00">已通过</font>
                                </c:if>
                                <c:if test="${caigou.cstate == 3}">
                                    <font color="red">已关闭</font>
                                </c:if>
                            </th>
                            <th>操作</th>
                        </tr>
                    </c:forEach>
                    </tbody>


                    <!-- 表的尾部 -->
                    <tfoot>
                    <tr>
                        <td colspan="6">
                            <div class="bulk-actions align-left">
                                <a class="mybutton" onclick="openDialog();">申请采购</a>
                            </div>

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
    <form action="${pageContext.request.contextPath}/caigou/insert" method="post">
        <fieldset>
            <!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
            <p>
                <label>标题</label>
                <input
                        class="text-input small-input" type="text" id="title_id"
                        name="title" />
            </p>
            <p>
                <label>明细</label>
                <textarea class="text-input textarea wysiwyg" id="info_id"
                          name="info" cols="79" rows="15"></textarea>
            </p>
            <p>
                <label>预算</label>
                <input
                        class="text-input small-input" type="text" id="money_id"
                        name="money" />
            </p>
            <p>
                <label>受理人</label>
                <select id="sname_id" name="sname">
                    <option value="-1">--请选择--</option>
                </select>
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

</body>
</html>
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



    </script>

</head>
<body>
<div id="main-content">
    <div class="content-box">
        <!-- End .content-box-header -->
        <div class="content-box-content">
            <div class="tab-content default-tab" id="tab1">

                <h1>任务管理</h1>
                <table>
                    <thead>
                    <tr>
                        <th><input class="check-all" type="checkbox" /></th>
                        <th>任务的id</th>
                        <th>任务的名称</th>
                        <th>创建的时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>

                    <!-- 表的内容 -->
                    <tbody>
                    <c:forEach items="${tasks}" var="task">
                        <tr>
                            <th><input class="check-all" type="checkbox" /></th>
                            <th>${task.id}</th>
                            <th>${task.name}</th>
                            <th>${task.createTime}</th>
                            <th><a href="/task/banli?taskid=${task.id}">办理任务</a></th>
                        </tr>
                    </c:forEach>
                    </tbody>


                    <!-- 表的尾部 -->
                    <tfoot>
                    <tr>
                        <td colspan="6">
                            <div class="bulk-actions align-left">
                            </div>

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


</body>
</html>
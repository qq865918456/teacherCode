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

        /**
         * 任务处理
         * @param flag
         */
        function taskChuli(flag){
            $("#flag_id").val(flag);
            $("#formid").submit();
        }

    </script>

</head>
<body>
<div id="main-content">
    <div class="content-box">
        <!-- End .content-box-header -->
        <div class="content-box-content">
            <div class="tab-content default-tab" id="tab1">

                <form id="formid" action="${pageContext.request.contextPath}/task/againshengqing" method="post">
                    <fieldset>
                        <input type="hidden" name="id" value="${caigou.id}"/>
                        <input type="hidden" name="eid" value="${caigou.eid}"/>
                        <input type="hidden" id="flag_id" name="flag" value="true"/>
                        <input type="hidden" name="taskId" value="${taskId}"/>
                        <!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
                        <p>
                            <label>标题</label>
                            <input
                                    class="text-input small-input" type="text" id="title_id" value="${caigou.title}"
                                    name="title" />
                        </p>
                        <p>
                            <label>明细</label>
                            <textarea class="text-input textarea wysiwyg" id="info_id"
                                      name="info" cols="79" rows="15">${caigou.info}</textarea>
                        </p>
                        <p>
                            <label>预算</label>
                            <input
                                    class="text-input small-input" type="text" id="money_id"
                                    name="money" value="${caigou.money}"/>
                        </p>
                        <p>
                            <label>受理人</label>
                            <select id="sname_id" name="sname">
                                <option value="-1">--请选择--</option>
                            </select>
                        </p>

                        <p>
                            <label>审核意见</label>
                            <table>
                            <tr>
                                <td>审核人</td>
                                <td>意见内容</td>
                                <td>是否通过</td>
                            </tr>
                            <c:forEach items="${yijians}" var="yijian">
                                <tr>
                                    <td>${yijian.eid}</td>
                                    <td>${yijian.content}</td>
                                    <td>${yijian.state == 0 ? '通过' : '驳回'}</td>
                                </tr>
                            </c:forEach>
                             </table>
                        </p>


                        <p>
                            <input class="mybutton" type="button" onclick="taskChuli(true);" value="再次申请" />
                            <input class="mybutton" type="button" onclick="taskChuli(false);" value="关闭" />
                        </p>
                    </fieldset>
                    <div class="clear"></div>
                    <!-- End .clear -->
                </form>

            </div>
        </div>
        <!-- End .content-box-content -->
    </div>
</div>
<!-- End #main-content -->



</body>
</html>
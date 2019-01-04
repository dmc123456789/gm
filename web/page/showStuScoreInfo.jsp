<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath() %>/" />
    <script type="text/javascript" src="static/js/jquery-1.8.2.min.js"></script>
    <%@include file="layUI.jsp"%>
    <style>
        input{
            border-radius: 5px;
            height: 30px;
            font-size: 15px;
            padding-left: 5px;
        }
    </style>
</head>
<body>
<form action="doStu?action=unionQuery" method="post">
    <label>成绩:</label>
    <input type="text" name="stuId" placeholder="请输入学号" />
    <label>姓名:</label>
    <input type="text" name="stuName" placeholder="请输入姓名"  />
    <label>课程:</label>
    <select name="couId">

    </select>
    <input class="layui-btn " type="submit"  value="查询"/>
</form>
<script>
    $(function () {
        var url = "doStu";
        var parameterData = {action:"showCou"}
        //$.post(url,function(){},"json");
        //执行AJax请求并响应内容类型为JSON格式数据
        $.getJSON(url,parameterData,function (couList) {
            //jq中增强for循环
            $.each(couList,function(index,cou){
               $("select[name='couId']").append("<option value='"+cou.couId+"'>"+cou.couName+"</option>")
           })
        })
    });
</script>
<a class="layui-btn" target="iframe_context" href="doStu?action=queryScore&pageNumber=1&orderBy=asc">升序</a>
<a class="layui-btn" target="iframe_context" href="doStu?action=queryScore&pageNumber=1&orderBy=desc">降序</a>

    <c:choose>
        <c:when test="${not empty sessionScope.Page.pageData}">
            <table id="stu" width="90%" class="layui-table" lay-size="sm">
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>成绩</th>
                    <th>科目名称</th>
                    <th colspan="2">操作</th>
                </tr>
                <c:forEach items="${sessionScope.Page.pageData}" var="extStu">
                    <tr>
                        <td>${extStu.stuId}</td>
                        <td>${extStu.stuName}</td>
                        <td>${extStu.score.score}</td>
                        <td>${extStu.course.couName}</td>
                        <td><a class="layui-btn layui-btn-sm" href="doStu?action=delById&stuId=${stu.stuId}">删除</a></td>
                        <td><a class="layui-btn layui-btn-sm" href="doStu?action=queryById&stuId=${stu.stuId}">修改</a></td>

                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="6">
                        <%@include file="PageUtil.jsp"%>
                    </td>
                </tr>
            </table>
        </c:when>
        <c:otherwise>
            <h3>暂无成绩信息</h3>
        </c:otherwise>
    </c:choose>
</body>
</html>

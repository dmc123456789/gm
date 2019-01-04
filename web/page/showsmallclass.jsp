<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath() %>/" />
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
<form action="doSmallclass?action=smaclassQuery&pageNumber=1" method="post">
<label>编号:</label>
<input type="text" name="Id" placeholder="请输入编号" />
<label>名字:</label>
    <input type="text" name="userName" placeholder="请输入姓名"  />
</select>
<input class="layui-btn " type="submit"  value="查询"/>
</form>
<c:choose>
    <c:when test="${not empty sessionScope.Page.pageDate}">
        <table id="stu" width="90%" class="layui-table" lay-size="sm">
            <tr>
                <th>编号</th>
                <th>物品</th>
                <th>大分类</th>
                <th>小文本</th>
                <th colspan="2">操作</th>
            </tr>
            <c:forEach items="${sessionScope.Page.pageDate}" var="sma">
                <tr>
                    <td>${sma.id}</td>
                    <td>${sma.smallName}</td>
                    <td>${sma.smallBigId}</td>
                    <td>${sma.smallText}</td>
                    <td><a class="layui-btn layui-btn-sm" href="doSmallclass?action=delById&smallclass=${sma.id}">删除</a></td>
                    <td><a class="layui-btn layui-btn-sm" href="doSmallclass?action=queryBybigId&smallclass=${sma.id}">修改</a></td>
                    <td><a class="layui-btn layui-btn-sm" href="page/addSmaclass.jsp">添加</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="9">
                    <%@include file="PageUtil.jsp"%>
                </td>
            </tr>
        </table>
    </c:when>
    <c:otherwise>
        <h3>暂无分类信息</h3>
    </c:otherwise>
</c:choose>
</body>
</html>

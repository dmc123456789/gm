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
<%--<form action="dogoods?action=goodsQuery&pageNumber=1" method="post">--%>
<%--<label>编号:</label>--%>
<%--<input type="text" name="Id" placeholder="请输入编号" />--%>
<%--<label>名字:</label>--%>
    <%--<input type="text" name="userName" placeholder="请输入姓名"  />--%>
<%--</select>--%>
<%--<input class="layui-btn " type="submit"  value="查询"/>--%>
<%--</form>--%>
<c:choose>
    <c:when test="${not empty sessionScope.Page.pageDate}">
        <table id="stu" width="90%" class="layui-table" lay-size="sm">
            <tr>
                <th>编号</th>
                <th>商家名称</th>
                <th>商家user</th>
                <th>商家密码</th>
                <th>商家性别</th>
                <th>出生日期</th>
                <th>身份证号</th>
                <th>邮箱</th>
                <th>手机号</th>
                <th>地址</th>
                <th colspan="2">操作</th>
            </tr>
            <c:forEach items="${sessionScope.Page.pageDate}" var="sma">
                <tr>
                    <td>${sma.id}</td>
                    <td>${sma.sellerName}</td>
                    <td>${sma.sellerUser}</td>
                    <td>${sma.sellerPassword}</td>
                    <td>${sma.sellerSex}</td>
                    <td>${sma.sellerBirthday}</td>
                    <td>${sma.sellerIdCard}</td>
                    <td>${sma.sellerEmail}</td>
                    <td>${sma.sellerTel}</td>
                    <td>${sma.sellerAddress}</td>
                    <td><a class="layui-btn layui-btn-sm" href="dogoods?action=delById&smallclass=${sma.id}">删除</a></td>
                    <td><a class="layui-btn layui-btn-sm" href="dogoods?action=queryBybigId&smallclass=${sma.id}">修改</a></td>
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
        <h3>暂无商品信息</h3>
    </c:otherwise>
</c:choose>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 52203
  Date: 2018/12/18
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@include file="layUI.jsp"%>
</head>
</head>
<body>
<div style="margin-bottom: auto">
    <form action="doAnnouncement?action=goodsAdd" method="post" >添加公告<br>
       公告标题<input type="text" name="goodsName"><br>
       公告内容<input type="text" name="goodsSmalId"><br>
       公告时间<input type="date" name="goodsSmalId"><br>
        <input class="layui-btn " type="submit" value="提交"><br>
    </form>
</div>
</body>
</html>

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
    <form action="doSmallclass?action=smaclassAdd" method="post" >添加商品小分类<br>
        分类名称<input type="text" name="smallName"><br>
        属于哪个大分类<input type="text" name="smallBigId"><br>
        什么文本我也不知道，反正填123绝对没毛病<input type="text" name="smallText"><br>
        <input class="layui-btn " type="submit" value="提交"><br>
    </form>
</div>
</body>
</html>

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
    <form action="dogoods?action=goodsAdd" method="post" >添加商品<br>
        商品名称<input type="text" name="goodsName"><br>
        小分类id<input type="text" name="goodsSmalId"><br>
        价格<input type="text" name="goodsMoney"><br>
        数量<input type="text" name="goodsNumber"><br>
        运费<input type="text" name="goodsCarriage"><br>
        不懂，填0就行<input type="text" name="goodsType"><br>
        折扣id<input type="text" name="goodsDiscId"><br>
        <input class="layui-btn " type="submit" value="提交"><br>
    </form>
</div>
</body>
</html>

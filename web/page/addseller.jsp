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
    <form action="doseller?action=goodsAdd" method="post" >添加商家<br>
        商家名称<input type="text" name="sellerName"><br>
         商家user<input type="text" name="sellerUser"><br>
          商家密码<input type="text" name="sellerPassword"><br>
          性别<input type="text" name="sellerSex"><br>
         出生日期<input type="date" name="sellerBirthday"><br>
          身份证号<input type="text" name="sellerIdCard"><br>
          邮箱号<input type="text" name="sellerEmail"><br>
          手机号<input type="text" name="sellerTel"><br>
          地址<input type="text" name="sellerAddress"><br>
        <input class="layui-btn " type="submit" value="提交"><br>
    </form>
</div>
</body>
</html>

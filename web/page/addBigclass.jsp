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
            <form action="doBigclass?action=bigclassAdd" method="post" >添加商品大分类<br>
                分类名称<input type="text" name="bigName"><br>
                商品成分<input type="text" name="bigText"><br>
                <input class="layui-btn " type="submit" value="提交"><br>
    </form>
</div>
</body>
</html>

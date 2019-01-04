<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath() %>/" />
    <%@include file="layUI.jsp"%>
</head>
<body>
     <c:choose>
         <c:when test="${not empty sessionScope.Page.pageData}">
             <table class="layui-table">
                 <thead>
                    <tr>
                        <th>教工号</th>
                        <th>姓名</th>
                        <th colspan="2">操作</th>
                    </tr>
                 </thead>
                <tbody>
                    <c:forEach items="${sessionScope.Page.pageData}" var="tea">
                        <tr>
                            <td>${tea.teaId}</td>
                            <td>${tea.teaName}</td>
                            <td><a class="layui-btn" href="#">删除</a></td>
                            <td><a class="layui-btn" href="#">修改</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="4">
                            <%@include file="PageUtil.jsp"%>
                        </td>
                    </tr>
                </tfoot>

             </table>

         </c:when>
         <c:otherwise>
             <h2>暂无教师数据</h2>
         </c:otherwise>
     </c:choose>
</body>
</html>

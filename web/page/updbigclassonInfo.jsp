<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath() %>/" />
    <%@include file="layUI.jsp"%>
    <style>
        .personWarp{
            height: 400px;
            width: 75%;
            overflow: hidden;
            margin: auto;
            background-color: #ffffff;
            padding-left:25%;
            font-size: 16px;
            color: #696969;
        }

        .personWarp input{
           margin-top: 20px;
        }
        input[type='text']{
            border-radius: 5px;
            height: 40px;
            font-size: 15px;
            padding-left: 10px;
        }
        input[name='stuId']{
            background-color: #999999;
        }
        input[type='submit']{
           width: 225px;
        }
    </style>
</head>
<body>
    <div class="personWarp">
        <form action="doBigclass?action=updateBigclassId" method="post">
            <label>编号:</label>
            <input type="text" name="Id" value="${sessionScope.Bigclass.id}" readonly/>&nbsp;&nbsp;&nbsp;
           <br>
            <label>大分类名称:</label>
            <input type="text" name="bigName" value="${sessionScope.Bigclass.bigName}" /><br>
            <label>内容:</label>
            <input type="text" name="bigText"  value="${sessionScope.Bigclass.bigText}" />&nbsp;&nbsp;&nbsp;
          <br>
            <input class="layui-btn layui-btn-lg" type="submit"  value="保存"/>
        </form>
    </div>

</body>
</html>

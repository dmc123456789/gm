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
        <form action="doStu?action=updateById" method="post">
            <label>学号:</label>
            <input type="text" name="stuId" value="${sessionScope.Student.stuId}" readonly/><br>
            <label>姓名:</label>
            <input type="text" name="stuName" value="${sessionScope.Student.stuName}" /><br>
            <label>性别:</label>
            <input type="radio" name="stuSex" value="男" ${sessionScope.Student.stuSex=='男'?'checked':''} />男
            <input type="radio" name="stuSex" value="女" ${sessionScope.Student.stuSex=='女'?'checked':''}/>女

            <input type="hidden"  name="stuPwd" value="${sessionScope.Student.stuPwd}" /><br>
            <label>地址:</label>
            <input type="text" name="stuAddress" value="${sessionScope.Student.stuAddress}" /><br>
            <label>生日:</label>
            <input type="text" name="stuBirthday"  value="${sessionScope.Student.stuBirthday}" /><br>
            <input class="layui-btn layui-btn-lg" type="submit"  value="保存资料"/>
        </form>
    </div>

</body>
</html>

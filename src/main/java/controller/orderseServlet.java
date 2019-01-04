package controller;

import pojo.Customer;
import pojo.Page;
import pojo.Superuser;
import service.impl.AdminServiceDaoImpl;
import service.impl.orderseServiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "orderseServlet",urlPatterns = "/doorderse")
public class orderseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码方式统一
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取输入了对象
        PrintWriter out = response.getWriter();
        //获取path路径
        String path = request.getContextPath();
        //获取session对象
        HttpSession session = request.getSession();
        //获取参数action的值
        //学生登录
        String action = request.getParameter("action");
        //获取学生服务对象
        orderseServiceDaoImpl orDao = orderseServiceDaoImpl.getInstance();
       if (action!=null&&action.equals("")){
           int pageSize=5;

       }
     }
    }


package controller;

import pojo.Customer;
import pojo.Page;
import pojo.Superuser;
import service.impl.AdminServiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet(name = "AdminServlet",urlPatterns = "/doadmin")
public class AdminServlet extends HttpServlet {
    String name;
    String id;
    String sex;
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
        AdminServiceDaoImpl adminDao = AdminServiceDaoImpl.getInstance();
        /**
         * 登录
         */
        if (action != null && action.equals("login")) {

                String loginname=request.getParameter("userName");
                String pwd=request.getParameter("userPassword");
                Superuser sup=adminDao.suoLogin(loginname,pwd);
                if (sup!=null){
                    session.setAttribute("Superuser",sup);
                    response.sendRedirect(path + "/page/index.jsp");

                } else {
                    response.sendRedirect("gmLogin.html?msg=0");
                }
            }
    /**
     * 查询所有
     */
    if (action!=null&&action.equals("queryall")){
        int pageSIze = 5;
        int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
        Page<Customer> page = adminDao.cusPageQueryAll( pageSIze,pageNumber);
        session.setAttribute("Page", page);
        request.setAttribute("ServletUrl", "/doadmin?action=queryall");
        request.getRequestDispatcher(path + "/page/showCoustomer.jsp").forward(request, response);
    }

        /**
         * 条件查询
         */
        if (action!=null&&action.equals("unionQuery")){
            int pageSIze = 5;
            int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
            if (request.getParameter("Id")!=null){
                id=request.getParameter("Id");
            }
            if (request.getParameter("userName")!=null){
                name=request.getParameter("userName");
            }
            if (request.getParameter("userSex")!=null){
                sex=request.getParameter("userSex");
            }
            if (name.length()==0&&id.length()==0&&sex.length()==0){

                Page<Customer> page = adminDao.cusPageQueryAll( pageSIze,pageNumber);
                session.setAttribute("Page", page);
                request.setAttribute("ServletUrl", "/doadmin?action=queryall");
                request.getRequestDispatcher(path + "/page/showCoustomer.jsp").forward(request, response);
            }else{
                Page<Customer> page=adminDao.cusPageunionQuery(pageSIze,pageNumber,id,name,sex);
                session.setAttribute("Page",page);
                request.setAttribute("ServletUrl","/doadmin?action=unionQuery");
                request.getRequestDispatcher(path+"/page/showCoustomer.jsp").forward(request,response);
            }
        }

        /**
         * 删除用户
         */
        if (action!=null&&action.equals("delById")){
            int id=Integer.valueOf(request.getParameter("cusid"));
            boolean flag=adminDao.delcus(id);
            if (flag){
                out.print("删除成功!");
            }else{
                out.print("删除失败!");
            }
        }
        /**
         * 修改管理员
         */
        if (action!=null&&action.equals("queryById")){
            int id=Integer.valueOf(request.getParameter("Id"));
            Superuser sup=adminDao.QueryByid(id);
            System.out.println(sup.getUserId());
            if (sup!=null){
                session.setAttribute("Superuser",sup);
                response.sendRedirect(path+"/page/updsuponInfo.jsp");
            }
        }
        //修改跳转页面
        if (action!=null&&action.equals("updateById")){
        int id=Integer.valueOf(request.getParameter("Id"));
        int status=Integer.valueOf(request.getParameter("userStatus"));
        String userid=request.getParameter("userid");
        String name=request.getParameter("userName");
        String userloginname=request.getParameter("userLoginName");
        Superuser sup=new Superuser(id,name,null,null,status,userid,userloginname);
        int i=adminDao.supUpdate(sup);
        if (i>0){
            session.setAttribute("Superuser",sup);
            response.sendRedirect(path + "/page/otherPage.jsp?msg=1");
        }else{
            out.print("<h3>修改失败!</h3>");
        }
        }
        /**
         * 修改用户
         */
        if (action!=null&&action.equals("queryBycusId")){
            int cusid=Integer.valueOf(request.getParameter("cusid"));
            Customer cus=adminDao.cusQueryByid(cusid);
            if (cus!=null){
                session.setAttribute("Customer",cus);
                response.sendRedirect(path+"/page/updcusonInfo.jsp");
            }
        }
        if (action!=null&&action.equals("updateBycusId")){
            int id=Integer.valueOf(request.getParameter("id"));
            String name=request.getParameter("cusName");
            String loginname=request.getParameter("cusloginname");
            String email=request.getParameter("cusemail");
            String cusSex=request.getParameter("cusSex");
            String cushobby=request.getParameter("cushobby");
            String cuscode=request.getParameter("cuscode");
            Date cusbirthday=Date.valueOf(request.getParameter("cusbirthday"));
            Customer cus=new Customer(id,name,loginname,null,email,cusSex,null,cushobby,cuscode,cusbirthday);
            int num=adminDao.cusUpdate(cus);
            if (num>0){
                out.print("修改成功!");
            }else{
                out.print("修改失败!");
            }

        }
    }
    }


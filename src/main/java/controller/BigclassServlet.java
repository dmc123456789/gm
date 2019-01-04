package controller;

import pojo.Bigclass;
import pojo.Customer;
import pojo.Page;
import service.impl.BigclassServiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "BigclassServlet",urlPatterns = "/doBigclass")
public class BigclassServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id=0;
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
        String action = request.getParameter("action");
        BigclassServiceDaoImpl bigDao = BigclassServiceDaoImpl.getInstance();
        /**
         * 查询所有
         */
      if (action!=null&&action.equals("Bigclassquery")){
          int pageSIze = 5;
          int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
          Page<Bigclass> page = bigDao.BigPageQueryAll( pageSIze,pageNumber);
          session.setAttribute("Page", page);
          request.setAttribute("ServletUrl", "/doBigclass?action=Bigclassquery");
          request.getRequestDispatcher(path + "/page/showBigclass.jsp").forward(request, response);
      }
        /**
         * 添加
         */

         if (action!=null&&action.equals("bigclassAdd")){
             String bigName=request.getParameter("bigName");
             String bigText=request.getParameter("bigText");
             Bigclass bigclass=new Bigclass(id,bigName,bigText);
             int add=bigDao.BigclassAdd(bigclass);
             if (add>0){
                 out.print("添加成功!");
             }else{
                 out.print("添加失败！");
             }

         }
        /**
         * 删除
         */
        if (action!=null&&action.equals("delById")){
            int id1=Integer.valueOf(request.getParameter("bigclass"));
            boolean flag=bigDao.delbigclass(id1);
            if (flag){
                out.print("删除成功!");
            }else{
                out.print("删除失败！");
            }
        }
        /**
         * 修改
         */
        if (action!=null&&action.equals("queryBybigId")){
            int cusid=Integer.valueOf(request.getParameter("bigclass"));
            Bigclass big=bigDao.cusQueryByid(cusid);
            if (big!=null){
                session.setAttribute("Bigclass",big);
                response.sendRedirect(path+"/page/updbigclassonInfo.jsp");
            }
        }
        /**
         * 修改
         */
        if (action!=null&&action.equals("updateBigclassId")){
            int id1=Integer.valueOf(request.getParameter("Id"));
            String bigName=request.getParameter("bigName");
            String bigText=request.getParameter("bigText");
            Bigclass big=new Bigclass(id1,bigName,bigText);
            int num=bigDao.cusUpdate(big);
            if (num>0){
                out.print("修改成功!");
            }else{
                out.print("修改失败!");
            }
        }
    }
}

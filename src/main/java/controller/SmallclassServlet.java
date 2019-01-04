package controller;

import pojo.Bigclass;
import pojo.Page;
import pojo.Smallclass;
import service.impl.SmallclassServiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SmallclassServlet",urlPatterns = "/doSmallclass")
public class SmallclassServlet extends HttpServlet {
    String name;
    String id;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id2=0;
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
        SmallclassServiceDaoImpl scdl= SmallclassServiceDaoImpl.getInstance();
        /**
         * 查询所有
         */
        if (action!=null&&action.equals("smallquery")){
            int pageSIze=7;
            int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
            Page<Smallclass> page = scdl.smallclasspageQuery(pageSIze,pageNumber);
            session.setAttribute("Page", page);
            request.setAttribute("ServletUrl", "/doSmallclass?action=smallquery");
            request.getRequestDispatcher(path + "/page/showsmallclass.jsp").forward(request, response);
        }
        /**
         * 删除
         */
        if (action!=null&&action.equals("delById")){
         int id1=Integer.valueOf(request.getParameter("smallclass").trim());
            Boolean f=scdl.delSmallclass(id1);
            if (f){
                out.print("删除成功！");
            }else{
                out.print("删除失败！");
            }
        }
        //级联查询
        if (action!=null&&action.equals("smaclassQuery")){
            int pageSIze = 5;
            int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
            if (request.getParameter("Id")!=null){
                id=request.getParameter("Id");
            }
            if (request.getParameter("userName")!=null){
                name=request.getParameter("userName");
            }
            if (name.length()==0&&id.length()==0){

                Page<Smallclass> page = scdl.smallclasspageQuery( pageSIze,pageNumber);
                session.setAttribute("Page", page);
                request.setAttribute("ServletUrl", "/doSmallclass?action=queryall");
                request.getRequestDispatcher(path + "/page/showsmallclass.jsp").forward(request, response);
            }else{
                Page<Smallclass> page=scdl.SmaPageunionQuery(pageSIze,pageNumber,id,name);
                session.setAttribute("Page",page);
                request.setAttribute("ServletUrl","/doSmallclass?action=unionQuery");
                request.getRequestDispatcher(path+"/page/showsmallclass.jsp").forward(request,response);
            }
        }
        /**
         * 添加
         */
        if (action!=null&&action.equals("smaclassAdd")){
            String smaName=request.getParameter("smallName");
            long smaBigid= Long.parseLong(request.getParameter("smallBigId"));
            String smaText=request.getParameter("smallText");
            Smallclass smaclass=new Smallclass(id2,smaName,smaBigid,smaText);
            int add=scdl.SmaclassAdd(smaclass);
            if (add>0){
                out.print("添加成功!");
            }else{
                out.print("添加失败！");
            }

        }
    }
}

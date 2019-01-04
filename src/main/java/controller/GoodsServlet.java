package controller;

import pojo.Goods;
import pojo.Page;
import service.impl.GoodsServiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GoodsServlet",urlPatterns = "/dogoods")
public class GoodsServlet extends HttpServlet {
    String name;
    String id;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id2=0;
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
        GoodsServiceDaoImpl goodsDao= GoodsServiceDaoImpl.getInstance();
        /**
         * 查询所有
         */
        if (action!=null&&action.equals("goodsquery")){
            int pageSIze=7;
            int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
            Page<Goods> page = goodsDao.goodspageQuery(pageSIze,pageNumber);
            System.out.println(page);
            session.setAttribute("Page", page);
            request.setAttribute("ServletUrl", "/dogoods?action=goodsquery");
            request.getRequestDispatcher(path + "/page/showgoods.jsp").forward(request, response);
        }
        /**
         * 删除
         */
        if (action!=null&&action.equals("delById")){
            int id1=Integer.valueOf(request.getParameter("smallclass").trim());
            Boolean f=goodsDao.delgoods(id1);
            if (f){
                out.print("删除成功！");
            }else{
                out.print("删除失败！");
            }
        }
        /**
         * 级联查询
         */
        if (action!=null&&action.equals("goodsQuery")){
            int pageSIze = 5;
            int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
            if (request.getParameter("Id")!=null){
                id=request.getParameter("Id");
            }
            if (request.getParameter("userName")!=null){
                name=request.getParameter("userName");
            }
            if (name.length()==0&&id.length()==0){

                Page<Goods> page = goodsDao.goodspageQuery( pageSIze,pageNumber);
                session.setAttribute("Page", page);
                request.setAttribute("ServletUrl", "/dogoods?action=goodsquery");
                request.getRequestDispatcher(path + "/page/showgoods.jsp").forward(request, response);
            }else{
                Page<Goods> page=goodsDao.goodsPageunionQuery(pageSIze,pageNumber,id,name);
                session.setAttribute("Page",page);
                request.setAttribute("ServletUrl","/dogoods?action=goodsQuery");
                request.getRequestDispatcher(path+"/page/showgoods.jsp").forward(request,response);
            }
        }
        /**
         *添加
         */
        if (action!=null&&action.equals("goodsAdd")){
            String goodsName=request.getParameter("goodsName");
            long goodsSmalId= Long.parseLong(request.getParameter("goodsSmalId"));
               double goodsMoney= Double.parseDouble(request.getParameter("goodsMoney"));
            long goodsNumber=Long.parseLong(request.getParameter("goodsNumber"));
             double goodsCarriage=Double.parseDouble(request.getParameter("goodsCarriage"));
             long goodsType=Long.parseLong(request.getParameter("goodsType"));
             long goodsDiscId=Long.parseLong(request.getParameter("goodsDiscId"));
            Goods smaclass=new Goods(id2,goodsName,goodsSmalId,goodsMoney,goodsNumber,null,goodsCarriage,goodsType,goodsDiscId);
            int add=goodsDao.goodsAdd(smaclass);
            if (add>0){
                out.print("添加成功!");
            }else{
                out.print("添加失败！");
            }

        }
    }
}

package controller;

import pojo.Goods;
import pojo.Page;
import pojo.Seller;
import service.impl.SellerServiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;


@WebServlet(name = "sellerServlet",urlPatterns = "/doseller")
public class sellerServlet extends HttpServlet {
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
        SellerServiceDaoImpl sDao=  SellerServiceDaoImpl.getInstance();
        /**
         * 查询所有
         */
        if (action!=null&&action.equals("aquery")){
            int pageSIze=7;
            int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
            Page<Seller> page = sDao.goodspageQuery(pageSIze,pageNumber);
            session.setAttribute("Page", page);
            request.setAttribute("ServletUrl", "/doseller?action=aquery");
            request.getRequestDispatcher(path + "/page/showseller.jsp").forward(request, response);
        }
        /**
         *添加
         */
        if (action!=null&&action.equals("goodsAdd")){
            String sellerName=request.getParameter("sellerName");
            String sellerUser=request.getParameter("sellerUser");
            String sellerPassword=request.getParameter("sellerPassword");
            String sellerSex=request.getParameter("sellerSex");
            Date sellerBirthday= Date.valueOf(request.getParameter("sellerBirthday"));
            String sellerIdCard=request.getParameter("sellerIdCard");
            String sellerEamil=request.getParameter("sellerEamil");
            String sellerTel=request.getParameter("sellerTel");
            String sellerAddress=request.getParameter("sellerAddress");
            Seller s= new Seller(id2,sellerName,sellerUser,sellerPassword,sellerSex,
                    sellerBirthday,sellerIdCard,sellerEamil,sellerTel,sellerAddress);
            int add=sDao.goodsAdd(s);
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
            int id1=Integer.valueOf(request.getParameter("smallclass").trim());
            Boolean f=sDao.delgoods(id1);
            if (f){
                out.print("删除成功！");
            }else{
                out.print("删除失败！");
            }
        }
    }
}

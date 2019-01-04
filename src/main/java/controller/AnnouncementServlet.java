package controller;

import pojo.Announcement;
import pojo.Page;
import service.impl.AnnouncementServiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;


@WebServlet(name = "AnnouncementServlet",urlPatterns = "/doAnnouncement")
public class AnnouncementServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
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
        AnnouncementServiceDaoImpl adi = AnnouncementServiceDaoImpl.getInstance();
        /**
         * 查询所有
         */
        if (action != null && action.equals("aquery")) {
            int pageSIze = 7;
            int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
            Page<Announcement> page = adi.goodspageQuery(pageSIze, pageNumber);
            session.setAttribute("Page", page);
            request.setAttribute("ServletUrl", "/doAnnouncement?action=pageNumber");
            request.getRequestDispatcher(path + "/page/showAnnouncement.jsp").forward(request, response);
        }
        /**
         * 删除
         */
        if (action != null && action.equals("delById")) {
            int id1 = Integer.valueOf(request.getParameter("smallclass").trim());
            Boolean f = adi.delgoods(id1);
            if (f) {
                out.print("删除成功！");
            } else {
                out.print("删除失败！");
            }
        }
        /**
         *添加
         */
        if (action != null && action.equals("goodsAdd")) {
            String aTitle = request.getParameter("aTitle");
            String aText = request.getParameter("aText");
            Date aDate = Date.valueOf(request.getParameter("aDate"));
            Announcement a = new Announcement(id, aTitle, aText, aDate);
            int add = adi.goodsAdd(a);
            if (add > 0) {
                out.print("添加成功!");
            } else {
                out.print("添加失败！");
            }
        }
    }
}
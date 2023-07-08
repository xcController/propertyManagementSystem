package com.learn.servlet;

import com.learn.bean.Maintain;
import com.learn.service.MaintainService;
import com.learn.service.impl.MaintainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Time;
import java.util.List;
import java.util.TimeZone;

/**
 * @author shkstart
 * @ClassName: MaintainServlet
 * @create 2023-04-08 14:21
 * @Description:
 */
@WebServlet("/maintain")
public class MaintainServlet extends BaseServlet{
    private MaintainService maintainService = new MaintainServiceImpl();

    protected void maintainList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Maintain> maintains = maintainService.getAllMaintain();
        req.setAttribute("maintains",maintains);
        req.getRequestDispatcher("maintain/maintain-list.jsp").forward(req,resp);
    }

    protected void maintainAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String thing = req.getParameter("thing");
        String status = req.getParameter("status");
        String homesnumber = req.getParameter("homesnumber");
        String sdate = req.getParameter("sdate");
        String enddate = req.getParameter("enddate");
        String precost = req.getParameter("precost");
        String relcost = req.getParameter("relcost");
        String maintainer = req.getParameter("maintainer");
        String note = req.getParameter("note");

        Double tt, st;
        if (precost == null) {
            tt = (double) 0.0;
        } else {
            tt = Double.parseDouble(precost);
        }
        if (relcost == null || relcost.equals("")) {
            st = (double) 0.0;
        } else {
            st = Double.parseDouble(relcost);
        }

        maintainService.save(new Maintain(thing,status,homesnumber,sdate,enddate,tt,st,maintainer,note));
        resp.sendRedirect("maintain?action=maintainList");
    }

    protected void toMaintainUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Maintain maintain = maintainService.getMaintainById(id);

        req.setAttribute("maintain",maintain);
        req.getRequestDispatcher("maintain/maintain-edit.jsp").forward(req,resp);
    }

    //管理员保修
    protected void maintainUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String thing = req.getParameter("thing");
        String status = req.getParameter("status");
        String homesnumber = req.getParameter("homesnumber");
        String sdate = req.getParameter("sdate");
        String enddate = req.getParameter("enddate");
        String precost = req.getParameter("precost");
        String relcost = req.getParameter("relcost");
        String maintainer = req.getParameter("maintainer");
        String note = req.getParameter("note");

        Double tt, st;
        if (precost == null) {
            tt = (double) 0.0;
        } else {
            tt = Double.parseDouble(precost);
        }
        if (relcost == null || relcost.equals("")) {
            st = (double) 0.0;
        } else {
            st = Double.parseDouble(relcost);
        }

        maintainService.update(new Maintain(id,thing,status,homesnumber,sdate,enddate,tt,st,maintainer,note));
        resp.sendRedirect("maintain?action=maintainList");
    }

    protected void maintainDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        maintainService.delete(id);
        resp.sendRedirect("maintain?action=maintainList");
    }

    //该用户的报修
    protected void maintainListOfUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maintainer = req.getParameter("maintainer");

        List<Maintain> maintains = maintainService.getMaintainByMaintainer(maintainer);

        req.setAttribute("maintains",maintains);
        req.getRequestDispatcher("maintain/user-maintain-list.jsp").forward(req,resp);
    }

    //删除该条报修信息
    protected void maintainUserDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maintainer = req.getParameter("maintainer");
        String id = req.getParameter("id");
        maintainService.delete(id);
        resp.sendRedirect("maintain?action=maintainListOfUser&maintainer=" +URLEncoder.encode(maintainer,"UTF-8"));
    }

    //用户报修
    protected void maintainUserAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String thing = req.getParameter("thing");
        String status = req.getParameter("status");
        String homesnumber = req.getParameter("homesnumber");
        String sdate = req.getParameter("sdate");
        String enddate = req.getParameter("enddate");
        String precost = req.getParameter("precost");
        String relcost = req.getParameter("relcost");
        String maintainer = req.getParameter("maintainer");
        String note = req.getParameter("note");

        Double tt, st;
        if (precost == null) {
            tt = (double) 0.0;
        } else {
            tt = Double.parseDouble(precost);
        }
        if (relcost == null || relcost.equals("")) {
            st = (double) 0.0;
        } else {
            st = Double.parseDouble(relcost);
        }

        maintainService.save(new Maintain(thing, status, homesnumber, sdate, enddate, tt, st, maintainer, note));
        //使用URLEncoder.encode()防止中文乱码
        resp.sendRedirect("maintain?action=maintainListOfUser&maintainer=" + URLEncoder.encode(maintainer,"UTF-8"));

    }
}

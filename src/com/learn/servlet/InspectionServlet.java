package com.learn.servlet;

import com.learn.bean.Inspection;
import com.learn.service.InspectionService;
import com.learn.service.impl.InspectionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author shkstart
 * @ClassName: InspectionServlet
 * @create 2023-04-08 14:25
 * @Description:
 */
@WebServlet("/inspection")
public class InspectionServlet extends BaseServlet{
    private InspectionService inspectionService = new InspectionServiceImpl();


    protected void inspectionList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Inspection> inspections = inspectionService.getAllInspection();
        req.setAttribute("inspections",inspections);
        req.getRequestDispatcher("inspection/inspection-list.jsp").forward(req,resp);

    }
    protected void inspectionAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String person = req.getParameter("person");
        String type = req.getParameter("type");
        String itime = req.getParameter("itime");
        String conductor = req.getParameter("conductor");
        String party = req.getParameter("party");
        String result = req.getParameter("result");
        String note = req.getParameter("note");

        inspectionService.save(new Inspection(person,type,itime,conductor,party,result,note));
        resp.sendRedirect("inspection?action=inspectionList");

    }

    //跳转修改页面，并保证部分信息可以回写
    protected void toInspectionUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Inspection inspection = inspectionService.getInspectionById(id);
        req.setAttribute("inspection",inspection);
        req.getRequestDispatcher("inspection/inspection-edit.jsp").forward(req,resp);
    }


    protected void inspectionUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String person = req.getParameter("person");
        String type = req.getParameter("type");
        String itime = req.getParameter("itime");
        String conductor = req.getParameter("conductor");
        String party = req.getParameter("party");
        String result = req.getParameter("result");
        String note = req.getParameter("note");

        inspectionService.update(new Inspection(id,person,type,itime,conductor,party,result,note));
        resp.sendRedirect("inspection?action=inspectionList");
    }

    protected void inspectionDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        inspectionService.delete(id);

        resp.sendRedirect("inspection?action=inspectionList");
    }
}

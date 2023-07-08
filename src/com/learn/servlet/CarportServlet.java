package com.learn.servlet;

import com.learn.bean.Carport;
import com.learn.service.CarportService;
import com.learn.service.impl.CarportServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author shkstart
 * @ClassName: CarportServlet
 * @create 2023-04-08 14:24
 * @Description:
 */
@WebServlet("/carport")
public class CarportServlet extends BaseServlet{

    private CarportService carportService =new CarportServiceImpl();


    //管理员视图
    protected void carportList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Carport> carports = carportService.getAllCarport();

        req.setAttribute("carports",carports);

        req.getRequestDispatcher("carport/carport-list.jsp").forward(req,resp);
    }
    protected void toCarportUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        Carport carport = carportService.getCarPortById(id);

        req.setAttribute("carport",carport);

        req.getRequestDispatcher("carport/carport-edit.jsp").forward(req,resp);
    }
    protected void carportUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String state = req.getParameter("state");
        String phone = req.getParameter("phone");
        String o = req.getParameter("ownerid");
        //防止输入数据为空，设置一个默认值
        if(o == null || "".equals(o)) o = "1";
        int ownerid = Integer.parseInt(o);

        carportService.update(new Carport(id,state,ownerid,phone));

        resp.sendRedirect("carport?action=carportList");

    }

    //用户自己的车位信息
    protected void carportListOfUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过用户id查询自己的车位
        String ownerid = req.getParameter("ownerid");
        List<Carport> carports = carportService.getCarportByOwnerid(ownerid);

        req.setAttribute("carports",carports);
        req.getRequestDispatcher("carport/user-carport-list.jsp").forward(req,resp);

    }
}

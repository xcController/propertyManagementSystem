package com.learn.servlet;

import com.learn.bean.House;
import com.learn.service.HouseService;
import com.learn.service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author shkstart
 * @ClassName: HouseServlet
 * @create 2023-04-08 14:23
 * @Description:
 */
@WebServlet("/house")
public class HouseServlet extends BaseServlet{
    private HouseService houseService = new HouseServiceImpl();


    protected void houseList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<House> houses = houseService.getAllHouse();

        req.setAttribute("houses",houses);
        req.getRequestDispatcher("house/house-list.jsp").forward(req,resp);
    }

    //添加
    protected void houseAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String num = req.getParameter("num");
        String unit = req.getParameter("unit");
        String floor = req.getParameter("floor");
        String type = req.getParameter("type");
        String area = req.getParameter("area");
        String sell = req.getParameter("sell");
        String direction = req.getParameter("direction");
        String note = req.getParameter("note");
        String o = req.getParameter("ownerid");
        if(o == null || "".equals(o)) o = "1";
        int ownerid = Integer.parseInt(o);

        houseService.save(new House(num,unit,floor,type,area,sell,direction,note,ownerid));
        resp.sendRedirect("house?action=actionList");
    }

    //跳转到修改页面，并保证部分信息回写
    protected void toHouseUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        House house = houseService.getHouseById(id);


        req.setAttribute("house",house);
        req.getRequestDispatcher("house/house-edit.jsp").forward(req,resp);
    }

    //修改
    protected void houseUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String num = req.getParameter("num");
        String unit = req.getParameter("unit");
        String floor = req.getParameter("floor");
        String type = req.getParameter("type");
        String area = req.getParameter("area");
        String sell = req.getParameter("sell");
        String direction = req.getParameter("direction");
        String note = req.getParameter("note");
        String o = req.getParameter("ownerid");
        if(o == null || "".equals(o)) o = "1";
        int ownerid = Integer.parseInt(o);

        houseService.update(new House(id,num,unit,floor,type,area,sell,direction,note,ownerid));
        resp.sendRedirect("house?action=houseList");


    }
    
    protected void houseDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        houseService.delete(id);
        resp.sendRedirect("house?action=houseList");
    }


    //该用户的房产信息
    protected void houseOfUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String accountid = req.getParameter("accountid");
        List<House> houses = houseService.getHouseByOwnerid(accountid);


        req.setAttribute("houses",houses);
        req.getRequestDispatcher("house/user-house-list.jsp").forward(req,resp);
    }
}

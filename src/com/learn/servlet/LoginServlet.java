package com.learn.servlet;

import com.learn.bean.Admin;
import com.learn.bean.Customer;
import com.learn.service.AdminService;
import com.learn.service.CustomerService;
import com.learn.service.impl.AdminServiceImpl;
import com.learn.service.impl.CustomerServiceImpl;
import com.learn.util.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLOutput;

/**
 * @author shkstart
 * @ClassName: LoginServlet
 * @create 2023-04-05 19:38
 * @Description:
 */
@WebServlet("/login")
public class LoginServlet extends BaseServlet{

    private AdminService adminService = new AdminServiceImpl();
    private CustomerService customerService = new CustomerServiceImpl();



    //登录模块
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String userType = req.getParameter("userType");
        String username = req.getParameter("username");
        String password = MD5Util.encode(req.getParameter("password"));

        HttpSession session = req.getSession();

        //通过userType属性区分是管理员登录还是居民登录
        if("admin".equals(userType)) {
            Admin admin = adminService.getAdminByNameAndPassword(username, password);
            if(admin != null) {
                session.setAttribute("admin",admin);
                resp.sendRedirect("index.jsp");

            }else {

                resp.getWriter().write("<script charset='UTF-8'>alert(\"用户名或密码错误！\");" +
                        "location.href='index.jsp';</script>");
            }
        }else {
            Customer customer = customerService.getCustomerByUsernameAndPassword(username, password);

            if(customer != null) {
                session.setAttribute("customer",customer);
                resp.sendRedirect("index2.jsp");
            }
            else {

                resp.getWriter().write("<script charset='UTF-8'>alert(\"用户名或密码错误！\");" +
                        "location.href='index.jsp';</script>");
            }

        }

    }


    //退出登录
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        session.invalidate();

        resp.sendRedirect("login.jsp");
    }
}

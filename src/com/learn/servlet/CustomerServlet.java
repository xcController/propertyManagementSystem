package com.learn.servlet;

import com.learn.bean.Customer;
import com.learn.service.CustomerService;
import com.learn.service.impl.CustomerServiceImpl;
import com.learn.util.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author shkstart
 * @ClassName: CustomerServlet
 * @create 2023-04-06 16:59
 * @Description:
 */
@WebServlet("/customer")
public class CustomerServlet extends BaseServlet{

    private CustomerService customerService = new CustomerServiceImpl();



    //展示全部用户
    protected void customerList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Customer> customers = customerService.getAllCustomer();

        req.setAttribute("customers",customers);
        req.getRequestDispatcher("customer/customer-list.jsp").forward(req,resp);
    }

    //添加
    protected void customerAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String addr = req.getParameter("addr");

        customerService.save(new Customer(username, MD5Util.encode(password),phone,addr));

        resp.sendRedirect("customer?action=customerList");

    }

    //跳转修改页面，并回写信息
    protected void toCustomerUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String accountid = req.getParameter("accountid");
        Customer customer = customerService.getCustomerById(accountid);

        req.setAttribute("customer",customer);
        req.getRequestDispatcher("customer/customer-edit.jsp").forward(req,resp);

    }

    //修改
    protected void customerUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int accountid = Integer.parseInt(req.getParameter("accountid"));

        String username = req.getParameter("username");
        String password = MD5Util.encode(req.getParameter("password"));
        String phone = req.getParameter("phone");
        String addr = req.getParameter("addr");

        customerService.update(new Customer(accountid,username,password,phone,addr));
        resp.sendRedirect("customer?action=customerList");
    }

    //删除
    protected void customerDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String accountid = req.getParameter("accountid");

        customerService.delete(accountid);

        resp.sendRedirect("customer?action=customerList");
    }


    //查看用户自身信息
    protected void customerInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String accountid = req.getParameter("accountid");
        Customer customer = customerService.getCustomerById(accountid);

        req.setAttribute("customer",customer);
        req.getRequestDispatcher("customer/user-customer-list.jsp").forward(req,resp);

    }


    //跳转到修改密码页面
    protected void toUpdatePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String accountid = req.getParameter("accountid");
        Customer customer = customerService.getCustomerById(accountid);

        req.setAttribute("customer",customer);
        req.getRequestDispatcher("customer/user-update-password.jsp").forward(req,resp);
    }

    //修改
    protected void updatePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int accountid = Integer.parseInt(req.getParameter("accountid"));

        String username = req.getParameter("username");
        String password = MD5Util.encode(req.getParameter("password"));
        String phone = req.getParameter("phone");
        String addr = req.getParameter("addr");

        customerService.update(new Customer(accountid,username,password,phone,addr));
        resp.sendRedirect("customer?action=customerInfo&accountid=" + accountid);
    }

}

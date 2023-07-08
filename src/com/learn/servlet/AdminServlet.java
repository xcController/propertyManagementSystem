package com.learn.servlet;

import com.learn.bean.Admin;
import com.learn.service.AdminService;
import com.learn.service.impl.AdminServiceImpl;
import com.learn.util.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author shkstart
 * @ClassName: AdminServlet
 * @create 2023-04-05 18:57
 * @Description:
 */
@WebServlet("/admin")
public class AdminServlet extends BaseServlet{
    private AdminService adminService = new AdminServiceImpl();


    //展示所有管理员信息
    protected void adminList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Admin> adminList = adminService.getAllAdmin();

        req.setAttribute("admins",adminList);
        req.getRequestDispatcher("admin/admin-list.jsp").forward(req,resp);
    }


    //添加管理员
    protected void adminAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String password = MD5Util.encode(req.getParameter("password"));
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String phone = req.getParameter("phone");
        String addr = req.getParameter("addr");
        String note = req.getParameter("note");
        String perms = req.getParameter("perms");


        Number ag = Integer.parseInt(age);
        adminService.save(new Admin(name,password,sex,ag,phone,addr,note,perms));
        resp.sendRedirect("admin?action=adminList");

    }


    //跳转到修改页面,并保证写回部分数据
    protected void toAdminUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Admin admin = adminService.getAdminById(id);

        //保存数据，保证可以写回
        req.setAttribute("admin",admin);

       req.getRequestDispatcher("admin/admin-edit.jsp").forward(req,resp);
    }

    //修改信息
    protected void adminUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String password = MD5Util.encode(req.getParameter("password"));
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String phone = req.getParameter("phone");
        String addr = req.getParameter("addr");
        String note = req.getParameter("note");
        String perms = req.getParameter("perms");

        int ag = Integer.parseInt(age);

        adminService.update(new Admin(id,name,password,sex,ag,phone,addr,note,perms));
        resp.sendRedirect("admin?action=adminList");
    }

    //做完权限验证后删除信息
    protected void adminDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        //获取登录者信息
        Admin signer = (Admin) req.getSession().getAttribute("admin");
        String perms = signer.getPerms();
        if("1".equals(perms)) {
            adminService.delete(id);
            resp.sendRedirect("admin?action=adminList");
        }else {
            resp.getWriter().write("<script charset='UTF-8'>alert(\"你没有删除权限\");" +
                    "location.href='admin?action=adminList';</script>");
        }

    }


    //添加管理员信息时检查权限
    protected void checkAddPerms(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取登录者信息
       Admin signer = (Admin) req.getSession().getAttribute("admin");
        String perms = signer.getPerms();

        if("1".equals(perms)) {
            resp.sendRedirect("admin/admin-add.jsp");
        }else {
            resp.getWriter().write("<script charset='UTF-8'>alert(\"你没有添加权限\");" +
                    "location.href='admin?action=adminList';</script>");
        }
    }

    //修改管理员信息时检查权限
    protected void checkUpdatePerms(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取登录者信息
        Admin signer = (Admin) req.getSession().getAttribute("admin");
        String perms = signer.getPerms();
        String id = req.getParameter("id");
        if("1".equals(perms)) {
            resp.sendRedirect("admin?action=toAdminUpdate&id=" + id);
        }else {
            resp.getWriter().write("<script charset='UTF-8'>alert(\"你没有修改权限\");" +
                    "location.href='admin?action=adminList';</script>");
        }
    }


}

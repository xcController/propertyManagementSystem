package com.learn.servlet;

import com.learn.bean.Notice;
import com.learn.service.NoticeService;
import com.learn.service.impl.NoticeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author shkstart
 * @ClassName: NoticeServlet
 * @create 2023-04-08 14:22
 * @Description:
 */
@WebServlet("/notice")
public class NoticeServlet extends BaseServlet{
    private NoticeService noticeService = new NoticeServiceImpl();


    protected void noticeList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Notice> notices = noticeService.getAllNotice();

        req.setAttribute("notices",notices);

        req.getRequestDispatcher("notice/notice-list.jsp").forward(req,resp);
    }

    protected void noticeAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String content = req.getParameter("content");
        String sdate = req.getParameter("sdate");
        String title = req.getParameter("title");
        String publisher = req.getParameter("publisher");

        noticeService.save(new Notice(content,sdate,title,publisher));

        resp.sendRedirect("notice?action=noticeList");
    }

    protected void toNoticeUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        Notice notice = noticeService.getNoticeById(id);

        req.setAttribute("notice",notice);

        req.getRequestDispatcher("notice/notice-edit.jsp").forward(req,resp);
    }

    protected void noticeUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String content = req.getParameter("content");
        String sdate = req.getParameter("sdate");
        String title = req.getParameter("title");
        String publisher = req.getParameter("publisher");

        noticeService.update(new Notice(id,content,sdate,title,publisher));

        resp.sendRedirect("notice?action=noticeList");
    }

    protected void noticeDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        noticeService.delete(id);
        resp.sendRedirect("notice?action=noticeList");
    }

    //展现给用户的公告视图
    protected void noticeListOfUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Notice> notices = noticeService.getAllNotice();

        req.setAttribute("notices",notices);

        req.getRequestDispatcher("notice/user-notice-list.jsp").forward(req,resp);

    }

    //用户看到的邮件内容

    protected void noticeContent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Notice notice = noticeService.getNoticeById(id);
        req.setAttribute("notice",notice);
        req.getRequestDispatcher("notice/notice-content.jsp").forward(req,resp);
    }



}

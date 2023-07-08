package com.learn.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author shkstart
 * @ClassName: LoginFilter
 * @create 2023-04-10 23:19
 * @Description:
 */
public class LoginFilter implements Filter {
    private RequestDispatcher requestDispatcher;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();

//        String uri=req.getRequestURI();
////        //将获取的请求资源路径uri进行字符串切割处理
////        String path=uri.substring(uri.indexOf("/",1),uri.length());
////        System.out.println(path);
////        if("/login.jsp".equals(path)){
////            filterChain.doFilter(servletRequest,servletResponse);
////            return;
////        }


        //判断是管理员还是用户登录
        String type = req.getParameter("userType");
        if(type == null) {
           resp.sendRedirect(req.getContextPath()+"/login.jsp");
            System.out.println("@@@@@@@@@@@@" + req.getContextPath());
        }else if("admin".equals(type)) {
            Object admin = session.getAttribute("admin");
            //验证管理员信息
            if(admin == null) {
                resp.sendRedirect(req.getContextPath()+"/login.jsp");
            }else {
                // 让程序继续往下访问用户的目标资源
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }else if("user".equals(type)){
            Object customer = session.getAttribute("customer");
            //验证业主信息
            if(customer == null) {
                resp.sendRedirect(req.getContextPath()+"/login.jsp");
            }else {
                // 让程序继续往下访问用户的目标资源
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }


    }

    @Override
    public void destroy() {

    }
}

package com.film.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 田际宝
 * @description: 登录过滤器
 * @param: null
 * @return:
 * @date: 2023/5/12 12:48
 */

@WebFilter(filterName = "UserLoginFilter", value = "/s")
public class UserLoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String path = req.getServletPath();
        String tag=req.getParameter("tag");
        if ("/captchaServlet".equals(path)||"/login.html".equals(path) || "/register.html".equals(path) || "/index.html".equals(path)||path.endsWith(".css")
                ||path.endsWith(".png")||path.endsWith(".jpg") ||!"login".equals(tag)||!"register".equals(tag)||"exist".equals(tag)) {
            chain.doFilter(req, res);
            return;
        }
        if (req.getSession().getAttribute("loginstate")==null) {//判断是否处于登录状态，并且不是登录或者注册页面
            //未登录，重定向到login.jsp,并退出doFilter
            req.getRequestDispatcher("login.html").forward(req,res);
            return;
        }
        //已登录，放行请求
        chain.doFilter(req, res);
    }
}

package com.film.servlet;

import com.alibaba.fastjson.JSON;
import com.film.pojo.User;
import com.film.service.UserService;
import com.film.service.impl.UserServiceImpl;
import com.film.util.Md5Util;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UserLoginServlet", value = "/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tag = request.getParameter("tag");
        if ("register".equals(tag)) {
            User user = new User();
            //获取用户的基本信息user_name、user_password、java、email、create_time，
            String user_name = request.getParameter("user_name");
            String user_password = request.getParameter("user_password");
            user_password = Md5Util.MD5(user_password + "java");
            String email = request.getParameter("email");
            String create_time = request.getParameter("create_time");
            //将用户的基本信息user_name、user_password、java、email、create_time存储在user对象中，
            user.setUserName(user_name);
            user.setUserPassword(user_password);
            user.setEmail(email);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                //格式化时间
                date = simpleDateFormat.parse(create_time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            user.setCreateTime(date);
            PrintWriter out = response.getWriter();
            if (userService.register(user)) {
                //注册成功向前端页面发送"1"
                out.write("1");

            } else {
                //注册失败向前端页面发送"0"
                out.write("0");
            }
            out.close();
        } else if ("login".equals(tag)) {//登录请求
            //response.setHeader("Access-Control-Allow-Origin", "*");
            //获取用户名及密码
            String username = request.getParameter("userName");
            String password = request.getParameter("password");
            String remember = request.getParameter("remember");
            //采用MD5进行加密
            String passwordMd5 = Md5Util.MD5(password + "java");
            //调用Service方法查询数据库中是否存在与输入的账号密码匹配的信息，并将查询到的结果对象返回
            User user = userService.login(username, passwordMd5);
            // 存session
            if (user != null) {
                request.getSession().setAttribute("userName", user.getUserName());
                request.getSession().setAttribute("loginstate", 1);
                if (remember != null) {
                    Cookie cookie1 = new Cookie("name", username);
                    Cookie cookie2 = new Cookie("pwd", password);
                    cookie1.setPath("/");
                    cookie2.setPath("/");
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                }
            }
//            将user对象转换成json格式数据
            String json = JSON.toJSONString(user);
            System.out.println(json);
            PrintWriter out = response.getWriter();
            //将json数据传递给前端
            out.write(json);
            out.close();
//            if (user != null) {
            //登录成功，将登录状态loginstate设置为1存储在session中
//                System.out.println("查询成功");
//                request.getSession().setAttribute("loginstate", 1);
////                if(remember!=null){
////                    Cookie cookie1=new Cookie("name",username);
////                    Cookie cookie2=new Cookie("pwd",password);
////                    cookie1.setPath("/");
////                    cookie2.setPath("/");
////                    response.addCookie(cookie1);
////                    response.addCookie(cookie2);
////                }
//                //request.getRequestDispatcher("index.html").forward(request, response);
//            } else {
//                //登录失败，将登录状态loginstate设置为0存储在session中
//                request.getSession().setAttribute("loginstate", 0);
//                //  request.getRequestDispatcher("index.html").forward(request, response);
        }
    }
}


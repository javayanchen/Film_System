package com.film.servlet;

import com.alibaba.fastjson.JSON;
import com.film.pojo.User;
import com.film.service.impl.UserServiceImpl;
import com.film.util.Md5Util;
import com.film.util.PageUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UserServlet", value = "/userServlet")
public class UserServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();

    /**
     * @description: get请求处理
     * @param: request
     * response
     * @return: void
     * @author 田际宝
     * @date: 2023/5/11 11:27
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tag = request.getParameter("tag");
        if (tag == null) {
            // 如果 tag 参数为空，则表示需要获取用户分页数据
            int index = 1;
            // 默认显示第一页
            if (request.getParameter("index") != null) {
                // 如果请求中包含参数 index，则使用该参数作为当前页码
                index = Integer.parseInt(request.getParameter("index"));
            }
            // 每页显示 5 条记录
            int size = 5;
            String user_name = request.getParameter("user_name");
            // 调用 UserService 对象 us 的 getPage() 方法查询分页数据
            PageUtil<User> pageUtil = userService.getPage(index, size, user_name);
            // 将分页数据转换成 JSON 字符串
            String json = JSON.toJSONString(pageUtil);
            System.out.println(json);
            response.setContentType("text/html; charset=utf-8");
            //获取响应输出流
            PrintWriter out = response.getWriter();
            // 将 JSON 字符串写入响应输出流中

            out.write(json);
            // 关闭响应输出流
            out.close();
        } else if ("del".equals(tag)) {
            // 获取请求参数 user_id 的值，并将其转换为整型变量 id
            int id = Integer.parseInt(request.getParameter("user_id"));
            PrintWriter out = response.getWriter();
            //调用Service层方法，更具id逻辑删除此用户
            if (userService.deleteUser(id)) {
                //删除成功
                out.write("1");
            } else {
                //删除失败
                out.write("0");
            }

        } else if ("exist".equals(tag)) {
            String user_name = request.getParameter("name");
            PrintWriter out = response.getWriter();
            //判断用户名是否存在，存在返回1，不存在返回0
            if (userService.exsit(user_name)) {
                out.write(1 + "");
            } else {
                out.write(0 + "");
            }
        } else if ("delAll".equals(tag)) {//多选删除
            //获取需要多选删除的id数组
            String ids = request.getParameter("ids");
            int result = userService.delAll(ids);
            String msg = "";
            PrintWriter out = response.getWriter();
            if (result == 0) {
                msg = "error";
                String error = JSON.toJSONString(msg);
                out.write(error);
                out.close();
            } else if (result > 0) {
                msg = "200";
                String success = JSON.toJSONString(msg);
                out.write(success);
                out.close();
            }
            // 这个if可以改成esle if吗？运行会出错吗？
        } else if ("edit".equals(tag)) {
            String user_id = request.getParameter("user_id");
            User user = userService.getUserById(user_id);
            System.out.println(user);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/admin/user/updateUser.jsp").forward(request, response);

        } else if ("logout".equals(tag)) {
            // 移除userName、loginstate属性
            request.getSession().removeAttribute("userName");
//            request.getSession().removeAttribute("loginstate");
            // 退出登录后，跳转到首页
            request.getRequestDispatcher("/index.html").forward(request, response);

        }
    }

    /**
     * @description: post请求处理
     * @param: request
     * response
     * @return: void
     * @author 田际宝
     * @date: 2023/5/11 11:27
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String tag = request.getParameter("tag");
        if ("update".equals(tag)) {
            // 获取 HTTP POST 请求中的参数 user_name、user_pwd、email 和 status 的值
            Integer user_id = Integer.valueOf(request.getParameter("id"));
            String user_name = request.getParameter("userName");
            String user_pwd = request.getParameter("password");
            String email = request.getParameter("email");
            User user = new User();
            // 将获取到的参数值设置到 User 对象 user 中
            user.setUserId(user_id);
            user.setUserName(user_name);
            user.setUserPassword(user_pwd);
            user.setEmail(email);
            if (userService.modify(user)) {
                // 如果修改用户信息成功，则执行此语
                request.getRequestDispatcher("/admin/user/userList.jsp").forward(request, response);
            } else {
                // 如果修改用户信息失败，则执行此语句块
                request.getRequestDispatcher("/admin/user/updateUser.jsp").forward(request, response);
            }
        }
    }
}


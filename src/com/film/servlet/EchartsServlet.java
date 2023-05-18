package com.film.servlet;

import com.alibaba.fastjson.JSON;
import com.film.pojo.Film;
import com.film.service.FilmService;
import com.film.service.UserService;
import com.film.service.impl.FilmServiceImpl;
import com.film.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @ClassName EchartsServlet
 * @Description TODO
 * @Author 魏必乾
 * @Date 2023/5/15 0015 20:29
 * @Version 1.0
 **/
@WebServlet("/echartsServlet")
public class EchartsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String tag = request.getParameter("tag");
        if ("film".equals(tag)) {
            FilmService filmService = new FilmServiceImpl();
            List<Film> films = filmService.getFilms();
            String countFilm = JSON.toJSONString(films);
            System.out.println(countFilm);
            PrintWriter out = response.getWriter();
            out.write(countFilm);
            out.close();
        } else if ("user".equals(tag)) {
            UserService userService = new UserServiceImpl();
            List info = userService.getInfoForEcharts();
            String resultDate = JSON.toJSONString(info);
            System.out.println(resultDate);
            PrintWriter out = response.getWriter();
            out.write(resultDate);
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

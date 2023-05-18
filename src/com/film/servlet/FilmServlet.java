package com.film.servlet;

import com.alibaba.fastjson.JSON;
import com.film.dao.FilmTypeDao;
import com.film.dao.impl.FilmTypeDaoImpl;
import com.film.pojo.Film;
import com.film.service.FilmService;
import com.film.service.impl.FilmServiceImpl;
import com.film.util.PageUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "FilmServlet", value = "/filmServlet")
public class FilmServlet extends HttpServlet {
    FilmService filmService = new FilmServiceImpl();
    FilmTypeDao filmTypeDao = new FilmTypeDaoImpl();

    // 注意，所有参数是否和页面参数一致
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tag = request.getParameter("tag");
        response.setContentType("text/html; charset=utf-8");
        if (tag == null) {
            // 访问查询页面/修改页面后跳转/删除后跳转/添加后跳转，tag都为空
            // 页大小设置为2
            Integer pageSize = 5;
            // 页码默认为第一页
            Integer pageIndex = 1;
            if (request.getParameter("pageindex") != null) {
                // 跳转首页/尾页/下一页/上一页，修改页码
                pageIndex = Integer.valueOf(request.getParameter("pageindex"));
            }
            // 获取影视名称/导演/影视类型
            String filmName = request.getParameter("filmName");
            String filmAuthor = request.getParameter("filmAuthor");
            Integer typeId = Integer.valueOf(request.getParameter("typeID"));
            // 获取分页对象
            PageUtil<Film> filmPageUtil = filmService.searchFilms(pageIndex, pageSize, filmName, filmAuthor, typeId);
            // 将分页对象转换成json格式
            String filmPageUtilJSON = JSON.toJSONString(filmPageUtil);
            // 将分页对象传送给Ajax
            System.out.println(filmPageUtilJSON);
            PrintWriter out = response.getWriter();
            out.write(filmPageUtilJSON);
            out.close();
        } else if ("edit".equals(tag)) {
            // 跳转修改页面
            Film film = filmService.getFilmsByFilmId(Integer.valueOf(request.getParameter("filmId")));
            request.setAttribute("film", film);
            request.getRequestDispatcher("/admin/film/updateFilm.jsp").forward(request, response);
        } else if ("del".equals(tag)) {
            // 修改影视状态，实现逻辑删除(多个/单个)
            if (filmService.updateFilmByStatus(request.getParameter("filmIds"))) {
                // 删除成功，返回数据到jsp页面的Ajax
                PrintWriter out = response.getWriter();
                out.write("1");
                out.close();
            }
        } else if ("views".equals(tag)) {
            // Ajax传单个参数，tag:"views" 是这样吗？
            // 浏览量自增，onclick="addViews()" function addViews(){$.get("filmServlet",tag:"views",function(data) {loadPage(1);刷新局部，分页数据}
            if (filmService.addFilmViews(Integer.valueOf(request.getParameter("filmId")))) {
                // 浏览量自增成功，返回数据到jsp页面的Ajax
                PrintWriter out = response.getWriter();
                out.write("");
                out.close();
            }
        }else if ("show".equals(tag)) {
            // 首页分类显示影视
            String typeId = request.getParameter("typeId");
            // 获取不同类型影视数组
            List<Film> filmList = filmService.getFilmsByTypeId(Integer.valueOf(typeId));
            // 将不同类型影视数组转换成json格式
            String filmListJSON = JSON.toJSONString(filmList);
            // 将分页对象传送给Ajax
            PrintWriter out = response.getWriter();
            out.write(filmListJSON);
            out.close();
        } else if ("dramaShow".equals(tag)) {
            // 分类显示电视剧
            String typeId = request.getParameter("typeId");
            String typeIdId = request.getParameter("typeIdId");
            // 获取不同类型电视剧数组
            List<Film> dramaList = filmService.getFilmsByTypeIdId(Integer.valueOf(typeId),Integer.valueOf(typeIdId));
            // 将不同类型电视剧数组转换成json格式
            String dramaListJSON = JSON.toJSONString(dramaList);
            // 将分页对象传送给Ajax
            PrintWriter out = response.getWriter();
            out.write(dramaListJSON);
            out.close();
        } else if ("movieShow".equals(tag)) {
            // 分类显示电视剧
            String typeId = request.getParameter("typeId");
            String typeIdId = request.getParameter("typeIdId");
            // 获取不同类型电视剧数组
            List<Film> movieList = filmService.getFilmsByTypeIdId(Integer.valueOf(typeId),Integer.valueOf(typeIdId));
            // 将不同类型电视剧数组转换成json格式
            String movieListJSON = JSON.toJSONString(movieList);
            // 将分页对象传送给Ajax
            PrintWriter out = response.getWriter();
            out.write(movieListJSON);
            out.close();
        } else if ("sportShow".equals(tag)) {
            // 分类显示电视剧
            String typeId = request.getParameter("typeId");
            String typeIdId = request.getParameter("typeIdId");
            // 获取不同类型电视剧数组
            List<Film> sportList = filmService.getFilmsByTypeIdId(Integer.valueOf(typeId),Integer.valueOf(typeIdId));
            // 将不同类型电视剧数组转换成json格式
            String sportListJSON = JSON.toJSONString(sportList);
            // 将分页对象传送给Ajax
            PrintWriter out = response.getWriter();
            out.write(sportListJSON);
            out.close();
        } else if ("addViews".equals(tag)) {
            // 分类显示电视剧
            Integer filmId = Integer.valueOf(request.getParameter("filmId"));
            if (filmService.addFilmViews(filmId)) {
                //返回前端的Ajax
                PrintWriter out = response.getWriter();
                out.write("1");
                out.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tag = request.getParameter("tag");
        request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("GBK");
        response.setContentType("text/html; charset=utf-8");
        if ("save".equals(tag)) {
            Film  film = filmService.getFilmsByFilmId(Integer.valueOf(request.getParameter("FilmId")));
            film.setFilmId(Integer.valueOf(request.getParameter("FilmId")));
            film.setFilmName(request.getParameter("FilmName"));
            film.setStatus(Integer.valueOf(request.getParameter("Status")));
            film.setFilmIdId(Integer.valueOf(request.getParameter("FilmIdId")));
            film.setFilmAuthor(request.getParameter("FilmAuthor"));
            film.setFilmIntro(request.getParameter("FilmIntro"));
            if (filmService.updateFilm(film)) {
                System.out.println("修改成功！");
                if ("电视剧".equals(film.getFilmType().getTypeName())) {
                    response.sendRedirect("/admin/film/tvList.jsp");
                } else if ("电影".equals(film.getFilmType().getTypeName())) {
                    response.sendRedirect("/admin/film/moviesList.jsp");
                } else if ("体育".equals(film.getFilmType().getTypeName())) {
                    response.sendRedirect("/admin/film/sportList.jsp");
                }
            } else {
                System.out.println("修改失败！");
                response.sendRedirect("/admin/film/updateFilm.jsp");
            }
        } else if ("add".equals(tag)) {
            // 存储影视信息
            Film film = new Film();
            PrintWriter out = response.getWriter();
            // 标记是否上传成功呢
            boolean flag = false;
            String filmType = "";
            // 判断请求信息中的内容是否是multipart类型
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            // 获取服务器fileupload目录的完整路径
            String uploadFilePath = request.getServletContext().getRealPath("/fileupload");
            if (isMultipart) {   //判断请求信息中的内容 是否是“multipart/form-data”类型
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                upload.setSizeMax(1024 * 1024 * 4);  //设置上传文件大小 4M
                try {
                    List<FileItem> items = upload.parseRequest(request);    // 解析form表单中所有文件
                    for (FileItem item : items) {
                        if (!item.isFormField()) { // 普通表单字段true, 文件表单字段false
                            String fileName = item.getName(); //文件名
                            // 实现只上传图片文件
                            if (fileName != null && !fileName.equals("")) {
                                // 截取文件类型，文件名后缀
                                String s = fileName.substring(fileName.lastIndexOf('.') + 1);
                                // 图片或视频格式不对，则返回上传页面,测试下面哪个路径是对的？
                                if (!s.equals("jpg") && !s.equals("gif") && !s.equals("bmp") && !s.equals("png")) {
                                    out.print("<script>alert('文件格式不正确！只能上传图片和视频');location.href='/admin/film/addFilm.jsp'</script>");
                                } else {

                                    // 拼接文件在服务器端的存储路径
                                    // 解决文件重名，自定义文件名,文件名前添加“随机32位数”
                                    String randNum = UUID.randomUUID().toString();
                                    // 文件名前加 “随机数32位”，方便下载时，根据随机数32位截取文件名
                                    String img = "/fileupload" + "/" + randNum + fileName;
                                    File saveFile = new File(uploadFilePath + "/" + randNum + fileName);
//                                    System.out.println(saveFile.getAbsolutePath());
                                    // 存储图片上传后的路径
//                                    film.setFilmImage(saveFile.getAbsolutePath());
                                    System.out.println(img);
                                    film.setFilmImage(img);
                                    // 上传视频，待实现
//                                    film.setFilmVideo(saveFile.getAbsolutePath());
                                    // 文件上传
                                    item.write(saveFile);  //上传
                                    flag = true;

                                }
                            }
                        } else {
                            if ("filmName".equals(item.getFieldName())) {
                                // 解决中文乱码
                                String filmName = new String(item.getString().getBytes("ISO-8859-1"), "utf-8");
                                film.setFilmName(filmName);
                                System.out.println("文件名：" + filmName.toString());
                            } else if ("filmTypeIdId".equals(item.getFieldName())) {
                                // item.getString()/item.toString() 返回相同的字符串？ 而且影视类型会是对的吗？
                                film.setFilmIdId(Integer.valueOf(item.getString()));
                            } else if ("filmTime".equals(item.getFieldName())) {
                                film.setFilmTime(item.getString());
                            } else if ("filmViews".equals(item.getFieldName())) {
                                film.setFilmViews(Integer.valueOf(item.getString()));
                            } else if ("filmAuthor".equals(item.getFieldName())) {
                                String filmAuthor = new String(item.getString().getBytes("ISO-8859-1"), "utf-8");
                                film.setFilmAuthor(filmAuthor);
                            } else if ("filmIntro".equals(item.getFieldName())) {
                                String filmIntro = new String(item.getString().getBytes("ISO-8859-1"), "utf-8");
                                film.setFilmIntro(filmIntro);
                            } else if ("filmTypeId".equals(item.getFieldName())) {
                                // 测一下item.getString()存的是影视类型编号吗？
                                System.out.println(item.getString());
                               filmType = item.getString();
                               film.setFilmType(filmTypeDao.getFilmTypeByTypeId(Integer.valueOf(filmType)));

                            }
                        }
                    }
                    // 如果上传成功，则根据上传的影视类型跳转到不同的页面
                    if (flag) {
                        if (filmService.addFilm(film)) {
                            if ("4".equals(filmType)) {
//                                out.print("<script>location.href='/admin/film/tvList.jsp';</script>");
                                response.sendRedirect("/admin/film/tvList.jsp");
                            } else if ("5".equals(filmType)) {
                                out.print("<script>location.href='/admin/film/moviesList.jsp';</script>");
                            } else if ("6".equals(filmType)) {
                                out.print("<script>location.href='/admin/film/sportList.jsp';</script>");
                            }
                        }
                    }
//                    // 添加影视
//                    if (filmService.addFilm(film)) {
//                        // 需要修改跳转路径
//                        response.sendRedirect("index.html");
//                    }
                } catch (Exception e) {
                    out.print("<script>alert('文件大小超出范围，只能上传最多4M的文件！');location.href='index.jsp'</script>");
                }
            }
        }
    }
}

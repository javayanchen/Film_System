<%--
  Created by IntelliJ IDEA.
  User: 18727
  Date: 2023/5/12 0012
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/jquery-2.1.0.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改影视信息</h3>
    <form action="filmServlet?tag=save" method="post">
        <div class="form-group">
            <label for="FilmId">影视编号：</label>
            <input type="text" class="form-control" id="FilmId" name="FilmId" readonly value="${film.getFilmId()}"/>
        </div>
        <div class="form-group">
            <label for="FilmName">影视名称：</label>
            <input type="text" class="form-control" id="FilmName" name="FilmName" value="${film.getFilmName()}"/>
        </div>
        <div class="form-group">
            <label>分类：</label>
            <input type="text" class="form-control" id="FilmIdId" name="FilmIdId" value="${film.getFilmIdId()}"/>
        </div>

        <div class="form-group">
            <label>导演：</label>
            <input type="text" class="form-control" id="FilmAuthor" name="FilmAuthor" value="${film.getFilmAuthor()}"/>
        </div>
        <div class="form-group">
            <label>状态：</label>
            <select class="form-control" id="Status" name="Status">
                <option value="1" ${film.getStatus() == 1 ? "selected" : ""}>热映中</option>
                <option value="2" ${film.getStatus() == 2 ? "selected" : ""}>待上映</option>
            </select>
        </div>
        <div class="form-group">
            <label>影视简介：</label>
            <textarea type="text" class="form-control" cols="1"  rows="10" id="FilmIntro" name="FilmIntro" >${film.getFilmIntro()}
            </textarea>
        </div>
        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <a class="btn btn-default" href="" onclick="history.back()">返回</a>
        </div>
    </form>
</div>
</body>
</html>


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
    <%
        // 判断影视类型
        String typeId = request.getParameter("typeId");
        if ("4".equals(typeId)) {
    %>
    <h3 style="text-align: center;">上传电视剧</h3>
    <form action="/filmServlet?tag=add" method="post" enctype="multipart/form-data">
        <input type="hidden" id="id" name="filmTypeId" readonly value="4"/>
        <div class="form-group">
            <label for="id">电视剧名称：</label>
            <input type="text" class="form-control" id="dramaName" name="filmName" />
        </div>
        <div class="form-group">
            <label for="category">电视剧类型：</label>
            <select id="category" name="filmTypeIdId">
                <option value="1">动画</option>
                <option value="2">古装</option>
                <option value="3">现代都市</option>
            <%
                } else if ("5".equals(typeId)) {
            %>
                <h3 style="text-align: center;">上传电影</h3>
                <form action="/filmServlet?tag=add" method="post" enctype="multipart/form-data">
                    <input type="hidden"id="id" name="filmTypeId" readonly value="5"/>
                    <div class="form-group">
                        <label for="id">电影名称：</label>
                        <input type="text" class="form-control" id="dramaName" name="filmName" />
                    </div>
                    <div class="form-group">
            <label for="category">电影类型：</label>
            <select id="category" name="filmTypeIdId">
                <option value="1">大陆</option>
                <option value="2">美国</option>
                <option value="3">日本</option>
            <%
                } else if ("6".equals(typeId)) {
            %>
                <h3 style="text-align: center;">上传体育视频</h3>
                <form action="/filmServlet?tag=add" method="post" enctype="multipart/form-data">
                    <input type="hidden" id="id" name="filmTypeId" readonly value="6"/>
                    <div class="form-group">
                        <label for="id">体育视频名称：</label>
                        <input type="text" class="form-control" id="dramaName" name="filmName" />
                    </div>
                    <div class="form-group">
            <label for="category">体育视频类型：</label>
            <select id="category" name="filmTypeIdId">
                <option value="1">篮球</option>
                <option value="2">网球</option>
                <option value="3">足球</option>
            <%}%>
            </select>
        </div>
        <div class="form-group">
            <label for="name">时长：</label>
            <input type="text" class="form-control" id="name" name="filmTime"/>
        </div>

        <div class="form-group">
            <label>导演：</label>
            <input type="text" class="form-control" id="summary" name="filmAuthor" />
        </div>

        <div class="form-group">
            <label>简介：</label>
            <input type="text" class="form-control" id="intro" name="filmIntro" />
        </div>

        <div class="form-group">
            <label>图片：</label>
            <input type="file" class="form-control" id="image" name="filmImage" />
        </div>

<%--        <div class="form-group">--%>
<%--            <label>视频：</label>--%>
<%--            <input type="file" class="form-control" id="video" name="filmVideo" />--%>
<%--        </div>--%>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <a class="btn btn-default" href="" onclick="history.back()">返回</a>
        </div>
    </form>
</div>

</body>
</html>


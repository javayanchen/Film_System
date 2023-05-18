<%--
  Created by IntelliJ IDEA.
  User: 璐可
  Date: 2023/5/15
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>

<head>
    <title>Movies</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="My Play Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- bootstrap -->
    <link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' media="all"/>
    <!-- //bootstrap -->
    <link href="css/dashboard.css" rel="stylesheet">
    <!-- Custom Theme files -->
    <link href="css/style.css" rel='stylesheet' type='text/css' media="all"/>
    <script src="js/jquery-1.11.1.min.js"></script>
    <!--start-smoth-scrolling-->
    <!-- fonts -->
    <link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
          rel='stylesheet' type='text/css'>
    <link href='http://fonts.useso.com/css?family=Poiret+One' rel='stylesheet' type='text/css'>
    <!-- //fonts -->
    <link rel="icon" href="images/logo.png" type="image/x-icon">
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" style="background-color: white;">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="./index.html">
                <h1><img src="./images/log.png" alt=""/></h1>
            </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <div class="top-search">
                <form class="navbar-form navbar-right">
                    <input type="text" class="form-control" placeholder="搜索...">
                    <input type="submit" value=" ">
                </form>
            </div>
            <div class="header-top-right">
                <div class="signin">
                    <%
                        String userName = "";
                        if (session.getAttribute("userName") == null) {
                            userName = "匿名";
                        } else {
                            userName = session.getAttribute("userName").toString();
                        }
                    %>
                    <strong style="font-family: '微软雅黑', '宋体'; font-size: 20px" >欢迎，<span id="user"><%=userName%></span></strong>

                </div>
                <div class="signin">
                    <a href="#small-dialog" class="play-icon popup-with-zoom-anim">退出</a>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</nav>

<div class="col-sm-3 col-md-2 sidebar" style="background-color: white;margin-top: 5px;">
    <div class="drop-navigation drop-navigation">
        <ul class="nav nav-sidebar">
            <li class="active">
                <a href="./main.jsp" class="home-icon">
                    <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                    主页
                </a>
            </li>
            <li>
                <a href="tv.jsp" class="menu2">
                    <span class="glyphicon glyphicon-film" aria-hidden="true"></span>
                    电视剧
                </a>
            </li>
            <li>
                <a href="movies.jsp" class="menu1">
                    <span class="glyphicon glyphicon-film" aria-hidden="true"></span>
                    电影
                </a>
            </li>
            <li>
                <a href="sports.jsp" class="menu">
                    <span class="glyphicon glyphicon-film glyphicon-king" aria-hidden="true"></span>
                    体育
                </a>
            </li>
        </ul>
    </div>
</div>

<div class="row" style="margin-top: 60px">
    <div class="col-md-12 col-md-offset-1">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 offset-md-2 main">
            <div class="show-top-grids">
                <div class="col-sm-10 show-grid-left main-grids">

                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
<div class="footer text-right">
    <div class="container">
        <div class="footer-top">
            <div class="footer-top-nav">
                <ul>
                    <li><a href="./web/about.html">关于</a></li>
                    <li><a href="press.html">出版社</a></li>
                    <li><a href="./web/copyright.html">版权</a></li>
                    <li><a href="./web/creators.html">创作者</a></li>
                    <li><a href="#">广告</a></li>
                    <li><a href="./web/developers.html">开发者</a></li>
                </ul>
            </div>
            <div class="footer-bottom-nav">
                <ul>
                    <li><a href="./web/terms.html">条款</a></li>
                    <li><a href="./web/privacy.html">隐私</a></li>
                    <li><a href="#small-dialog4" class="play-icon popup-with-zoom-anim">发送反馈</a></li>
                    <li><a href="./web/privacy.html">政策和安全 </a></li>
                    <li>
                        <p style="color: #0b0b0b">版权 &copy; 2021.一组开发组
                        </p>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

</body>
<script>
    //页面加载时，触发加载loadData()
    $(function () {
        loadData();
    });

    //从发送请求给服务器，获取当前页数据
    async function loadData() {
        for (let i = 1; i < 4; i++) {
            try {
                let str = "";
                const data = await $.getJSON("/filmServlet", {tag: "dramaShow", typeId: 5, typeIdId: i}, function (data) {
                    const movieType = i === 1 ? "大陆" : (i === 2 ? "美国" : "日本");
                    str = '<div class="recommended"><div class="recommended-grids"><div class="recommended-info"><div class="heading"><h3>'+movieType+'</h3>'
                        +'</div><div class="clearfix"></div></div>';
                    for (let j = 0; j < data.length; j++) {
                        str += '<div class="col-md-2 resent-grid recommended-grid movie-video-grid"><div class="resent-grid-img recommended-grid-img">'
                            +'<a href="single.jsp" onclick="addViews('+ data[j].filmId +')"><img src="'+ data[j].filmImage +'" alt=""/></a><div class="time small-time show-time movie-time"><p>'+data[j].filmTime+'</p>'
                            +'</div><div class="clck movie-clock"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></div></div>'
                            +'<div class="resent-grid-info recommended-grid-info recommended-grid-movie-info"><h5><a href="single.jsp" class="title" onclick="addViews('+ data[j].filmId +')">'+ data[j].filmIntro +'</a></h5>'
                            +'<ul><li><p class="author author-info"><a href="#" class="author">' + data[j].filmAuthor + '</a></p>' +
                            '</li><li class="right-list"><p class="views views-info">' + data[j].filmViews + 'views</p></li></ul></div></div>';
                    }
                    str += '<div class="clearfix"></div></div></div>';
                });
                $(".show-top-grids > div ").append(str);
            } catch (error) {
                console.log("Error fetching data:", error);
            }
        }
    }

    function addViews(filmId) {
        // alert("filmId="+filmId);
        $.get("/filmServlet", {tag: "addViews", filmId: filmId},
            function (data) {
                if (data == "1") {
                    loadData();
                }
            });
    }
</script>
</html>

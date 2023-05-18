﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="../css/admin_style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="../js/jquery.js"></script>

    <script type="text/javascript">
        $(function () {
            //导航切换
            $(".menuson .header").click(function () {
                var $parent = $(this).parent();
                $(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();

                $parent.addClass("active");
                if (!!$(this).next('.sub-menus').size()) {
                    if ($parent.hasClass("open")) {
                        $parent.removeClass("open").find('.sub-menus').hide();
                    } else {
                        $parent.addClass("open").find('.sub-menus').show();
                    }


                }
            });

            // 三级菜单点击
            $('.sub-menus li').click(function (e) {
                $(".sub-menus li.active").removeClass("active")
                $(this).addClass("active");
            });

            $('.title').click(function () {
                var $ul = $(this).next('ul');
                $('dd').find('.menuson').slideUp();
                if ($ul.is(':visible')) {
                    $(this).next('.menuson').slideUp();
                } else {
                    $(this).next('.menuson').slideDown();
                }
            });
        })
    </script>


</head>

<body style="background:#f0f9fd;">

<div class="lefttop"><span></span>操作</div>

<dl class="leftmenu">
    <dd>
        <div class="title">
            <span><img src="../images/leftico01.png"/></span>管理信息
        </div>
        <ul class="menuson">
            <li>
                <div class="header">
                    <cite></cite>
                    <a href="#">用户管理</a>
                    <i></i>
                </div>
                <ul class="sub-menus">
                    <li><a href="user/userList.jsp" target="rightFrame">用户列表</a></li>
                </ul>
            </li>
            <li>
                <div class="header">
                    <cite></cite>
                    <a href="#">影视管理</a>
                    <i></i>
                </div>
                <ul class="sub-menus">
                    <li><a href="film/tvList.jsp" target="rightFrame">电视剧管理列表</a></li>
                    <li><a href="film/sportList.jsp" target="rightFrame">体育视频管理列表</a></li>
                    <li><a href="film/moviesList.jsp" target="rightFrame">电影管理列表</a></li>
                </ul>
            </li>
            <li>
                <div class="header">
                    <cite></cite>
                    <a href="#">统计</a>
                    <i></i>
                </div>
                <ul class="sub-menus">
                    <li><a href="statistics/filmStatistics.jsp" target="rightFrame">影视浏览情况</a></li>
                    <li><a href="statistics/userStatistics.jsp" target="rightFrame">用户人数统计</a></li>
                </ul>
            </li>
        </ul>
    </dd>
</dl>

</body>
</html>

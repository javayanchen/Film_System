<%--
  Created by IntelliJ IDEA.
  User: 18727
  Date: 2023/5/12 0012
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>电视剧管理</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/jquery-2.1.0.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>

<div class="container-fluid">
    <%--题头--%>
    <h3 style="text-align: center">电视剧管理列表</h3>

    <%--查询--%>
    <div style="float: left;">
        <form class="form-inline" action="#" method="post">
            <div class="form-group">
                <label for="tvName">电视名称</label>
                <input type="text" name="name" class="form-control" id="tvName">
            </div>

            <div class="form-group">
                <label for="director">导演</label>
                <input type="text" name="address" class="form-control" id="director">
            </div>

            <button type="button" class="btn btn-default" onclick="loadData(1)">查询</button>
        </form>
    </div>

    <%--操作选项按钮--%>
    <div style="float: right;margin: 5px;">
        <a class="btn btn-primary" href="/admin/film/addFilm.jsp?typeId=4">添加</a>
        <a class="btn btn-primary" id="delSelected" onclick="deleteAll()">删除选中</a>
    </div>

    <%--用户列表--%>
    <form id="form" action="" method="post">
        <table border="1" class="table table-bordered table-hover">
            <thead>
            <tr class="success">
                <th><input type="checkbox" id="fId" onclick="selectedCheck(this)"></th>
                <th>剧名</th>
                <th>类型</th>
                <th>导演</th>
                <th>浏览量</th>
                <th>分类</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </form>

    <%--分页--%>
    <div>
        <%--显示总数据量、总页数，当前页--%>
        <div id="pageInfo" style="float: left;">

        </div>
        <%--跳转页码--%>
        <div id="page" style="float: right;">
            <nav aria-label="Page navigation" id="pages">
                <ul class="pagination">

                </ul>
            </nav>
        </div>
    </div>


</div>

<script>
    $(function () {
        loadData(1);
    });

    function loadData(index) {
        var filmName = $("#tvName").val();
        var filmAuthor = $("#director").val();
        $.getJSON("/filmServlet", {
            pageindex: index,
            filmName: filmName,
            filmAuthor: filmAuthor,
            typeID: "4"
        }, function (data) {
            var str = "";
            var pageList = data.pageList;
            for (var i = 0; i < pageList.length; i++) {
                str += "<tr>";
                str += "<td><input name='cId' type='checkbox' onclick='selectAll()' value='" + pageList[i].filmId + "'/></td>"
                str += "<td>" + pageList[i].filmName + "</td>";
                str += "<td>" + pageList[i].filmType.typeName + "</td>";
                str += "<td>" + pageList[i].filmAuthor + "</td>";
                str += "<td>" + pageList[i].filmViews + "</td>";
                if (pageList[i].filmIdId == 1) {
                    str += "<td> 动画</td>";
                }else if(pageList[i].filmIdId == 2){
                    str += "<td> 古装</td>";
                }else{
                    str += "<td> 都市</td>";
                }
                if (pageList[i].status == 1) {
                    str += "<td>热映中</td>";
                }else if(pageList[i].status == 2){
                    str += "<td>待上映</td>";
                }
                str += "<td><a class='btn btn-default btn-sm' href='/filmServlet?tag=edit&filmId=" + pageList[i].filmId + "' class='tablelink'>修改</a>" +
                    "<a class=\"btn btn-default btn-sm\" onclick=\"del(" + pageList[i].filmId + ")\" class='tablelink'>删除</a></td>"
                str += "</tr>";
            }
            $("tbody").html(str);

            str = "";
            str = "<p>共<i>" + data.totalCount + "</i>条记录，" +
                "当前显示第<i>" + data.currentPage + "</i>页," +
                "共<i>" + data.totalPageCount + "</i>页</p>";
            $("#pageInfo").html(str);

            str = "";
            str += "<li><a aria-label='Previous' onclick='loadData(1)'><span aria-hidden='true'>首页</span></a></li>";
            var prePage = data.currentPage > 1 ? data.currentPage - 1 : 1;
            var nextPage = data.currentPage < data.totalPageCount ? data.currentPage + 1 : data.totalPageCount;
            str += "<li><a href='#' onclick='loadData(" + prePage + ")'>上一页</a></li>";
            str += "<li><a href='#' onclick='loadData(" + nextPage + ")'>下一页</a></li>";
            str += "<li><a href='#' aria-label='Next' onclick='loadData(" + data.totalPageCount + ")'><span aria-hidden='true'>尾页</span></a></li>";
            $(".pagination").html(str);

        });
    // .fail(function (data) {
    //         alert("加载数据失败，原因：" + data.responseText);
    //     // });
    }


    //触发点击全部变为已选择状态
    function selectedCheck(fId) {
        var items = document.getElementsByName("cId");
        for (var i = 0; i < items.length; i++) {
            items[i].checked = fId.checked;
        }
    }

    //当子选择全部选择时，父也被选择
    function selectAll() {
        //数据上的复选框
        var items = document.getElementsByName("cId");
        var bool = true;
        for (var i = 0; i < items.length; i++) {
            if (!items[i].checked) {
                bool = false;
                break;
            }
        }
        document.getElementById("fId").checked = bool;
    }

    function del(id) {
        if (confirm("您确定要删除吗?")) {
            $.get("/filmServlet", {tag: "del", filmIds: id},
                function (data) {
                    if (data == "1") {
                        loadData(1);
                    }
                });
        }
    }

    //删除已被选择的子选择
    function deleteAll() {
        if (confirm("您确定要删除吗?")) {
            var cIds = "";
            var items = document.getElementsByName("cId");
            for (var i = 0; i < items.length; i++) {
                if (items[i].checked) {
                    cIds += items[i].value + ","
                }
            }
            cIds = cIds.substr(0, cIds.length - 1);

            //发送ajax请求
            $.get("/filmServlet", {tag: "del", filmIds: cIds},
                function (data) {
                    if (data == "1") {
                        loadData(1);
                    }
                });
        }
    }
</script>
</body>
</html>


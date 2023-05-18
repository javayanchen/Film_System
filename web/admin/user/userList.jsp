<%--
  Created by IntelliJ IDEA.
  User: 18727
  Date: 2023/5/12 0012
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户信息列表</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
    <script src="../../js/jquery.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <%--题头--%>
    <h3 style="text-align: center">用户信息列表</h3>

    <%--查询--%>
    <div style="float: left;">
        <div class="form-inline">
            <div class="form-group">
                <label for="searchUserName">用户名</label>
                <input type="text" name="userName" id="searchUserName" class="form-control">
            </div>
            <button type="submit" class="btn btn-default" onclick="loadData(1)">查询</button>
        </div>
    </div>

    <%--操作选项按钮--%>
    <div style="float: right;margin: 5px;">
        <a class="btn btn-primary" id="delSelected" onclick="deleteAll()">删除选中</a>
    </div>

    <%--用户列表--%>
    <form id="form" action="" method="post">
        <table border="1" class="table table-bordered table-hover">
            <%--列表题头--%>
            <thead>
            <tr class="success">
                <th><input type="checkbox" id="fId" onclick="selectedCheck(this)"></th>
                <th>编号</th>
                <th>用户名</th>
                <th>密码</th>
                <th>邮箱</th>
                <th>角色</th>
                <th>注册时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <%--列表内容--%>
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
    const inputElement = document.getElementById('searchUserName');
    inputElement.addEventListener('input', (event) => {
        const inputValue = event.target.value;
        document.cookie = `inputValue=${inputValue}`;
    });
    const cookieValue = document.cookie
        .split('; ')
        .find(row => row.startsWith('inputValue='))
        ?.split('=')[1];
    if (cookieValue) {
        inputElement.value = cookieValue;
    }
    //页面加载时，触发加载loadData()
    $(function () {
        loadData(1);
    });

    //从发送请求给服务器，获取当前页数据
    function loadData(index) {
        var searchName = $("#searchUserName").val();
        $.getJSON("/userServlet", {index: index, user_name: searchName}, function (data) {
            var str = "";
            for (var i = 0; i < data.pageList.length; i++) {
                str += "<tr>";
                str += "<td><input name='cId' type='checkbox' onclick='selectAll()' value='" + data.pageList[i].userId + "'/></td>"
                str += "<td>" + data.pageList[i].userId + "</td>";
                str += "<td>" + data.pageList[i].userName + "</td>";
                str += "<td>" + data.pageList[i].userPassword + "</td>";
                str += "<td>" + data.pageList[i].email + "</td>";

                str += "<td>" + data.pageList[i].role.roleName + "</td>";
                str += "<td>" + data.pageList[i].createTime + "</td>";
                if (data.pageList[i].role.roleName == "普通用户") {
                    str += "<td><a class='btn btn-default btn-sm' href='/userServlet?tag=edit&user_id=" +data.pageList[i].userId+ "'class='tablelink'>修改</a>" +
                        "<a class='btn btn-default btn-sm' class='tablelink' onclick='deleteUser(" +data.pageList[i].userId + ")'> 删除</a></td>";
                    str += "</tr>";
                }else {
                    str += "<td><a class='btn btn-default btn-sm' href='/userServlet?tag=edit&user_id=" + data.pageList[i].userId + "'class='tablelink'>修改</a>" +
                        "<a class='btn btn-default btn-sm' class='tablelink' onclick='banDelete()'> 删除</a></td>";
                    str += "</tr>";
                }
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
    //管理员用户禁止删除
    function banDelete(){
        alert("此账号为管理员用户，禁止删除！");
    }

    //删除已被选择的子选择
    function deleteAll() {
        if (confirm("您确定要删除吗?")) {
            var cIds = "";
            var items = document.getElementsByName("cId");
            for (var i = 0; i < items.length; i++) {
                if (items[i].checked) {
                    cIds += items[i].value + ",";
                }
            }
            cIds = cIds.substr(0, cIds.length - 1);

            //发送ajax请求
            // alert(cIds);
            $.getJSON("/userServlet", {tag: "delAll", ids: cIds},
                function (data) {
                    if (data == "error") {
                        alert("选中删除中，有管理员，管理员不能被删除！请重新选择");
                        return;
                    } else if (data == "200") {
                        alert("删除成功！");
                        window.location.href = "/admin/user/userList.jsp";
                    }
                });
        }
    }

    function deleteUser(uid) {
        if (confirm("你确定要删除吗？")) {
            $.getJSON("/userServlet", {tag: "del",user_id: uid}, function (data) {
                if (data=="1") {
                    window.location.href = "/admin/user/userList.jsp";
                }
            });
        }
    }


</script>
</body>
</html>


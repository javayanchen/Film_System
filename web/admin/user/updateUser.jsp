<%--
  Created by IntelliJ IDEA.
  User: 18727
  Date: 2023/5/12 0012
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
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

    <h3 style="text-align: center;">修改用户信息</h3>

    <form action="userServlet?tag=update" method="post">

        <div class="form-group">
            <label for="id">编号：</label>
            <input type="text" class="form-control" id="id" name="id" value="${user.userId}" readonly/>
        </div>

        <div class="form-group">
            <label for="userName">用户名：</label>
            <input type="text" class="form-control" id="userName" name="userName" value="${user.userName}"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="text" class="form-control" id="password" name="password" value="${user.userPassword}"/>
        </div>

        <div class="form-group">
            <label for="email">邮箱：</label>
            <input type="text" class="form-control" id="email" name="email" value="${user.email}"/>
        </div>

        <div class="form-group">
            <label for="role">角色：</label>
            <select id="role" name="role" class="form-control">
                <option >${user.role.roleName}</option>
            </select>
        </div>

        <div class="form-group">
            <label for="createTime">注册时间：</label>
            <input type="text" class="form-control" id="createTime" name="createTime" value="${user.createTime}" readonly/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <a class="btn btn-default" onclick="history.back()">返回</a>
        </div>
    </form>
</div>

<script>
    $(function() {
        getRoleName();
    })
    function getRoleName() {
        $.getJSON("/userServlet",function (data){
            var str="";
            for (var i=0;i<data.length;i++){
                str+="<option value='"+data[i].roleId+"'>"+data[i].roleName+"</option>"
            }
            $("#role").append(str);
        });
    }
</script>
</body>
</html>

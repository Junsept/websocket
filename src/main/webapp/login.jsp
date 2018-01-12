<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UtF-8">
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<title>登录页面</title>
</head>
<body>
	<div class="container-fluid" style="width:500px;">
		<div class="form-group">
		    <label for="name">姓名</label>
		    <input type="text" class="form-control" id="name" placeholder="请输入名称">
		</div>
		<div class="form-group">
		    <label for="password">密码</label>
		    <input type="text" class="form-control" id="password" placeholder="请输入密码">
		</div>
		<button type="button" id="loginbtn" class="btn btn-success" style="width:100%;margin-bottom:20px">登录</button>
		<button type="button" id="registerbtn" class="btn btn-success" style="width:100%">注册</button>
	</div>
</body>
</html>
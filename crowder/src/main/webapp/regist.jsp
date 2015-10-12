<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.scutpress.cloud.crowder.domain.Crowder"%>
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<html>
<head>
<title>注册界面</title>
<!-- Bootstrap core CSS -->
<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="http://cdn.bootcss.com/bootstrap/2.3.2/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="regist.css" rel="stylesheet">
</head>
<body>
	<h2 class="form-signin-heading">众包注册</h2>
	<div class="container">

		<form class="form-signin" action="admin.html" method="post">
			<div class="input-group">
				<span class="input-group-addon">姓名</span> <input type="text"
					class="form-control" name="name" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon">性别</span> <input type="text"
					class="form-control" name="sex" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon">年龄</span> <input type="text"
					class="form-control" name="age" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon">职业 </span> <input type="text"
					class="form-control" name="occupation"
					aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon">电话</span> <input type="text"
					class="form-control" name="phone" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon">邮箱</span> <input type="email"
					class="form-control" name="email" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon">省份</span> <input type="text"
					class="form-control" name="provice" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon">城市</span> <input type="text"
					class="form-control" name="city" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon">地址 </span> <input type="text"
					class="form-control" name="address" aria-describedby="basic-addon1">
			</div>

			<div class="input-group"  >
				<input type="submit" class="form-control" 
					value="提交" aria-describedby="basic-addon1">
			</div>
		</form>
	</div>
</body>
</html>

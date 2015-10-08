<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.scutpress.cloud.crowder.domain.Crowder"%>
<html>
<head>
<title>注册界面</title>
<!-- Bootstrap core CSS -->
<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form class="form-signin" action="admin.html" method="post">
			<h2 class="form-signin-heading">众包注册</h2>
			<br> 姓名 <input type="text" name="name" /> <br> 性别 <input
				type="text" name="sex" /> <br> 年龄 <input type="text"
				name="age" /> <br> 职业 <input type="text" name="occupation" />
			<br> 电话 <input type="text" name="phone" /> <br> 邮箱 <input
				type="text" name="email" /> <br> 省份 <input type="text"
				name="provice" /> <br> 城市 <input type="text" name="city" /> <br>
			地址 <input type="text" name="address" /> <br> <input
				type="submit" value="提交" />
		</form>
	</div>
</body>
</html>

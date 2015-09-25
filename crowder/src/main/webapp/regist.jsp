<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.scutpress.cloud.crowder.domain.Crowder"%>
<html>
<head>
<title>注册界面</title>
    <!-- Bootstrap core CSS -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form action="admin.html" method="post">
	 姓名 <input type="text" name="name" />
	 性别 <input type="text" name="sex" />
	 年龄 <input type="text" name="age" />
	 职业 <input type="text" name="occupation" />
	 电话 <input type="text" name="phone" />
	 邮箱 <input type="text" name="email" />
	 省份 <input type="text" name="provice" />
	 城市 <input type="text" name="city" />
	 地址 <input type="text" name="address" />
		<input type="submit" value="提交" />
	</form>
</body>
</html>

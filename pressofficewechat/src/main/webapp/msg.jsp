<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.scutpress.cloud.pressofficewechat.domain.Msg"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=session.getAttribute("title")%></title>
<style type="text/css">
body {
	font-family: Microsoft YaHei, 宋体;
	margin-top: 0px;
}

a {
	display: block;
	height: 240px !important;
	border-bottom: 2px solid #ccc;
	overflow: hidden;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#fff),
		to(#f1f1f1));
	background-image: -webkit-linear-gradient(#fff, #f1f1f1);
	background-image: -moz-linear-gradient(#fff, #f1f1f1);
	background-image: -ms-linear-gradient(#fff, #f1f1f1);
	background-image: -o-linear-gradient(#fff, #f1f1f1);
	background-image: linear-gradient(#fff, #f1f1f1);
	margin-left: -10px;
	margin-right: -10px;
}

a:visited {
	color: inherit;
}

a:link {
	color: inherit;
}

div.weibo-list-item-img {
	position: absolute;
	display: block;
	left: 30px;
	width: 160px;
	height: 160px;
	margin-top: 40px;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

div.weibo-list-item-line {
	position: absolute;
	padding-top: 50px;
	padding-left: 240px;
	font-size: 60px;
}

div.weibo-list-item-title {
	height: 50px;
	padding-left: 30px;
	padding-right: 40px;
	font-size: 60px;
}
</style>
</head>
<body>
	<div class="weibo-list">
		<%
			List<Msg> list = (List<Msg>) session.getAttribute("list");
			Iterator<Msg> it = list.iterator();
			Msg msg;
			while (it.hasNext()) {
				msg = it.next();
		%>
		<a class="weibo-list-item" href="<%=msg.getMsgUrl()%>">
			<div class="weibo-list-item-img"
				style="background-image: url(msgImg/<%=msg.getThumbMediaId()%>.jpeg)">
			</div>
			<div class="weibo-list-item-line">
				<div class="weibo-list-item-title"><%=msg.getTitle()%></div>
			</div>
			<div class="weibo-list-item-icon"></div>
		</a>

		<%
			}
		%>
	</div>
</body>
</html>
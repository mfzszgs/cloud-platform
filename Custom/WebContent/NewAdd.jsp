<%@page import="com.beans.*"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java"
	import="java.util.*,com.beans.Conn,java.sql.*,com.filter.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
	<base href="<%=basePath%>">
	
	<title>新闻发布</title>
	<link rel="stylesheet" type="text/css" href="MainStyle.css" />
	<style type="text/css">
<!--
.STYLE2 {
	font-size: 16px;
	font-weight: bold;
	color: #0000FF;
}
.STYLE5 {font-size: 14px; font-weight: bold; color: #0000FF; }
-->
    </style>
	</head>
	
	<body>
	<%@ include file="Public/MyTitle.jsp"%>
	<%  request.setCharacterEncoding("UTF-8"); %>
	
	<% 
		
		DAO dao = new DAO();
		PubDAO pubdao = new PubDAO();
		//List<DocBean> bli = dao.getDoc(id);
		List<String> li = pubdao.getNewCol(0);/*获得新闻栏目列表*/
	%>
	<form name="form" method="post" > 
	<div class="M_table">
	<table width="100%" border="1" cellpadding="1" cellspacing="0" style="width: 900px; ">
      
      <tr>
        <td colspan="2">标题：<input name="Title" type="text" style="width: 600px; "></td>
      </tr>
      <tr>
        <td>栏目：
               <select name="selectNewCol">
							<%
								for (int i = 0; i < li.size(); i++) {
							%>
							<option value="<%=i + 1%>"><%=li.get(i)%></option>
							<%
								}
							%>
					</select></td>
        <td>作者：<input type="text" name="author" value ="<%=session.getAttribute("loginName") %>" style="width: 350px; "/></td>
      </tr>
      <tr>
        
        <td colspan="2">关键字：<input type="text" name="keywords" style="width:580px;"/></td>
      </tr>
      <tr>
        <td colspan="2">内容：
        <textarea name="fulltext" cols="30" rows="10" style="width: 890px; ">
        </textarea></td>
      </tr>
      <tr>
        <td colspan="2">
        <input onClick="form.action='AddNewServlet?uid=<%=dao.checkUserId(session.getAttribute("loginName").toString()) %>';form.submit();" type="submit" name="Submit" value="发布新闻">
        </td>
      </tr>
      
    </table>
    </div>
	<p>&nbsp;</p>
	  <p>
	    <%@ include file="Public/MyBottom.jsp"%>
      </p>
    </form>
	</body>
	
</html>
<%@ page language="java" import="java.util.*,com.scutpress.customs.beans.*,java.sql.*,com.scutpress.customs.filter.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Manager_docClass.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="MainStyle.css" />

  </head>
  
  <body>
  
     <p>
		<%@ include file="Public/MyTitle.jsp"%>
	</p>
	<form>
	<%	
		PubDAO pubdao = new PubDAO();
		List<String> nli = pubdao.getNewsClass(0);
	 %>

	 <table align="center"  width="300" border="1" cellpadding="1" cellspacing="0">
	 	<tr>
	 <td>
	 	新闻类别名
	 </td>
	 <td>
	 	编辑
	 </td>
	 <td>
		 删除
	 </td>
	 </tr>
	 <%for(int i=0;i<nli.size();i++){ %>
		 <tr>
			 <td>
			 	<%= nli.get(i) %>
			 </td>
			 <td>
			 	<a href ="Manager_newsClass_edit.jsp?id=<%=i+1%>">编辑</a>
			 </td>
			 <td>
			 	删除
			 </td>
		 </tr>
	 <%} %>
	
	 
	 </table>
	 
	<p align="center">
		<font color="blue"><a href="Manager.jsp">返回管理员主页面</a></font>
			<%@ include file="Public/MyBottom.jsp"%>
		</p>
	</form>
	
	
  </body>
</html>

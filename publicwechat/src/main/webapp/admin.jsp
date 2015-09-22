<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.scutpress.cloud.publicwechat.domain.Msg"%>
<html>
<head>
<title>admin</title>
</head>
<body>
	<!-- 	<form action="<c:url value="admin.html"/>" method="post">-->
	<form action="admin.html" method="post">
		<table>
			<tr>
				<th>Title</th>
				<th>Type</th>
			</tr>
			<%
				List<Msg> list = (List<Msg>) session.getAttribute("list");
				if (list != null) {
					for (int j = 0; j < list.size(); j++) {
			%>
			<tr>
				<td><a href="<%=list.get(j).getMsgUrl()%>"><%=list.get(j).getTitle()%></a></td>
				<td><select name="choose">
						<%
							List<String> typeList = (List<String>) session.getAttribute("typeList");
									Iterator<String> typeIt = typeList.iterator();
									int i = 0;
									while (typeIt.hasNext()) {
										i++;
						%>
						<option value="<%=i%>" <%if (i == 1) {%> selected="selected" <%}%>><%=typeIt.next()%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<%
				}
				}
			%>
		</table>
		<input type="submit" value="提交" />
	</form>
</body>
</html>

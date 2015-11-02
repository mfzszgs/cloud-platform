<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.scutpress.cloud.pressofficewechat.domain.Msg"%>
<html>
<head>
<title>乡愁记忆 板块分类</title>
<link
	href="http://cdn.bootcss.com/bootstrap/2.3.2/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="http://cdn.bootcss.com/bootstrap/2.3.2/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<link href="mycss.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h2>华工出版社公众号 板块分类</h2>
		<%
			List<List<Msg>> listList = (List<List<Msg>>) session.getAttribute("listList");
			List<String> typeList = (List<String>) session.getAttribute("typeList");
		%>
		<div class="tabbable">
			<h4>
				<ul class="nav nav-tabs">
					<%
						for (int i = 0; i < typeList.size(); i++) {
					%>
					<li <%if (i == 0) {%> class="active" <%} else {%> class="" <%}%>><a
						href="#type<%=i + 1%>" data-toggle="tab"><%=typeList.get(i)%></a></li>
					<%
						}
					%>
				</ul>
			</h4>
			<div class="tab-content">
				<%
					for (int i = 0; i < typeList.size(); i++) {
				%>
				<div class="tab-pane <%if (i == 0) {%>active<%}%>"
					id="type<%=i + 1%>">
					<form action="admin.html" method="post">
					<div>
					<div>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>名称</th>
									<th>分类</th>
								</tr>
							</thead>
							<tbody>
								<%
									List<Msg> list = listList.get(i);
										if (list != null) {
											for (int j = 0; j < list.size(); j++) {
								%>
								<tr>
									<td><%=list.get(j).getId()%></td>
									<td><a href="<%=list.get(j).getMsgUrl()%>"><%=list.get(j).getTitle()%></a></td>
									<td><select class="form-control"
										name="<%=list.get(j).getId()%>">
											<%
												for (int k = 0; k < typeList.size(); k++) {
											%>
											<option value="<%=k + 1%>" <%if (k == i) {%>
												selected="selected" <%}%>><%=typeList.get(k)%></option>
											<%
												}
											%>
									</select></td>
								</tr>
								<%
									}
										}
								%>
							</tbody>
						</table>
						</div>
						</div>
						<input type="submit" value="保存" />
						<button onclick="window.location.href='sync.html'">从微信公众号同步新消息</button>
					</form>

				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="http://cdn.bootcss.com/bootstrap/2.3.2/js/bootstrap.min.js"></script>

</body>
</html>

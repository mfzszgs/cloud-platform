<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link
	href="http://cdn.bootcss.com/bootstrap/2.3.2/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="http://cdn.bootcss.com/bootstrap/2.3.2/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="dashboard.css" rel="stylesheet">
</head>
<body>
	<h2 class="sub-header">Section title</h2>
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th width=400>#</th>
					<th>Header</th>
					<th>Header</th>
					<th>Header</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1,001</td>
					<td>Lorem</td>
					<td>ipsum</td>
					<td>sit</td>
				</tr>
				<tr>
					<td>1,002</td>
					<td>amet</td>
					<td>consectetur</td>
					<td>elit</td>
				</tr>
			</tbody>
		</table>
	</div>

	<select
		onchange="window.location.href=this.options[this.selectedIndex].value">
		<option value="" hidden="hidden"></option>
		<option value="http:\\www.baidu.com">百度</option>
		<option value="http:\\www.google.cn">谷歌</option>
	</select>


	<div class="tabbable tabs-left">
		<ul class="nav nav-tabs">
			<li class=""><a href="#lA" data-toggle="tab">Section 1</a></li>
			<li class=""><a href="#lB" data-toggle="tab">Section 2</a></li>
			<li class="active"><a href="#lC" data-toggle="tab">Section 3</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane" id="lA">
				<p>I'm in Section A.</p>
			</div>
			<div class="tab-pane" id="lB">
				<p>Howdy, I'm in Section B.</p>
			</div>
			<div class="tab-pane active" id="lC">
				<p>What up girl, this is Section C.</p>
			</div>
		</div>
	</div>

	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="http://cdn.bootcss.com/bootstrap/2.3.2/js/bootstrap.min.js"></script>
</body>
</html>
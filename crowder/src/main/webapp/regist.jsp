<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.scutpress.cloud.publicwechat.domain.Msg"%>
<html>
<head>
<title>admin</title>
    <!-- Bootstrap core CSS -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

      <form class="form-signin">
        <h2 class="form-signin-heading">注册信息</h2>

        <label for="inputName" class="sr-only">name</label>
        <input type="name" id="inputName" class="form-control" placeholder="Email address" required autofocus>

        <label for="inputEmail" class="sr-only">email</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮箱" required>
        <label for="inputEmail" class="sr-only">email</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮箱" required>
        <label for="inputEmail" class="sr-only">email</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮箱" required>
        <label for="inputEmail" class="sr-only">email</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮箱" required>
        <label for="inputEmail" class="sr-only">email</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮箱" required>
        <label for="inputEmail" class="sr-only">email</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮箱" required>
        <label for="inputEmail" class="sr-only">email</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮箱" required>
        <label for="inputEmail" class="sr-only">email</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮箱" required>
        <label for="inputEmail" class="sr-only">email</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮箱" required>
        <label for="inputEmail" class="sr-only">email</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮箱" required>

        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">确认注万恶册</button>
      </form>
      
      
      <div class="form" id="consignee-form" name="consignee-form">
	<div class="item" id="name_div">
		<span class="label"><span style="color:red">*</span>&nbsp;收货人：</span>
		<div class="fl">
			<input type="hidden" id="consignee_form_id" name="consigneeParam.id" value="">
		    <input type="hidden" id="consignee_type" name="consigneeParam.type" value="">
		    <input type="hidden" id="consignee_ceshi1" name="consignee_ceshi1" value="">
			<input type="text" class="itxt" id="consignee_name" name="consigneeParam.name" maxlength="20" value="" tabindex="1">
			<span class="error-msg" id="name_div_error"></span>
		</div>
	</div>
	<div class="item" id="area_div">
		<span class="label"><span style="color:red">*</span>&nbsp;所在地区：</span>
		<div class="fl">
			<span id="span_area">
			  <span id="span_province"><select class="selt" id="consignee_province" name="consigneeParam.provinceId" onchange="loadCitys()" tabindex="2"><option value="">请选择：</option><option value="1">北京</option><option value="2">上海</option><option value="3">天津</option><option value="4">重庆</option><option value="5">河北</option><option value="6">山西</option><option value="7">河南</option><option value="8">辽宁</option><option value="9">吉林</option><option value="10">黑龙江</option><option value="11">内蒙古</option><option value="12">江苏</option><option value="13">山东</option><option value="14">安徽</option><option value="15">浙江</option><option value="16">福建</option><option value="17">湖北</option><option value="18">湖南</option><option value="19">广东</option><option value="20">广西</option><option value="21">江西</option><option value="22">四川</option><option value="23">海南</option><option value="24">贵州</option><option value="25">云南</option><option value="26">西藏</option><option value="27">陕西</option><option value="28">甘肃</option><option value="29">青海</option><option value="30">宁夏</option><option value="31">新疆</option><option value="32">台湾</option><option value="42">香港</option><option value="43">澳门</option><option value="84">钓鱼岛</option></select></span>
			   <span id="span_city"><select class="selt" id="consignee_city" name="consigneeParam.cityId" tabindex="3"><option value="">请选择：</option></select></span>
			   <span id="span_county"><select class="selt" id="consignee_county" name="consigneeParam.countyId" tabindex="4"><option value="">请选择：</option></select></span>
			   <span id="span_town" style="display:none"><select class="selt" id="consignee_town" name="consigneeParam.townId" tabindex="5"><option value="">请选择：</option></select></span>
	        </span>
			<span class="error-msg" id="area_div_error"></span>
			<!--div class="ftx-03">标“*”的为支持货到付款的地区，<a href="" target="_Blank" class="ftx-05" id="codHelpUrl">查看货到付款地区</a></div-->
		</div>
	</div>
	<div class="item">
		<span class="label" id="address_div"><span style="color:red">*</span>&nbsp;详细地址：</span>
		<div class="fl">
			<!--span id="areaNameTxt"></span-->
			<input type="text" class="itxt itxt02" id="consignee_address" name="consigneeParam.address" maxlength="50" onblur="check_Consignee('address_div')" value="" tabindex="6">
			<span class="error-msg" id="address_div_error"></span>
		</div>
	</div>
	<div class="item" id="call_div">
		<span class="label"><span style="color:red">*</span>&nbsp;手机号码：</span>
		<div class="fl">
			<input type="text" class="itxt " id="consignee_mobile" name="consigneeParam.mobile" onblur="check_Consignee('call_mobile_div')" onfocus="if(value == defaultValue){value='';}" maxlength="11" value="" tabindex="7">
		</div>
		<div class="fl">
			<span class="label">固定电话：</span>
			<input type="text" class="itxt " id="consignee_phone" name="consigneeParam.phone" onblur="check_Consignee('call_phone_div')" onfocus="if(value == defaultValue){value='';}" maxlength="20" value="" tabindex="8">
		</div>
		<span class="error-msg" id="call_div_error"></span>
	</div>
	<div class="item" id="email_div">
		<span class="label">邮箱：</span>
		<div class="fl">
			<input type="text" class="itxt" id="consignee_email" name="consigneeParam.email" maxlength="50" onblur="check_Consignee('email_div')" value="" onfocus="if(value == defaultValue){value='';}" tabindex="9">
			<span class="error-msg" id="email_div_error"></span>
			<div class="ftx-03">用来接收订单提醒邮件，便于您及时了解订单状态</div>
		</div>
	</div>
	<div class="item">
		<span class="label">&nbsp;</span>
		<div class="fl">
			<a href="#none" class="btn-9" onclick="save_Consignee()"><span id="saveConsigneeTitleDiv">保存收货人信息</span></a>
			<div class="loading loading-1" style="display:none"><b></b>正在提交信息，请等待！</div>
			<!--a href="#none" class="btn-9 ml10">取消</a-->
		</div>
		<div style="display:none"><input id="consignee_form_reset" name="" type="reset"></div>
	</div>
</div>
      
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

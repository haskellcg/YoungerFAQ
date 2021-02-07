<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="youngerFAQ.commons.sub.*"%>
<%@ page import="youngerFAQ.commons.dbfunction.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/messages_cn.js"></script>
<title>修改个人信息</title>
<%
	UserMes userMes = (UserMes) request.getAttribute("userMes");
	String birthday = userMes.getBirthday();
	String[] dateList = birthday.split("-");
	String birth_year = dateList[0];
	String birth_month = dateList[1];
	birth_month = Integer.toString(Integer.parseInt(birth_month));
	String birth_day = dateList[2];
%>
<script type="text/javascript">
	$().ready(function() {
		$("#regform").validate({
			rules : {
				username : {
					required : true,
					rangelength : [ 5, 20 ],
					remote : {
						url : "UserCheck", //后台处理程序   
						type : "post", //数据发送方式   
						dataType : "json", //接受数据格式      
						data : { //要传递的数据，默认已传递应用此规则的表单项   
							username : function() {
								return $('#username').val();
							}
						}
					}

				},
				dearname : {
					required : true,
					rangelength : [ 1, 15 ],
				},
				password : {
					required : true,
					rangelength : [ 6, 20 ]
				},
				password2 : {
					required : false,
				},
				mail : {
					required : true,
					email : true
				},
				cellphone : {
					required : false,
					digits : true,
					rangelength : [ 7, 11 ]
				},
				qq : {
					required : false,
					maxlength : 15,
					digits : true
				},
				work : {
					required : false,
					maxlength : 15
				},
				gender : {
					required : true
				},
				address : {
					required : false
				},
				birthyear : {
					required : false
				},
			},
			success : function(label) {
				// set &nbsp; as text for IE
				label.html("&nbsp;").addClass("checked");
				//label.addClass("valid").text("Ok!")
			}
		});
	});
</script>


<style type="text/css">
.input {
	float: left;
	margin-left: 20px;
}

input.error {
	border: 1px solid red;
}

label.error {
	float: left;
	font-weight: bold;
	color: #EA5200;
}

label.valid {
	display: hidden;
}
</style>
</head>
<body>
	<jsp:include page="common/head.jsp" flush="true" />
	<div id="page" style="">
		<jsp:include page="common/nav.jsp" flush="true" />
		<div style="padding-left: 260px;">
			<form method="post" id="regform" enctype="multipart/form-data">
				<table border="0" width="800" height="500"
					style="background: none; text-align: left;">
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">用户名*</div></td>
						<td width="600"><input type="text" name="username"
							id="username" class="input" value="<%=userMes.getUserName()%>" /></td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">昵称*</div></td>
						<td width="600"><input type="text" name="dearname"
							class="input" value="<%=userMes.getDearName()%>" /></td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">用户密码*</div></td>
						<td width="600"><input type="password" name="password"
							id="password" class="input" value="<%=userMes.getPassword()%>" /></td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">旧密码(如果修改密码需填写)</div></td>
						<td width="600"><input type="password" name="password2"
							id="password2" class="input" /></td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">电子邮箱*</div></td>
						<td width="600"><input type="text" name="mail" class="input"
							value="<%=userMes.getEmail()%>" /></td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">移动电话</div></td>
						<td width="600"><input type="text" name="cellphone"
							class="input" value="<%=userMes.getCellNumber()%>" />&nbsp;</td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">QQ</div></td>
						<td width="600"><input type="text" name="qq" class="input"
							value="<%=userMes.getQqnumber()%>" />&nbsp;</td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">职业</div></td>
						<td width="600"><input type="text" name="work" class="input"
							value="<%=userMes.getUserName()%>" /> &nbsp;</td>
					</tr>

					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">所在地区</div></td>
						<td width="600"><input type="text" name="address"
							class="input" value="<%=userMes.getAddress()%>" /> &nbsp;</td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">出生日期</div></td>
						<td width="600" style=""><div
								style="float: left; margin-left: 20px;">
								<select name="birthyear">
									<%
										for (int i = 1990; i <= 2012; i++) {
											if (Integer.toString(i).equals(birth_year)) {
									%>
									<option selected="selected"><%=i%></option>
									<%
										} else {
									%>
									<option><%=i%></option>
									<%
										}
										}
									%>
								</select>年 <select name="birthmonth">
									<%
										for (int i = 1; i <= 12; i++) {
											if (Integer.toString(i).equals(birth_month)) {
									%>
									<option selected="selected"><%=i%></option>
									<%
										} else {
									%>
									<option><%=i%></option>
									<%
										}
										}
									%>
								</select>月 <select name="birthdy">
									<%
										for (int i = 1; i <= 31; i++) {
											if (Integer.toString(i).equals(birth_day)) {
									%>
									<option selected="selected"><%=i%></option>
									<%
										} else {
									%>
									<option><%=i%></option>
									<%
										}
										}
									%>
								</select>日
							</div></td>

					</tr>
					<tr align="center" valign="middle">

						<td width="200"><div class="table_font">性别</div></td>
						<td width="600" class="input">
							<div style="float: left;">
								<select name="sex">
									<%
										if (userMes.isSex() == true) {
									%>
									<option selected="selected">男</option>
									<option>女</option>
									<%
										} else {
									%>
									<option>男</option>
									<option selected="selected">女</option>
									<%
										}
									%>
								</select>
							</div>
						</td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">头像</div></td>
						<td width="600" style=""><input type="file" name="headpic"
							width="20" class="input" /></td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font"></div></td>
						<td width="600"><input type="hidden" name="isAdministration"
							value="no" /></td>
					</tr>
				</table>
				<div style="padding-left: 30px; text-align: center;">
					<table border="0" width="450" height="50">
						<tr>
							<td width="275px"><input type="submit" value="确定修改" /></td>
							<td width="275px"><input type="reset" value="重置"></td>
						</tr>
					</table>
				</div>
			</form>
		</div>
	</div>
	<br />
	<br />
	<div class="line"></div>
	<div id="ft">©2012 Younger</div>
</body>
</html>
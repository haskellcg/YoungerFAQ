<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/messages_cn.js"></script>
<title>register</title>

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
					required : true,
					equalTo : "#password"
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
			<form method="post" id="regform" enctype="multipart/form-data"
				action="register.jsp">
				<table border="0" width="800" height="500"
					style="background: none; text-align: left;">
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">用户名*</div></td>
						<td width="600"><input type="text" name="username"
							id="username" class="input" /></td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">昵称*</div></td>
						<td width="600"><input type="text" name="dearname"
							class="input" /></td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">用户密码*</div></td>
						<td width="600"><input type="password" name="password"
							id="password" class="input" /></td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">重复密码*</div></td>
						<td width="600"><input type="password" name="password2"
							id="password2" class="input" /></td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">电子邮箱*</div></td>
						<td width="600"><input type="text" name="mail" class="input" /></td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">移动电话</div></td>
						<td width="600"><input type="text" name="cellphone"
							class="input" />&nbsp;</td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">QQ</div></td>
						<td width="600"><input type="text" name="qq" class="input" />&nbsp;
						</td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">职业</div></td>
						<td width="600"><input type="text" name="work" class="input" />
							&nbsp;</td>
					</tr>

					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">所在地区</div></td>
						<td width="600"><input type="text" name="address"
							class="input" /> &nbsp;</td>
					</tr>
					<tr align="center" valign="middle">
						<td width="200"><div class="table_font">出生日期</div></td>

						<td width="600" style=""><div
								style="float: left; margin-left: 20px;">
								<select name="birthyear">
									<option>1990</option>
									<option>1991</option>
									<option>1992</option>
									<option>1993</option>
									<option>1994</option>
									<option>1995</option>
									<option>1996</option>
									<option>1997</option>
									<option>1998</option>
									<option>1999</option>
									<option>2000</option>
									<option>2001</option>
									<option>2002</option>
									<option>2003</option>
									<option>2004</option>
									<option>2005</option>
									<option>2006</option>
									<option>2007</option>
									<option>2008</option>
									<option>2009</option>
									<option>2010</option>
									<option>2011</option>
									<option>2012</option>
								</select>年 <select name="birthmonth">
									<option>01</option>
									<option>02</option>
									<option>03</option>
									<option>04</option>
									<option>05</option>
									<option>06</option>
									<option>07</option>
									<option>08</option>
									<option>09</option>
									<option>10</option>
									<option>11</option>
									<option>12</option>
								</select>月 <select name="birthdy">
									<option>01</option>
									<option>02</option>
									<option>03</option>
									<option>04</option>
									<option>05</option>
									<option>06</option>
									<option>07</option>
									<option>08</option>
									<option>09</option>
									<option>10</option>
									<option>11</option>
									<option>12</option>
									<option>13</option>
									<option>14</option>
									<option>15</option>
									<option>16</option>
									<option>17</option>
									<option>18</option>
									<option>19</option>
									<option>20</option>
									<option>21</option>
									<option>22</option>
									<option>23</option>
									<option>24</option>
									<option>25</option>
									<option>26</option>
									<option>27</option>
									<option>28</option>
									<option>29</option>
									<option>30</option>
									<option>31</option>
								</select>日
							</div></td>

					</tr>
					<tr align="center" valign="middle">

						<td width="200"><div class="table_font">性别</div></td>
						<td width="600" class="input">
							<div style="float: left;">
								<select name="sex">
									<option>男</option>
									<option>女</option>
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
							<td width="275px"><input type="submit"
								value="注册为Younger知道用户" /></td>
							<td width="275px"><input type="reset" value="重新填写" /></td>
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
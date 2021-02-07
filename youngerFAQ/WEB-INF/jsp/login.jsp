<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/loginPage.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录younger账号</title>
</head>

<body>
	<center>
		<br /> 
		<br />
		<div id="main" align="left">
			<table id="loginPage" cellpadding="0" cellspacing="0" border="0"
				width="840">
					<tr>
						<td id="logotd">
						        <a href="index.jsp"> <img
								alt="younger" src="image/logoWhite.jpg" height="70" width="250"
								border="0"></a>
						</td>
						<td id="helptd" style="padding-right:22px; padding-top: 15px;"
							align="right">
							<a href="#"> 帮助 </a>
						</td>
					</tr>
			</table>
			<br />

			<div id="left">
				<table>
					<tr>
						<td><img width="576" height="150"
							src="image/2011082346643937.jpg" style="border: none;"></td>
					</tr>
				</table>
			</div>

			<div id="center" style="border:#ccc solid 1px;" >
				<table width="240" cellpadding="8" cellspacing="0">
					<form name="myform" method="post">
						<br/>
						<tr>
							<td><strong>Younger注册账户请直接登录 </strong></td>
						</tr>
						<tr>
							<td><hr size="0" style="border-top: 1px solid #AAAAAA" /></td>
						</tr>
						<tr>
							<td colspan="2" bgcolor="#FFFFFF" height="150">
								<p style="text-align: center;" font="18">
									账号 <input type="text" name="username" style="width: 120px;">
								</p>
								<p style="text-align: center;">
									密码 <input type="password"  name="password" style="width: 120px;">
								</p>
								<lable style="font-size:13px ;color:red;"><%if(request.getAttribute("errorMes")!=null){ %><%=request.getAttribute("errorMes")%><%} %></lable>
								<p style="text-align: center">
									<input type="submit" name="login"
										style="background-color: #4E98E1; margin-right: 20px"
										value="登录" onClick="logo_in()"> <input type="button"
										name="exit" style="background: #4E98E1" value="取消"
										onClick=window.location.assign("index.jsp")>
								</p>
								<br/>
								<p style="font-size: 13px; text-align: center">
									还没有Younger账号？ <a href="register.jsp"">立即注册</a>
								</p> 
								<br/>
							</td>
						</tr>
					</form>
				</table>
			</div>

			<div id="right" border="0">
				<table>
					<tr>
						<img src="image/right.JPG" width="22" height="150" />
					</tr>
				</table>
			</div>
			<br clear="all">
			<br/>
			<br/>
			<br/>
		    <br/>
			<br/>
			<div class="line"> </div>
			<div id="ft"> ©2012 Younger </div>
		</div>
	</center>
</body>
</html>
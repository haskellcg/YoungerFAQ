<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="youngerFAQ.commons.sub.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/common.css">
<title>用户列表</title>
</head>


<%
	UserMesList list = (UserMesList) request.getAttribute("list");//获得用户列表
%>

<body>
	<jsp:include page="common/head.jsp" flush="true" />
	<div id="page" style="">
		<jsp:include page="common/nav.jsp" flush="true" />
		<table width="800" border="0" cellpadding="0" cellspacing="0"
			id="table3">
			<tr height="37">
				<td align="left" width="100" id="table3td1"
					style="background-color: #8FBC8F" onClick="change1()"
					style="font-size:18px">搜索结果</td>
				<td id="for1" align="right" valign="middle" class=""
					style="background-color: #8FBC8F">共有结果：<%=list.length()%>个&nbsp;总页数：1&nbsp;
					&nbsp; &nbsp; &hearts; 第 1 页
				</td>
				<td width="20" align="right" valign="middle" class=""
					style="background-color: #8FBC8F"><input type="button"
					value="上一页" /></td>
				<td width="20" align="right" valign="middle" class=""
					style="background-color: #8FBC8F"><input type="button"
					value="下一页" /></td>
			</tr>
			<tr>
				<td colspan="4">
					<table width="100%" align="center" cellpadding="1" cellspacing="1"
						background="src/q8.jpg" id="table2" bordercolor="#123">
						<tr>
							<td align="center" valign="middle"><div
									style="text-align: left;">用户图像</div></td>
							<td width="20%" height="28" align="center" valign="middle"><div
									align="left">用户名称</div></td>
						</tr>
						<%
							int count = 10;
							if (list != null) {
								if (count > list.length())
									count = list.length();
								for (int i = 0; i < count; i++) {
									list.setPos(i);
						%>
						<tr class="maintxt">
							<td><img src=<%=list.currValue().getHeadPic()%>></td>
							<td><a
								href="userhome.jsp?userId=<%=list.currValue().getUserId()%>"><%=list.currValue().getUserName()%></a></td>
						</tr>
						<%
							}
							}
						%>
					</table> <br>
				</td>
			</tr>
		</table>
	</div>
	<br />
	<br />
	<div class="line"></div>
	<div id="ft">©2012 Younger</div>
</body>
</html>
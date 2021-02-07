<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="youngerFAQ.commons.sub.*"%>
<%@ page import="youngerFAQ.commons.dbfunction.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<title>用户详细信息</title>
<style type="text/css">
@charset "utf-8";
/* CSS Document */
.usertable_font {
	font-size: 10px;
	font-family: Georgia, "Times New Roman", Times, serif;
	font-weight: 900;
}
</style>
<%
	UserMes userMes = (UserMes) request.getAttribute("userMes");
	ProblemMesList proSolvedList = (ProblemMesList) request
			.getAttribute("proSolvedList");
	ProblemMesList proSolveList = (ProblemMesList) request
			.getAttribute("proSolveList");
	AnswerMesList ansList = (AnswerMesList) request
			.getAttribute("answerMesList");
	DBFunctions dbFunction = new DBFunctions();
%>
</head>
<body>
	<jsp:include page="common/head.jsp" flush="true" />
	<div id="page" style="">
		<jsp:include page="common/nav.jsp" flush="true" />
		<center>
			<table border="1" width="845" height="630">
				<tr>
					<td>
						<table border="1" width="200" height="630">
							<tr>
								<td align="center"><img alt=""
									src="<%=userMes.getHeadPic()%>" /></td>
							</tr>
							<tr>
								<td height="20" align="left"><div class="usertable_font">名称</div></td>
							</tr>
							<tr>
								<td height="20" align="center"><%=userMes.getUserName()%></td>
							</tr>
							<tr>
								<td height="20" align="left"><div class="usertable_font">昵称</div></td>
							</tr>
							<tr>
								<td height="20" align="center"><%=userMes.getDearName()%></td>
							</tr>
							<tr>
								<td height="20" align="left"><div class="usertable_font">邮箱</div></td>
							</tr>
							<tr>
								<td height="20" align="center"><%=userMes.getEmail()%></td>
							</tr>
							<tr>
								<td height="20" align="left"><div class="usertable_font">移动电话</div></td>
							</tr>
							<tr>
								<td height="20" align="center"><%=userMes.getCellNumber().equals("") ? "未设置" : userMes
					.getCellNumber()%></td>
							</tr>
							<tr>
								<td height="20" align="left"><div class="usertable_font">QQ</div></td>
							</tr>
							<tr>
								<td height="20" align="center"><%=userMes.getQqnumber().equals("") ? "未设置" : userMes
					.getQqnumber()%></td>
							</tr>
							<tr>
								<td height="20" align="left"><div class="usertable_font">职业</div></td>
							</tr>
							<tr>
								<td height="20" align="center"><%=userMes.getWorkName().equals("") ? "未设置" : userMes
					.getWorkName()%></td>
							</tr>
							<tr>
								<td height="20" align="left"><div class="usertable_font">所在地区</div></td>
							</tr>
							<tr>
								<td height="20" align="center"><%=userMes.getAddress().equals("") ? "未设置" : userMes
					.getAddress()%></td>
							</tr>
							<tr>
								<td height="20" align="left"><div class="usertable_font">出生日期</div></td>
							</tr>
							<tr>
								<td height="20" align="center"><%=userMes.getBirthday()%></td>
							</tr>
							<tr>
								<td height="20" align="left"><div class="usertable_font">是否为超级管理员</div></td>
							</tr>
							<tr>
								<td height="20" align="center"><%=userMes.isAdministrator() == true ? "是" : "否"%></td>
							</tr>
							<tr>
								<td height="20" align="center"><div class="usertable_font">
										回答问题数：<%=ansList.length()%></div></td>
							</tr>
							<tr>
								<td height="20" align="center"><div class="usertable_font">
										提出问题数：<%=(proSolvedList.length() + proSolveList.length())%></div></td>
							</tr>
							<tr>
								<td height="20" align="left">
									<div class="usertable_font">
										<input type="submit" value="修改个人信息"
											onClick="javascript:window.open('changeUserInfo.jsp?userId=<%=userMes.getUserId()%>')" />
									</div>
								</td>
							</tr>
						</table>
					</td>

					<td valign="top">
						<table border="1" width="630" height="685">
							<tr valign="top">
								<td>
									<table border="1" width="620" height="210">
										<tr height="20">
											<td align="left"><div class="usertable_font">已解决的问题</div></td>
										</tr>
										<tr>
											<td valign="top" align="center">
												<table width=615 align="left" border=3 cellPadding="4"
													bordercolor="#c8cdcf">
													<%
														for (int i = 0; i < proSolvedList.length(); i++) {
															proSolvedList.setPos(i);
													%>
													<tr>
														<td>
															<p>
																<a
																	href="problemDetailed.jsp?proId=<%=proSolvedList.currValue().getProId()%>"><%=proSolvedList.currValue().getProTitle()%></a>
															<p>
														</td>
													</tr>

													<%
														proSolvedList.next();
														}
													%>
												</table>
											</td>
										</tr>
									</table>
									<table border="1" width="620" height="210">
										<tr height="20">
											<td align="left"><div class="usertable_font">未解决的问题</div></td>
										</tr>
										<tr>
											<td valign="top" align="center">
												<table width=615 align="left" border=3 cellPadding="4"
													bordercolor="#c8cdcf">
													<%
														for (int i = 0; i < proSolveList.length(); i++) {
															proSolveList.setPos(i);
													%>

													<tr>
														<td>
															<p>
																<a
																	href="problemDetailed.jsp?proId=<%=proSolveList.currValue().getProId()%>"><%=proSolveList.currValue().getProTitle()%></a>
															<p>
														</td>
													</tr>

													<%
														proSolveList.next();
														}
													%>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</center>
	</div>
	<br />
	<br />
	<div class="line"></div>
	<div id="ft">©2012 Younger</div>
</body>
</html>
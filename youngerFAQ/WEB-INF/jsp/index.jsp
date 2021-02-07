<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*"%>
<%@ page import="youngerFAQ.commons.sub.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Younger知道</title>
<script language="JavaScript">
	
</script>
<script for="window" event="onload">
	window.resizeTo(1280, 768);
</script>
<%
	ProblemMesList a = (ProblemMesList) request
			.getAttribute("proSolveList");
	ProblemMesList b = (ProblemMesList) request
			.getAttribute("proSolvedList");
	//需要精彩推荐的数组 c
	//需要来自于公告的数组 d
	ProblemMesList c = (ProblemMesList) request.getAttribute("proList");
	ProblemMesList d = (ProblemMesList) request.getAttribute("annouce");
%>
</head>
<body>

	<jsp:include page="common/head.jsp" flush="true" />
	<div id="page" style="">
		<jsp:include page="common/nav.jsp" flush="true" />
		<div class="inner">
			<div style="border: none;">
				<img src="image/rd_picture.jpg" height="160" width="200"
					style="padding: 5px; float: left;">
			</div>
			<div class="text">
				<img src="image/recommand.png" width="59" height="20" alt="精彩推荐"
					style="padding-top: 2px; float: left;" /> <a
					href="questionList.jsp?type=recommend" style="float: right">更多</a>
				<div style="height: 1px; clear: both;"></div>
				<ul
					style="font-family: '宋体'; font-size: 16px; list-style-type: disc;">
					<%
						int count_recommend = 4;
						if (c != null) {
							if (count_recommend > c.length())
								count_recommend = c.length();
							for (int i = 0; i < count_recommend; i++) {
								c.setPos(i);
					%>
					<li><a
						href="problemDetailed.jsp?proId=<%=c.currValue().getProId()%>"><%=c.currValue().getProTitle()%></a></li>

					<%
						}
						}
					%>

				</ul>
			</div>
		</div>
		<div class="inform">
			<div style="height: 30px; background: #8FBC8F">
				<span style="float: left; padding: 5px; font-weight: 600; color:"083A0B">公告区</span>
			</div>
			<div style="height: 145;">
				<table style="font-size: 17px">
					<tr>
						<td>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;我们提醒您注意，您需要注册并登录，才能享受我们的完整服务进行各项操作，否则您只有搜索和浏览的权限。</p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;注册成为“知道”的用户，是完全免费的。</p>
						</td>
					</tr>
				</table>


			</div>
		</div>
		<div style="height: 10px; clear: both;"></div>
		<div class="classify">
			<div
				style="height: 25px; font-size: 15px; color: #083A0B; font-weight: 600; text-align: left; padding: 5px; background: #8FBC8F;">
				问题分类</div>
			<div style="">
				<table width="200" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td><table id="table1" width="100%" border="0"
								//这里的点击都会被专至questioList。jsp中。
								cellpadding="1"
								cellspacing="1" background="src/q4.jpg">
								<tr>
									<td height="28" align="left"><a
										style="text-decoration: none" href="questionList.jsp?type=all">全部</a></td>
								</tr>
								<tr>
									<td height="28" align="left"><a
										style="text-decoration: none" href="questionList.jsp?type=1">科学教育</a></td>
								</tr>
								<tr>
									<td height="28" align="left"><a
										style="text-decoration: none" href="questionList.jsp?type=2">娱乐休闲</a>
									</td>
								</tr>
								<tr>
									<td height="28" align="left"><a
										style="text-decoration: none" href="questionList.jsp?type=3">生活</a></td>
								</tr>
								<tr>
									<td height="28" align="left"><a
										style="text-decoration: none" href="questionList.jsp?type=4">体育运动</a></td>
								</tr>
								<tr>
									<td height="28" align="left"><a
										style="text-decoration: none" href="questionList.jsp?type=5">时政</a></td>
								</tr>
							</table></td>
					</tr>

				</table>
			</div>
		</div>
		<div class="not_answer">
			<div
				style="height: 25px; font-size: 15px; font-weight: 600; color: #0C3; padding: 5px; background: #8FBC8F;">
				<span style="float: left; color: #083A0B">待解决问题</span> <span
					style="text-align: right; float: right; padding-top: 5px;"><a
					href="questionList.jsp?type=solve" style="text-decoration: none;">更多</a></span>
			</div>
			<div class="answer_list" id=table1>
				<ul style="list-style-type: disc;">



					<%
						int count = 10;
						if (a != null) {
							if (count > a.length())
								count = a.length();
							for (int i = 0; i < count; i++) {
								a.setPos(i);
					%><li><span class="answer_list_1"><a
							href="problemDetailed.jsp?proId=<%=a.currValue().getProId()%>"><%=a.currValue().getProTitle()%></a></span><span
						class="answer_list_2"><%=a.currValue().getProVisitNumber()%>访问</span></li>

					<%
						}
						}
					%>
				</ul>
			</div>
		</div>
		<div class="not_answer" style="margin-top: 20px;">
			<div
				style="height: 25px; font-size: 15px; font-weight: 600; color: #0C3; padding: 5px; background: #8FBC8F;">
				<span style="float: left; color: #083A0B">已解决问题</span> <span
					style="text-align: right; float: right; padding-top: 5px;"><a
					href="questionList.jsp?type=solved" style="text-decoration: none;">更多</a></span>
			</div>
			<div class="answer_list" id=table2>
				<ul style="list-style-type: disc;">
					<%
						count = 10;
						if (b != null) {
							if (count > b.length())
								count = b.length();
							for (int i = 0; i < count; i++) {
								b.setPos(i);
					%><li><span class="answer_list_1"><a
							href="problemDetailed.jsp?proId=<%=b.currValue().getProId()%>"><%=b.currValue().getProTitle()%></a></span><span
						class="answer_list_2"><%=b.currValue().getProVisitNumber()%>访问</span></li>

					<%
						}
						}
					%>

				</ul>
			</div>
		</div>
		<div style="height: 200px; clear: both;"></div>
	</div>
	<br />
	<br />
	<div class="line"></div>
	<div id="ft">©2012 Younger</div>
</body>
</html>
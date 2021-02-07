<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="youngerFAQ.commons.sub.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	ProblemMesList list = (ProblemMesList) request.getAttribute("list");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/common.css">
<title>question list</title>
</head>
<body>
	<jsp:include page="common/head.jsp" flush="true" />
	<div id="page" style="">
		<jsp:include page="common/nav.jsp" flush="true" />
		<table width="800" border="0" cellpadding="0" cellspacing="0"
			id="table3">
			<tr>
				<td colspan="4">
					<table width="100%" align="center" cellpadding="1" cellspacing="1"
						background="src/q8.jpg" id="table2" bordercolor="#123">
						<tr>
							<td height="28" align="center" valign="middle"><div
									style="text-align: left;">问题列表</div></td>
							<td width="20%" height="28" align="center" valign="middle"><div
									align="center">发贴时间</div></td>
							<td width="20%" height="28" align="center" valign="middle"><div
									align="center">发帖人</div></td>
						</tr>
							<%String str=null;
						str=(String)request.getAttribute("type");
						int pa = 0;
						int pagemax = 0;
						int count ;
						int count2;
						%>
						<%if(str!=null&&str.equals("recommend")){
							count2=8;
							count=8;
						}else{
							count2=15;
							count=15;
						}%>
						<%
							
							if (list != null) {
								pagemax = list.length() / count2;
								//pa=pagemax;
								String papa = (String) request.getAttribute("pa");
								if (papa != null)
									pa = Integer.parseInt(papa);
								if (pa == pagemax)
									count = list.length() - pa * count2;
								for (int i = 0; i < count; i++) {
									list.setPos(i + pa * count2);
						%>
						<tr class="maintxt">
							<td height="28"><a
								href="problemDetailed.jsp?proId=<%=list.currValue().getProId()%>"><%=list.currValue().getProTitle()%></a></td>
							<td height="28" align="center"><%=list.currValue().getProPublishDate()%></td>
							<td height="28" align="center"><%=list.currValue().getProPublisher()%></td>
						</tr>
						<%}} %>
					
						<%if(str!=null&&!str.equals("recommend")){%>
						<tr height="37">
							<td id="for1" align="right" valign="middle" class=""
								style="background-color: #8FBC8F">共有结果：<%=list.length()%>个&nbsp;总页数：<%=pagemax + 1%>&nbsp;
								&nbsp; &nbsp; &hearts; 第 <%=pa + 1%>页
							</td>
							<td width="20" align="right" valign="middle" class=""
								style="background-color: #8FBC8F"><a
								href="<%if (pa > 0) {%>questionList.jsp?type=<%=request.getAttribute("type")%>&pa=<%=pa - 1%><%} else {%>#<%}%>"><input
									type="button" value="上一页" /></a></td>
							<td width="20" align="right" valign="middle" class=""
								style="background-color: #8FBC8F"><a
								href="<%if (pa < pagemax) {%>questionList.jsp?type=<%=request.getAttribute("type")%>&pa=<%=pa + 1%><%} else {%>#<%}%>"><input
									type="button" value="下一页" /></a></td>
						</tr>
						<%}%>
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
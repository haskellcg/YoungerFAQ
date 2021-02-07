<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="youngerFAQ.commons.sub.*"%>
<%@ page import="youngerFAQ.commons.dbfunction.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<title>问题详细信息</title>
<script type="text/javascript">
	function checkNull(form) {
		with (form) {
			with (response) {
				if (value == "" || value == null) {
					alert("输入不能为空!!!");
					return false;
				} else {
					return true;
				}
			}
		}
	}
</script>
</head>
<body>
	<jsp:include page="common/head.jsp" flush="true" />
	<div id="page" style="">
		<jsp:include page="common/nav.jsp" flush="true" />
		<center></center>

		<!--  -->
		<%
			ProblemMes problemMes = (ProblemMes) request
					.getAttribute("problemMes");
			AnswerMesList answerMesList = (AnswerMesList) request
					.getAttribute("answerMesList");
			//String bestAnsId=problemMes.getProBestAnsId(); 
			DBFunctions dbFunction = new DBFunctions();
		%>
		<table width=800 align="left" border=3 cellPadding="4"
			bordercolor="gray">
			<tr>
				<td>
					<p><%=problemMes.getProTitle()%>
					<p><%=problemMes.getProPublishDate()%></p>
					<p>
						提问者：<a
							href="userhome.jsp?userId=<%=dbFunction.getUserId(problemMes.getProPublisher())%>"><%=problemMes.getProPublisher()%></a>
					</p>
					<p><%=problemMes.getProContent()%>
					<p>
				</td>
			</tr>


			<!--<tr><td>
 <p style="font-size:18px;color:red">满意回答&hearts;</p>
 <p><p>
<p>2018-05-25</p>
<p>回答者：<span style="font-size:15px;color:red">2B</span></p>
 </td></tr>-->



		</table>


		<hr />
		<%
			if (!problemMes.isEnd()) {
		%>
		<table width=800 align="left" border=3 cellPadding="4"
			bordercolor="#c8cdcf">
			<tr>
				<td>
					<p>回答</p>
					<form action="answerQuestion.jsp?proId=<%=problemMes.getProId()%>"
						method="post" onsubmit="return checkNull(this)">
						<textarea cols=60 rows=6 name="response" id="response"></textarea>
						<input type="submit" value="提交" style="background: red"></input>
					</form>
				</td>
			</tr>
		</table>
		<%
			}
		%>
		<%
			for (int i = 0; i < answerMesList.length(); i++)

			{
				answerMesList.setPos(i);
		%>
		<table width=800 align="left" border=3 cellPadding="4"
			bordercolor="#c8cdcf">
			<tr>
				<td>

					<p>
						<a
							href="userhome.jsp?userId=<%=dbFunction.getUserId(answerMesList.currValue()
						.getAnsPersonname())%>"><%=answerMesList.currValue().getAnsPersonname()%></a>
					</p>
					<p><%=answerMesList.currValue().getAnsContent()%>
					<p>
					<%if(!problemMes.isEnd()&&session.getAttribute("userName")!=null&&session.getAttribute("userName").equals(problemMes.getProPublisher())){ %>
					<p>
					<a href="setBestAnswer.jsp?ansId=<%=answerMesList.currValue().getAnsId()%>">设置为最佳答案</a>
					</p>
					<%} %>
				</td>
			</tr>
		</table>
		<%
			answerMesList.next();
			}
		%>

	</div>
	<br />
	<br />
	<div style="height: 1px; clear: both;"></div>
	<div class="line"></div>
	<div id="ft">©2012 Younger</div>

</body>
</html>
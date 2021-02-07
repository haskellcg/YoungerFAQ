<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*"%>
<%@ page import="youngerFAQ.commons.sub.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>成功页面</title>
</head>
<body>
	<jsp:include page="common/head.jsp" flush="true" />
	<div id="page" style="">
		<jsp:include page="common/nav.jsp" flush="true" />
		<span style="font-size: 25px; color: green"><%=(String) request.getAttribute("successMes")%></span>

	</div>
	<br />
	<br />
	<div class="line"></div>
	<div id="ft">©2012 Younger</div>
</body>
</html>
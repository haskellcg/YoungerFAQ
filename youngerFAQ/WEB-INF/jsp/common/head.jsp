<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="top">
	<a href="index.jsp" title="login">首页</a>|
	<% if(session.getAttribute("userName")==null)
	{%>
	    <a href="register.jsp" title="login">注册</a>
	    <a href="login.jsp" title="login.jsp">登录</a>
<%	}
	else
	{ %>   
	    <a href="userhome.jsp?userId=<%=session.getAttribute("userId") %>" title="login"><%=session.getAttribute("userName")%></a>
	    <a href="logout.jsp" title="login">注销</a><%//暂时未定义注销
	}%>
</div>
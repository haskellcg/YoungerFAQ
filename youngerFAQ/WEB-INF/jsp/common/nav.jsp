<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="youngerFAQ.commons.dbfunction.*" %>  
<%	
	DBFunctions db=new DBFunctions();
%>  
<script type="text/javascript">
	function checkNull2(form) {
		with (form) {
			with (search) {
				if (value==""||value==null) {
					alert("输入不能为空!!!");
					return false;
				}else{
					return true;
				}
			}
		}
	}
</script>
<a href="index.jsp" class="logo" ><img style="margin:10px 0 0 0;border:none;" width="220px" height="80px" src="image/logo_big.png" /></a>
	<div class="btns" style="width:650px;">
			<form method="post" action="SearchIndex" onsubmit="return checkNull2(this)" name="searchIndex">
       	 		<span class="head_search">
   					 <input type="text" size="46" class="input_text" maxlength="100" name="search" id="search">
   					 <select name="choice">
   					 	<option>搜问题</option>
   					 	<option>搜人</option>
   					 </select>
				</span>
                <div style="height:1px; margin-left="15px" clear:both;"></div>
	        	<span class="btn_wrap">
    				<input type="submit" class="button" value="搜索"  />
  			    </span>
    		    <span class="btn_wrap">
    				<input type="button" class="button"  value="我要提问" onClick=window.location.assign("askQuestion.jsp")></input>
  			    </span>
        		<span class="btn_wrap">
    				<input type="button" class="button" value="我要回答" onClick=window.location.assign("questionList.jsp?type=all")></input>
  			    </span>
        	</form>
    </div>
    <div style="height:1px; clear:both;"></div>
    <div class="bar">
		<div class="bar_nav"><a href="index.jsp" style="">知道首页</a></div>
 		<div class="bar_nav"><a href="questionList.jsp?type=all" style="">更多问题</a></div>
		<div class="bar_nav"><a href="questionList.jsp?type=recommend">精彩推荐</a></div>
		<div class="bar_nav"><a href="userhome.jsp?userId=<%=(String)session.getAttribute("userId")%>" style="">个人主页</a></div>
		<div class="qustion_num" style="padding-top:7px;font:15px #000;float:right;text-align:center;">累计解决问题数:<%=db.getSolvedProblemMes().length() %>&nbsp;&nbsp;</div>
    </div> 
    <div style="height:10px; clear:both;"></div>
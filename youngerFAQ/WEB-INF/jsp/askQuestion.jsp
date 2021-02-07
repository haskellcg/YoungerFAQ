<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/common.css">
<title>提问题</title>
<script type="text/javascript">
	function checkNull3(form) {
		with (form) {
			with (textfield4) {
				if (value==""||value==null) {
					alert("标题不能为空!!!");
					return false;
				}else{
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
		<table width="100%" border="2" cellpadding="0" cellspacing="0">
			<tr>
				<td height="26" align="center" background="" class="maintitle">
					<span class="maintitle2">发布问题</span>
				</td>

			</tr>
			<tr>
				<form method="post" onsubmit="return checkNull3(this)">
					<td colspan="2"><br>
						<table width="90%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="20%" height="28"><div align="center">问题类别</div></td>
								<td height="28"><div align="left">
										<select name="select">
											<option>科学教育</option>
											<option>娱乐休闲</option>
											<option>生活</option>
											<option>体育运动</option>
											<option>时政</option>
										</select>
									</div></td>
							</tr>
							<tr>
								<td width="20%" height="28"><div align="center">问题标题</div></td>
								<td height="28"><div align="left">
										<input name="textfield4" type="text" size="50" maxlength="50"
											style="height: 30; background-color: #CCCC99; font-size: 20">
									</div></td>
							</tr>
							<tr>
								<td width="20%" height="28"><div align="center">详细内容</div></td>
								<td height="28" align="left" valign="top"><textarea
										name="textarea" cols="95" rows="10"
										style="background-color: transparent; font-size: 20"></textarea></td>
							</tr>
							<tr>
								<td height="28" colspan="2">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2"><div align="center">
										<input type="submit" name="Submit2" value="提交我的问题">
									</div></td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
							</tr>
						</table> <br></td>
				</form>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
		</table>

	</div>
</body>
<br />
<br />
<div class="line"></div>
<div id="ft">©2012 Younger</div>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户编辑</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/employee.do?cmd=save " method="post">
<fieldset>
<legend>添加员工信息</legend><br/>
用户名：<input type="text" name="username" value="" placeholder="请输入用户名"/><br/><br/>
密码：<input type="password" name="password" value=""/><br/><br/>
姓名：<input type="text" name="realname" value=""/><br/><br/>
性别：<input type="radio" name="gender" value="男"/>
男<input type="radio" name="gender" value="女" />
女<br /><br />
出生日期：			<input type="text" name="bornDate"value='' />
			<br />
			<br />
入职日期:			<input type="text" name="entryDate"value='' />
			<br /><br />
学历：			<select name="edu">
				<option>本科</option>
				<option>专科</option>
				<option>硕士</option>
				<option >博士</option>
				<option >壮士</option>
				<option >烈士</option>
			</select>
			<br /><br />
专业：			<input type="text" name="specialty" value="" />
			<br /><br />
简历：			<textarea rows="6" cols="50" name="intro"></textarea>
			<br /><br />
			<input type="submit" value="提交" />&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="重置" />
</fieldset>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请登录</title>
</head>
<body>
<!-- ${pageContext.request.contextPath} -->
<form action="<%=request.getContextPath()%>/user/login" method="post">
	用户名：<input type="text" name="username"/><br/>
	密  码：<input type="password" name="password"/><br/>
	${logintips}
	<br/>
	<br/>
	<input type="submit" value="登 录"/>
</form>
</body>
</html>
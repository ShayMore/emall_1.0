<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户详情</title>
</head>
<body>
<div>
	${user.id}<br/>
	${user.username}<br/>
	${user.age}<br/>
	${user.sex}<br/>
	<a href="users"><input type="button" value="返回"/></a>
</div>
</body>
</html>
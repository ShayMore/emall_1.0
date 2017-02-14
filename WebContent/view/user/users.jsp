<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户列表</title>
</head>
<body>
<div>
<c:forEach items="${users}" var="user">
	${user.value.id }
	${user.value.username}&emsp;
	${user.value.age}&emsp;
	${user.value.sex}&emsp;&emsp;
	<a href="${user.value.id }">详情 ${user.value.id }</a>&emsp;
	<a href="${user.value.id }/update">修改 ${user.value.id }</a>&emsp;
	<a href="${user.value.id }/delete">删除${user.value.id }</a>&emsp;
	<br/>
</c:forEach>
<a href="add">添加用户</a>
</div>
</body>
</html>
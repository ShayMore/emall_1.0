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
<c:forEach items="${users}" var="user">
	<p>${user.value.username}</p>
	<p>${user.value.password}</p>
	<p>${user.value.age}</p>
	<p>${user.value.email}</p><br/>
</c:forEach>
</body>
</html>
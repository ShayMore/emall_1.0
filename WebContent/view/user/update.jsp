<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
</head>
<body>
<spring:form method="post" modelAttribute="user">
	<spring:input path="id" value="${user.id }" type="hidden"/>
	用户名：<spring:input path="username" value="${user.username }"/><spring:errors path="username"/><br/>
	年龄：<spring:input path="age" value="${user.age }"/><spring:errors path="username"/><br/>
	性别：<spring:input path="sex" value="${user.sex }"/><spring:errors path="sex"/><br/>	
	<input type="submit" value="修改"/> &nbsp;<a href="${pageContext.request.contextPath}/user/users"><input type="button" value="返回"/></a>
</spring:form>
</body>
</html>
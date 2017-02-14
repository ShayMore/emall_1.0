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
<spring:form method="post" modelAttribute="user" enctype="multipart/form-data">
	用户名：<spring:input path="username"/><spring:errors path="username"/><br/>
	年龄：<spring:input path="age"/><spring:errors path="age"/><br/>
	性别：<spring:input path="sex"/><spring:errors path="sex"/><br/>
	头像：<input type="file" name="ufiles"/><input type="file" name="ufiles"/><input type="file" name="ufiles"/><br/>
	<input type="submit" value="添加"/>&nbsp;
	<a href="users"><input type="button" value="返回"/></a>
	<a href="../v/test.jsp"><input type="button" value="测试v"/></a>
	<a href="../default.jsp"><input type="button" value="测试"/></a>
</spring:form>
</body>
</html>
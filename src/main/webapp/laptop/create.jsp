<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Laptop</title>
</head>
<body>
	<h1>Create New Laptop</h1>
	<form action="${pageContext.request.contextPath}/Controller" method="post">
		<div>Name: <input name="name"/></div>
		<div>Price: <input name="price"/></div>
		<div>Description: <input name="desc"/></div>
		<div><input type="submit" name="a" value="Create"/></div>
	</form>
</body>
</html>
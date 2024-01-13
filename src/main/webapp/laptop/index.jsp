<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Laptop List</title>
</head>
<body>
	<h4><a href="Controller?a=DisplayCreate">Create New</a></h4>
	<form action="Controller">
		Min: <input name="min"/>
		Max: <input name="max"/>
		<input type="submit" name="a" value="Search"/>
	</form>
	<h1>Laptop List</h1>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Description</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${laptops}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.price}</td>
					<td>${item.description}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
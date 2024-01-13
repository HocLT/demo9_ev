<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Student</title>
</head>
<body>
	<form>
		<input type="radio" name="lang" value="Eng" id="eng" checked/>
		<label for="eng">English</label>
		<input type="radio" name="lang" value="Viet" id="viet"/>
		<label for="viet">Vietnam</label>
		<input type="submit" value="Change"/>
	</form>
	
	<fmt:setLocale value="en_US"/>
	<c:if test="${param.lang!=null && param.lang=='Viet'}">
		<fmt:setLocale value="vi_VN"/>
	</c:if>
	
	<%-- nạp tập tin ngôn ngữ theo locale --%>
	<fmt:setBundle basename="vn.aptech.lang.student" var="n"/>
	
	<h1><fmt:message bundle="${n}" key="create.student"/></h1>
	<form>
		<div>
			<label for="name"><fmt:message bundle="${n}" key="name"/></label>
			<input name="name" id="name"/>
		</div>
		<div>
			<label for="email"><fmt:message bundle="${n}" key="email"/></label>
			<input name="email" id="email"/>
		</div>
		<div>
			<label for="phone"><fmt:message bundle="${n}" key="phone"/></label>
			<input name="phone" id="phone"/>
		</div>
		<div><input type="submit" value="<fmt:message bundle="${n}" key="create"/>"/></div>
	</form>
</body>
</html>
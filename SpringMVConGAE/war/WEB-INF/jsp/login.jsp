<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title><spring:message code="login"/></title>
</head>
<body>
<table>
<form:form method="post" action="LoginAction.html">
<tr>
<td><spring:message code="user.name"/></td>
<td><form:input path="userName"/></td>
</tr>
<tr>
<td><spring:message code="password"/></td>
<td><form:password path="password"/></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="<spring:message code="login"/>"/>
</td>
</tr>
</form:form>
</table>
</body>
</html> 


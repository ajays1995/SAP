<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title><spring:message code="my.account"/></title>
</head>
<body>
<h2><spring:message code="my.account"/></h2>
<table>
<form:form method="post" action="RegisterUser.html">
<tr>
<td><spring:message code="first.name"/></td>
<td><form:input path="firstName" /></td>
</tr>
<tr>
<td><spring:message code="last.name"/></td>
<td><form:input path="lastName" /></td>
</tr>
<tr>
<td><spring:message code="email"/></td>
<td><form:input path="email" /></td>
</tr>
<tr>
<td><spring:message code="phone.number"/></td>
<td><form:input path="phoneNumber" /></td>
</tr>
<tr>
<tr>
<td colspan="2">
<input type="submit" value="<spring:message code="update.action"/>"/>
</td>
</tr>
</form:form>
</table>
</body>
</html> 


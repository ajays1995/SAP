<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title><spring:message code="user.registration"/></title>
</head>
<body>
<h2><spring:message code="user.registration"/></h2>
<table>
<form:form method="post" action="Login.html">
<tr>
<td><spring:message code="user.registration.request"/>
</td>
<td><input type="submit" value="<spring:message code="login"/>"/></td>
</tr>
</form:form>
</table>
</body>
</html> 


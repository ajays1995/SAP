<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title><spring:message code="home.page"/></title>
</head>
<body>
<h2><spring:message code="ride.share"/></h2>
<table>
<form:form method="post" action="postride.html">
<tr>
<td colspan="2">
<input type="submit" value="<spring:message code="post.ride"/>"/>
</td>
</tr>
<tr>
<td colspan="2">
</td>
</tr>
</form:form>
<form:form method="post" action="searchride.html">
<tr>
<td colspan="2">
<input type="submit" value="<spring:message code="search.ride"/>"/>
</td>
</tr>
</form:form>
<form:form method="post" action="userRegistration.html">
<tr>
<td colspan="2">
<input type="submit" value="<spring:message code="sign.up"/>"/>
</td>
</tr>
</form:form>
<form:form method="post" action="manageAccount.html">
<tr>
<td colspan="2">
<input type="submit" value="<spring:message code="my.account"/>"/>
</td>
</tr>
</form:form>
<form:form method="post" action="changePassword.html">
<tr>
<td colspan="2">
<input type="submit" value="<spring:message code="change.password"/>"/>
</td>
</tr>
</form:form>
</table>
</body>
</html> 


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<title><spring:message code="user.registration"/></title>
</head>
<body>
<h2><spring:message code="user.registration"/></h2>
<table>
<form:form method="post" action="RegisterUser.html">
<form:errors path="*" cssClass="errorblock" element="div" />
<tr>
<td><spring:message code="first.name"/></td>
<td><form:input path="firstName" /></td>
<td><form:errors path="firstName" cssClass="error"/></td>
</tr>
<tr>
<td><spring:message code="last.name"/></td>
<td><form:input path="lastName" /></td>
<td><form:errors path="lastName" cssClass="error"/></td>
</tr>
<tr>
<td><spring:message code="gender"/></td>
<td><form:radiobutton path="gender" value="M"/><spring:message code="gender.M"/></td>
<td><form:radiobutton path="gender" value="F"/><spring:message code="gender.F"/></td>
<td><form:errors path="gender" cssClass="error"/></td>
</tr>
<tr>
<td><spring:message code="email"/></td>
<td><form:input path="email" /></td>
<td><form:errors path="email" cssClass="error"/></td>
</tr>
<tr>
<td><spring:message code="phone.number"/></td>
<td><form:input path="phoneNumber" /></td>
<td><form:errors path="phoneNumber" cssClass="error"/></td>
</tr>
<tr>
<tr>
<td><spring:message code="password"/></td>
<td><form:password path="password" /></td>
<td><form:errors path="password" cssClass="error"/></td>
</tr>
<tr>
<td><spring:message code="confirm.password"/></td>
<td><form:password path="confirmPassword" /></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="<spring:message code="register.action"/>"/>
</td>
</tr>
</form:form>
</table>
</body>
</html> 


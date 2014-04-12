<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Change My Password</title>
</head>
<body>
<h2>Change Password</h2>
<table>
<form:form method="post" action="ChangePassword.html">
<tr>
<td><form:label path="oldPassword">Old Password</form:label></td>
<td><form:password path="oldPassword" /></td>
</tr>
<tr>
<td><form:label path="password">New Password</form:label></td>
<td><form:password path="password" /></td>
</tr>
<tr>
<td><form:label path="confirmPassword">Confirm Password</form:label></td>
<td><form:password path="confirmPassword" /></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Change My Password"/>
</td>
</tr>
</form:form>
</table>
</body>
</html> 

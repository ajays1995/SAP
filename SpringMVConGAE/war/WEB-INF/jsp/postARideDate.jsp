<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Post a Ride</title>
</head>
<body>
<h2>Post a Ride: Date</h2>
<form:form method="post" action="postrideDate.html">
<table>
<tr>
<td><form:label path="startDate">Start Date</form:label></td>
<td><form:input path="startDate" /></td>
</tr>
<tr>
<td><form:label path="endDate">End Date</form:label></td>
<td><form:input path="endDate" /></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Next Step"/>
</td>
</tr>
</table>
</form:form>
</body>
</html> 


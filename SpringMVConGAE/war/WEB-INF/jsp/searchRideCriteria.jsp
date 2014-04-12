<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Home Page</title>
</head>
<body>
<h2>Ride Share</h2>
<table>
<form:form method="post" action="searchrideDetails.html">
<tr>
<td><form:label path="startLoc">Starting From</form:label></td>
<td><form:input path="startLoc" /></td>
</tr>
<tr>
<td><form:label path="endLoc">Going To</form:label></td>
<td><form:input path="endLoc" /></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Search a Ride"/>
</td>
</tr>
</form:form>
</table>
</body>
</html> 


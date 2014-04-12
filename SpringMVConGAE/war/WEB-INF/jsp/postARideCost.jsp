<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Post a Ride</title>
</head>
<body>
<h2>Post a Ride: Cost</h2>
<p>How much do you want each passenger to contribute ?</p>
<form:form method="post" action="postrideCost.html">
<table>

<tr>  
   <td><form:radiobutton path="rateType" value="0" />Standard Rate<form:radiobutton  
                           path="rateType" value="1" />Customized Rate</td>  
</tr>  

<tr>
<td><form:label path="rate">Rs</form:label></td>
<td><form:input path="rate" /></td>
</tr>


<tr>
<td><form:label path="notes">Note</form:label></td>
<td><form:input path="notes" /></td>
</tr>

<tr>
<td><form:label path="maxAllowed">Max No of Passengers Allowed</form:label></td>
<td><form:input path="maxAllowed" /></td>
</tr>

<tr>
<td colspan="2">
<input type="submit" value="PostRide"/>
</td>
</tr>

<tr>
	<td>Share</td>
	<td><form:checkbox path="shareFlag" value="0" /></td>
				
</tr>

</table>
</form:form>
</body>
</html> 


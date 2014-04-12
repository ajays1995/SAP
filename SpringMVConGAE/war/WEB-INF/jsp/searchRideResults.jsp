<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<title>Available Rides</title>
</head>
<body>
<h2>Available Rides</h2>
<form:form name="results" method="post" action="searchrideSuccess.html">
<table>
         <tr>
   			<th>From</th>
   			<th>To</th>
   		    <th>Ride Name</th>
   			<th>Start Date</th>
   			<th>End Date</th>
   			<th>Seats Left</th>
   			<th>Rate (Rs)</th>
 		</tr>
 		</tr>
        
        <c:forEach var="ride" items="${rides}">
            <tr>
                <td>${ride.rideFromAddr}</td>   
                <td>${ride.rideToAddr}</td>
                <td>${ride.rideName}</td>
                <td>${ride.rideStartDate}</td>
                <td>${ride.rideEndDate}</td>
                <td>${ride.seatsLeft}</td>
                 <td>${ride.rate}</td>
            </tr>
        </c:forEach>
 </table>

</form:form>
</body>
</html> 


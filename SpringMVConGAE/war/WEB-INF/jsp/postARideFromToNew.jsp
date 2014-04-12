<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style type="text/css">
.two-col {
    overflow: hidden;/* Makes this div contain its floats */
}

.two-col .col1 {
    float: left;
}

.two-col .col2 {
    float: right;
}

.two-col label {
    display: block;
}


.global { width:708px; padding:2px; text-align:left;}
.leftpane {width:400px; margin-right:2px; display:inline-table;text-align:left;}
#mapholder {width:300px; display:inline-table;text-align:left;}

</style>
<title>Post a Ridee</title>
</head>
<body>
<h2>Post a Ride:From To</h2>
<form:form method="post" action="postrideDetails.html">

<div class="global">
    <div class="leftpane">
        <form:label path="startLoc">Starting Fromm </form:label>
        <form:input path="startLoc" /><br>
		<form:label width="50px" path="endLoc">Going To </form:label>
        <form:input path="endLoc" /><br>
        <input type="submit" value="Next Step"/>
    </div>

    <div id="mapholder">
        <label id="map" for="field2" onmouseover="getLocation()">Google Map here</label>
    </div>
</div>
</form:form>
<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script>
var x=document.getElementById("map");
function getLocation()
  {
  if (navigator.geolocation)
    {
    navigator.geolocation.getCurrentPosition(showPosition,showError);
    }
  else{x.innerHTML="Geolocation is not supported by this browser.";}
  }

function showPosition(position)
  {
  lat=position.coords.latitude;
  lon=position.coords.longitude;
  x.innerHTML="Latitude: " + lat +   "<br>Longitude: " + lon;
  latlon=new google.maps.LatLng(lat, lon)
  mapholder=document.getElementById('mapholder')
  mapholder.style.height='250px';
  mapholder.style.width='500px';

  var myOptions={
  center:latlon,zoom:14,
  mapTypeId:google.maps.MapTypeId.ROADMAP,
  mapTypeControl:false,
  navigationControlOptions:{style:google.maps.NavigationControlStyle.SMALL}
  };
  var map=new google.maps.Map(document.getElementById("mapholder"),myOptions);
  var marker=new google.maps.Marker({position:latlon,map:map,title:"You are here!"});
  }

function showError(error)
  {
  switch(error.code) 
    {
    case error.PERMISSION_DENIED:
      x.innerHTML="User denied the request for Geolocation."
      break;
    case error.POSITION_UNAVAILABLE:
      x.innerHTML="Location information is unavailable."
      break;
    case error.TIMEOUT:
      x.innerHTML="The request to get user location timed out."
      break;
    case error.UNKNOWN_ERROR:
      x.innerHTML="An unknown error occurred."
      break;
    }
  }
</script>
</body>
</html> 


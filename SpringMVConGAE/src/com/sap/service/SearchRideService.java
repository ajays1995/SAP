package com.sap.service;

import java.net.HttpURLConnection;  
import java.net.URL;  
import java.net.URLEncoder;  
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.xpath.XPath;  
import javax.xml.xpath.XPathConstants;  
import javax.xml.xpath.XPathFactory;  
import org.w3c.dom.Document;  
import org.w3c.dom.Node;  
import org.w3c.dom.NodeList;  
import org.xml.sax.InputSource;    
import java.io.IOException;  
import javax.xml.parsers.ParserConfigurationException;  
import javax.xml.xpath.XPathExpressionException;  
import org.xml.sax.SAXException;
import java.util.*;
import com.sap.form.RideInput;
import com.sap.form.SearchRideInput;
import com.sap.orm.postride.*;
import com.sap.dao.*;

public class SearchRideService {
	
	
	public List findRides(SearchRideInput srchRdI)
	{
		List fromArr = new ArrayList();
		List toArr = new ArrayList();
		try {
			
		// Google Geocoding API Call...will be charged per call..so commented out in Dev Env
		//fromArr = findLatLong(srchRdI.getStartLoc());
		//toArr = findLatLong(srchRdI.getEndLoc());
		
		fromArr.add("12");
		fromArr.add("31");
		toArr.add("14");
		toArr.add("27");
		
		}
		catch(Exception e)
		{
			System.out.println("Google Geocoding API call exception");
		}
		SearchRideDAO srchRdDAO = new SearchRideDAO();
		List ridesList = srchRdDAO.findRides(srchRdI.getStartDate(), fromArr, toArr);
		return ridesList;
	}
   
	
	// URL prefix to the geocoder    
	private static final String GEOCODER_REQUEST_PREFIX_FOR_XML = "http://maps.google.com/maps/api/geocode/xml";      
	public  List findLatLong (String locs) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException 
	{        // query address      
	//String address = "1600 Amphitheatre Parkway, Mountain View, CA";        
		String address = locs;
	// prepare a URL to the geocoder      
	URL url = new URL(GEOCODER_REQUEST_PREFIX_FOR_XML + "?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=false");        
	// prepare an HTTP connection to the geocoder      
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();        
	Document geocoderResultDocument = null;      
	try {        
	// open the connection and get results as InputSource.        
	conn.connect();        
	InputSource geocoderResultInputSource = new InputSource(conn.getInputStream());          
	// read result and parse into XML Document        
	geocoderResultDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(geocoderResultInputSource);      
	} 
	finally {       
	conn.disconnect();      
	}        
	// prepare XPath      
	XPath xpath = XPathFactory.newInstance().newXPath();        
	// extract the result      
	NodeList resultNodeList = null;        
	// a) obtain the formatted_address field for every result      
	resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result/formatted_address", geocoderResultDocument, XPathConstants.NODESET);      
	for(int i=0; i<resultNodeList.getLength(); ++i) 
	{        
	System.out.println(resultNodeList.item(i).getTextContent());      
	}        
	// b) extract the locality for the first result      
	resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result[1]/address_component[type/text()='locality']/long_name", geocoderResultDocument, XPathConstants.NODESET);      
	for(int i=0; i<resultNodeList.getLength(); ++i) 
	{        
	System.out.println(resultNodeList.item(i).getTextContent());      
	}        
	// c) extract the coordinates of the first result      
	resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result[1]/geometry/location/*", geocoderResultDocument, XPathConstants.NODESET);      
	float lat = Float.NaN;  
	
	float lng = Float.NaN;      
	for(int i=0; i<resultNodeList.getLength(); ++i) 
	{        
	Node node = resultNodeList.item(i);        
	if("lat".equals(node.getNodeName())) lat = Float.parseFloat(node.getTextContent());        
	if("lng".equals(node.getNodeName())) lng = Float.parseFloat(node.getTextContent());      
	}      
	System.out.println("lat/lng=" + lat + "," + lng);            
	// c) extract the coordinates of the first result      
	resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result[1]/address_component[type/text() = 'administrative_area_level_1']/country[short_name/text() = 'US']/*", geocoderResultDocument, XPathConstants.NODESET);      
	//float lat = Float.NaN;      
	//float lng = Float.NaN;      
	for(int i=0; i<resultNodeList.getLength(); ++i) 
	{        
	Node node = resultNodeList.item(i);        
	if("lat".equals(node.getNodeName())) lat = Float.parseFloat(node.getTextContent());        
	if("lng".equals(node.getNodeName())) lng = Float.parseFloat(node.getTextContent());      
	}      
	System.out.println("lat/lng=" + lat + "," + lng);      
	  
	List<String> latlong = new ArrayList<String>();
	
	latlong.add(String.valueOf(lat));
	latlong.add(String.valueOf(lng));
	
	//latlong.add("12.123");
	//latlong.add("31.234");
	
	
	return latlong;
	}    
}



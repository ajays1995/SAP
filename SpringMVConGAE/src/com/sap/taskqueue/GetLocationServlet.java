package com.sap.taskqueue;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class GetLocationServlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override

	public void doGet(HttpServletRequest req, HttpServletResponse resp)	throws IOException 
	{
		String driverID = req.getParameter("driverID");
		
		//get the driver ID then return the location of the driver
		
		String location = "Divya Sree Technopolis";
		
		resp.getWriter().println(location);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)	throws IOException 
	{
		doGet(req, resp);
	}
}

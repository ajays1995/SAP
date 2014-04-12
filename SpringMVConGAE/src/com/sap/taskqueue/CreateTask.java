package com.sap.taskqueue;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

@SuppressWarnings("serial")
public class CreateTask extends HttpServlet 
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)	throws IOException 
	{
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Queue queue = QueueFactory.getQueue("location-queue");
		
		Transaction tx = ds.beginTransaction();
		queue.add(TaskOptions.Builder.withUrl("/getLocation.do").param("driverID", "1"));
		
		String message = "successfully created a Task";
		
		resp.getWriter().println(message);
		
		tx.commit();
		
		//queue will be configured in the queue.xml which will be there in the /WEB-INF/
		//we will have the name for the queue or else it will be default-queue
		// there will be pull and push queue messages
		//if we do not specify the rate then it will be default of 5 tasks for second
		//<rate></rate>
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)	throws IOException 
	{
		doGet(req, resp);
	}
}

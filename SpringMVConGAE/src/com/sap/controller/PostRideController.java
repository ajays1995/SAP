package com.sap.controller;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller; 

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.apphosting.utils.remoteapi.RemoteApiPb.Request;
import com.sap.orm.HibernateUtil;
import com.sap.orm.postride.Location;
import com.sap.orm.postride.Ride; 
import org.springframework.stereotype.Controller; 
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.ModelAttribute; 

import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.SessionAttributes; 
import javax.servlet.http.HttpServletRequest;
import com.sap.form.*;
import com.sap.service.PostRideService;
import com.sap.valueobject.RideResult;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import com.sap.dao.*;
import com.sap.orm.postride.*;




@Controller
//@SessionAttributes("rideInput")
public class PostRideController 
{       
	@RequestMapping(value = "/postrideDetails", method = RequestMethod.POST)     
	public ModelAndView addRideDeatils(@ModelAttribute RideInput rdInput, BindingResult result, HttpServletRequest request) 
	{              
		System.out.println("Inside add Ride Details method");
		System.out.println("Start Locationn:" + rdInput.getStartLoc() + "End Loaction:" + rdInput.getEndLoc());
		request.getSession().setAttribute("rideInput", rdInput);
	    // return "redirect:postride.html";
		//ModelAndView modelAndView  = new ModelAndView();
		//modelAndView.setViewName("postARideDate");  
		//modelAndView.addObject("rideInput", rdInput);  
		//return modelAndView;
		return new ModelAndView("postARideDate", "command", rdInput); 
		}           
	
	@RequestMapping(value = "/postrideDate", method = RequestMethod.POST)     
	public ModelAndView addRideDate(@ModelAttribute RideInput rdInput, BindingResult result, HttpServletRequest request) 
	{                   
		System.out.println("Inside add Ride Date method");
		RideInput rdI = (RideInput)request.getSession().getAttribute("rideInput");
		System.out.println("Start Location :" + rdI.getStartLoc());
		
		rdI.setStartDate(rdInput.getStartDate());
		rdI.setEndDate(rdInput.getEndDate());
		request.getSession().setAttribute("rideInput", rdI);
		
		//System.out.println("Start Location After:" + rdBef.getStartLoc());
		System.out.println("Start Date :" + rdI.getStartDate());

		//ModelAndView modelAndView  = new ModelAndView();
		//modelAndView.setViewName("postARideCost"); 
		//modelAndView.addObject("rideInput", rdInput);
		//return modelAndView;
		//return "redirect:postride.html";
		return new ModelAndView("postARideCost", "command", rdInput); 
		}  
	
	@RequestMapping(value = "/postrideCost", method = RequestMethod.POST)     
	public ModelAndView addRideCost(@ModelAttribute RideInput rdInput, BindingResult result, HttpServletRequest request) 
	{                   
		System.out.println("Inside add Ride Cost method");
		RideInput rdI = (RideInput)request.getSession().getAttribute("rideInput");
		System.out.println("Start Location :" + rdI.getStartLoc());
		//System.out.println("Start Date :" + rdInput.getStartDate());
		
		rdI.setRateType(rdInput.getRateType());
		rdI.setRate(rdInput.getRate());
		rdI.setNotes(rdInput.getNotes());
		rdI.setShareFlag(rdInput.getShareFlag());
		rdI.setMaxAllowed(rdInput.getMaxAllowed());
		
		request.getSession().setAttribute("rideInput", rdI);
		
		System.out.println("Start Location:" + rdI.getStartLoc());
		System.out.println("Ride Start Date:" + rdI.getStartDate());
		System.out.println("Rate:" + rdI.getRate());
		System.out.println("Rate Type:" + rdI.getRateType());
		System.out.println("Notes:" + rdI.getNotes());
		System.out.println("Share Flag:" + rdI.getShareFlag());
		String userId = (String)request.getSession().getAttribute("userId");
		PostRideService pstRdSvc = new PostRideService();
		pstRdSvc.postRide(rdI,userId );
		
		/*List<String> latlongFrom = new ArrayList<String>();
		List<String> latlongTo = new ArrayList<String>();
		try {
			latlongFrom.add("12");
			latlongFrom.add("31");
			
			latlongTo.add("14");
			latlongTo.add("27");
			
		//latlongFrom = pstRdSvc.findLatLong(rdI.getStartLoc());
		//latlongTo = pstRdSvc.findLatLong(rdI.getEndLoc());
		}
		catch(Exception e)
		{
			System.out.println("Exception in GeoCoding: "+e.getMessage());
		}
		Ride rdEntity = new Ride();
		rdEntity = prepareEntity(rdEntity, rdI);
		
		Location locFrom = new Location();
		Location locTo = new Location();
		locFrom.setCompAddr(rdI.getStartLoc());
		locTo.setCompAddr(rdI.getEndLoc());
		
		locFrom.setLatitude((String)latlongFrom.get(0));
		locFrom.setLongitude((String)latlongFrom.get(1));
		
		locTo.setLatitude((String)latlongTo.get(0));
		locTo.setLongitude((String)latlongTo.get(1));
	
		
		User usr = new User("Guest", "Gupta", "test@abc.com", "9199992341");
		//usr.setRide(rdBef1);
		PostRideDAO pstRdDAO = new PostRideDAO();
		pstRdDAO.postRide(rdEntity, usr, locTo, locFrom);
		*/
		
		
		//return "redirect:postride.html";
		//ModelAndView modelAndView  = new ModelAndView();
		//modelAndView.setViewName("postARideSuccess"); 
		//modelAndView.addObject("rideInput", rdInput);
		//return modelAndView;

		return new ModelAndView("postARideSuccess", "command", rdInput); 
		}           
	
	
	@RequestMapping("/postride")     
	public ModelAndView getRideDeatils(HttpServletRequest request) 
	{                   
		
		
		SessionFactory sf = HibernateUtil.getSessionFactory();    
		 System.out.println("inside getRideDeatils method in PostRideController");
		Session session = sf.openSession();         
		

		
		session.beginTransaction();           
		//Ride department = new Ride();         
		//department.setDepartmentName("Sales");         
		
		User usr = new User();
		usr.setFirstname("Guest");
		usr.setUserType("Driver");
		usr.setLastname("Guest");
		
		session.save(usr);      
		 System.out.println("inside getRideDeatils method in PostRideController2");
		session.getTransaction().commit();
		 System.out.println("inside getRideDeatils method in PostRideController3");
		 
		 
		 session.beginTransaction();
		 System.out.println("inside getRideDeatils method in PostRideController4");
		 String hql1 = "SELECT usr.userId FROM User usr";
		 System.out.println("inside getRideDeatils method in PostRideController5");
			Query query = session.createQuery(hql1);
			System.out.println("inside getRideDeatils method in PostRideController6");
			List usrList = query.list();
			System.out.println("inside getRideDeatils method in PostRideController7");
			Long userId1 = (Long)usrList.get(0);
			//User usr1 = (User)usrList.get(0);
			session.getTransaction().commit();
			System.out.println("inside getRideDeatils method in PostRideController4 and user id is:"+userId1.longValue());
			
			
			
			request.getSession().setAttribute("userId", userId1.toString());
		session.close();
		
		return new ModelAndView("postARideFromTo", "command", new RideInput());     
	} 
	
	private Ride prepareEntity(Ride rdEntity, RideInput rdIp)
	{
		rdEntity.setEndDate(rdIp.getEndDate());
		rdEntity.setStartDate(rdIp.getStartDate());
		rdEntity.setNotes(rdIp.getNotes());
		rdEntity.setRate(rdIp.getRate());
		rdEntity.setRateType(rdIp.getRateType());
		rdEntity.setShareFlag(rdIp.getShareFlag());
		rdEntity.setRideName("TestRide");
		rdEntity.setRideStatus("In progress");
		
		
		//rdEntity.se(rdIp.getEndLoc());
		return rdEntity;
	}
	} 


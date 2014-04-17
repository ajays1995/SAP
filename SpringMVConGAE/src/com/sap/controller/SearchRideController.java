package com.sap.controller;

import org.springframework.stereotype.Controller; 

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.apphosting.utils.remoteapi.RemoteApiPb.Request;
import com.sap.orm.postride.Location;
import com.sap.orm.postride.Ride; 
import org.springframework.stereotype.Controller; 
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.ModelAttribute; 

import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.SessionAttributes; 
import javax.servlet.http.HttpServletRequest;
import com.sap.form.*;
import com.sap.service.*;
import java.util.List;
import java.util.ArrayList;
import com.sap.dao.*;
import com.sap.orm.postride.*;




@Controller
//@SessionAttributes("rideInput")
public class SearchRideController 
{       
	@RequestMapping(value = "/searchrideDetails", method = RequestMethod.POST)     
	public ModelAndView getRideDeatils(@ModelAttribute SearchRideInput srchRdInput, BindingResult result, HttpServletRequest request) 
	{              
		System.out.println("Inside getRideDeatils method");
		System.out.println("Start Locationn:" + srchRdInput.getStartLoc() + "End Loaction:" + srchRdInput.getEndLoc());
		//request.getSession().setAttribute("rideInput", rdInput);
	    // return "redirect:postride.html";
		//ModelAndView modelAndView  = new ModelAndView();
		//modelAndView.setViewName("postARideDate");  
		//modelAndView.addObject("rideInput", rdInput);  
		//return modelAndView;
		SearchRideService srchRdSvc = new SearchRideService();
		List ridesList = srchRdSvc.findRides(srchRdInput);
		//ModelAndView mv = new ModelAndView("searchRideResults", "command", new Ride());
		ModelAndView mv = new ModelAndView("searchRideResults");
		mv.addObject("rides",ridesList);
		return mv;
		//return new ModelAndView("searchRideResults", "command", new Ride()); 
		}   
	
	@RequestMapping("/searchride")     
	public ModelAndView searchRideCriteria() 
	{                   
		return new ModelAndView("searchRideCriteria", "command", new SearchRideInput());     
	} 
	
	
	} 


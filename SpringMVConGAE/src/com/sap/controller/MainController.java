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
import com.sap.service.PostRideService;
import java.util.List;
import java.util.ArrayList;
import com.sap.dao.*;
import com.sap.orm.postride.*;




@Controller
//@SessionAttributes("rideInput")
public class MainController 
{       
	
	@RequestMapping("/home")     
	public ModelAndView getRideDeatils() 
	{               
		System.out.println("in the home controller");
		return new ModelAndView("home", "command", new RideInput());     
	} 
	
	
	} 


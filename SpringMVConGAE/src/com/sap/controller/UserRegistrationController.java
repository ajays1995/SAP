package com.sap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sap.form.UserRegistrationInput;

@Controller
public class UserRegistrationController
{
	@RequestMapping("/userRegistration")
	public ModelAndView getUserRegistrationDetails()
	{
		System.out.println("in the user registration controller");
		return new ModelAndView("userRegistration", "command", new UserRegistrationInput());
	}
}

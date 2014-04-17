package com.sap.controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.sap.form.UserRegistrationInput;
import com.sap.orm.HibernateUtil;
import com.sap.orm.postride.User;

@Controller
public class RegisterUserController  
{
	@RequestMapping("/RegisterUser")
	
	public ModelAndView addUserDetails(@ModelAttribute UserRegistrationInput userInput, BindingResult result, HttpServletRequest request)
	{
		System.out.println("User Details during registration");
		
		System.out.println("User First Name   "+userInput.getFirstName());
		System.out.println("User last Name   "+userInput.getLastName());
		System.out.println("User email   "+userInput.getEmail());
		System.out.println("User Phone Number  "+userInput.getPhoneNumber());
		System.out.println("Password  "+userInput.getPassword());
		
						
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		User user = new User();
		
		user.setFirstname(userInput.getFirstName());
		user.setLastname(userInput.getLastName());
		user.setEmailId(userInput.getEmail());
		user.setPhoneNo(userInput.getPhoneNumber());
		user.setPassword(userInput.getPassword());
		//set the active flag as N. Once the verification is completed from the task queue then the flag will
		//be set to 'Y';
		user.setActive('N');
		
		session.save(user);
		session.getTransaction().commit();
		
	/**
	 * TODO: here we should send the user id generated to the task queue so that we will send some 
	 * random number generation to user email and user phone number which should be entered via application
	 * 
	 * once the user enters all the details and save them, we will verify those number and if they are correct
	 * user registration will be activated.
	 */
		
		return new ModelAndView("successfulRegistration");
	}
}

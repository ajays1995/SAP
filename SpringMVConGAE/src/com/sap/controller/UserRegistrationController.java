package com.sap.controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sap.Md5Encryption.Md5Encryption;
import com.sap.form.UserRegistrationInput;
import com.sap.orm.HibernateUtil;
import com.sap.orm.postride.User;
import com.sap.utils.RandomNumberGenerator;
import com.sap.utils.SendSMS;
import com.sap.validators.UserRegistrationValidator;

@Controller
public class UserRegistrationController
{
	String KEY = "onetime.password.message";
	
	@RequestMapping("/userRegistration")
	public ModelAndView getUserRegistrationDetails()
	{
		System.out.println("in the user registration controller");
		return new ModelAndView("userRegistration", "command", new UserRegistrationInput());
	}
	@RequestMapping("/RegisterUser")
	
	public ModelAndView addUserDetails(@ModelAttribute UserRegistrationInput userInput, BindingResult result, HttpServletRequest request)
	{
		UserRegistrationValidator validator = new UserRegistrationValidator();
		validator.validate(userInput, result);
		
		if(result.hasErrors())
		{
			return new ModelAndView("userRegistration", "command", userInput);
		}
						
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		User user = new User();
		
		user.setFirstname(userInput.getFirstName());
		user.setLastname(userInput.getLastName());
		user.setEmailId(userInput.getEmail());
		user.setPhoneNo(userInput.getPhoneNumber());
		user.setPassword(Md5Encryption.getEncryptedString(userInput.getPassword()));
		user.setGender(userInput.getGender());
		//set the account verified flag as N. 
		user.setAccountVerified('N');
		
		session.save(user);
		session.getTransaction().commit();
		
	/**
	 * TODO: here we should send the user id generated to the task queue so that we will send some 
	 * random number generation to user email and user phone number which should be entered via application
	 * 
	 * once the user enters all the details and save them, we will verify those number and if they are correct
	 * user registration will be activated.
	 *//*
	
		String message = "Thanks for Registering with our App. Your OTP is {0}. Use this for your Account Verification.";
		message = message.replace("{0}", new RandomNumberGenerator().getRandomNumber());
		
		try
		{
			SendSMS.sendSMS(userInput.getPhoneNumber(), message);
		}
		catch(Exception e)
		{
			System.out.println("Could not send the SMS due to some error  "+e.getMessage());
		}*/
		
		return new ModelAndView("successfulRegistration");
	}
}

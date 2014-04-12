package com.sap.controller;

import javax.servlet.http.HttpServletRequest; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sap.form.UserRegistrationInput;
import com.sap.orm.HibernateUtil;
import com.sap.orm.postride.User;

@Controller
public class ChangeMyPasswordController 
{
	@RequestMapping("/ChangePassword")
	
	public ModelAndView changePassword(@ModelAttribute UserRegistrationInput input,HttpServletRequest request)
	{
		System.out.println("in the controller");
		String oldPasswordEntered = input.getOldPassword();
		String newPasswordEntered = input.getPassword();
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		User user = new User();
		
		user = (User)session.get(User.class, new Long(1));
		
		String passwordStored = user.getPassword();
		
		session.close(); 
		
		if(oldPasswordEntered.equalsIgnoreCase(passwordStored))
		{
			user.setPassword(newPasswordEntered);
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.update(user);
			
			session.getTransaction().commit();
			
			System.out.println("changed the password");
			
			return new ModelAndView("successfulChangedPassword","command",new UserRegistrationInput());
		}
		else
		{
			//this is when the password stored and old password entered are different
			return new ModelAndView("changeMyPassword","command",new UserRegistrationInput());
		}
		
		
	}
	
	@RequestMapping("/changePassword")
	public ModelAndView getPasswordView()
	{
		System.out.println("in the second method controller");
		return new ModelAndView("changeMyPassword","command",new UserRegistrationInput());
	}
}

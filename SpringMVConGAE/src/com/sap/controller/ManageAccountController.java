package com.sap.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sap.form.UserRegistrationInput;
import com.sap.orm.HibernateUtil;
import com.sap.orm.postride.User;

@Controller
public class ManageAccountController 
{
	@RequestMapping("/manageAccount")
	
	public ModelAndView getUserDetails()
	{
		System.out.println("in the My Account Controller");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		User user = new User();
		
		user = (User)session.get(User.class, new Long(1));
		
		UserRegistrationInput ui = new UserRegistrationInput();
		ui.setEmail(user.getEmailId());
		ui.setFirstName(user.getFirstname());
		ui.setLastName(user.getLastname());
		ui.setPhoneNumber(user.getPhoneNo());
		
		session.close();
		
		return new ModelAndView("myAccount", "command", ui);
	}
}

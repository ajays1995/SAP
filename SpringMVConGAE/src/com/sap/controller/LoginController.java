package com.sap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sap.Md5Encryption.Md5Encryption;
import com.sap.dao.UserDAO;
import com.sap.orm.postride.User;

@Controller
public class LoginController 
{
	
	@RequestMapping("/Login")
	public ModelAndView loginAction()
	{
		System.out.println("Login Action");
		return new ModelAndView("login", "command", new UserLogin());
	}
	
	@RequestMapping("LoginAction")
	public ModelAndView checkAuthorization(@ModelAttribute UserLogin ul)
	{
		User user = new User();
		
		user.setUserName(ul.getUserName());
		
		UserDAO userDAO = new UserDAO();
		user = userDAO.findByUserName(user);
		
		//check whether the password is same or not
		
		if(Md5Encryption.getEncryptedString(ul.getPassword()).equals(user.getPassword()))
		{
			System.out.println("password is same");
			return new ModelAndView("home");
		}
		else
		{
			// login validation to be done
			return new ModelAndView();
		}
		
		
	}
}

/**
 * Inner class to store user name and password
 * @author Ajay
 *
 */
class UserLogin
{
	String userName;
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	String password;
	
	
}

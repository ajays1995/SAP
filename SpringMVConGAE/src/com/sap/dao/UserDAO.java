package com.sap.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sap.orm.HibernateUtil;
import com.sap.orm.postride.User;

public class UserDAO 
{
	
	public User findByUserName(User user)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		@SuppressWarnings("unchecked")
		List<User> users = session.createQuery("from User as user where user.emailId=? or user.phoneNo=?").
					setString(0, user.getUserName()).
					setString(1, user.getUserName())
					.list();
		
		session.close();
		
		/** 
		 * Only one user will be retrieved
		 */
		return users.get(0);
		
		
		
	}
}

package com.sap.dao;

import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.SessionFactory;   

import com.sap.form.RideInput;
import com.sap.orm.HibernateUtil;
import com.sap.orm.postride.*;
import com.sap.valueobject.RideResult;

import java.util.Iterator;
import java.util.List;
import java.sql.*;

public class PostRideDAO {       
	
	@SuppressWarnings("unchecked")     
	public void postRide(RideInput rdI, List fromArr, List toArr, String usrInSess) 
	{           
		System.out.println("inside postRide method in PostRideDAO New11 ans userid is session is :"+usrInSess);
		
		/*String url = null;
		try {
	    Class.forName("com.mysql.jdbc.Driver");         
	    //url = "jdbc:mysql://127.0.0.1:3306/SAP"; 
	    url="jdbc:google:rdbms://localhost:3306/SAP";
	    Connection conn = DriverManager.getConnection(url, "root", "mydb");
	    Statement stmt = conn.createStatement();
	    System.out.println("inside postRide method in PostRideDAO2");
	      String sql;
	      sql = "SELECT EMPLOYEE_ID FROM EMPLOYEE";
	      ResultSet rs = stmt.executeQuery(sql);
	      System.out.println("inside postRide method in PostRideDAO3");
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	    	  System.out.println("inside postRide method in PostRideDAO4");
	         //Retrieve by column name
	         int id  = rs.getInt("EMPLOYEE_ID");
	         System.out.println("inside postRide method in PostRideDAO5 an did is:"+id);

		}
		}
		catch(Exception e)
		{
			System.out.println("inside postRide method in PostRideDAO and causght exception");
		}
		*/
		
		
		SessionFactory sf = HibernateUtil.getSessionFactory();    
		 System.out.println("inside postRide method in PostRideDAO2");
		Session session = sf.openSession();         
		

		
		session.beginTransaction();           
		//Ride department = new Ride();         
		//department.setDepartmentName("Sales");         
		
		Ride rdEntity = new Ride();
		rdEntity = prepareEntity(rdEntity, rdI);
		session.save(rdEntity);                   
		//User usr1 = new User("Nina", "Mayers", "111");         
		//User usr2 = new User("Tony", "Almeida", "222"); 
		
		Location loc = new Location();
		//Location locTo = new Location();
		
		// Set From Location Details in Location Object
		loc.setFromCompAddr(rdI.getStartLoc());
		loc.setFromLat((String)fromArr.get(0));
		loc.setFromLong((String)fromArr.get(1));	
		
		
		// Set To Location Details in Location Object
		loc.setToCompAddr(rdI.getEndLoc());
		loc.setToLat((String)toArr.get(0));
		loc.setToLong((String)toArr.get(1));
		
		// associate the location details with a ride
		loc.setRide(rdEntity); 
           
		session.save(loc);
	
		
		
		
		
		
		String hql = "FROM User usr WHERE usr.userId = :usrId";
		//String hql = "SELECT E.firstName FROM Employee E WHERE E.id = :employee_id";
		System.out.println("inside postRide method in PostRideDAO3");
		Query query = session.createQuery(hql);
		System.out.println("inside postRide method in PostRideDAO4");
		//Long usrInSess1 = new Long();
		
		query.setParameter("usrId",Long.valueOf(usrInSess));
		
		System.out.println("inside postRide method in PostRideDAO5");
		List usrLst = query.list();
		
		
		
		User usr = (User)usrLst.get(0);
            
		System.out.print("inside postRide method in PostRideDAO6 and name is: " + usr.getFirstname()); 
			
		System.out.print("inside postRide method in PostRideDAO7 and ride id is:"+rdEntity.getRideId());
		usr.setRideId(rdEntity.getRideId());
		System.out.print("inside postRide method in PostRideDAO8");
		session.save(usr);
		System.out.print("inside postRide method in PostRideDAO9");
		
		//session.save(emp2);           
		session.getTransaction().commit();   
		System.out.print("inside postRide method in PostRideDAO10");
		session.close();  
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
		rdEntity.setRideStatus("Initiated");
		rdEntity.setMaxAllowed(rdIp.getMaxAllowed());
		rdEntity.setSeatsLeft(rdIp.getMaxAllowed());
		
		
		//rdEntity.se(rdIp.getEndLoc());
		return rdEntity;
	}
	} 


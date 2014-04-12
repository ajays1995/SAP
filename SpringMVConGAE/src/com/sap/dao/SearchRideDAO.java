package com.sap.dao;

import org.hibernate.Session; 
import org.hibernate.SessionFactory;   

import com.sap.form.RideInput;
import com.sap.form.SearchRideInput;
import com.sap.orm.HibernateUtil;
import com.sap.orm.postride.*;
import com.sap.valueobject.*;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import java.util.Iterator;
import org.hibernate.Query;

public class SearchRideDAO {       
	
	@SuppressWarnings("unchecked")     
	public List findRides(String rdDate, List fromLoc, List toLoc) 
	{           
		System.out.println("inside findRides method in SearchRideDAO New11");
		
		
		
		
		SessionFactory sf = HibernateUtil.getSessionFactory();    
		System.out.println("inside findRides method in SearchRideDAO2");
		Session session = sf.openSession();         
		String latF = (String)fromLoc.get(0);
		String longF= (String)fromLoc.get(1);
		String latT = (String)toLoc.get(0);
		String longT= (String)toLoc.get(1);
		Object[] val = null;
		List ridesList = new ArrayList();

		try {
		session.beginTransaction();      
		//String hql = "SELECT rd.rate, rd.startDate, rd.endDate, loc.compAddr FROM Ride AS rd INNER JOIN rd.locations AS loc WHERE loc.latitude = :latSql AND loc.longitude = :longSql";
		String hql = "SELECT loc.fromCompAddr, loc.toCompAddr, rd.rideName, rd.startDate, rd.endDate, rd.rate, rd.seatsLeft FROM Ride AS rd INNER JOIN rd.locations AS loc WHERE loc.fromLat = :fromLatSql AND loc.fromLong = :fromLongSql AND loc.toLat = :toLatSql AND loc.toLong = :toLongSql";

		//String hql = "SELECT E.firstName FROM Employee E WHERE E.id = :employee_id";
		System.out.println("inside findRides method in SearchRideDAO21");
		Query query = session.createQuery(hql);
		System.out.println("inside findRides method in SearchRideDAO3");
		//query.setParameter("latSql",latF);
		//query.setParameter("longSql",longF);
		
		query.setParameter("fromLatSql",latF);
		query.setParameter("fromLongSql",longF);
		query.setParameter("toLatSql",latT);
		query.setParameter("toLongSql",longT);
		System.out.println("inside findRides method in SearchRideDAO4");
		List rideList = query.list();
		System.out.println("inside findRides method in SearchRideDAO5");
		
		
		for (Iterator iterator = rideList.iterator(); iterator.hasNext();)
		{
			System.out.println("inside findRides method in SearchRideDAO6");
			//Ride ride = (Ride) iterator.next(); 
			val = (Object[]) iterator.next();
            RideResult rdRes = new RideResult();
            rdRes.setRideFromAddr((String)val[0]);
            rdRes.setRideToAddr((String)val[1]);
            rdRes.setRideName((String)val[2]);
            rdRes.setRideStartDate((String)val[3]);
            rdRes.setRideEndDate((String)val[4]);
            rdRes.setRate(val[5].toString());
            rdRes.setSeatsLeft(val[6].toString());
            ridesList.add(rdRes);
			System.out.print("inside findRides method in SearchRideDAO7 and Rate is: " + val[0]); 
			System.out.println("inside findRides method in SearchRideDAO7 and Start Date is: " + val[1]); 
			System.out.println("inside findRides method in SearchRideDAO7 and Complete Address is: " + val[3]);
			
		}
		
		
		//session.save(emp2);           
		session.getTransaction().commit();         
		//session.close();  
		
		}catch (Exception e) {
			System.out.println("inside findRides method in SearchRideDAO and caught exception");
			e.printStackTrace(); 
		}finally {
        session.close(); 
        }
		return ridesList;
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
		rdEntity.setRideStatus("In progress");
		
		
		//rdEntity.se(rdIp.getEndLoc());
		return rdEntity;
	}
	} 


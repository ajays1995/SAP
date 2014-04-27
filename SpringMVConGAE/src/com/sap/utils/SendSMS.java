package com.sap.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class SendSMS {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		sendSMS("9886133511", "Ajay, Committing the SMS code");
	}
	public static void sendSMS(String mobileNumber, String message) throws Exception
	{
		
		 URL url = new URL("http://alerts.sinfini.com/api/web2sms.php?workingkey=535984b66viu3y3vh5cu&sender=INFINI&to="+mobileNumber+"&message="+message.replaceAll(" ", "+"));
		    //    URLConnection yc = yahoo.openConnection();
			    HttpURLConnection con = (HttpURLConnection) url.openConnection();
			    con.setRequestMethod("POST");
			    con.setDoOutput(true);
			    con.getOutputStream();
			    con.getInputStream();
			    BufferedReader rd;
			    String line;
		        String result = "";
		        rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
		       while ((line = rd.readLine()) != null)
		        {
		           result += line;
		        }
		        rd.close(); 
		        System.out.println("Result is" + result);
//		        in.close();
	}

}

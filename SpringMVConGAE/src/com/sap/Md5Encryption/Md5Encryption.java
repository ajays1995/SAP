package com.sap.Md5Encryption;

import java.security.MessageDigest;

public class Md5Encryption 
{
	public  static String getEncryptedString(String unencryptedString)
	{
		//the below salt string is used to add with the unencrptedstring and will produce the encrypted string.
		
		String salt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+";
		
		try
		{
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update((salt+unencryptedString).getBytes());
			byte[] mdbytes = messageDigest.digest();
			StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < mdbytes.length; i++) 
	        {
	          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
	         
	        }
	        return sb.toString();
		}
		catch(Exception e)
		{
			System.out.println("Unable to generate the encrypted text    "+e.getMessage());
			return null;
		}
		
	}
}

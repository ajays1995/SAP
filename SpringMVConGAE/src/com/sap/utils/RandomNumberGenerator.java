package com.sap.utils;

import java.util.Random;

public class RandomNumberGenerator 
{
	private char []randomNumberArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	
	public static void main(String [] args)
	{
		System.out.println("random string "+new RandomNumberGenerator().getRandomNumber());
	}
	
	public String getRandomNumber()
	{
		StringBuffer sb = new StringBuffer();
		Random rd = new Random();
		
		for(int i=0;i<6;i++)
		{
			sb.append(randomNumberArray[rd.nextInt(randomNumberArray.length)]);
		}
		return sb.toString();
	}
}

package org.sreeram.Thread1;

/*
 * One way of creating a Thread in java is by extending Thread class
 * 
 * 
 * and over riding run method
 * 
 * 
 * 
 */

public class Runner extends Thread {

	
	public void run(){
		
		
		for(int i=0;i<10;i++)
		{
			System.out.println(i);
			try
			{
			Thread.sleep(1000);
			}catch(Exception e)
			{
				System.out.println("The exception is caused");
			}
		}
	}
	
}

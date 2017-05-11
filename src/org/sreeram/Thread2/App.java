package org.sreeram.Thread2;

public class App {
	
	/*
	 * Implement Runnable interface for the class 
	 * and Pass the instance of the class to the Thread constructor
	 * 
	 * other way is to pass the new Runnable() directly to the thread class and in the new Runnable() over ride the run method
	 * 
	 * See thread3, thread4 for clear explanation
	 */

	
	public static void main(String args[])
	{
		
		
		Thread t1 = new Thread(new Runner());
		Thread t2 = new Thread(new Runner());
		
		t1.start();
		t2.start();
		
		Thread t3 = new Thread(new Runnable(){
			public void run(){
				for(int i =0;i<10;i++)
				{
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		Thread t4 = new Thread(new Runnable(){
			public void run(){
				for(int i =0;i<10;i++)
				{
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		t3.start();
		t4.start();
	}
}

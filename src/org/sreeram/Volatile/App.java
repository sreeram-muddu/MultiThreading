package org.sreeram.Volatile;

class Runner implements Runnable{
	
	
	/*
	 * 
	 * when a new thread has been initiated from the Main thread
	 * 
	 * There is a chance that class member variable values might be cached and the latest value of the member variable may not be available for executing thread
	 * 
	 * It depends on the operating system and it is not guaranteed that the new updated value is available to the thread
	 * 
	 * In order to make sure the new value is available we need to use volatile key word for the member variable this guarantees to make updated value available to the thread
	 * 
	 * 
	 * 
	 */
	
	private int counter=0;
	private volatile
	boolean counting=true;
	
	public void run(){
		
		while(counting)
		{
			System.out.println(counter);
			++counter;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void stopCounter(){
		this.counting=false;
	}
}

public class App {

	public static void main(String[] args) {
		
		
		Runner r = new Runner();
		Thread t1 = new Thread(r);
		
		t1.start();
		
		java.util.Scanner s = new java.util.Scanner(System.in);
        
		s.nextLine();
		
		r.stopCounter();
		
		
		
	}

}

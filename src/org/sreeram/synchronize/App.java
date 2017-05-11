package org.sreeram.synchronize;

public class App {

private int count;
	
	public static void main(String[] args) {
	
		
		App app = new App();
		
		app.doWork();
		

	}
	
	private synchronized void increment()
	{
		++count;
	}
	
	public void doWork(){
		
		Thread t1 = new Thread(new Runnable(){
			
			public void run(){
				
				for(int i=0;i<10000;i++)
				{
					increment();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			
			public void run(){
				for(int i=0;i<10000;i++)
				{
					increment();  // count = count + 1
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try
		{
		t1.join();//this will make sure it will wait until the t1 completes
		t2.join();
		}catch(Exception e)
		{
			
		}
		
		System.out.println("The value of the count is "+count);
		
	}

}

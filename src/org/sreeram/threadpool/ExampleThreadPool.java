package org.sreeram.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Process implements Runnable{
	
	/*
	 * 
	 * The ExecutorService is used to create a pool of threads before hand
	 * 
	 * we can submit any number of tasks to the executor service but the executor service uses the 
	 * 
	 * fixed number of threads created during the construction of executor service to finish the task.
	 * 
	 * Whenever a thread completes a task it doesn't close the thread and create a new thread when it again needs
	 * 
	 * it maintains a pool of threads and re uses the threads to work now new tasks
	 * 
	 * 
	 * executor.awaitTermination method can be used to specify the maximum amount of time the exuctor can take 
	 * to complete all the tasks
	 * 
	 * 
	 */
	
	private int id;
	
	public Process(int id)
	{
		this.id=id;
	}

	@Override
	public void run() {
		
		System.out.println("Started Executing the Thread with an id: "+id);
		
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
				}
		
		System.out.println("Completed Executing the Thread with an id: "+id);
	}
	
}


public class ExampleThreadPool {
	
	
	public static void main(String args[])
	{
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i=0;i<10;i++)
		{
		    executor.submit(new Process(i));	
		}
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(10000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			
		}
		
	}

}

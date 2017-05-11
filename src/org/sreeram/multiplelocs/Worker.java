package org.sreeram.multiplelocs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	
	/*
	 * The problem with the synchronized key word is that multiple methods with synchronized keywords
	 * in a class will have same lock applied on them because java assumes that 
	 * both the methods can be manipulating the same member variable
	 * 
	 * But if we are sure that those different methods are manipulating independent content from one another
	 * then we can create separate locks for each methods blocks so that those two methods can be run in parallel
	 * 
	 * In much more simple terms
	 * 
	 * if we have 2 threads and 2 methods synchronized
	 * 
	 * at any point of time only 1 thread can execute only 1 method , we can't call the other method because 
	 * 
	 * it has synchronized keyword and java assumes all the methods are dependent on one another
	 * 
	 * if we create and apply our own locks then we can control the flow of executions of threads
	 */
	
private Random random = new Random();	
	
private List<Integer> list1 = new ArrayList<>();

private List<Integer> list2 = new ArrayList<>();

private Object lock1 = new Object();
private Object lock2 = new Object();

public  void step1()
{
	synchronized(lock1)
	{
	try {
		Thread.sleep(1);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	list1.add(random.nextInt());
	}
}

public synchronized void step2()
{
	
	synchronized(lock2)
	{
	try{
		Thread.sleep(1);
	}catch(InterruptedException e){
		
	}
	list2.add(random.nextInt());
	}

}

public void process()
{
	for(int i=0;i<1000;i++)
	{
		step1();
		step2();
	}
}

public void main(){
	
	System.out.println("Started the Threads .....");
	
	
	Thread t1 = new Thread(new Runnable(){
		public void run(){
			process();
		}
	});
	
	Thread t2 = new Thread(new Runnable(){
		public void run(){
			process();
		}
	});
	long start = System.currentTimeMillis();

	t1.start();
	t2.start();
	
	try{
	t1.join();
	t2.join();
	long end = System.currentTimeMillis();
	System.out.println("The threads completed executin in "+(end-start));
	System.out.println(" List1 Size is "+list1.size()+" list 2 size is "+list2.size());
	}catch(Exception e)
	{
		
	}
}


}

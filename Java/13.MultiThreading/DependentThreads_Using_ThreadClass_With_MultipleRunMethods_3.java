import java.util.Scanner;

class Banking1 extends Thread
{
	
	@Override
	public void run()
	{
		System.out.println("Activity 1 started");
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter you account num");
		int ac=scan.nextInt();
		System.out.println("Enter you account password");
		int pw=scan.nextInt();
		
		System.out.println("please see the account details");
		
		System.out.println("Activity 1 ended");
		
		System.out.println("**************************************************");
	}
	
}

class PrintingNum1 extends Thread
{
	@Override
	public void run()
	{
		System.out.println("Activity 2 started");
		for(int i=0;i<5;i++)
		{
		System.out.println(i);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		System.out.println("Activity 2 ended");
		
		System.out.println("**************************************************");

		
	}
}

class PrintingAlpha1 extends Thread
{
	@Override
	public void run()
	{
		System.out.println("Activity 3 started");
		
		for(int i=65;i<70;i++)
		{
		System.out.println((char)i);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		System.out.println("Activity 3 ended");
	}
}

public class DependentThreads_Using_ThreadClass_With_MultipleRunMethods_3
{
//Here we are not creating any Threads by seperately creating the objects of Thread class because the classes
	//are already extending the Thread class, it is like if we create object of that class indirectly creates an object
	//of Thread class as it is extending it. So here we are just using start method to give controller to TS.
	public static void main(String[] args)throws Exception 
	{
		
		System.out.println("Main Thread started ");
		
		System.out.println("Resources opening");
		Banking1 b=new Banking1();
		
		
		PrintingNum1 pn=new PrintingNum1();
		
		
		PrintingAlpha1 pa=new PrintingAlpha1();
		
		System.out.println(b.isAlive());//false
		System.out.println(pn.isAlive());//false
		System.out.println(pa.isAlive());//false
		
		b.start();
		pn.start();
		pa.start();
		
		System.out.println(b.isAlive());//true
		System.out.println(pn.isAlive());//true
		System.out.println(pa.isAlive());//true

		//We are using the join method, it simply says the main Thread to wait until the “b” Threads completes
		// the work joins you back’
		b.join();
		pn.join();
		pa.join();
		
		
		System.out.println("Resources closed");
		
		System.out.println("Main thread completed work");
		
		
		//Instead of start method if we are calling run method manually then it will behave like a single Threaded application.
//		b.run();
//		pn.run();
//		pa.run(); // progm will behave like single threaded programming
		
		
		
	}

}

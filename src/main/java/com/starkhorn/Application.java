package com.starkhorn;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Application {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		MyEnvironment env = context.getBean(MyEnvironment.class);
		System.out.println("username = " + env.getUsername());
		System.out.println("password = " + env.getPassword());
		
	}

	private static void testAsync(ApplicationContext context) throws InterruptedException, ExecutionException {
		AwdService service = context.getBean(AwdService.class);

		long start = System.currentTimeMillis();
		
		Future<List<String>> orders = service.getOrders();
		Future<String> summary = service.getSummary();
		
		System.out.println("Orders length = " + orders.get().size());
		System.out.println("Summary = " + summary.get());
		
		System.out.println("Finish @ " + (System.currentTimeMillis() - start));
	}
	
}

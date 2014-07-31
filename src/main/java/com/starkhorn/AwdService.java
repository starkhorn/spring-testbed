package com.starkhorn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AwdService {

	@Async
	public Future<List<String>> getOrders() throws InterruptedException {
		Thread.sleep(1000L);
		
		ArrayList<String> orders = new ArrayList<String>();
		
		orders.add("Work Order 1");
		orders.add("Work Order 2");
		orders.add("Work Order 3");
		
		return new AsyncResult<List<String>>(orders);
	}
	
	@Async
	public Future<String> getSummary() throws InterruptedException {
		Thread.sleep(1000L);
		
		return new AsyncResult<String>("Summary done!");
	}
	
}

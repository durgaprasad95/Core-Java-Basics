package com.demo.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainApp {

	public static void main(String[] args) {
		
		//CREATING AN INSTANCE OF CLASS BANKACCOUNT 
		BankAccount acct = new BankAccount(500);
		
		//CREATING INSTANCE OF A RUNNABLE CLASS
		TxPromoWorker worker = new TxPromoWorker(acct, 'd',	20);
		
		//CREATING  THREAD POOL OF 5 THREADS
		ExecutorService es = Executors.newFixedThreadPool(5);
		
		// SINGLE THREADING THOUGH THREAD POOL IS PRESENT 
		es.submit(worker);
		
		// TO USE THOSE THREADS WE NEED TO MAKE A LOOP


		try {
			es.shutdown();
			es.awaitTermination(60, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

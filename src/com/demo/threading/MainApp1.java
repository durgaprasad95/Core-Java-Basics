package com.demo.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainApp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount acct = new BankAccount(100);
		BankAccount acct1 = new BankAccount(100);

		// THREAD POOL OF 5 THREADS
		ExecutorService es = Executors.newFixedThreadPool(5);

		// SINGLE THREADING THOUGH THREAD POOL IS PRESENT es.submit(worker);
		// TO USE THOSE THREADS WE NEED TO MAKE A LOOP

		for (int i = 0; i < 3; i++) {
			TxWorker worker = new TxWorker(acct, 'w', 10);
			es.submit(worker);
			TxWorker worker2 = new TxWorker(acct1, 'd', 20);
			es.submit(worker2);
		}

		try {
			es.shutdown();
			es.awaitTermination(60, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

package com.demo.threading;

public class BankAccount {
	private int balance;

	public BankAccount(int startBalance) {
		balance = startBalance;
	}

	public String getId() {
		return "";
	}

	public synchronized int getBalance() throws Exception {
		return balance;
	}

	public synchronized void deposit(int amount) throws Exception {
		balance += amount;
		System.out.println(balance);
	}

	public synchronized void withdrawal(int amount) throws Exception {
		balance -= amount;
		System.out.println(balance);
	}

}

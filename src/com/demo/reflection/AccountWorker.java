package com.demo.reflection;

import com.demo.threading.BankAccount;

public class AccountWorker implements Runnable {
	BankAccount ba;
	HighVolumeAccount hva;

	public AccountWorker(BankAccount ba) {

	}

	public AccountWorker(HighVolumeAccount hva) {

	}

	public void doWork() {
		Thread t = new Thread(hva != null ? hva : this);
		t.start();
	}

	@Override
	public void run() {
		char txType = 'w';// read tx type
		int amt = 0; // read tx amount
		try {

			if (txType == 'w')
				ba.withdrawal(amt);
			else if (txType == 'd')
				ba.deposit(amt);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

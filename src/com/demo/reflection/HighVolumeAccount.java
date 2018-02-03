package com.demo.reflection;

import com.demo.threading.BankAccount;

public class HighVolumeAccount extends BankAccount implements Runnable {

	public HighVolumeAccount(int startBalance) {
		super(startBalance);
		// TODO Auto-generated constructor stub
	}

	private int[] readDailyDeposits() {
		return null;
	};

	private int[] readDailyWithdrawals() {
		return null;
	};

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}

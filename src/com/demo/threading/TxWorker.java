package com.demo.threading;

public class TxWorker implements Runnable {
	protected BankAccount account;
	protected char txType;
	protected int amt;

	public TxWorker(BankAccount account, char txType, int amt) {
		this.account = account;
		this.txType = txType;
		this.amt = amt;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {

			if (txType == 'w')
				account.withdrawal(amt);
			else if (txType == 'd')
				account.deposit(amt);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

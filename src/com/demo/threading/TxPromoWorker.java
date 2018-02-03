package com.demo.threading;

public class TxPromoWorker extends TxWorker {

	public TxPromoWorker(BankAccount account, char txType, int amt) {
		super(account, txType, amt);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {

			if (txType == 'w')
				account.withdrawal(amt);
			else if (txType == 'd') {
				synchronized (account) {
					account.deposit(amt);
					if (account.getBalance() > 500) {
						int bonus = (int) ((account.getBalance() - 500) * 0.1);
						account.deposit(bonus);
					}
				}
			}

		} catch (Exception e) {

		}
	}
}

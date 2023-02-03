package ss.week6.account;

public class Account {
	protected double balance = 0.0;
	private final Object lock = new Object();

	public void transaction(double amount) {
		synchronized (lock) {
			while (balance + amount < -1000) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// ignore
				}
			}
			balance = balance + amount;
			lock.notifyAll();
		}
	}
	public double getBalance() {
		synchronized (lock) {
			return balance;
		}
	}
}
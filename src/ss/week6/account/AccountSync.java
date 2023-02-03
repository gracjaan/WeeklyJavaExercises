package ss.week6.account;

public class AccountSync {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        double amount = 100;
        int frequency = 1000;
        MyThread thread1 = new MyThread(amount, frequency, account);
        MyThread thread2 = new MyThread(-amount, frequency, account);
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final balance: " + account.getBalance());
    }
}
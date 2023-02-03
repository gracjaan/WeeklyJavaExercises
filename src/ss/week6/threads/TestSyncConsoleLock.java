package ss.week6.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsoleLock implements Runnable{
    private static final Lock lock = new ReentrantLock();  // create a lock

    private void sum (){
        lock.lock();  // acquire the lock
        try {
            int fig1 = SyncConsole.readInt(Thread.currentThread().getName() + " get number 1? ", "wrong input");
            int fig2 = SyncConsole.readInt(Thread.currentThread().getName() + " get number 2? ", "wrong input");
            int s = fig1+fig2;
            SyncConsole.println(fig1 + " + " + fig2 + " = " + s);
        } finally {
            lock.unlock();  // release the lock
        }
    }

    @Override
    public void run() {
        sum();
    }

    public static void main(String[] args) {
        new Thread(new TestSyncConsole(), "Thread A").start();
        new Thread(new TestSyncConsole(), "Thread B").start();
    }
}

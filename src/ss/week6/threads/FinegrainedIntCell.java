package ss.week6.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinegrainedIntCell implements IntCell {
    private int value = 0;
    private Lock lock = new ReentrantLock();
    private Condition hasValue = lock.newCondition();
    private Condition hasNoValue = lock.newCondition();

    public void setValue(int valueArg) {
        lock.lock();
        try {
            while (value != 0) {
                hasNoValue.await();
            }
            value = valueArg;
            hasValue.signal();
        } catch (InterruptedException e) {
            // do nothing
        } finally {
            lock.unlock();
        }
    }

    public int getValue() {
        lock.lock();
        try {
            while (value == 0) {
                hasValue.await();
            }
            int val = value;
            value = 0;
            hasNoValue.signal();
            return val;
        } catch (InterruptedException e) {
            return 0;
        } finally {
            lock.unlock();
        }
    }
}
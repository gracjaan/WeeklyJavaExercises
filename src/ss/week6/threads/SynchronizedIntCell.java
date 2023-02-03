package ss.week6.threads;

public class SynchronizedIntCell implements IntCell {
    private int value = 0;

    public synchronized void setValue(int valueArg) {
        this.value = valueArg;
        notifyAll();
    }

    public synchronized int getValue() {
        while (value == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                // do nothing
            }
        }
        int val = value;
        value = 0;
        return val;
    }
}

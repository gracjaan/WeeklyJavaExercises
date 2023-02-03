package ss.week6.threads;

public class TestSyncConsole implements Runnable{
    synchronized private void sum () {
        //synchronized (System.in) {
            int fig1 = SyncConsole.readInt(Thread.currentThread().getName() + " get number 1? ");
            int fig2 = SyncConsole.readInt(Thread.currentThread().getName() + " get number 2? ");
//        int fig1 = SyncConsole.readInt(" ", "wrong input");
//        int fig2 = SyncConsole.readInt(" ", "wrong input");
            int s = fig1 + fig2;
            SyncConsole.println(fig1 + " + " + fig2 + " = " + s);
            //return s;
        //}
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

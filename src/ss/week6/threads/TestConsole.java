package ss.week6.threads;

public class TestConsole implements Runnable {

    private void sum (){
//        int fig1 = Console.readInt("get number 1? ", "wrong input");
//        int fig2 = Console.readInt("get number 2? ", "wrong input");
        int fig1 = Console.readInt(" ", "wrong input");
        int fig2 = Console.readInt(" ", "wrong input");
        int s = fig1+fig2;
        SyncConsole.println(fig1 + " + " + fig2 + " = " + s);
//        Console.print(Thread.currentThread().getName() + ": ");
//        Console.println(fig1 + " + " + fig2 + " = " + s);
    }

    @Override
    public void run() {
//        Console.print(Thread.currentThread().getName() + ": ");
//        int fig1 = Console.readInt("get number 1? ", "wrong input");
//        Console.print(Thread.currentThread().getName() + ": ");
//        int fig2 = Console.readInt("get number 2? ", "wrong input");
            sum();
    }

    public static void main(String[] args) {
        new Thread(new TestConsole(), "Thread A").start();
        new Thread(new TestConsole(), "Thread B").start();
    }
}


package ch.joil.joilchat.test;

/**
 * Created by bananatreedad on 23/05/16.
 */
public class ThreadTest implements Runnable {
    public static void main(String[] args) {

        Thread thread = new Thread(new Ilian());

        thread.setName("Ilian-Thread");
        thread.start();

        Thread thread2 = new Thread(new ThreadTest());
        thread2.no

        thread2.setName("Interface on Main");
        thread2.start();

        ThreadUtils.dumpThreads();

    }

    @Override
    public void run() {
        while(true)  {
            System.out.println("Hello Ili! :D");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Ilian implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Run Ilian!");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadUtils {
    public static void dumpThreads() {
        final ThreadGroup group = Thread.currentThread().getThreadGroup();
        final int activeCount = group.activeCount();

        final Thread[] threads = new Thread[activeCount];
        group.enumerate(threads);

        System.out.println("Thread group " + group + " contains " + activeCount + " active threads.");

        for(final Thread thread : threads) {
            System.out.println("Thread: " + thread);
        }
    }
}

package ch.joil.joilchat.test;

/**
 * Created by bananatreedad on 23/05/16.
 */
public class ThreadTest implements Runnable {
    public static void main(String[] args) {

        Thread thread = new Thread(new Ilian());

        thread.start();

        Thread thread2 = new Thread(new ThreadTest());

        thread2.start();

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

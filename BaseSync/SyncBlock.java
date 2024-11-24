package Multithreading.BaseSync;

public class SyncBlock {
    public static void main(String[] args) {
        MyRunnable2 runnable2 = new MyRunnable2();
        Thread thread1 = new Thread(runnable2);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter2 {
    static int count = 0;
}
class MyRunnable2 implements Runnable {
    public void doWork1() {
        synchronized(this) {
            Counter2.count++;
            System.out.println(Counter2.count);
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            doWork1();
        }
    }
}

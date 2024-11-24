package Multithreading.GeneralExamples;

public class Ex10 {
    public static void main(String[] args) {
        MyRunnable1 thread = new MyRunnable1();
        Thread thread1 = new Thread(thread);
        Thread thread2 = new Thread(thread);
        Thread thread3 = new Thread(thread);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class Counter {
    volatile static int count = 0;
}

class MyRunnable1 implements Runnable {
    public synchronized void incrementCount() {
        Counter.count++;
        System.out.print(Counter.count + " ");
    }
    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            incrementCount();
        }
    }
}
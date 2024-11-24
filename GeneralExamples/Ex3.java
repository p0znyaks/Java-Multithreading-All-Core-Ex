package Multithreading.GeneralExamples;

public class Ex3 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread3());
        Thread thread2 = new Thread(new MyThread4());
        thread1.start();
        thread2.start();

        new Thread(() -> System.out.println("privet")).start();
    }
}

class MyThread3 implements Runnable {
    @Override
    public void run() {
        for(int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}

class MyThread4 extends Thread {
    @Override
    public void run() {
        for(int i = 1000; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
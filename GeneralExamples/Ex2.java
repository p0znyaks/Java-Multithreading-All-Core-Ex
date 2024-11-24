package Multithreading.GeneralExamples;

public class Ex2 extends Thread {
    public void run() {
        for(int i = 1000; i >= 1; i--) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        Ex2 threadEx2 = new Ex2();

        threadEx2.start();
        myThread2.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for(int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for(int i = 1000; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
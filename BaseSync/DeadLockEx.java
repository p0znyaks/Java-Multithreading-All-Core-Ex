package Multithreading.BaseSync;

public class DeadLockEx {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread1: Попытка захватить монитор объекта lock1");
        synchronized (DeadLockEx.lock1) {
            System.out.println("Thread1: Монитор объекта lock1 захвачен");

            System.out.println("Thread1: Попытка захватить монитор объекта lock2");
            synchronized (DeadLockEx.lock2) {
                System.out.println("Thread1: Мониторы объектов lock1 и lock2 захвачены");
            }
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread2: Попытка захватить монитор объекта lock2");
        synchronized (DeadLockEx.lock1) {
            System.out.println("Thread2: Монитор объекта lock2 захвачен");

            System.out.println("Thread2: Попытка захватить монитор объекта lock1");
            synchronized (DeadLockEx.lock2) {
                System.out.println("Thread2: Мониторы объектов lock2 и lock1 захвачены");
            }
        }
    }
}
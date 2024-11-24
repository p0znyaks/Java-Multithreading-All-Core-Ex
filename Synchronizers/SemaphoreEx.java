package Multithreading.Synchronizers;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);
        Thread thread1 = new Thread(new Person("Anton", callBox));
        Thread thread2 = new Thread(new Person("Maksim", callBox));
        Thread thread3 = new Thread(new Person("Elena", callBox));
        Thread thread4 = new Thread(new Person("Evgeniy", callBox));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class Person implements Runnable {
    String name;
    private Semaphore callBox;
    public Person(String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " ждёт");
            callBox.acquire();
            System.out.println(name + " пользуется телефоном");
            Thread.sleep(2000);
            System.out.println(name + " завершил(а) звонок");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            callBox.release();
        }
    }
}
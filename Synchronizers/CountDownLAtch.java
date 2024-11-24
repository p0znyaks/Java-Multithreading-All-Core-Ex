package Multithreading.Synchronizers;

import java.util.concurrent.CountDownLatch;

public class CountDownLAtch {
    static CountDownLatch countDownLatch = new CountDownLatch(3);
    private static void marketStaffOnPlace() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Staff came to work!");
        countDownLatch.countDown();
        System.out.println("countDownLatch after market staff on work = " + countDownLatch.getCount());
    }

    private static void everythingIsReady() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Everything is ready, so let`s open market!");
        countDownLatch.countDown();
        System.out.println("countDownLatch after everything is ready = " + countDownLatch.getCount());
    }

    private static void openMarket() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Market is open!!!");
        countDownLatch.countDown();
        System.out.println("countDownLatch after market open = " + countDownLatch.getCount());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Friend("Oleg", countDownLatch));
        Thread thread2 = new Thread(new Friend("Sasha", countDownLatch));
        Thread thread3 = new Thread(new Friend("Anton", countDownLatch));

        thread1.start();
        thread2.start();
        thread3.start();

        marketStaffOnPlace();
        everythingIsReady();
        openMarket();
    }
}

class Friend implements Runnable {
    String name;
    private final CountDownLatch countDownLatch;
    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            System.out.println("Ждёт своей очереди");
            countDownLatch.await();
            System.out.println(name + " присутпил к закупкам");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
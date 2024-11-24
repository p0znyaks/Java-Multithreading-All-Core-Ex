package Multithreading.Synchronizers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx2 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService =
                Executors.newScheduledThreadPool(1);
//        for(int i = 0; i < 10; i++) {
//            executorService.execute(new Runnable200());
//        }
//        executorService.schedule(new Runnable200(), 3, TimeUnit.SECONDS);
//        executorService.scheduleAtFixedRate(new Runnable200(),
//                3, 1, TimeUnit.SECONDS);
        executorService.scheduleWithFixedDelay(new Runnable200(),
                3, 1, TimeUnit.SECONDS);

        Thread.sleep(20000);
        executorService.shutdown();
    }
}

class Runnable200 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins work");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}
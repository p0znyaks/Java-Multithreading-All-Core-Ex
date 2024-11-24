package Multithreading.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable100());
        }
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);
    }
}

class Runnable100 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
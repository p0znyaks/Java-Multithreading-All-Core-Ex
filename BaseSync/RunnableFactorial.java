package Multithreading.BaseSync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableFactorial {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Factorial factorial = new Factorial(15);
//        executorService.execute(factorial);
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}

//class Factorial implements Runnable {
//    private final int f;
//
//    public Factorial(int f) {
//        this.f = f;
//    }
//
//    @Override
//    public void run() {
//        int result = 1;
//
//        if (f <= 0) {
//            System.out.println("Вы ввели неверное число");
//            return;
//        }
//
//        for (int i = 1; i <= f; i++) {
//            result *= i;
//        }
//
//        RunnableFactorial.factorialresult = result;
//    }
//}
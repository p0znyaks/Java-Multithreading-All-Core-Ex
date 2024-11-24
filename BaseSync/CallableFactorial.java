package Multithreading.BaseSync;

import java.util.concurrent.*;

public class CallableFactorial {
    static int factorialResult;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(6);
        Future<Integer> future = executorService.submit(factorial);
        try {
            System.out.println(future.isDone());
            System.out.println("Хотим получить результат");
            factorialResult = future.get();
            System.out.println("Получили результат");
            System.out.println(future.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        }
        finally {
            executorService.shutdown();
        }
        System.out.println(factorialResult);
    }
}

class Factorial implements Callable<Integer> {
    private final int f;

    Factorial(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        if (f <= 0) throw new Exception("Введено неверное число");
        for (int i = 1; i <= f; i++) {
            result *= i;
        }
        return result;
    }
}
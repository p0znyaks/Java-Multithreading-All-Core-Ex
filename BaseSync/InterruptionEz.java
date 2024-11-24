package Multithreading.BaseSync;

public class InterruptionEz {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starts");
        InterruptedThread thread = new InterruptedThread();
        thread.start();

        Thread.sleep(3000);

        thread.interrupt();
        thread.join();

        System.out.println("Main thread ends");
    }
}

class InterruptedThread extends Thread {
    double sqrtSum = 0;

    @Override
    public void run() {
        for(int i = 1; i <= 1000000000; i++) {
            if(isInterrupted()) {
                System.out.println("Поток хотят прервать");
                return;
            }
            sqrtSum += Math.sqrt(i);
        }
        System.out.println(sqrtSum);
    }
}
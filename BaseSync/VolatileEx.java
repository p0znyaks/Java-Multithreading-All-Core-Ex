package Multithreading.BaseSync;

public class VolatileEx extends Thread {
    volatile boolean b = true;

    @Override
    public void run() {
        long counter = 0;
        while(b) {
            counter++;
        }
        System.out.println("Loop finish " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileEx thread = new VolatileEx();
        thread.start();
        Thread.sleep(3000); // sleep для потока main
        System.out.println("After 3 seconds is time to wake up!");
        thread.b = false;
        thread.join();
        System.out.println("End of program");
    }
}

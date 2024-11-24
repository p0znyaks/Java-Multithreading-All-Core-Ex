package Multithreading.BaseSync;

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread starts");
        UserThread userThread = new UserThread();
        userThread.setName("UserThread");
        DaemonThread1 daemonThread1 = new DaemonThread1();
        daemonThread1.setName("DaemonThread");
        daemonThread1.setDaemon(true);
        userThread.start();
        daemonThread1.start();
        System.out.println("Main Thread ends");
    }
}

class UserThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " is daemon: " + isDaemon());
        for(char i = 'A'; i <= 'J'; i++) {
            try {
                sleep(300);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class DaemonThread1 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " is daemon: " + isDaemon());
        for(int i = 1; i <= 1000; i++) {
            try {
                sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
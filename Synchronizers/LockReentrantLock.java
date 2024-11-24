package Multithreading.Synchronizers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockReentrantLock {
    public static void main(String[] args) {
        Call call = new Call();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.mobileCall();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.skypeCall();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.whatsAppCall();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Call {
    private final Lock lock = new ReentrantLock();

    void mobileCall() {
        lock.lock();
        try {
            System.out.println("Mobile call starts");
            Thread.sleep(3000);
            System.out.println("Mobile call ends");
        } catch (InterruptedException ignored) {}
        finally {
            lock.unlock();
        }
    }

    void skypeCall() {
        lock.lock();
        try {
            System.out.println("Skype call starts");
            Thread.sleep(3000);
            System.out.println("Skype call ends");
        } catch (InterruptedException ignored) {}
        finally {
            lock.unlock();
        }
    }

    void whatsAppCall() {
//        lock.lock();
        if(lock.tryLock()) {
            try {
                System.out.println("WhatsApp call starts");
                Thread.sleep(3000);
                System.out.println("WhatsApp call ends");
            } catch (InterruptedException ignored) {
            } finally {
                lock.unlock();
            }
        } else System.out.println("Dont need to call");
    }
}
package Multithreading.GeneralExamples;

public class Ex12 {
    static final Object lock = new Object();
    synchronized void mobileCall() {
        synchronized (lock) {
            System.out.println("Mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mobile call ends");

        }
    }
    synchronized void skypeCall() {
        synchronized (lock) {
            System.out.println("Skype call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Skype call ends");

        }
    }
    synchronized void whatsAppCall() {
        synchronized (lock) {
            System.out.println("WhatsApp call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("WhatsApp call ends");

        }
    }
    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableMobile());
        Thread thread2 = new Thread(new RunnableSkype());
        Thread thread3 = new Thread(new RunnableWhatsApp());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RunnableMobile implements Runnable {
    @Override
    public void run() {
        new Ex12().mobileCall();
    }
}
class RunnableSkype implements Runnable {
    @Override
    public void run() {
        new Ex12().skypeCall();
    }
}
class RunnableWhatsApp implements Runnable {
    @Override
    public void run() {
        new Ex12().whatsAppCall();
    }
}
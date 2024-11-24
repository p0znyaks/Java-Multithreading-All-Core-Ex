package Multithreading.GeneralExamples;

public class Ex5 {
    public static void main(String[] args) {
        Thread myThread5 = new Thread(new MyThread5());

        System.out.println("Name = " + myThread5.getName() +
                " Prior = " + myThread5.getPriority());
        myThread5.setName("Artem");
        myThread5.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Name = " + myThread5.getName() +
                " Prior = " + myThread5.getPriority());
    }
}

class MyThread5 implements Runnable {
    @Override
    public void run() {
        System.out.println("privet");
    }
}
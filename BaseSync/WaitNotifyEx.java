package Multithreading.BaseSync;

public class WaitNotifyEx {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Начало работы маркета");
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);
        Thread threadProducer = new Thread(producer);
        Thread threadConsumer = new Thread(consumer);

        threadConsumer.start();
        threadProducer.start();

        threadProducer.join();
        threadConsumer.join();
        System.out.println("Конец работы маркета");
    }
}

class Market {
    private int breadCount = 0;

    public synchronized void getBread() {
        while (breadCount < 1) {
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }
        breadCount--;
        System.out.println("Потребитель купил 1 хлеб");
        System.out.println("Кол-во хлеба в магазине = " + breadCount);
        notify();
    }

    public synchronized void putBread() {
        while (breadCount >= 5) {
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }
        breadCount++;
        System.out.println("Производитель добавил на витрину 1 хлеб");
        System.out.println("Кол-во хлеба в магазине = " + breadCount);
        notify();
    }
}

class Consumer implements Runnable {
    Market market;
    Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}

class Producer implements Runnable {
    Market market;
    Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}
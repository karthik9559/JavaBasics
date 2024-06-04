package ConcurrencyAndThreads.Semaphores;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class PnC_Client {
    public static void main(String[] args) {
        Queue<Object> q = new ConcurrentLinkedDeque<>(); // shirt store.

//        Initial values , Producer and Consumer Semaphores are initialized with 6 and 0 respectively.
//        Since we have 6 producers that will add products to the store, we initialize ProducerSemaphore with 6.
//        Since we have 6 consumers that will consume products from the store, But initially we will have 0 because at the beginning we cannot
//        buy if we don't have. initially add them buy.

        Semaphore ProducerSemaphore = new Semaphore(6);
        Semaphore ConsumerSemaphore = new Semaphore(0);

        // multiple tasks for producer...
        ProducerTask p1 = new ProducerTask(ProducerSemaphore, ConsumerSemaphore, q, 6, "p1");
        ProducerTask p2 = new ProducerTask(ProducerSemaphore, ConsumerSemaphore, q, 6, "p2");
        ProducerTask p3 = new ProducerTask(ProducerSemaphore, ConsumerSemaphore, q, 6, "p3");

        // multiple tasks for consumer...
        ConsumerTask c1 = new ConsumerTask(ProducerSemaphore, ConsumerSemaphore, q, 6, "c1");
        ConsumerTask c3 = new ConsumerTask(ProducerSemaphore, ConsumerSemaphore, q, 6, "c3");
        ConsumerTask c4 = new ConsumerTask(ProducerSemaphore, ConsumerSemaphore, q, 6, "c4");
        ConsumerTask c2 = new ConsumerTask(ProducerSemaphore, ConsumerSemaphore, q, 6, "c2");
        ConsumerTask c5 = new ConsumerTask(ProducerSemaphore, ConsumerSemaphore, q, 6, "c5");
        ConsumerTask c6 = new ConsumerTask(ProducerSemaphore, ConsumerSemaphore, q, 6, "c6");

        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p2);
        t2.start();
        Thread t3 = new Thread(p3);
        t3.start();

        Thread ct1 = new Thread(c1);
        ct1.start();
        Thread ct2 = new Thread(c2);
        ct2.start();
        Thread ct3 = new Thread(c3);
        ct3.start();
        Thread ct4 = new Thread(c4);
        ct4.start();
        Thread ct5 = new Thread(c5);
        ct5.start();
        Thread ct6 = new Thread(c6);
        ct6.start();

    }
}

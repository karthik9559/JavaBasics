package ConcurrencyAndThreads.Semaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProducerTask implements Runnable{
    private Queue<Object> queue;
    private int maxSize;
    private String name;
    private Semaphore ProducerSemaphore; //Aquire
    private Semaphore ConsumerSemaphore; // release

    public ProducerTask(Semaphore ProducerSemaphore, Semaphore ConsumerSemaphore,Queue<Object> queue, int maxSize, String name) {
        this.ProducerSemaphore = ProducerSemaphore;
        this.ConsumerSemaphore = ConsumerSemaphore;
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;

    }

    public void run(){
        while(true){
//                Step 1: Acquire the Producer Semaphore
            try{
                ProducerSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//                Step 2 : Produce an item (Critical Section
            if (queue.size() < maxSize){
                System.out.println("Producer " + name + " produced 1 item , before size: " + queue.size());
                queue.add(new Object());
            }
//                Step 3: Release the Consumer Semaphore
            ConsumerSemaphore.release();
        }
    }

}

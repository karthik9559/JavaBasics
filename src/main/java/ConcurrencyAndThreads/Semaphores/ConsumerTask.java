package ConcurrencyAndThreads.Semaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ConsumerTask implements Runnable{
    private Queue<Object> queue;
    private int maxSize;
    private String name;
    private Semaphore ProducerSemaphore; // release
    private Semaphore ConsumerSemaphore; // aquire

    public ConsumerTask(Semaphore ProducerSemaphore, Semaphore ConsumerSemaphore, Queue<Object> queue, int maxSize, String name) {
        this.ProducerSemaphore = ProducerSemaphore;
        this.ConsumerSemaphore = ConsumerSemaphore;
        this.name = name;
        this.maxSize = maxSize;
        this.queue = queue;
    }



    public void run(){
        while(true){
            try {
                    ConsumerSemaphore.acquire();
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
            if (queue.size() > 0){
                System.out.println("Consumer " + name + " consumed 1 item , before size: " + queue.size());
                queue.remove();
            }
                ProducerSemaphore.release();
        }
    }
}

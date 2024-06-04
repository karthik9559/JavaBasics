package ConcurrencyAndThreads.producer_consumer;

import java.util.Queue;

public class ConsumerTask implements Runnable{
    private Queue<Object> queue;
    private int maxSize;
    private String name;

    public ConsumerTask(Queue<Object> queue, int maxSize, String name) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;
    }

    public void run(){
        while(true){
            synchronized(queue){
                if (queue.size() > maxSize){
                    System.out.println("Consumer " + name + " consumed 1 item , before size: " + queue.size());
                    queue.remove();
                }
            }
        }
    }
}

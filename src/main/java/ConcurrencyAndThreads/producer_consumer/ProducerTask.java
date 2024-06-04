package ConcurrencyAndThreads.producer_consumer;

import java.util.Queue;

public class ProducerTask implements Runnable{
    private Queue<Object> queue;
    private int maxSize;
    private String name;

    public ProducerTask(Queue<Object> queue, int maxSize, String name) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;
    }

    public void run(){
        while(true){
            synchronized(queue){
                if (queue.size() < maxSize){
                    System.out.println("Producer " + name + " produced 1 item , before size: " + queue.size());
                    queue.add(new Object());
                }
            }
        }
    }


}

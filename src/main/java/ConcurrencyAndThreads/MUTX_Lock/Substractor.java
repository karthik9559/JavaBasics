package ConcurrencyAndThreads.MUTX_Lock;

import java.util.concurrent.locks.Lock;

public class Substractor implements Runnable{
    private Count count;
    private Lock lock;


    public Substractor(Count count){
        this.count = count;
    }

    public Substractor(Count count, Lock lock){
        this.count = count;
        this.lock = lock;
    }
    public void run(){
        lock.lock();
        for (int i = 0; i < 10000000; i++) {
            count.val -= 1;
        }
        lock.unlock();
    }
}

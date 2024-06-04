package ConcurrencyAndThreads.SyncMethods;

import java.util.concurrent.locks.Lock;

public class Substractor implements Runnable{
    private Count count;
    public Substractor(Count count){
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < 10000000; i++) {
            this.count.increament(-i);
        }
    }
}
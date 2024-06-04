package ConcurrencyAndThreads.Sync_v1;


import com.sun.source.tree.SynchronizedTree;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    private Count count;

    public Adder(Count count){
        this.count = count;
    }

    @Override
    public  void run(){
        synchronized (count) {
            for (int i = 0; i < 10000007; i++) {
                count.val += 1;
            }
        }

    }
}

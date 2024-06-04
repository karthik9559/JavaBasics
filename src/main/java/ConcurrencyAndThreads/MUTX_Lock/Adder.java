package ConcurrencyAndThreads.MUTX_Lock;


import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    private Count count;
    private Lock lock;

    public Adder(Count count){
        this.count = count;
    }
    public Adder(Count count, Lock lock){
        this.count = count;
        this.lock = lock;
    }

    @Override
    public  void run(){
        lock.lock();
        for (int i = 0; i < 10000007; i++) {
            count.val += 1;
        }
        lock.unlock();
    }
}

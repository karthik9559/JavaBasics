package ConcurrencyAndThreads.Sync_v1;


public class client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        Adder adder = new Adder(count);
        Substractor substractor = new Substractor(count);



        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(substractor);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count.val);
    }
}

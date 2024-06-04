package ConcurrencyAndThreads.SerializationProblems;

public class client {
    public static void main(String[] args) throws InterruptedException {
        count count = new count();

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);


        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count: " + count.val);
    }
}

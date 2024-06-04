package ConcurrencyAndThreads.SerializationProblems;

public class Adder implements  Runnable{
    private count count;

    public Adder(count count) {
        this.count = count;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            count.val += 1;
        }
    }
}

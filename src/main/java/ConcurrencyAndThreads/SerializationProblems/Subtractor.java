package ConcurrencyAndThreads.SerializationProblems;

public class Subtractor implements  Runnable {
    private count count;

    public Subtractor(count count) {
        this.count = count;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            count.val -= 1;
        }
    }
}

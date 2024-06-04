package ConcurrencyAndThreads.ExecutorsCallables;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            NumberPrinter n = new NumberPrinter(i);
            exe.submit(n);
        }
    }
}

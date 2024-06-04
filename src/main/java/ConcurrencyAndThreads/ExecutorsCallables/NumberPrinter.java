package ConcurrencyAndThreads.ExecutorsCallables;

public class NumberPrinter implements Runnable {
    int value;
    public NumberPrinter(int value){
        this.value = value;

    }

    public void printer(int i) {
        System.out.println(+i + " Value with Thread" + Thread.currentThread().getName() + " is done.");
    }

    @Override
    public void run() {
        printer(value);
    }
}

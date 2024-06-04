package ConcurrencyAndThreads.print_1_100;

public class runnable_provider implements Runnable{
    private int i;
    public runnable_provider(int i){
        this.i = i;
    }


    public  void number_printer(int i){
        System.out.println("Number " + i + " Thread > "  + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        number_printer(i);
    }

}

package ConcurrencyAndThreads;

public class HelloWorldPrinterTask implements Runnable{
    @Override
    public void run(){
        System.out.println("Inside run method >>> Here With a different Thread name " + Thread.currentThread().getName());
        doSomething();
    }
    public void doSomething(){
        System.out.println("Inside doSomething method >>> Hello World from a thread!");
    }
}

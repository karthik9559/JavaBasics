package ConcurrencyAndThreads;

public class client {
    public static void main(String[] args)  {
        System.out.println("Inside main method , Current Thread name is : " + Thread.currentThread().getName());
        HelloWorldPrinterTask h_w_task = new HelloWorldPrinterTask(); // Create an object of HelloWorldPrinterTask
        Thread t = new Thread(h_w_task);  // Create a new thread and execute this HelloWorldPrinterTask as a part of thread
        t.start(); // Start the thread
//        t.join(); // Wait for the thread to finish its execution
        System.out.println("Bye From Thread...." + Thread.currentThread().getName());

        /*
        Output:
        Inside main method , Current Thread name is : main
        Bye main
        Inside run method >>> Here With a different Thread name Thread-0
        Inside doSomething method >>> Hello World from a thread!
         */

        // The output is different because the thread is executed in parallel with the main thread.
        // The main thread is not waiting for the thread to finish its execution.
        // If we want to wait for the thread to finish its execution, we can use the join method.


    }
}

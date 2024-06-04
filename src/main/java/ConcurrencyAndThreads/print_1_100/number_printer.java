package ConcurrencyAndThreads.print_1_100;

public class number_printer {
    public static void main(String[] args) {
        /*
        Print numbers from 1 to 100 with each as a part of new Thread.
         */
//        for (int i = 1; i <= 100; i++) {
//            int finalI = i;
//            Thread t = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(finalI + " With " + Thread.currentThread().getName());
//                }
//            });
//            t.start();
//        }

//        Trying another way
        for (int i = 0; i < 100; i++){
            runnable_provider r = new runnable_provider(i);
            Thread t = new Thread(r);
            t.start();

        }


    }
}

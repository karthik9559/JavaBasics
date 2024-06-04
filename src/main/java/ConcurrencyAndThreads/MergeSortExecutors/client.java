package ConcurrencyAndThreads.MergeSortExecutors;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> Array = List.of(5, 3, 8, 6, 2, 7, 1, 4);

        // S1. Create ExecutorService
        ExecutorService executorService = Executors.newCachedThreadPool();

        // S2. Create MergeSorter object
        MergeSorter mergeSorter = new MergeSorter(Array, executorService);

        // S3. Submit the task to the executorService and should wait until the task is completed
        Future<List<Integer>> sorted_list = executorService.submit(mergeSorter);

//        S4. Get the result
        List<Integer> sortedArray = sorted_list.get();

//        S5. Shutdown the executorService
        System.out.println("Sorted Array: " + sortedArray);
        executorService.shutdown();

    }
}

package ConcurrencyAndThreads.TreeSizeCalculator;

import java.util.concurrent.*;

public class client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // S1. Create ExecutorService
        ExecutorService executorService = Executors.newCachedThreadPool();

        // S2. Create TreeSizeCalculator object
        TreeSizeCalculator treeSizeCalculator = new TreeSizeCalculator(root, executorService);

        // S3. Submit the task to the executorService and should wait until the task is completed
        Future<Integer> treeSize = executorService.submit(treeSizeCalculator);

        // S4. Get the result
        int final_size = 0;
        final_size = treeSize.get();

        System.out.println("The size of the tree is: " + final_size);

//        S5. Shutdown the executorService
        executorService.shutdown();
    }
}

package ConcurrencyAndThreads.TreeSizeCalculator;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {

    private Node root;

    private final ExecutorService executorService;


    public TreeSizeCalculator(Node root, ExecutorService executorService) {
        this.root = root;
        this.executorService = executorService;
    }

    @Override
    public Integer call() throws Exception {
        if (root != null){
            System.out.println(root.data + " with Calculating Tree Size with Thread: " + Thread.currentThread().getName());
        }
        if (root == null) {
            return 0;
        }
        TreeSizeCalculator leftSide = new TreeSizeCalculator(root.left, executorService);
        TreeSizeCalculator rightSide = new TreeSizeCalculator(root.right, executorService);

        Future<Integer> leftsize = executorService.submit(leftSide);
        Future<Integer> rightsize =  executorService.submit(rightSide);

        int left = leftsize.get();
        int right = rightsize.get();

        return 1 + left + right;
    }
}

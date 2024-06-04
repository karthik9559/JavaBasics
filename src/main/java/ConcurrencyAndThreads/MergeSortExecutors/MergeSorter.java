package ConcurrencyAndThreads.MergeSortExecutors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer> ArrayToSort;
    private ExecutorService executorService;

    public MergeSorter(List<Integer> arrayToSort, ExecutorService executorService) {
        ArrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        System.out.println("Sorting Array : " + ArrayToSort + " with Thread: " + Thread.currentThread().getName());
//        Step 1: Break condition for MergeSort
        if (ArrayToSort.size() <= 1) {
            return ArrayToSort;
        }

//        Step 2: Split the array into 2 parts
        int mid = ArrayToSort.size() / 2;

        List<Integer> forming_left = new ArrayList<>();
        List<Integer> forming_right = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            forming_left.add(ArrayToSort.get(i));
        }

        for (int i = mid; i < ArrayToSort.size(); i++) {
            forming_right.add(ArrayToSort.get(i));
        }

//        Step 3: Create 2 subtasks to sort the 2 parts , that will have to wait for the result
        MergeSorter left = new MergeSorter(forming_left, executorService);
        MergeSorter right = new MergeSorter(forming_right, executorService);

        Future<List<Integer>> leftResult = executorService.submit(left);
        Future<List<Integer>> rightResult = executorService.submit(right);

//        Step 4 Merge 2 sorted arrays

        List<Integer> leftSortedArray = leftResult.get();
        List<Integer> rightSortedArray = rightResult.get();

//      Step 5: Merge the 2 sorted arrays
        int i = 0;
        int j = 0;

        List<Integer> sorted_array = new ArrayList<>();

        while (i < leftSortedArray.size() && j < rightSortedArray.size()) {
            if (leftSortedArray.get(i) < rightSortedArray.get(j)){
                sorted_array.add(leftSortedArray.get(i));
                i++;
            }
            else {
                sorted_array.add(rightSortedArray.get(j));
                j++;
            }
        }

        while (i < leftSortedArray.size()){
            sorted_array.add(leftSortedArray.get(i));
            i++;
        }
        while (j < rightSortedArray.size()){
            sorted_array.add(rightSortedArray.get(j));
            j++;
        }

        return sorted_array;
    }
}

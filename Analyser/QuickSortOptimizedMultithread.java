import java.util.*;
public class QuickSortOptimizedMultithread extends MeasurableSortingAlgorithm {

    protected static int threadCounter = 0;
    
    @Override
    public String getName() {
        return "QuickSort middle Pivot with InsertionSort and Multithread";
    }
    

    @Override
    public void sort(int[] _list) {
        comparisons = -1;
        swaps = -1;
        System.out.println("availableProcessors " + Runtime.getRuntime().availableProcessors());
        System.out.println("minPartitionSize: " + _list.length / QuickSortOptimizedMultithreadLogic.MAX_THREADS);
        threadCounter = 0;
        try{
            QuickSortOptimizedMultithreadLogic quicksort = new QuickSortOptimizedMultithreadLogic(_list.length / QuickSortOptimizedMultithreadLogic.MAX_THREADS, _list, 0, _list.length - 1);
            Thread t = new Thread(quicksort);
            t.start();
            t.join();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
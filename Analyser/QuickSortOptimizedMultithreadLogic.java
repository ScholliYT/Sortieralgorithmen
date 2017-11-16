import java.util.*;
import java.util.concurrent.*;
public class QuickSortOptimizedMultithreadLogic extends QuickSortOptimizedMultithread implements Runnable {
    public static final int MAX_THREADS = Runtime.getRuntime().availableProcessors();

    final int[] my_array;
    final int start, end;
    private final int minPartitionSize;

    public QuickSortOptimizedMultithreadLogic(int _minPartitionSize, int[] _array, int _start, int _end) {
        minPartitionSize = _minPartitionSize;
        my_array = _array;
        start = _start;
        end = _end;
    }

    public void run() {
        quickSort(my_array, start, end);
    }

    private void quickSort(int[] _list, int lower, int upper) {
        int len = upper - lower + 1;
        if(len <= 1) { //Sicherstellen, dass sich elemente in der Teilliste befinden
            return;
        } else if(len <= 8) { // Insertionsort if subarraysize is <=8
            //System.out.println(Thread.currentThread().getName() + " insertionSort: " + len);
            insertionSort(_list, lower, upper);
            return;
        }
        int pivotIndex = (lower + upper) / 2;
        
        if(_list[pivotIndex] > _list[upper]) { //Sicherstellen, dass das pivot Element nicht das größte ist
            swap(_list, pivotIndex, upper);
        }
        int pivot = _list[pivotIndex];
        int i = lower, j = upper;
        //System.out.println(Thread.currentThread().getName() + " quickSort: " + len);
        while(i<=j) {
            while(_list[i] < pivot) {
                i++;
            }
            while(_list[j] > pivot) {
                j--;
            }
            
            if(i <= j) {
                swap(_list, i, j);
                i++; 
                j--;
            }
        }
        int partition1len = j - lower +1, partition2len = upper - i + 1;
        if((partition1len > minPartitionSize || partition2len > minPartitionSize) && threadCounter < MAX_THREADS) {
            threadCounter++;
            QuickSortOptimizedMultithreadLogic quick = new QuickSortOptimizedMultithreadLogic(minPartitionSize, _list, lower, j);
            Thread t = new Thread(quick);
            t.start();
            //System.out.println(Thread.currentThread().getName() + " New Thread " + t.getName() + " with: " + (j - lower +1) + " items");

            quickSort(_list, i, upper);
            if(t.isAlive()) { 
                //System.out.println(Thread.currentThread().getName() + " Thread still alive");
                try{
                    t.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            //System.out.println(Thread.currentThread().getName() + " Partition");
            quickSort(_list, lower, j);
            quickSort(_list, i, upper);
        }
    }

    private void insertionSort(int[] list, int first, int last) {
        for (int i = first+1; i <= last; i++) { // Change i <= last 
            int currentElement = list[i];
            int j = i-1;
            while (j>=0 && list[j]>currentElement) {
                list[j+1] = list[j];
                j--;
            }
            list[j+1] = currentElement;
        }
    }
}
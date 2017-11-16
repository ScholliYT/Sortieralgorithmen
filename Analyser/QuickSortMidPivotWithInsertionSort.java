import java.util.Arrays;
public class QuickSortMidPivotWithInsertionSort extends MeasurableSortingAlgorithm {

    @Override
    public String getName() {
        return "QuickSort middle Pivot with InsertionSort";
    }
    

    @Override
    public void sort(int[] _list) {
        quickSort(_list, 0, _list.length - 1);
    }

    private void quickSort(int[] _list, int lower, int upper) {
        if(lower>upper) { //Sicherstellen, dass sich elemente in der Teilliste befinden
            return;
        } else if(upper - lower +1 <= 8) { // Insertionsort if subarraysize is <=8
            insertionSort(_list, lower, upper);
            return;
        }
        int pivot = _list[(lower + upper) / 2];
        int i = lower, j = upper;
        while(i<=j) {
            comparisons++;
            while(_list[i] < pivot) {
                i++;
                comparisons++;
            }
            comparisons++;
            while(_list[j] > pivot) {
                j--;
                comparisons++;
            }
            
            if(i <= j) {
                swap(_list, i, j);
                swaps += 3;
                i++; 
                j--;
            }
        }
        quickSort(_list, lower, j);
        quickSort(_list, i, upper);
    }
    
/*
    private void insertionSort(int[] _list, int lower, int upper) {
        int j;
        for (int p = lower; p <= upper; p++) {
            int tmp = _list[p];
            swaps++;
            for(j = p; j > 0 && tmp < _list[j - 1]; j--) {
                _list[j] = _list[j-1];
                swaps++;
                comparisons++;
            }
            _list[j] = tmp;
            swaps++;
            comparisons++;
        }
    }
*/


    private void insertionSort(int[] list, int first, int last) {
        for (int i = first+1; i <= last; i++) { // Change i <= last 
            int currentElement = list[i];
            swaps++;
            int j = i-1;
            while (j>=0 && list[j]>currentElement) {
                list[j+1] = list[j];
                swaps++;
                j--;
                comparisons++;
            }
            list[j+1] = currentElement;
            swaps++;
            comparisons++;
        }
    }
}
import java.util.Arrays;
public class QuickSortOptimized extends MeasurableSortingAlgorithm {

    @Override
    public String getName() {
        return "QuickSortOptimized";
    }
    

    @Override
    public void sort(int[] _list) {
        quickSort(_list, 0, _list.length - 1);
    }

    private void quickSort(int[] _list, int lower, int upper) {
        int i = lower + 1, j = upper;
        if(i>j) { //Sicherstellen, dass sich elemente in der Teilliste befinden
            return;
        }
        if((upper+1) - lower <= 10) { // Insertionsort if size is <=10
            insertionSort(_list, lower, upper);
            return;
        }
        
        comparisons++;
        if(_list[lower] > _list[upper]) { //Sicherstellen, dass das erste Element nicht das größte ist
            swap(_list, lower, upper);
            swaps += 3;
        }
        while(i<=j) {
            comparisons++;
            while(_list[i] < _list[lower]) {
                i++;
                comparisons++;
            }
            comparisons++;
            while(_list[j] > _list[lower]) {
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
        swap(_list, lower, j);
        swaps += 3;
        quickSort(_list, lower, j-1);
        quickSort(_list, j+1, upper);
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
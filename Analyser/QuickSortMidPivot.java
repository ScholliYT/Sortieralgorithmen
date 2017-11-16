public class QuickSortMidPivot extends MeasurableSortingAlgorithm {

    @Override
    public String getName() {
        return "QuickSortMidPivot";
    }
    

	@Override
	public void sort(int[] _list) {
        quickSort(_list, 0, _list.length - 1);
    }

    private void quickSort(int[] _list, int lower, int upper) {
        if(lower>upper) { //Sicherstellen, dass sich elemente in der Teilliste befinden
            return;
        }
        int pivot = _list[(lower + upper) / 2];
        int i = lower, j = upper;

        comparisons++;
        if(pivot > _list[upper]) { //Sicherstellen, dass das pivot Element nicht das größte ist
            swap(_list, (lower + upper) / 2, upper);
            swaps += 3;
        }
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
}
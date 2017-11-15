public class QuickSort extends MeasurableSortingAlgorithm {

    @Override
    public String getName() {
        return "QuickSort";
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
}
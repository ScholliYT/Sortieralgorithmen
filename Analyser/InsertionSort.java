public class InsertionSort extends MeasurableSortingAlgorithm {

    @Override
    public String getName() {
        return "InsertionSort";
    }
    
	@Override
	public void sort(int[] _list) {
         int n = _list.length;
        int i = 1;
        while(i < n) {
            int j = i;
            while(j > 0) {
            	comparisons++;
                if(_list[j] < _list[j-1]) {
                    swap(_list, j, j-1);
                    swaps += 3;
                    j--;
                }
                else {
                    j = 0;
                }
            }
            i++;
        }
    }
}
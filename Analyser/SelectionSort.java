public class SelectionSort extends MeasurableSortingAlgorithm {

    @Override
    public String getName() {
        return "SelectionSort";
    }

    @Override
	public void sort(int[] _list) {
        int n = _list.length;
        int i = 0;
        int minID = 0;

        while (i < (n - 1)) {
            int j = i + 1;
            minID = i;

            while (j < n) {
            	comparisons++;
                if (_list[j] < _list[minID]) {
                    minID = j;
                }
                j++;
            }
            swaps += 3;
            swap(_list, i, minID);
            i++;
        }
    }
}
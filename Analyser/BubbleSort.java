public class BubbleSort extends MeasurableSortingAlgorithm {

    @Override
    public String getName() {
        return "BubbleSort";
    }

    @Override
    public void sort(int[] _list) {
        int n = _list.length;
        for(int i = 0; i < n -1; i++) {
            for(int j = n - 1; j > i; j--) {
                comparisons++;
                if(_list[j] < _list[j-1]) {
                    swap(_list, j, j-1);
                    swaps += 3;
                }
            }
        }
    }
}
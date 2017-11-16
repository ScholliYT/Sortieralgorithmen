public abstract class MeasurableSortingAlgorithm extends SortingAlgorithm {
    protected static long comparisons;
    protected static long swaps;

    public MeasurementResults measure(int[] _list) {
        resetConters();
        long start = System.nanoTime();
        sort(_list);
        long time = System.nanoTime() - start;
        return new MeasurementResults(time, comparisons, swaps);
    }

    private void resetConters() {
        comparisons = 0;
        swaps = 0;
    }

}

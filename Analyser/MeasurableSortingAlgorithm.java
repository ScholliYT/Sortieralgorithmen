public abstract class MeasurableSortingAlgorithm extends SortingAlgorithm {
    protected long comparisons;
    protected long swaps;

    public MeasurementResults measure(int[] _list) {
        resetConters();
        long start = System.currentTimeMillis();
        sort(_list);
        long time = System.currentTimeMillis() - start;
        return new MeasurementResults(time, comparisons, swaps);
    }

    private void resetConters() {
        comparisons = 0;
        swaps = 0;
    }

}

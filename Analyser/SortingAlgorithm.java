public abstract class SortingAlgorithm {
	public abstract void sort(int[] _list);
	public abstract String getName();

	//==================================================== Helper Methods ==================================================== 
    protected void swap(int[] _list, int a, int b) {
        int temp = _list[a];
        _list[a] = _list[b];
        _list[b] = temp;
    }
}
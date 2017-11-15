import java.util.*;
import java.text.NumberFormat;
public class SortAlgorithmsAnalyse {
	private final int ARRAY_SIZE = 100_000_000;

	public static void main(String[] args) {
		new SortAlgorithmsAnalyse();
	}

	public SortAlgorithmsAnalyse() {
		final int[] list = new int[ARRAY_SIZE];
		ArrayList<ListGenerator> listGenerators = new ArrayList<>();
		//listGenerators.add(new ASCListGenerator());
		//listGenerators.add(new DESCListGenerator());
		listGenerators.add(new RNDListGenerator());

		ArrayList<MeasurableSortingAlgorithm> algorithms = new ArrayList<>();
		//algorithms.add(new SelectionSort());
		//algorithms.add(new BubbleSort());
		//algorithms.add(new InsertionSort());
		algorithms.add(new QuickSort());
		algorithms.add(new QuickSortOptimized());



		for(ListGenerator listGenerator : listGenerators) {
			for(MeasurableSortingAlgorithm algorithm : algorithms) {
				System.out.println("====================");
				System.out.println("Algorithm: " + algorithm.getName());
				System.out.println("List Size: " + NumberFormat.getInstance(Locale.GERMAN).format(list.length));
				listGenerator.generate(list);
				System.out.println("List Type: " + listGenerator.getName());
				MeasurementResults measurementResults = algorithm.measure(list);
				System.out.println(measurementResults);
				System.out.println("The array " + (isSorted(list)?"is":"is NOT") + " sorted!");
				System.out.println("====================");
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}
	}

	public boolean isSorted(int[] _list) {
        for(int i = 1; i < _list.length; i++) {
            if(_list[i] < _list[i-1]) {
                System.out.println("Array is not sortet at: " + i + "[" + _list[i] + "]");
                return false;
            }
        }
        return true;
    }
}
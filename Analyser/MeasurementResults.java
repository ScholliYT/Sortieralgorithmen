import java.text.NumberFormat;
import java.util.Locale;
public class MeasurementResults {
	private long time;
	private long comparisons;
	private long swaps;

	public MeasurementResults(long _time, long _comparisons, long _swaps) {
		time = _time;
		comparisons = _comparisons;
		swaps = _swaps;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);
		return "Time: " + nf.format(time/1000000) + "ms\nTime: " + nf.format(time) + "ns\nComparisons: " + nf.format(comparisons) + "\nSwaps: " + nf.format(swaps);
	}
}
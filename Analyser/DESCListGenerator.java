import java.util.*;
public class DESCListGenerator extends ListGenerator {
	@Override
	public void generate(int[] _list) {
		descListe(_list, Integer.MAX_VALUE / 2, 1000);
	}
	@Override
	public String getName() {
		return "Descending";
	}
	private void descListe(int[] _list, int _max, int _numberSpace) {
		Random r = new Random();
		_list[0] = r.nextInt(_max);
		for(int i = 1; i < _list.length; i++) {
			_list[i] = _list[i - 1] - r.nextInt(_numberSpace);
		}
	}
}
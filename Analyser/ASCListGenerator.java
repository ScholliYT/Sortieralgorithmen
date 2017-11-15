import java.util.*;
public class ASCListGenerator extends ListGenerator {
	@Override
	public void generate(int[] _list) {
		ascListe(_list, Integer.MAX_VALUE / 2, 1000);
	}
	@Override
	public String getName() {
		return "Ascending";
	}
	private void ascListe(int[] _list, int _max, int _numberSpace) {
		Random r = new Random();
		_list[0] = r.nextInt(_max);
		for(int i = 1; i < _list.length; i++) {
			_list[i] = r.nextInt(_numberSpace) + _list[i - 1];
		}
	}
}
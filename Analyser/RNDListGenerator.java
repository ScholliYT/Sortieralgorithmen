import java.util.*;
public class RNDListGenerator extends ListGenerator {
	@Override
	public void generate(int[] _list) {
		rndListe(_list, Integer.MAX_VALUE);
	}
	@Override
	public String getName() {
		return "Random";
	}
	private void rndListe(int[] _list, int _max) {
		Random r = new Random();
		for(int i = 0; i < _list.length; i++) {
			_list[i] = r.nextInt(_max);
		}
	}
}
package mueller;

import java.util.HashSet;

public class LottoTip {
	
	/**
	 * Der Lotto Tipp(6 einmalige zahlen zwischen 1-45)
	 */
	HashSet<Integer> tip = new HashSet<Integer>();
	
	public LottoTip() {
		while (tip.size()<=6) {
			tip.add((int) ((Math.random()*46)+1));
		}
	}
	
}

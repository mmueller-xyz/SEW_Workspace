package mueller;

import java.util.HashSet;

public class LottoZiehung {
	HashSet<Integer> ziehung = new HashSet<Integer>();
	int zusatzzahl = (int) ((Math.random()*45)+1);	
	/**
	 * Eine ziehung ist effectiv ein tipp + eine Zusatzzahl.
	 * 
	 * @since Dec 3, 2015
	 */
	public LottoZiehung() {
		LottoTip tip = new LottoTip();
		ziehung.addAll(tip.tip);
		while (tip.tip.contains(zusatzzahl)) {
			zusatzzahl = (int) ((Math.random()*45)+1);
		}		
	}

}

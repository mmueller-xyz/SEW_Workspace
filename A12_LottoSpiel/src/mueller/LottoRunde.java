package mueller;

import java.util.HashSet;

public class LottoRunde {
	static LottoZiehung ziehung = new LottoZiehung();

	static boolean istDreier(HashSet<Integer> tip) {
		int count = 0;
		for (Integer zahl : tip) {
			if (ziehung.ziehung.contains(zahl)) {
				count++;
			}
		}
		if (count == 3)
			return true;
		return false;
	}

	static boolean istVierer(HashSet<Integer> tip) {
		int count = 0;
		for (Integer zahl : tip) {
			if (ziehung.ziehung.contains(zahl)) {
				count++;
			}
		}
		if (count == 4)
			return true;
		return false;
	}

	static boolean istFünfer(HashSet<Integer> tip) {
		int count = 0;
		for (Integer zahl : tip) {
			if (ziehung.ziehung.contains(zahl)) {
				count++;
			}
		}
		if (count == 5)
			return true;
		return false;
	}

	static boolean istFünferMitZusatzZahl(HashSet<Integer> tip) {
		int count = 0;
		for (Integer zahl : tip) {
			if (ziehung.ziehung.contains(zahl)) {
				count++;
			}
		}
		if (count == 5 && tip.contains(ziehung.zusatzzahl))
			return true;
		return false;
	}

	static boolean istSechser(HashSet<Integer> tip) {
		int count = 0;
		for (Integer zahl : tip) {
			if (ziehung.ziehung.contains(zahl)) {
				count++;
			}
		}
		if (count == 6)
			return true;
		return false;
	}

	/**
	 * Tippt solange bis ein dreier getippt wurde.
	 * @return Anzahl der Versuche
	 * @since Dec 8, 2015
	 */
	static int dreierTippen() {
		boolean temp = false;
		int i = 0;
		while (!temp) {
			i++;
			LottoTip tip = new LottoTip();
			if (istDreier(tip.tip)) {
				temp = true;
			}
		}
		return i;
	}

	/**
	 * Tippt solange bis ein vierer getippt wurde.
	 * @return Anzahl der Versuche
	 * @since Dec 8, 2015
	 */
	static int viererTippen() {
		boolean temp = false;
		int i = 0;
		while (!temp) {
			i++;
			LottoTip tip = new LottoTip();
			if (istVierer(tip.tip)) {
				temp = true;
			}
		}
		return i;
	}

	/**
	 * Tippt solange bis ein fünfer getippt wurde.
	 * @return Anzahl der Versuche
	 * @since Dec 8, 2015
	 */
	static int fünferTippen() {
		boolean temp = false;
		int i = 0;
		while (!temp) {
			i++;
			LottoTip tip = new LottoTip();
			if (istFünfer(tip.tip)) {
				temp = true;
			}
		}
		return i;
	}

	/**
	 * Tippt solange bis ein fünfer mit zusatzzahl getippt wurde.
	 * @return Anzahl der Versuche
	 * @since Dec 8, 2015
	 */
	static int fünferMitZZZTippen() {
		boolean temp = false;
		int i = 0;
		while (!temp) {
			i++;
			LottoTip tip = new LottoTip();
			if (istFünferMitZusatzZahl(tip.tip)) {
				temp = true;
			}
		}
		return i;
	}

	/**
	 * Tippt solange bis ein sechser getippt wurde.
	 * @return Anzahl der Versuche
	 * @since Dec 8, 2015
	 */
	static int sechserTippen() {
		boolean temp = false;
		int i = 0;
		while (!temp) {
			i++;
			LottoTip tip = new LottoTip();
			if (istSechser(tip.tip)) {
				temp = true;
			}
		}
		return i;
	}

	/**
	 * berechnet wieviele tipps man durschschnittlich abgeben muss um zu gewinnen.
	 * @param args
	 * @since Dec 8, 2015
	 */
	public static void main(String[] args) {
		double[] durchschnitt = new double[5];
		int e = 100;
		for (int i = 0; i < e; i++) {
			durchschnitt[0] += dreierTippen();
			durchschnitt[1] += viererTippen();
			durchschnitt[2] += fünferTippen();
			durchschnitt[3] += fünferMitZZZTippen();
			durchschnitt[4] += sechserTippen();
		}
		for (int i = 0; i < durchschnitt.length; i++) {
			durchschnitt[i] = durchschnitt[i]/e;
		}
		for (int i = 0; i < durchschnitt.length; i++) {
			System.out.println(durchschnitt[i]);
		}
	}
}

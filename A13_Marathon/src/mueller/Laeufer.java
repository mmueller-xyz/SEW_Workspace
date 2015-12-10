package mueller;

import java.text.*;
import java.util.*;

/**
 * Ein Marathonl?ufer f?r Laufzeittests.
 * @author Johann Weiser
 * @version 2015-11-20
 */
public class Laeufer implements Comparable<Laeufer>{
	private String vorName, nachName;
	private long laufZeit; // in Milliseconds
	
	// F?r die Ausgabe der Laufzeit.
	private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss,SSS");
	// F?r korrekte Zeitausgabe!
	private static final long OFFSET = 60*60*1000;
	
	/**
	 * Konstruktor f?r einen neuen L?ufer
	 * @param vorName Der Vorname des L?ufers..
	 * @param nachName Der nachname des L?ufers.
	 * @param laufZeit Die Laufzeit des L?ufers.
	 */
	Laeufer(String vorName, String nachName, long laufZeit) {
		this.vorName = vorName;
		this.nachName = nachName;
		this.laufZeit = laufZeit;
	}
	
	/**
	 * Der Hashcode wird aus Vorname und Nachname gebildet.
	 */
	@Override
	public int hashCode() {
		return compareName().hashCode();
	}
	
	/**
	 * F?r Vergleichszwecke wird immer dieser compareName bestehend aus 
	 * Nachname und Vorname (in dieser Reihenfolge) herangezogen.
	 * @return Der vollst?ndige Name f?r Vergleichszwecke.
	 */
	private String compareName() {
		return nachName + " " + vorName;
	}
	
	/**
	 * Beim Vergleich wird nur der Name verglichen, aber nicht die Zeit!
	 */
	@Override
	public int compareTo(Laeufer laeufer) {
		Laeufer l = (Laeufer) laeufer;
		return compareName().compareTo(l.compareName());
	}
	
	/**
	 * Vergleicht zwei L?ufer mittels compareTo - Methode.
	 */
	@Override
	public boolean equals(Object laeufer) {
		if (!(laeufer instanceof Laeufer)) {
			return false;
		}
		return compareTo((Laeufer)laeufer) == 0;
	}
	
	/**
	 * Formatiert die Laufzeit in einen lesbaren String um.
	 * @return Die Laufzeit als lesbarer String.
	 */
	private String laufZeitToString() {
		// nur 2 Dezimalstellen, daher substring!
		return sdf.format(new Date(laufZeit-OFFSET+5)).substring(0, 11);// + " - " + laufZeit;
	}

	/**
	 * Erzeugt einen Textdarstellung des L?ufers.
	 */
	@Override 
	public String toString() {
		return vorName + " " + nachName + ": " + laufZeitToString();
	}
}

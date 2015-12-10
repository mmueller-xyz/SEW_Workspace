package mueller;

import java.util.Hashtable;

/**
 * DieKlasse erzeugt zuf?llige Marathonl?ufer-Objekte.
 * @author Johann Weiser
 * @version 2015-11-20
 */
public class LaeuferFactory {
	// Die minimale und maximale Laufzeit der zu erzeugenden L?uferclones.
	private long minTime, maxTime;
	private int maxCloneNumber;
	//Hashtabelle zum Speichern bereits vergebener Clonenummern.
	private Hashtable<Integer, Integer> cloneValues = new Hashtable<Integer, Integer>();
	// Namensprefixe f?r die Clones.
	private String vorNamePrefix, nachNamePrefix;
	
	/**
	 * Konstruktor f?r die L?uferfactory. Hier kann man die L?uferfactory 
	 * konfigurieren. Bei Bedarf k?nnen weitere Konstruktoren hinzugef?gt werden. 
	 * @param maxCloneNumber L?uferclones wird eine Nummer zwischen 0 und maxCloneNumber angeh?ngt.
	 */
	public LaeuferFactory(int maxCloneNumber) {
		vorNamePrefix = "Neeraj";
		nachNamePrefix = "Rattu";
		minTime = 150*60*1000; // 2h30min
		maxTime = 240*60*1000;  // 4h
		//minTime = 0;
		//maxTime = minTime+1000;
		this.maxCloneNumber = maxCloneNumber;
	}
	
	/**
	 * Erzeugt einen neuen L?uferclone mit Namen, Vornamen und Zeit.
	 * Name und Vorname bestehen aus dem Prefix und einer angeh?ngten Zahl.
	 * Es werdene einige Versuche unternommen, eine bisher unbenutzte Zahl zu finden.  
	 * @return ein, nach M?glichkeit neuer, L?uferclone.
	 */
	public Laeufer createClone() {
		long laufZeit = (long)(Math.random() *(maxTime - minTime) + minTime);
		int cloneNumber;
		int counter = 0;
		do {
			cloneNumber = (int)(Math.random() * maxCloneNumber);
			counter++;
		} while (cloneValues.get(cloneNumber) != null && counter < 10);
		Integer existingValue = cloneValues.put(cloneNumber, cloneNumber);
		if (existingValue != null) {
			System.out.println("Clone with number " + cloneNumber + " already exists");
		}
		Laeufer l = new Laeufer(vorNamePrefix+cloneNumber, nachNamePrefix+cloneNumber, laufZeit);
		return l;
	}

	/**
	 * Nur zum Suchen eines L?ufers in einer Tabelle. Das L?ufer-Objekt enth?lt nur
	 * Familienname und Vorname, aber keine Zeit!
	 * @return
	 */
	public Laeufer createSimpleClone() {
		int	cloneNumber = (int)(Math.random() * maxCloneNumber);
		return new Laeufer(vorNamePrefix+cloneNumber, nachNamePrefix+cloneNumber, 0);
	}
	
	/**
	 * Eine kleine Testmethode.
	 * @param args Keine Bedeutung.
	 */
	public static void main(String[] args) {
		LaeuferFactory lf = new LaeuferFactory(20);
		System.out.println(new Laeufer("Min", "Min", lf.minTime));
		System.out.println(new Laeufer("Max", "Max", lf.maxTime));
		for (int i=0;i<10;i++) {
			System.out.println(lf.createClone());
		}
	}

}
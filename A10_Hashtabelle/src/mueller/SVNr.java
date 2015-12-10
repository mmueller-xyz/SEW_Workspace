package mueller;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Vergibt eindeutige Sozialversicherungsnummern.
 * @author Johann Weiser
 */
public class SVNr {
	/** Liste der vergebenen SV-Nummern. */
	private static Hashtable<String,String> svTable = new Hashtable<String,String>();
	
	/**
	 * Erzeuge eine neue SV-Nr f�r das gegebene Geburtsdatum.
	 * @param gebDatum Das Geburtsdatum
	 * @return Die zugeh�rige neue SV-Nr.
	 */
	public static String createSvnr(GregorianCalendar gebDatum) {
		long gd = gebDatum.get(GregorianCalendar.DAY_OF_MONTH) * 10_000 * 100 + 
			(gebDatum.get(GregorianCalendar.MONTH)+1) * 10_000 +
			gebDatum.get(GregorianCalendar.YEAR) ;
		String svnr = null;
		int counter = 0;
		do {
			svnr = "000" + (gd + (long)(Math.random()*10_000) *10_000*10_000);
			svnr = svnr.substring(svnr.length()-12);
			if (svTable.get(svnr) == null) {
				// okay - eintragen
				svTable.put(svnr,  svnr);
			} else {
				// svnr gibt es schon!
				svnr = null;
				counter++;
				if (counter > 10000) {
					// etwas flapsig!
					throw new RuntimeException("Keine g�ltige SV-Nr gefunden");
				}
			}
		} while (svnr==null);
		return svnr;
	}
}

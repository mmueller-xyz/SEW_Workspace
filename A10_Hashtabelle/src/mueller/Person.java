package mueller;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class Person {
	String vorName;
	String nachName;
	GregorianCalendar gebDatum;
	String svNr;
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MMMM yyyy");

	
	public Person(String vorName, String nachName, GregorianCalendar gebDatum) {
		this.vorName = vorName;
		this.nachName = nachName;
		this.gebDatum = gebDatum;
		svNr = SVNr.createSvnr(gebDatum);
	}

	/**
	 * @return the vorName
	 * @since Nov 13, 2015
	 */
	public String getVorName() {
		return vorName;
	}

	/**
	 * @return the nachName
	 * @since Nov 13, 2015
	 */
	public String getNachName() {
		return nachName;
	}

	/**
	 * @return the gebDatum
	 * @since Nov 13, 2015
	 */
	public GregorianCalendar getGebDatum() {
		return gebDatum;
	}

	/**
	 * @return the svNr
	 * @since Nov 13, 2015
	 */
	public String getSvNr() {
		return svNr;
	}

	
	/**
	 * @return
	 * @since Nov 16, 2015
	 */
	public String name() {
		return getVorName() + " " + getNachName();
	}

	/**
	 * gibt "Vorname, Nachname" aus
	 * @return
	 * @since Nov 16, 2015
	 */
	public String sortName() {
		return getNachName() + " " + getVorName();
	}

	/**
	 * @return
	 * @since Nov 13, 2015
	 */
	@Override
	public String toString() {
		return name() + ", geb. am " + sdf.format(gebDatum.getTime()) + "\n   SV-Nr.: " + svNr;
	}

	static class BirthComparator implements Comparator<Person>{
		/**
		 * vergleicht 2 personen
		 * @param o1
		 * @param o2
		 * @return
		 * @since Nov 16, 2015
		 */
		@Override
		public int compare(Person o1, Person o2) {
			if (o1.gebDatum.compareTo(o2.gebDatum) > 0) {
				return 1;
			}
			if (o1.gebDatum.compareTo(o2.gebDatum) < 0) {
				return -1;
			}
			if (o1.svNr.compareTo(o2.svNr) > 0) {
				return 1;
			}
			if (o1.svNr.compareTo(o2.svNr) < 0) {
				return -1;
			}
			return 0;
		}
	}
}

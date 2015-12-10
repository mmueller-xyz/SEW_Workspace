package müller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * @author Maximilian
 * @version 08. Okt. 2015
 * 
 */
public class AllgemeinerTest {
	
	/**
	 * @param args
	 * @since 08. Okt. 2015
	 */
	public static void main(String[] args) {
		AllgemeineListe<Schüler> li = AllgemeineListe.lesen("schülerListeIn.txt");
		AllgemeinerIterator si = li.get();
		AllgemeineListe.schreiben(li, "schülerListeOut.txt");
		while(si.hasNext())System.out.println(si.next().toString());
		si = li.get();
	}

}

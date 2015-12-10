package müller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class SchülerTest {
	
	public static void main(String[] args) {
		SchülerListe li = new SchülerListe();
		li.add(new Schüler("Maxi", "Müller", "male", new GregorianCalendar(1998, 11, 23)));
		li.add(new Schüler("Max", "Müller", "male", new GregorianCalendar(1998, 11, 23)));
		li.add(new Schüler("Max", "Müller", "male", new GregorianCalendar(1998, 11, 23)));
		li.add(new Schüler("Max", "Müller", "male", new GregorianCalendar(1998, 11, 23)));
		li.add(new Schüler("Max", "Müller", "male", new GregorianCalendar(1998, 11, 23)));
		SchülerIterator si = li.get();
		while(si.hasNext())System.out.println(si.next().toString());
	}

}

package müller;

import java.util.GregorianCalendar;

public class test1 {

	/**
	 * @param args
	 * @since 08. Okt. 2015
	 */
	public static void main(String[] args) {
		int i = 0;
		ObjektSpeicher<Schüler> schülerSpeicher = new ObjektSpeicher<Schüler>(5);

		schülerSpeicher.add(new Schüler("Max", "Müller", "m", new GregorianCalendar(1998, 12-1, 23)), i++);
		schülerSpeicher.add(new Schüler("Maxi", "Mueller", "m", new GregorianCalendar(1998, 12-1, 23)), i++);
		schülerSpeicher.add(new Schüler("Maximilian", "M.", "m", new GregorianCalendar(1998, 12-1, 23)), i++);

		System.out.println(schülerSpeicher.toString());
	}
}
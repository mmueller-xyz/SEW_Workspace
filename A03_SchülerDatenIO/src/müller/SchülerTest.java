package müller;

/**
 * 
 * @author Maximilian
 * @version 24. Sep. 2015
 *
 */
public class SchülerTest {
	
	/**
	 * 
	 * @param args
	 * @since 24. Sep. 2015
	 */
	public static void main(String[] args) {
		SchülerListe li = new SchülerListe();
		li = SchülerIO.lesen("schülerListeIn.txt");
		SchülerIterator si = li.get();
		SchülerIO.schreiben(li, "schülerListeOut.txt");
		while(si.hasNext())System.out.println(si.next().toString());
		si = li.get();
	}
}

/**
 * 
 */
package müller;

import java.util.ArrayList;

/**
 * @author Maximilian
 * @version 08. Okt. 2015
 * 
 */
public class test1 {

	/**
	 * @param args
	 * @since 08. Okt. 2015
	 */
	public static void main(String[] args) {
		ArrayList<Schüler> li = SchülerIO.lesen("schülerListeIn.txt");
		SchülerIO.schreiben(li, "schülerListeOut.txt");
		for (Schüler schüler : li) {
			System.out.println(schüler.toString());
		}
	}

}

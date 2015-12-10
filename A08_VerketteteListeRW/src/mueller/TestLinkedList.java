package mueller;

import java.io.File;
import java.util.Iterator;

/**
 * @author Maximilian
 * @version 15. Okt. 2015
 * 
 */
public class TestLinkedList {

	/**
	 * @param args
	 * @since 15. Okt. 2015
	 */
	public static void main(String[] args) {
		MyLinkedListe<String> liste = new MyLinkedListe<String>();
		liste.add(new String("2"));
		liste.add(new String("3"));
		liste.addFirst(new String("1"));
		liste.addFirst(new String("1"));
		liste.remove();
		liste.add(new String("5"));
		liste.add(new String("6"));
		liste.add(new String("4"), 4);
		liste.add(new String("8"));
		liste.add(new String("7"), 7);
		liste.removeLast();
		liste.remove(3);
		liste.read(new File("linkedListIN"));//input file
		liste.write(new File("linkedListOUT"));//output file
		
		Iterator<String> iter = liste.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());	
		}
	}
}

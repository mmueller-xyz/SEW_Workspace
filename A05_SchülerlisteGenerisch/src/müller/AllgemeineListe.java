package müller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author Maximilian
 * @version 08. Okt. 2015
 * 
 * @param <E>
 */
public class AllgemeineListe<E> {
	int i = 0;
	Object[] objektListe = new Object[0];

	/**
	 * @author Maximilian
	 * @version 08. Okt. 2015
	 * 
	 */
	public class Iterator implements AllgemeinerIterator<E> {
		public int i;
		public Object[] objektListe;

		/**
		 * @param objektListe
		 * @since 08. Okt. 2015
		 */
		public Iterator(Object[] objektListe) {
			i = 0;
			this.objektListe = objektListe.clone();
		}

		/**
		 * @return
		 * @since 08. Okt. 2015
		 */
		@Override
		public E next() {
			return (E) objektListe[i++];
		}

		/**
		 * @return
		 * @since 08. Okt. 2015
		 */
		@Override
		public boolean hasNext() {
			return i < objektListe.length;
		}

	}

	/**
	 * @param e
	 * @since 08. Okt. 2015
	 */
	public void add(E e) {
		Object temp[] = new Object[objektListe.length + 1];
		for (int i = 0; i < objektListe.length; i++) {
			temp[i] = objektListe[i];
		}
		temp[i++] = e;
		objektListe = temp.clone();
	}

	/**
	 * @param e
	 * @since 08. Okt. 2015
	 */
	public void remove(E e) {
		if (objectToIndex(e) != 0) {
			Object[] temp = new Object[objektListe.length - 1];
			for (int i = 0; i < objectToIndex(e); i++) {
				temp[i] = objektListe[i];
			}
			for (int i = objectToIndex(e) + 1; i < temp.length; i++) {
				temp[i] = objektListe[i + 1];
			}
			objektListe = temp.clone();
		}
	}

	/**
	 * @param e
	 * @return
	 * @since 08. Okt. 2015
	 */
	public int objectToIndex(E e) {
		for (int i = 0; i < objektListe.length; i++) {
			if (e.equals(objektListe[i]))
				return i;
		}
		return -1;
	}

	/**
	 * @return
	 * @since 08. Okt. 2015
	 */
	public int anzahl() {
		return objektListe.length;
	}
	
	/**
	 * @return
	 * @since 08. Okt. 2015
	 */
	public Iterator get() {
		return new Iterator(objektListe);
	}
	
	/**
	 * @param path
	 * @return
	 * @since 08. Okt. 2015
	 */
	static AllgemeineListe<Schüler> lesen(String path) {
		try {
			Scanner line;
			line = new Scanner(new File(path));

			AllgemeineListe<Schüler> sl = new AllgemeineListe<Schüler>();
			while (line.hasNextLine()) {
				Scanner scanner = new Scanner(line.nextLine());

				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				GregorianCalendar calendar = new GregorianCalendar();

				String vn = scanner.next();
				String nn = scanner.next();
				String sx = scanner.next();

				calendar.setTime(date.parse(scanner.next()));

				Schüler s = new Schüler(vn, nn, sx, calendar);
				sl.add(s);
				scanner.close();
			}
			line.close();
			return sl;
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	/**
	 * @param sl
	 * @param path
	 * @since 08. Okt. 2015
	 */
	static void schreiben(AllgemeineListe<Schüler> sl, String path) {
		try {
			PrintWriter writer = new PrintWriter(new File(path));
			AllgemeinerIterator iter = sl.get();

			while(iter.hasNext()){
				Schüler s = (Schüler) iter.next();
				
				writer.println(s.toString());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

package mueller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Maximilian
 * @version 12. Okt. 2015
 * 
 */
public class MyLinkedListe<E> implements Iterable<E> {

	/**
	 * @return
	 * @since 19. Okt. 2015
	 */
	@Override
	public Iterator<E> iterator() {
		return new Iter<E>();
	}

	private class Element {
		private Element next, previous;
		private E e;

		/**
		 * @param next
		 * @param previous
		 * @param e
		 * @since 12. Okt. 2015
		 */
		public Element(E e, Element next, Element previous) {
			this.next = next;
			this.previous = previous;
			this.e = e;
		}

		/**
		 * @param e
		 * @since 12. Okt. 2015
		 */
		public Element(E e) {
			this(e, null, null);
		}
	}

	/**
	 * Erstes und letztes Element in der liste.
	 */
	private Element first, last;

	/**
	 * 
	 * @since 15. Okt. 2015
	 */
	public MyLinkedListe() {
		first = null;
		last = null;
	}

	/**
	 * fügt ein Element an die letzte Stelle hinzu
	 * 
	 * @param e
	 *            Element
	 * @since 15. Okt. 2015
	 */
	void add(E e) {
		if (last == null) {
			last = new Element(e);
			first = last;
		} else {
			Element newE = new Element(e, null, last);
			last.next = newE;
			last = newE;
		}
	}

	/**
	 * Fügt ein Element an die Stelle i ein
	 * 
	 * @param e
	 *            Element
	 * @param i
	 *            Stelle i
	 * @since 15. Okt. 2015
	 */
	void add(E e, int i) {
		if (i == 1) {// erstes element
			addFirst(e);
		} else {
			Element temp = first;
			for (int j = 1; j < i-1 && temp != last; j++) {//zählt hoch bis temp das element unter dem neuen ist
				temp = temp.next;
			}
			Element newE = new Element(e, temp.next, temp);
			if (temp != last) {
				temp.next.previous = newE;
				temp.next = newE;
			}else {
				add(e);
			}
		}
	}

	/**
	 * Fügt ein Element an der ersten Stelle hinzu
	 * 
	 * @param e
	 * @since 15. Okt. 2015
	 */
	void addFirst(E e) {
		Element newE = new Element(e, first, null);
		first.previous = newE;
		first = newE;
	}

	/**
	 * @author Maximilian
	 * @version 15. Okt. 2015
	 * 
	 * @param <E>
	 */
	class Iter<E> implements Iterator<E> {
		Element next, lastReturned;

		public Iter() {
			next = first;
			lastReturned = null;
		}

		/**
		 * @return
		 * @since 15. Okt. 2015
		 */
		@Override
		public boolean hasNext() {
			return next != null;
		}

		/**
		 * @return
		 * @since 15. Okt. 2015
		 */
		@Override
		public E next() {
			if (next == null)
				throw new NoSuchElementException();
			lastReturned = next;
			next = next.next;
			return (E) lastReturned.e;
		}

		@Override
		public void remove() {
			if (lastReturned == null) {
				throw new NoSuchElementException();
			} else {
				lastReturned.previous.next = lastReturned.next;
				lastReturned.next.previous = lastReturned.previous;
				lastReturned = null;
			}
		}
	}

	/**
	 * löscht das erste Element und gib dieses zurück
	 * 
	 * @return das gelösche Element
	 * @since 15. Okt. 2015
	 */
	E remove() {
		if (first.next == null) {
			throw new NoSuchElementException();
		} else {
			E temp = first.e;
			first.next.previous = null;
			first = first.next;
			return temp;
		}
	}

	/**
	 * löscht ein element an der stelle i und gibt dieses zurück
	 * 
	 * @param i
	 * @return das gelöschte element
	 * @since 15. Okt. 2015
	 */
	E remove(int i) {
		if (i == 1) {
			return remove();
		} else {

			Element temp = first;
			for (int j = 1; j < i && temp != last; j++) {//zählt hoch bis temp das element das zu entfernend ist
				temp = temp.next;
			}
			if (temp != last) {
				temp.previous.next = temp.next;
				temp.next.previous = temp.previous;
				return temp.e;
			}else {
				return removeLast();
			}
		}
	}

	/**
	 * löscht das Letzte Element und giebt dieses zurück
	 * 
	 * @return das gelöschte element
	 * @since 15. Okt. 2015
	 */
	E removeLast() {
		if (first.next == null) {
			throw new NoSuchElementException();
		} else {
			E temp = last.e;
			last.previous.next = null;
			last = last.previous;
			return temp;
		}
	}
	/**
	 * liest das spezifizieret file ein und fügt zeilenweise den inhalt zu der arrayliste hinzu 
	 * @param f input file
	 * @since Nov 12, 2015
	 */
	void read(File f){
		Scanner sc;
		try {
			sc = new Scanner(f);
			while (sc.hasNextLine()) {
				add((E) sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * schreibt alle jetzigen elemente in der Arrayliste in das spezifiziere File
	 * @param f output File
	 * @since Nov 12, 2015
	 */
	void write(File f){
		try {
			PrintWriter pw = new PrintWriter(f);
			Iterator<String> iter = (Iterator<String>) this.iterator();
			while (iter.hasNext()) {
				pw.println(iter.next());
			}
			pw.close();	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

package müller;

import java.util.Arrays;

/**
 * @author Maximilian
 * @version 08. Okt. 2015
 * 
 */
public class ObjektSpeicher<E> {

	Object ol[];

	/**
	 * @param size größe des Arrays
	 * @since 08. Okt. 2015
	 */
	public ObjektSpeicher(int size) {
		ol = new Object[size];
	}

	/**
	 * @param e
	 * @param position
	 * @since 08. Okt. 2015
	 */
	public void add(E e, int position) {
		ol[position] = e;
	}

	/**
	 * @param position
	 * @return
	 * @since 08. Okt. 2015
	 */
	public E get(int position) {
		return (E) ol[position];
	}

	/**
	 * @return
	 * @since 08. Okt. 2015
	 */
	public int size() {
		return ol.length;
	}

	/**
	 * @return
	 * @since 08. Okt. 2015
	 */
	public int numberOfElements() {
		int j = 0;
		for (int i = 0; i < ol.length; i++) {
			if (ol[i] != null)
				j++;
		}
		return j;
	}

	/**
	 * @return
	 * @since 08. Okt. 2015
	 */
	@Override
	public String toString() {
		String s = "";
		int j = 0;
		for (int i = 0; i < ol.length; i++) {
			if (ol[i] != null) {
				s += ol[i].toString() + ", index: "+i;
				j++;
				if (j<numberOfElements()) {
					s += "\n";
				}
			}
		}
		return s;
	}
}

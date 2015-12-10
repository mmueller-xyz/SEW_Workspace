

public class Stack<E> {
	Object[] elements;
	int nextFreeIndex;

	/**
	 * @param elements
	 * @since Nov 16, 2015
	 */
	public Stack(int Size) {
		elements = new Object[Size];
		nextFreeIndex = 0;
	}

	/**
	 * fügt ein neuse Element dem Stack hinzu
	 * @param e
	 * @since Nov 16, 2015
	 */
	void push(E e) {
		if (isFull()) {
			throw new IllegalStateException("Stack allready full!");
		}
		elements[nextFreeIndex++]=e;
	}

	/**
	 * löscht das oberste Element im Stack und gibt dieses zurück
	 * @return
	 * @since Nov 16, 2015
	 */
	E pop(){
		if (isEmpty()) {
			throw new IllegalStateException("Stack allready empty!");
		}
		return (E) elements[--nextFreeIndex];
	}
	
	/**
	 * gibt das oberste Element zurück
	 * @return
	 * @since Nov 16, 2015
	 */
	E peek(){
		return (E) elements[nextFreeIndex-1];
	}
	
	/**
	 * gibt zurück ob der Stack leer ist
	 * @return
	 * @since Nov 16, 2015
	 */
	boolean isEmpty(){
		if (nextFreeIndex == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * gibt zurück ob der Stack voll ist
	 * @return
	 * @since Nov 16, 2015
	 */
	boolean isFull(){
		if (nextFreeIndex==elements.length-1) {
			return true;
		}
		return false;
	}
}

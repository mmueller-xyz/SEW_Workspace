package weiser;

import java.util.*;

/**
 * Eine Stackklasse, welche nur in Ansätzen implementiert ist.
 * @author Johann Weiser
 * @version 2016-02-22
 * @param <T> Die Klasse des Stackelementes
 */
public  class MyStack<T> {
	
	private ArrayList<T> tArr;
	private int size;
	
	public MyStack(int size) {
		tArr = new ArrayList<T>();
		this.size = size;
	}
	
	public  void push(T t) throws StackFullException {
		throw new UnsupportedOperationException("Method push not yet implemented.");
	}
	
	public T pop() throws EmptyStackException {
		throw new UnsupportedOperationException("Method pop not yet implemented.");
	}
	
	public boolean isEmpty() {
		return tArr.isEmpty();
	}
	
	public boolean isFull() {
		return tArr.size()>=size;
	}

	
}
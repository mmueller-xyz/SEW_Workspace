package mueller;

import java.util.*;

/**
 * Testet verschiedene listen auf geschwidigkeit
 * 
 * @author max
 * @version Dec 10, 2015
 * 
 */
public class LaufzeitTest {

	/**
	 * Testet java.util.Hashtable auf io geschwindigkeit
	 * 
	 * @since Dec 10, 2015
	 */
	public static void testHashTable() {
		System.out.println("Hash Table:");

		LaeuferFactory factory = new LaeuferFactory(30000);
		Hashtable<String, Laeufer> testTable = new Hashtable<String, Laeufer>();

		// write speed test
		long startT = System.currentTimeMillis();

		for (int i = 0; i < 10000; i++) {
			Laeufer tempLaufer = factory.createClone();
			testTable.put(tempLaufer.toString(), tempLaufer);
		}

		long endT = System.currentTimeMillis();
		System.out.println(endT - startT + " ms");

		Enumeration<String> keys = testTable.keys();

		// read speed test
		startT = System.currentTimeMillis();

		while (keys.hasMoreElements()) {
			testTable.get(keys.nextElement());
		}

		endT = System.currentTimeMillis();
		System.out.println(endT - startT + " ms\n");
	}

	/**
	 * Testet java.util.Stack auf io geschwindigkeit
	 * 
	 * @since Dec 10, 2015
	 */
	public static void testStack() {
		System.out.println("Stack:");

		LaeuferFactory factory = new LaeuferFactory(30000);
		Stack<Laeufer> testStack = new Stack<Laeufer>();

		// write speed test
		long startT = System.currentTimeMillis();

		for (int i = 0; i < 10000; i++) {
			testStack.push(factory.createClone());
		}

		long endT = System.currentTimeMillis();
		System.out.println(endT - startT + " ms");

		// read speed test
		startT = System.currentTimeMillis();

		while (!testStack.isEmpty()) {
			testStack.pop();
		}

		endT = System.currentTimeMillis();
		System.out.println(endT - startT + " ms\n");
	}

	/**
	 * Testet java.util.ArrayList auf io geschwindigkeit
	 * 
	 * @since Dec 10, 2015
	 */
	public static void testArrayList() {
		System.out.println("Arraylist:");

		LaeuferFactory factory = new LaeuferFactory(30000);
		ArrayList<Laeufer> testArrayList = new ArrayList<Laeufer>();

		// write speed test
		long startT = System.currentTimeMillis();

		for (int i = 0; i < 10000; i++) {
			testArrayList.add(factory.createClone());
		}

		long endT = System.currentTimeMillis();

		// read speed test
		System.out.println(endT - startT + " ms");
		startT = System.currentTimeMillis();

		for (int j = 0; j < testArrayList.size(); j++) {
			testArrayList.get(j);
		}

		endT = System.currentTimeMillis();
		System.out.println(endT - startT + " ms\n");
	}

	public static void main(String[] args) {
		testHashTable();
		testStack();
		testArrayList();
	}
}
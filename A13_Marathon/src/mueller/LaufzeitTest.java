package mueller;

import java.util.Enumeration;
import java.util.Hashtable;

public class LaufzeitTest {

	public LaufzeitTest() {

	}

	public static void testHashTable() {
		LaeuferFactory factory = new LaeuferFactory(30000);
		Hashtable<String, Laeufer> testTable = new Hashtable<String, Laeufer>();

		long startT = System.currentTimeMillis();

		for (int i = 0; i < 10000; i++) {
			Laeufer tempLaufer = factory.createClone();
			testTable.put(tempLaufer.toString(), tempLaufer);
		}

		long endT = System.currentTimeMillis();
		System.out.println(endT - startT + " ms");

		Enumeration<String> keys = testTable.keys();

		startT = System.currentTimeMillis();

		while (keys.hasMoreElements()) {
			testTable.get(keys.nextElement());
		}

		endT = System.currentTimeMillis();
		System.out.println(endT - startT + " ms");
	}

	public static void test1() {
		long startT = System.currentTimeMillis();

		long endT = System.currentTimeMillis();
		System.out.println(endT - startT);
		startT = System.currentTimeMillis();

		endT = System.currentTimeMillis();
		System.out.println(endT - startT);
	}

	public static void test2() {
		long startT = System.currentTimeMillis();

		long endT = System.currentTimeMillis();
		System.out.println(endT - startT);
		startT = System.currentTimeMillis();

		endT = System.currentTimeMillis();
		System.out.println(endT - startT);
	}

	public static void main(String[] args) {
		testHashTable();
	}
}

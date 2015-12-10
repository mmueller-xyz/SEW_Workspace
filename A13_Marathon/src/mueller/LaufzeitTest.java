package mueller;

import java.util.Hashtable;

public class LaufzeitTest {

	public LaufzeitTest() {

	}

	public static void testHashTable() {
		LaeuferFactory factory = new LaeuferFactory(20000);
		Hashtable<String, Laeufer> testTable = new Hashtable<String, Laeufer>();

		long startT = System.currentTimeMillis();
		
		for (int i = 0; i < 10000; i++) {
			Laeufer tempLaufer = factory.createClone();
			testTable.put(tempLaufer.toString(), tempLaufer);
		}

		long endT = System.currentTimeMillis();
		System.out.println(endT - startT);
		
		startT = System.currentTimeMillis();

		for (int i = 0; i < 10000; i++) {
			testTable.
		}
		
		endT = System.currentTimeMillis();
		System.out.println(endT - startT);
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

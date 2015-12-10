/**
 * 
 */
package müller;

/**
 * @author Maximilian
 * @version 08. Okt. 2015
 * 
 */
public class test2 {

	/**
	 * @param args
	 * @since 08. Okt. 2015
	 */
	public static void main(String[] args) {
		int i = 0;

		ObjektSpeicher<Integer> integerSpeicher = new ObjektSpeicher<Integer>(5);

		integerSpeicher.add(new Integer(3), i++);
		integerSpeicher.add(new Integer(7), i++);
		integerSpeicher.add(new Integer(9), i++);
		
		for (int j = 0; j < integerSpeicher.size(); j++) {
			if (integerSpeicher.get(j) != null) {
				System.out.println(integerSpeicher.get(j));
			}
		}
	}
}
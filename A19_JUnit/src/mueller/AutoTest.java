package mueller;

import static org.junit.Assert.*;
import org.junit.*;
import weiser.*;
/**
 * @author max
 * @version Feb 11, 2016
 */
public class AutoTest {
	private Auto auto = null;
	
	@Test
	public void testKonstruktor(){
		auto = new Auto();
	}
	
	@Test
	public void testType(){
		System.out.println("Methode testType");
		auto = new Auto();
		auto.setType(null);
		
		if (auto.getType()!=null){
			Assert.fail("Type != null");
		}
	}
	
	@Test
	public void testFarbe(){
		System.out.println("Methode testFarbe");
	}

	@Test
	public void testLeistung(){
		System.out.println("Methode testLeistung");
	}

	@Test
	public void testToString(){
		System.out.println("Methode testToString");
	}

	/**
	 * @param args
	 * @since Feb 11, 2016
	 */
	public static void main(String[] args) {
		
	}

}

package mueller;

/**
 * @author max
 * @version Nov 20, 2015
 * 
 */
public class Ofen {

	BrikettStack b1 = new BrikettStack();
	BrikettStack b2 = new BrikettStack();
	
	/**
	 * @param b1
	 * @param b2
	 * @since Nov 23, 2015
	 */
	public Ofen() {
		b1.add(new Braunkohlebrikett());
		b1.add(new Holzbrikett());
		b1.add(new Pelletsbrikett());
		b1.add(new Steinkohlebrikett());
		
	}

	boolean pelletsHeizen(){
		while (!b1.isEmpty()) {
			if (b1.peek().toString() == Pelletsbrikett.class.getName()) {
				b1.pop();
				return true;
			}else {
				b2.add(b1.pop());
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Ofen ofen = new Ofen();
		System.out.println(ofen.pelletsHeizen());
	}

}

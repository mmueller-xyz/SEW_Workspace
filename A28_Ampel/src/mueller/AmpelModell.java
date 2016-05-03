package mueller;

public class AmpelModell {
	public final static int STATUS_ROT = 0;
	public final static int STATUS_ROT_GELB = 1;
	public final static int STATUS_GRUEN = 2;
	public final static int STATUS_GRUEN_BL = 3;
	public final static int STATUS_GELB = 4;
	private int status;
	
	/**
	 * @since Apr 28, 2016
	 */
	public AmpelModell() {
		status = 0;
	}

	/**
	 * @return the status
	 * @since Apr 28, 2016
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to next
	 * @since Apr 28, 2016
	 */
	public void nextStatus() {
		status = ++status%5;
	}

}

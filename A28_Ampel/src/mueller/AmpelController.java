package mueller;

import javax.swing.SwingUtilities;

public class AmpelController {
	private AmpelView v;
	private AmpelModell m;

	/**
	 * @param v
	 * @param m
	 * @since Apr 28, 2016
	 */
	public AmpelController() {
		m = new AmpelModell();
		v = new AmpelView(m);
	}

	public void endlosLoop() {
		while (true) {
			try {
				Thread.sleep(2000);
				m.nextStatus();
				if (m.getStatus() == AmpelModell.STATUS_GRUEN_BL) {
					for (int i = 0; i < 8; i++) {
						Thread.sleep(1000);						
						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								v.repaint();
							}
						});
					}
				} else {
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							v.repaint();
						}
					});
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		AmpelController c = new AmpelController();
		c.endlosLoop();
	}
}

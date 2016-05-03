package mueller;

import java.awt.*;
import javax.swing.*;

/**
 * @author max
 * @version Apr 28, 2016
 * 
 */
public class AmpelView extends JPanel {
	private AmpelModell m;
	int lichtRad = 230;
	int abst = 5;
	Boolean flash = true;

	/**
	 * @param m
	 * @since Apr 28, 2016
	 */
	public AmpelView(AmpelModell m) {
		this.m = m;
		JFrame f = new JFrame("Ampel");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(lichtRad + abst, 3 * (lichtRad + abst) - abst));
		f.setContentPane(this);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	/**
	 * @param g
	 * @since Apr 28, 2016
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (m.getStatus() == AmpelModell.STATUS_ROT || m.getStatus() == AmpelModell.STATUS_ROT_GELB) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.DARK_GRAY);
		}
		g.fillOval(abst / 2, abst / 2, lichtRad, lichtRad);

		if (m.getStatus() == AmpelModell.STATUS_ROT_GELB || m.getStatus() == AmpelModell.STATUS_GELB) {
			g.setColor(Color.YELLOW);
		} else {
			g.setColor(Color.DARK_GRAY);
		}
		g.fillOval(abst / 2, abst + lichtRad, lichtRad, lichtRad);

		if (m.getStatus() == AmpelModell.STATUS_GRUEN || (m.getStatus() == AmpelModell.STATUS_GRUEN_BL && flash)) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.DARK_GRAY);
		}
		if (flash) {
			flash = false;
		}else {
			flash = true;
		}
		g.fillOval(abst / 2, abst * 3 / 2 + lichtRad * 2, lichtRad, lichtRad);
	}

}

package müller;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.GregorianCalendar;

import javax.swing.*;
/**
 * 
 * @author Maximilian
 * @version 17. Sep. 2015
 */
@SuppressWarnings("serial")
public class SchülerDaten extends JPanel implements ActionListener{
	
	private JTextField fnTf;
	private JTextField vnTf;
	private JTextField gbTf;
	private JRadioButton rbM;
	private JRadioButton rbW;
	
	
	/**
	 * 
	 * 
	 * @since 17. Sep. 2015
	 */
	public SchülerDaten() {
		setLayout(new BorderLayout());

		JPanel tf = new JPanel();
		tf.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		JPanel north = new JPanel();
		JLabel überschrift = new JLabel("Sch�lerdaten");
		überschrift.setFont(new Font("Areal", Font.BOLD,25));
		north.add(Box.createHorizontalGlue());
		north.add(überschrift);
		north.add(Box.createHorizontalGlue());		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		
		JLabel familienname = new JLabel("Familianname:");
		familienname.setFont(new Font("Areal", Font.PLAIN, 12));
		tf.add(familienname, gbc);
		
		gbc.gridx = 1;
		fnTf = new JTextField(15);
		tf.add(fnTf, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		JLabel vorname = new JLabel("Vorname:");
		vorname.setFont(new Font("Areal", Font.PLAIN, 12));
		tf.add(vorname, gbc);
		
		gbc.gridx = 1;
		vnTf = new JTextField(15);
		tf.add(vnTf, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		JLabel geschlecht = new JLabel("Geschlecht:");
		geschlecht.setFont(new Font("Areal", Font.PLAIN, 12));
		tf.add(geschlecht, gbc);
		
		rbM = new JRadioButton("männlich");
		rbW = new JRadioButton("weiblich");
		ButtonGroup bg1 = new ButtonGroup();
		rbM.setSelected(true);
		bg1.add(rbW);bg1.add(rbM);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		tf.add(rbM, gbc);
		
		gbc.gridy++;
		
		tf.add(rbW, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		
		JLabel geburtsdatum = new JLabel("Geburtsdatum(dd.MM.JJJJ):");
		geburtsdatum.setFont(new Font("Areal", Font.PLAIN, 12));
		tf.add(geburtsdatum, gbc);
		
		gbc.gridx = 1;
		
		gbTf = new JTextField(15);
		tf.add(gbTf, gbc);
		
		JPanel buttons = new JPanel();
		
		JButton bReset = new JButton("reset"), bOk = new JButton("ok"), bExit = new JButton("exit");
		
		bReset.addActionListener(this);
		bOk.addActionListener(this);
		bExit.addActionListener(this);
		
		buttons.add(Box.createHorizontalGlue());
		buttons.add(bReset);
		buttons.add(Box.createHorizontalStrut(20));
		buttons.add(bOk);
		buttons.add(Box.createHorizontalStrut(20));
		buttons.add(bExit);
		buttons.add(Box.createHorizontalGlue());
		
		add(north, BorderLayout.NORTH);		
		add(tf, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
	}
	
	/**
	 * 
	 * @param args
	 * @since 17. Sep. 2015
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Schülerdaten");
		frame.setContentPane(new SchülerDaten());

		frame.pack();
		frame.setPreferredSize(new Dimension(300, 200));
		frame.setDefaultCloseOperation(3);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	/**
	 * 
	 * @param e
	 * @since 17. Sep. 2015
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		final String[] month= {"Jänner", "Februar", "Märtz", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
		switch (e.getActionCommand()) {
		case "reset":
			fnTf.setText("");
			vnTf.setText("");
			gbTf.setText("");
			rbM.setSelected(true);
			break;

		case "ok":
			SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
			GregorianCalendar dateGreg = new GregorianCalendar();
			Boolean dateOk = true;
			try {
				dateGreg.setTime(date.parse(gbTf.getText()));
			} catch (ParseException e1) {
				dateOk = false;
				gbTf.setText("");
			}
			if(dateOk){
			System.out.println("Familienname:\n"+fnTf.getText());
			System.out.println("Vorname:\n"+vnTf.getText());
			System.out.println("Geburtstagsdatum:");
			System.out.println(dateGreg.get(GregorianCalendar.DAY_OF_MONTH)+"."+month[dateGreg.get(GregorianCalendar.MONTH)]+"."+dateGreg.get(GregorianCalendar.YEAR));
			System.out.println("Männlich:\n"+rbM.isSelected());
			}
			break;
			
		case "exit":
			System.exit(3);
			break;
			
		default:
			break;
		}
	}

}

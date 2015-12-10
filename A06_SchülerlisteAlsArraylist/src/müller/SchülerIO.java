package müller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Maximilian
 * @version 08. Okt. 2015
 * 
 */
public class SchülerIO {

	/**
	 * @param path
	 * @return
	 * @since 08. Okt. 2015
	 */
	static ArrayList<Schüler> lesen(String path) {
		try {
			Scanner line;
			line = new Scanner(new File(path));

			ArrayList<Schüler> sl = new ArrayList<Schüler>();

			while (line.hasNextLine()) {
				Scanner scanner = new Scanner(line.nextLine());

				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				GregorianCalendar calendar = new GregorianCalendar();

				String vn = scanner.next();
				String nn = scanner.next();
				String sx = scanner.next();

				calendar.setTime(date.parse(scanner.next()));

				Schüler s = new Schüler(vn, nn, sx, calendar);
				sl.add(s);
				scanner.close();
			}
			line.close();
			return sl;
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	/**
	 * @param sl
	 * @param path
	 * @since 08. Okt. 2015
	 */
	static void schreiben(ArrayList<Schüler> sl, String path) {
		try {
			PrintWriter writer = new PrintWriter(new File(path));

			for (Schüler s : sl) {
				writer.println(s.toString());
			}

			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

package mueller;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * A23 Bestimmen von Ordnergröße mithilfe von rekursiever programmierung
 * 
 * @author Maximilian Müller
 * @version Mar 14, 2016
 * 
 */
public class file{
	
	/**
	 * Diese Methode 
	 * 
	 * @param dir Der pfad der zu überprüfenden Datei
	 * @return
	 * @since Mar 14, 2016
	 */
	public static long listDir(File f){
		if (!f.isDirectory()) {
			return f.length();
		}
		File[] flist = f.listFiles();
		long n = 0;
		for (File file : flist) {
			n += listDir(new File(file.getAbsolutePath()));
		}
		return n;
	}
	
	public static void main(String[] args) {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.showOpenDialog(fc);
		long startTime = System.currentTimeMillis();
		long size = listDir(fc.getSelectedFile());
		long finishTime = System.currentTimeMillis();
		String[] names = {" Byte(s)", " kB", " mB", " GB", " TB"};
		double n = size;
		int i;
		for (i = 0;n > 1024;i++) {
			n /= 1024;
		}
		for (;i>=0;i--) {
			System.out.println((size/(long)Math.pow(1024, i))+names[i]);
		}
		System.out.println(finishTime-startTime+" ms");
	}

}

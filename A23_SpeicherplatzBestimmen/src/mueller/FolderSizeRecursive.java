package mueller;

import java.io.File;
import javax.swing.JFileChooser;

/**
 * A23 Bestimmen von Ordnergröße mithilfe von rekursiever programmierung
 * 
 * @author Maximilian Müller
 * @version Mar 14, 2016
 * 
 */
public class FolderSizeRecursive{
	
	/**
	 * Diese Methode gibt wenn das angegebene File Objekt kein Ordner ist die größe zurück
	 * und wenn es ein Ordner ist ruft die Methode sich für jedes File in dem Ordner sich selbst auf.
	 * 
	 * @param dir Der pfad der zu überprüfenden Datei
	 * @return Größe des Files / Ordners
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
	
	/**
	 * Die main() Methode ruft grundsätzlich nur listDir() auf und gibt den Returnwert auf der Konsole aus, 
	 * wurde aber spaßhalber ausgebaut.
	 * 
	 * @param args
	 * @since Mar 15, 2016
	 */
	public static void main(String[] args) {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.showOpenDialog(fc);	//Öffnen des FileDialogs
		
		long startTime = System.currentTimeMillis();
		/*Start der Zeitnehmung*/
		long size = listDir(fc.getSelectedFile());
		/*Ende der Zeitnehmung*/
		long finishTime = System.currentTimeMillis();
		
		String[] names = {" Byte(s)", " kB", " mB", " GB", " TB"};	//Liste der Einheten (Erweiterbar)
		double n = size;
		int i;	//wie oft 1024 in n ganzzahlig ausgeht
		for (i = 0;n > 1024;n /= 1024, i++);
		for (int j=i;j>=0;j--) {
			System.out.println((size/(long)Math.pow(1024, j))+names[j]);
		}
		
		int psi = (int) (size/(finishTime-startTime+0.1)/Math.pow(1024, 3)*100*1000);
		double ps = ((double) psi) / 100;
		
		String persec = "(" + ps + names[3] + "/s)";
		
		System.out.println("It took: " + (finishTime-startTime) + " ms "+ persec +" for:\n"+fc.getSelectedFile());
	}
}

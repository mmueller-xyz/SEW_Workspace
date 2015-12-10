package müller;

/**
 * @author Maximilian
 * @version 17. Sep. 2015
 * 
 */
public class SchülerListe {
	int i = 0;
	Schüler[] schülerListe = new Schüler[0];

	/**
	 * @param l
	 * @param schülerListe
	 * @since 20. Sep. 2015
	 */
	public class Iterator implements SchülerIterator {
		public int i;
		public Schüler[] schülerListe;

		/**
		 * @param schülerListe
		 * @since 20. Sep. 2015
		 */
		public Iterator(Schüler[] schülerListe) {
			i = 0;
			this.schülerListe = schülerListe.clone();
		}

		/**
		 * 
		 * @return
		 * @since 20. Sep. 2015
		 */
		@Override
		public Schüler next() {
			Schüler s = schülerListe[i];
			i++;
			return s;
		}

		/**
		 * 
		 * @return
		 * @since 20. Sep. 2015
		 */
		@Override
		public boolean hasNext() {
			return i < schülerListe.length;
		}

	}

	/**
	 * 
	 * @param s
	 * @since 20. Sep. 2015
	 */
	public void add(Schüler s) {
		Schüler[] temp = new Schüler[schülerListe.length + 1];
		for (int i = 0; i < schülerListe.length; i++) {
			temp[i] = schülerListe[i];
		}
		temp[i++] = s;
		schülerListe = temp.clone();
	}

	/**
	 * @param s
	 * @since 20. Sep. 2015
	 */
	public void remove(Schüler s) {
		if (studentToIndex(s) != 0) {
			Schüler[] temp = new Schüler[schülerListe.length - 1];
			for (int i = 0; i < studentToIndex(s); i++) {
				temp[i] = schülerListe[i];
			}
			for (int i = studentToIndex(s) + 1; i < temp.length; i++) {
				temp[i] = schülerListe[i + 1];
			}
			schülerListe = temp.clone();
		}
	}

	/**
	 * @param s
	 * @return
	 * @since 20. Sep. 2015
	 */
	public int studentToIndex(Schüler s) {
		for (int i = 0; i < schülerListe.length; i++) {
			if (s.equals(schülerListe[i]))
				return i;
		}
		return -1;
	}

	/**
	 * @return
	 * @since 20. Sep. 2015
	 */
	public int anzahl() {
		return schülerListe.length;
	}

	/**
	 * @return
	 * @since 20. Sep. 2015
	 */
	public Iterator get() {
		return new Iterator(schülerListe);
	}
}

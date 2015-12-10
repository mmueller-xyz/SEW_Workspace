package mueller;

import java.util.Arrays;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;

import mueller.Person.BirthComparator;

public class PersonenTest{

	static Hashtable<String, Person> hashName = new Hashtable<String, Person>();
	static Hashtable<String, Person> hashSVnr = new Hashtable<String, Person>();
	
	static void createPersons(){
		for (int i = 0; i < 30; i++) {
			Person test = new Person("vor", "nach", new GregorianCalendar((int) (Math.random()*100+1900), (int) (Math.random()*11),(int) (Math.random()*29)));
			hashName.put(test.sortName(), test);
			hashSVnr.put(test.svNr, test);
		}
	}
	
	static void deletePersons(){
		int j = (int)Math.random()*hashName.size();
		Collection<Person> values = hashName.values();
		Iterator<Person> valiter = values.iterator();
		for (int i = 0; i < j; i++) {
			Person test = valiter.next();
			hashName.remove(test.sortName());
			hashSVnr.remove(test.svNr);
		}
	}
	
	static void printPersons(){
		Collection<Person> valuesName = hashName.values();
		Iterator<Person> valIterName = valuesName.iterator();
		Collection<Person> valuesSvnr = hashSVnr.values();
		Iterator<Person> valIterSvnr = valuesSvnr.iterator();
		while (valIterName.hasNext()) {
			System.out.println(valIterName.next()+"\n");
		}
		System.out.println("\n\n");
		while (valIterSvnr.hasNext()) {
			System.out.println(valIterSvnr.next()+"\n");
		}
		
	}
	
	/**
	 * 
	 * @since Nov 19, 2015
	 */
	static void sortPersons(){
		Collection<Person> valuesName = hashName.values();
		Person[] arrName = (Person[]) valuesName.toArray(new Person[valuesName.size()]);
		Collection<Person> valuesSvnr = hashSVnr.values();
		Person[] arrSvnr = (Person[]) valuesSvnr.toArray(new Person[valuesSvnr.size()]);
		
		Arrays.sort(arrName, new BirthComparator());
		Arrays.sort(arrSvnr, new BirthComparator());
		
		for (int i = 0; i < arrName.length; i++) {
			System.out.println(arrName[i]+"\n");
		}
		System.out.println("\n\n");
		for (int i = 0; i < arrSvnr.length; i++) {
			System.out.println(arrSvnr[i]+"\n");
		}
	}
	
	public static void main(String[] args) {
		createPersons();
		sortPersons();
//		main(null);
//		printPersons();
	}
}

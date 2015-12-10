package müller;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Maximilian
 * @version 17. Sep. 2015
 * 
 */
public class Schüler {
	private String name;
	private String sureName;
	private String sex;//gender
	private GregorianCalendar dob;//date of birth
	
	/**
	 * @param name
	 * @param sureName
	 * @param sex
	 * @param dob
	 * @since 20. Sep. 2015
	 */
	public Schüler(String name, String sureName, String sex, GregorianCalendar dob) {
		super();
		this.name = name;
		this.sureName = sureName;
		this.sex = sex;
		this.dob = dob;
	}

	/**
	 * @return the name
	 * @since 17. Sep. 2015
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 * @since 17. Sep. 2015
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the sureName
	 * @since 17. Sep. 2015
	 */
	public String getSureName() {
		return sureName;
	}
	
	/**
	 * @param sureName the sureName to set
	 * @since 17. Sep. 2015
	 */
	public void setSureName(String sureName) {
		this.sureName = sureName;
	}
	
	/**
	 * @return the sex
	 * @since 17. Sep. 2015
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * @param sex the sex to set
	 * @since 17. Sep. 2015
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/**
	 * @return the dob
	 * @since 17. Sep. 2015
	 */
	public GregorianCalendar getDob() {
		return dob;
	}
	
	/**
	 * @param dob the dob to set
	 * @since 17. Sep. 2015
	 */
	public void setDob(GregorianCalendar dob) {
		this.dob = dob;
	}
	
	/**
	 * @return
	 * @since 17. Sep. 2015
	 */
	@Override
	public String toString() {
		return name + " " + sureName + " " + sex + " " + dob.get(Calendar.YEAR) + "-" + (dob.get(Calendar.MONTH)+1) + "-" + dob.get(Calendar.DAY_OF_MONTH);
	}
}

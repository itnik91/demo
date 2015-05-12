/**
 * 
 */
package com.ynov.models;

import java.util.Comparator;
import java.util.Date;

/**
 * @author sdacalor
 *
 */
public class People {

	private String lname;
	private String fname;
	private String phoneNumber;
	private String adress;
	private String zipCode;
	private Date birthDay;

	/**
	 * @return the name
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param name the name to set
	 */
	public void setLname(String name) {
		this.lname = name;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @return the birthDay
	 */
	public Date getBirthDay() {
		return birthDay;
	}
	/**
	 * @param birthDay the birthDay to set
	 */
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * Constructor
	 */
	public People(String lNameToSet, String fNameToSet, String phoneNumberToSet){
		this.setFname(fNameToSet);
		this.setLname(lNameToSet);
		this.setPhoneNumber(phoneNumberToSet);
	}

	public People(){
		super();
	}

	/*Comparator for sorting the list by Student Name*/ 
	public static Comparator<People> PeopleNameComparator = new Comparator<People>() { 
		public int compare(People p1, People p2) { 
			String PeopleName1 = p1.getLname().toUpperCase(); 
			String PeopleName2 = p2.getLname().toUpperCase(); 
			//ascending order 
			return PeopleName1.compareTo(PeopleName2); 
			//descending order 
			//return StudentName2.compareTo(StudentName1); 
		}};
}

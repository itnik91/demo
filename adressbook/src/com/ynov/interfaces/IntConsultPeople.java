/**
 * 
 */
package com.ynov.interfaces;

import java.util.ArrayList;

import com.ynov.models.People;

/**
 * @author sdacalor
 *
 */
public interface IntConsultPeople {
	
	
	ArrayList<People> getByName(String lName, String...fName) throws Exception;
	
	People getByPhoneNumber(String phoneNumber) throws Exception;

}

/**
 * 
 */
package com.ynov.services;

import java.util.ArrayList;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.ynov.interfaces.IntConsultPeople;
import com.ynov.models.People;

/**
 * @author sdacalor
 *
 */
public class CurrentSvcConsultPeople extends SvcConsultPeople implements IntConsultPeople{

	/**
	 * In this non-commercial version, current  service not search for People
	 */
	@Override
	public ArrayList<People> getByName(String lName, String... fName) {
		return peopleCollection;
	}

	@Override
	public People getByPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

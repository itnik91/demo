/**
 * 
 */
package com.ynov.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;
import com.ynov.interfaces.IntConsultPeople;
import com.ynov.models.People;

/**
 * @author sdacalor
 *
 */
public class MockSvcConsultPeople extends SvcConsultPeople implements IntConsultPeople{


	// Looking for People in database that last name matches the entry
	/**
	 * @return list of People
	 */
	public ArrayList<People> getByName(String lName, String...fName) throws Exception {

		ArrayList<People> listOfItems = new ArrayList<People>();
		People item = null;
		Iterator<People> iterator = peopleCollection.listIterator();
		
		if (lName.length() > 1) {
			
			while (iterator.hasNext()) {
				item = iterator.next();
				if (item.getLname().contentEquals(lName)){
					listOfItems.add(item);
				}
			}
		}else {
			while (iterator.hasNext()) {
				item = iterator.next();
				if (Arrays.asList(fName).contains(item.getFname())){
					listOfItems.add(item);
				}
			}
		}
		return sortPeopleCollection(listOfItems);
		
	}

		
	@Override
	public People getByPhoneNumber(String phoneNumber) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * use sortPeopleCollection to sort a list of People
	 * @return a sorted list of People
	 */
	public static ArrayList<People> getPeopleCollection() {
		if (peopleCollection == null){
			peopleCollection = new ArrayList<People>();
		}

		return sortPeopleCollection(peopleCollection);
	}

	/**
	 * 
	 * @param peopleCollectionToSort
	 * @return a sorted list of People
	 */
	private static ArrayList<People> sortPeopleCollection( ArrayList<People>  peopleCollectionToSort) {

		Collections.sort(peopleCollectionToSort, People.PeopleNameComparator);
		return peopleCollectionToSort;

	}



}

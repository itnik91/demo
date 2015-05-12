package com.ynov.services;

import java.util.ArrayList;
import java.util.Iterator;

import com.ynov.interfaces.IntConsultPeople;
import com.ynov.models.People;

public abstract class SvcConsultPeople  {
	
	/*
	 * Create my unique peopleCollection
	 */
	protected static ArrayList<People> peopleCollection = null;
	

	/**
	 * @return the peopleCollection
	 */
	public static ArrayList<People> getPeopleCollection() {
		if (peopleCollection == null){
			peopleCollection = new ArrayList<People>();
		}
		
		return peopleCollection;
	}


	/**
	 * @return the people that match lname and fname
	 */
	public static People getPeople(String lName, String...fName) throws Exception {
		
		return null;
	}
	
	


}
	
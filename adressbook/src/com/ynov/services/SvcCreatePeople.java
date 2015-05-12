package com.ynov.services;

import com.ynov.models.People;

public abstract class SvcCreatePeople {


	/**
	 * @return People
	 * addPeople deliver a People instance with properties value
	 */
	public static People addPeople(String lNameValue, String fNameValue, String phoneNumber) {

		People person = new People(lNameValue, fNameValue, phoneNumber);

		return person;
	}

	public static People addPeople() {

		People person = new People();

		return person;
	}

}

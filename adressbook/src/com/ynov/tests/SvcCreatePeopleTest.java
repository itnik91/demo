/**
 * 
 */
package com.ynov.tests;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;

import com.ynov.models.People;
import com.ynov.services.MockSvcConsultPeople;
import com.ynov.services.SvcConsultPeople;
import com.ynov.services.SvcCreatePeople;

/**
 * @author sdacalor
 *
 */
public class SvcCreatePeopleTest extends TestCase {
	
	
	/*
	 * Declare CONSTANTE
	 */
	String STRCONTACT_LNAME_P1 = "Dacalor", STRCONTACT_FNAME_P1 = "Steeve", STRCONTACT_PHONENUMBER_P1 = "0634209856"; 
	String STRCONTACT_LNAME_P2 = "Van Box", STRCONTACT_FNAME_P2 = "Marie", STRCONTACT_PHONENUMBER_P2 = "0734209896";
	
	String STRCONTACT_LNAME_P3 = "Remy", STRCONTACT_FNAME_P3 = "Gérard", STRCONTACT_PHONENUMBER_P3 = "0634892356";
	String STRCONTACT_ADDRESS_P3 = "20 rue de la pente, OSSO-sur-Alpes", STRCONTACT_ZIPCODE_P3 = "43980";
	Date STRCONTACT_BIRTHDAY_P3 = new Date(21/03/1979);
	
	
	String STRCONTACT_LNAME_P4 = "Perrati", STRCONTACT_FNAME_P4 = "Audrey", STRCONTACT_PHONENUMBER_P4 = "0632730021";

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 * Use the fixture to setup the env variables needed for the test
	 * Create a contact, add it to the contact list using SvcCreatePeople() and SvcConsultPeople.
	 * Bind it to SvcConsultPeople 
	 */
	@Override
	protected void setUp() throws Exception {
		
		super.setUp();
		People pUsedForTest_P1 = SvcCreatePeople.addPeople();
		pUsedForTest_P1.setLname(STRCONTACT_LNAME_P1); pUsedForTest_P1.setFname(STRCONTACT_FNAME_P1); pUsedForTest_P1.setPhoneNumber(STRCONTACT_PHONENUMBER_P1);		
		People pUsedForTest_P2 = SvcCreatePeople.addPeople(STRCONTACT_LNAME_P2, STRCONTACT_FNAME_P2, STRCONTACT_PHONENUMBER_P2);
		
		People pUsedForTest_P3 = SvcCreatePeople.addPeople(STRCONTACT_LNAME_P3, STRCONTACT_FNAME_P3, STRCONTACT_PHONENUMBER_P3);
		pUsedForTest_P3.setAdress(STRCONTACT_ADDRESS_P3 ); 
		pUsedForTest_P3.setBirthDay(STRCONTACT_BIRTHDAY_P3); pUsedForTest_P3.setZipCode(STRCONTACT_ZIPCODE_P3);
		
		People pUsedForTest_P4 = SvcCreatePeople.addPeople(STRCONTACT_LNAME_P4, STRCONTACT_FNAME_P4, STRCONTACT_PHONENUMBER_P4);
		MockSvcConsultPeople.getPeopleCollection().add(pUsedForTest_P1);
		MockSvcConsultPeople.getPeopleCollection().add(pUsedForTest_P2);
		MockSvcConsultPeople.getPeopleCollection().add(pUsedForTest_P3);
		MockSvcConsultPeople.getPeopleCollection().add(pUsedForTest_P4);
		
			
		}


	/*
	 * Verify listOfPeople is not empty
	 * 
	 */
	
	public void testSvcCreatePeopleAdd() {
		
		ArrayList<People> listOfPeople = SvcConsultPeople.getPeopleCollection(); 
		assertFalse(listOfPeople.isEmpty()); 
		
	}
	
	/*
	 * Verify properties(last name, first name, phone number, zipcode, etc...) of People person used for the test
	 */

	public void testSvcCreatePeopleProperties(){
		ArrayList<People> listOfPeople = MockSvcConsultPeople.getPeopleCollection();
		assertTrue("First contact properties", listOfPeople.get(0).getFname().contentEquals(STRCONTACT_FNAME_P1));
		assertTrue("First contact properties", listOfPeople.get(0).getLname().contentEquals(STRCONTACT_LNAME_P1));
		assertTrue("First contact properties", listOfPeople.get(0).getPhoneNumber().contentEquals(STRCONTACT_PHONENUMBER_P1));
		
		assertTrue("Third contact properties", listOfPeople.get(2).getFname().contentEquals(STRCONTACT_FNAME_P3));
		assertTrue("Third contact properties", listOfPeople.get(2).getLname().contentEquals(STRCONTACT_LNAME_P3));
		assertTrue("Third contact properties", listOfPeople.get(2).getPhoneNumber().contentEquals(STRCONTACT_PHONENUMBER_P3));
		assertTrue("Third contact properties", listOfPeople.get(2).getAdress().contentEquals(STRCONTACT_ADDRESS_P3));
		assertTrue("Third contact properties", listOfPeople.get(2).getBirthDay().equals(STRCONTACT_BIRTHDAY_P3));
		assertTrue("Third contact properties", listOfPeople.get(2).getZipCode().contentEquals(STRCONTACT_ZIPCODE_P3));
		
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		
		super.tearDown();
		SvcConsultPeople.getPeopleCollection().clear();
		
		
	}
	
}

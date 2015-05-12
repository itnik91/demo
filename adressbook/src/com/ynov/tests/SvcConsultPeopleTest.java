/**
 * 
 */
package com.ynov.tests;

import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.TestCase;
import com.ynov.models.People;
import com.ynov.services.MockSvcConsultPeople;
import com.ynov.services.SvcConsultPeople;
import com.ynov.services.SvcCreatePeople;

/**
 * @author sdacalor
 *
 */
public class SvcConsultPeopleTest extends TestCase {

	/*
	 * Declare CONSTANTE
	 */
	String STRCONTACT_LNAME_P1 = "Dacalor", STRCONTACT_FNAME_P1 = "Steeve", STRCONTACT_PHONENUMBER_P1 = "0634209856"; 
	String STRCONTACT_LNAME_P2 = "Van Box", STRCONTACT_FNAME_P2 = "Marie", STRCONTACT_PHONENUMBER_P2 = "0734209896";

	/*
	 * ListOfPeople, MockSvcConsultPeople
	 */
	private ArrayList<People> listOfPeople = null;
	private MockSvcConsultPeople mockSvcConsultPeople = new MockSvcConsultPeople();
	private People pUsedForTest_P2;
	
	/*
	 * Initialize my service. Transform in Singleton next time....
	 */



	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 * Use the fixture to setup the env variables needed for the test
	 * Create a contact, add it to the contact list.
	 * Bind it to SvcConsultPeople 
	 */
	protected void setUp() throws Exception {
		super.setUp();
		People pUsedForTest_P1 = new People( STRCONTACT_LNAME_P1, STRCONTACT_FNAME_P1, STRCONTACT_PHONENUMBER_P1);
		pUsedForTest_P2 = SvcCreatePeople.addPeople(STRCONTACT_LNAME_P2, STRCONTACT_FNAME_P2, STRCONTACT_PHONENUMBER_P2);
		
		listOfPeople = MockSvcConsultPeople.getPeopleCollection();
		listOfPeople.add(pUsedForTest_P1);
		listOfPeople.add(pUsedForTest_P2);
	}

	/*
	 * Verify my listOfPeople is not empty
	 */
	public void testListOfPeople() {
		 
		assertFalse(listOfPeople.isEmpty()); 
	}

	/*
	 * The unique element of the list is the one I have inserted before
	 */
	public void testElementInListOfPeople() {
		

		assertTrue("Le nom est incorrect", listOfPeople.get(0).getLname().contentEquals(STRCONTACT_LNAME_P1));
		assertEquals("Le prénom est incorrect", listOfPeople.get(0).getFname() , STRCONTACT_FNAME_P1);
		assertFalse("Le numéro de téléphone n'est pas vide", listOfPeople.get(0).getPhoneNumber().isEmpty());

	}

	
	/*
	 * Test the search for People
	 * getByName returns a list which size is One.
	 */
	public void testLookingForPeople() throws Exception {
		People pResult_0 = mockSvcConsultPeople.getByName(STRCONTACT_LNAME_P2, "").get(0);				
		assertTrue("Le nom n'a pas été trouvé", pUsedForTest_P2.equals(pResult_0));
		
		People pResult_1 = mockSvcConsultPeople.getByName("", STRCONTACT_FNAME_P2).get(0);
		assertTrue("Le nom n'a pas été trouvé", pUsedForTest_P2.equals(pResult_1));
	}

	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 * Let's every object free
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		listOfPeople.clear();


	}

}

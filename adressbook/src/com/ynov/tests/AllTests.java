package com.ynov.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(SvcConsultPeopleTest.class);
		suite.addTestSuite(SvcCreatePeopleTest.class);
		//$JUnit-END$
		return suite;
	}
	
	/*
	 * Next stage is using Thread for my tests
	 */

}

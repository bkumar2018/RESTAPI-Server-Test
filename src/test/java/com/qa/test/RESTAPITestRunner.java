package com.qa.test;

import org.testng.annotations.Test;

import com.qa.apitest.TestApiEndPoint;

public class RESTAPITestRunner  {

	@Test
	public void testApi(){
		
		TestApiEndPoint ep = new TestApiEndPoint();
		ep.testApiEndPoint();
		ep.testApiEndPointUsersDetails();
		ep.testApiEndPointUsersIdDetails();
		
	}
}
